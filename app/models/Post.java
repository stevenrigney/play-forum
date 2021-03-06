package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Post extends Model {
 
    public Date date;
    public String comment;
    
    @ManyToOne
    public Author author;
    
    @ManyToOne
    public Topic topic;
    
    public Post(String comment, Author author, Topic topic) {
        this.date = new Date();
        this.comment = comment;
        this.author = author;
        this.topic = topic;
    }

}