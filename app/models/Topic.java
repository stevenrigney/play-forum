package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Topic extends Model {
 
    public String topic;
    public Date date;
    
    @ManyToOne
    public Author author;
    
   @OneToMany(mappedBy="topic", cascade=CascadeType.ALL)
	public List<Post> posts;

   public Topic(String topic, Author author) {
		this.posts = new ArrayList<Post>();
		this.topic = topic;
		this.date = new Date();
		this.author = author;
   }
    
   public Topic addPost(String comment, Author author){
   	Post newPost = new Post(comment, author, this).save();
   	this.posts.add(newPost);
   	this.save();
   	return this;
   }
}