package models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="events")
public class Event extends Model{
	
	@Required
	public String name;
	
	@Required
	public String date;
	
	public List<Object> users;
	public String location;
	// summary
	
	public Event()	{
		users = new ArrayList<Object>();
	}
	
	public String getName()	{
		return name;
	}
	
	public String setName(String newName)	{
		name = newName;
		return name;
	}
	
	public String getDate()	{
		return date;
	}
	
	public String setDate(String newDate)	{
		date = newDate;
		return date;
	}
	
	public List getUsers()	{
		return users;
	}
	
	public List addUser(Object newUser)	{
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
	
}