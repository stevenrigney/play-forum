package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Author extends Model {
	public String firstName;
	public String lastName;
	public String nickName;
	
	public Author(String firstName, String lastName, String nickName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
	}
}