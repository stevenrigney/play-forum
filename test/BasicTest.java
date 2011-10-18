import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteAll();
	}
    
   @Test
   public void aVeryImportantThingToTest() {
		assertEquals(2, 1 + 1);
   }
    
	@Test
	public void verifyEmptyDB() {
		List<Topic> topics = Topic.findAll();
		assertEquals(0, topics.size());
   }

	@Test
	public void createAndRetrieveATopic() {
		Author author = new Author("Steven", "Rigney", "codegeek").save();

		new Topic("this is awesome", new Date(), author).save();
		
		Topic saved = Topic.find("byTopic", "this is awesome").first();
		
		assertNotNull(saved);
		assertEquals("this is awesome", saved.topic);
		assertEquals("Steven", saved.author.firstName);
	}
	
	@Test
	public void createAndRetrieveAPost() {
		Author author = new Author("Steven", "Rigney", "codegeek").save();
		
		Author topicCreator = new Author("Erin", "Rigney", "awesomewife").save();
		Topic topic = new Topic("I make the best potato soup", new Date(), topicCreator).save();
		
		Date savedDate = new Date();
		new Post(savedDate, "I agree", author, topic).save();
		Post post = Post.find("byDate", savedDate).first();
		assertNotNull(post);
		assertEquals("I agree", post.comment);
		assertEquals("I make the best potato soup", post.topic.topic);
		assertEquals("awesomewife", post.topic.author.nickName);
	}
}
