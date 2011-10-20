package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
public class Author extends Model {
	public String firstName;
	public String lastName;
	public String nickName;
	public String password;
	
	public Author(String firstName, String lastName, String nickName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.password = password;
	}
	
	public static Author connect(String nickName, String password) {
		return find("byNickNameAndPassword", nickName, password).first();
	}
	
}