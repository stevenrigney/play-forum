package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {
    
	@Before
	static void setConnectedUser() {
		if(Security.isConnected()) {
			Author user = Author.find("byNickName", Security.connected()).first();
			renderArgs.put("name", user.firstName + " " + user.lastName);
		}
	}
        
	public static void index() {
		List<Topic> recentTopics = Topic.find(
			"order by date desc"
		).from(0).fetch(10);
		render(recentTopics);
	}
    
	public static void addTopic(){
		render();
	}

	public static void saveTopic(String topic) {
		Author author = Author.find("byNickName", Security.connected()).first();
		Topic newTopic = new Topic(topic, author).save();

		index();
	}
	
	public static void showTopic(long id) {
		Topic topic = Topic.find("byId", id).first();
		render(topic);
	}
	
	public static void saveComment(long id, String comment) {
		System.out.println("id " + id);
		System.out.println("comment " + comment);
		Topic topic = Topic.find("byId", id).first();
		System.out.println("nickname " + Security.connected());
		
		Author author = Author.find("byNickName", Security.connected()).first();
		System.out.println("author " + author);
		topic.addPost(comment, author);
		
		showTopic(id);
	}
}