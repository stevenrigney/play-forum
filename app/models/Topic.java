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
    
    public Topic(String topic, Date dt, Author author) {
        this.topic = topic;
        this.date = dt;
        this.author = author;
    }
    
}