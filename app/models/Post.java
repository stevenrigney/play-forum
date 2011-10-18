package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Post extends Model {
 
    public Date date;
    public String author;
    public String comment;
    
    @ManyToOne
    public Topic topic;
    
    public Post(Date dt, String author, String comment) {
        this.date = dt;
        this.author = author;
        this.comment = comment;
    }

}