package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Topic extends Model {
 
    public String topic;
    public Date date;
    public String by;
    
    public Topic(String topic, Date dt, String by) {
        this.topic = topic;
        this.date = dt;
        this.by = by;
    }
    
}