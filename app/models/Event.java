package models;
import java.util.*;

public class Event {
	public String name;
	public String date;
	public ArrayList<Object> users;
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
	
	public ArrayList getUsers()	{
		return users;
	}
	
	public ArrayList addUser(Object newUser)	{
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