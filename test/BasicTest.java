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
		new Topic("this is awesome", new Date(), "Steve").save();
		
		Topic saved = Topic.find("byTopic", "this is awesome").first();
		
		assertNotNull(saved);
		assertEquals("this is awesome", saved.topic);
	}
	
	@Test
	public void createAndRetrieveAPost() {
		new Post(new Date(), "Steve", "I agree").save();
		Post post = Post.find("byAuthor", "Steve").first();
		assertNotNull(post);
		assertEquals("I agree", post.comment);
	}
}
