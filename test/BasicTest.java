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

		new Topic("this is awesome", author).save();
		
		Topic saved = Topic.find("byTopic", "this is awesome").first();
		
		assertNotNull(saved);
		assertEquals("this is awesome", saved.topic);
		assertEquals("Steven", saved.author.firstName);
	}
	
	@Test
	public void createAndRetrieveAPost() {
		Author author = new Author("Steven", "Rigney", "codegeek").save();
		
		Author topicCreator = new Author("Erin", "Rigney", "awesomewife").save();
		Topic topic = new Topic("I make the best potato soup", topicCreator).save();
		
		new Post("I agree", author, topic).save();
		Post post = Post.find("byComment", "I agree").first();
		assertNotNull(post);
		assertEquals("I agree", post.comment);
		assertEquals("I make the best potato soup", post.topic.topic);
		assertEquals("awesomewife", post.topic.author.nickName);
	}
	
	@Test
	public void createAddPostToTopic() {
		Author topicCreator = new Author("Erin", "Rigney", "awesomewife").save();
		Topic topic = new Topic("I make the best potato soup", topicCreator).save();
		
		Author codeGeek = new Author("Steven", "Rigney", "codegeek").save();
		topic.addPost("I agree", codeGeek);

		Author author2 = new Author("Adylynn", "Maple", "adycakes").save();
		topic.addPost("Me too", author2);
		
		assertEquals(3, Author.count());
		assertEquals(1, Topic.count());
		assertEquals(2, Post.count());

		Topic bragging = Topic.find("byAuthor", topicCreator).first();
		assertNotNull(bragging);
		
		assertEquals(2, bragging.posts.size());
		assertEquals("codegeek", bragging.posts.get(0).author.nickName);
		
		bragging.delete();

		assertEquals(3, Author.count());
		assertEquals(0, Topic.count());
		assertEquals(0, Post.count());
				
	}
}
