package models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="events")
public class Event extends Model{

	private static final long serialVersionUID = 8402775284782646080L;

	@Id
	@SequenceGenerator(name="institutions_seq", sequenceName="institutions_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="institutions_seq")
	private int id;
	
	@Required
	public String name;
	
	@Required
	public String eventDate;
	
	public List<User> users;
	public String location;
	
	@Required
	public String summary;
	
	public static Finder<Integer,Event> find = new Finder<Integer,Event>(Integer.class, Event.class);
	
	public String getName()	{
		return name;
	}
	
	public String setName(String newName)	{
		name = newName;
		return name;
	}
	
	public String getDate()	{
		return eventDate;
	}
	
	public String setDate(String newDate)	{
		eventDate = newDate;
		return eventDate;
	}
	
	public List<User> getUsers()	{
		return users;
	}
	
	public List<User> addUser(User newUser)	{
		users.add(newUser);
		return users;
	}
	
	public String getLocation()	{
		return location;
	}
	
	public String setLocation(String newLocation)	{
		location = newLocation;
		return location;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}