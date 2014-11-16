package models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.Logger;
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
	private String name;
	
	@Required
	@Column(name = "eventDate")
	private Date eventDate;
	
	private List<User> users;
	private String location;
	
	@Required
	private String summary;
	
	@Required
	private Org org;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	public static Finder<Integer,Event> find = new Finder<Integer,Event>(Integer.class, Event.class);
	
	public static void createEvent(Event event) {
		Logger.debug("Saving event: " + event.toString());
		event.save();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName()	{
		return name;
	}
	
	public String setName(String newName)	{
		name = newName;
		return name;
	}
	
	public Date getDate()	{
		return eventDate;
	}
	
	public Date setEventDate(Date newDate)	{
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}
	
}