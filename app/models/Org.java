package models;
import java.util.*;

public class Org {
	public String name;
	public ArrayList users;
	public String contact;
	public ArrayList events;
	
	public Org()	{
		users = new ArrayList<Object>();
		events = new ArrayList<Object>();
	}
	
	public String getName()	{
		return name;
	}
	
	public String setName(String newName)	{
		name = newName;
		return name;
	}
	public ArrayList getUsers()	{
		return users;
	}
	
	public ArrayList addUser(Object newUser)	{
		users.add(newUser);
		return users;
	}
	
	public ArrayList getEvents(){
		return events;
	}
	
	public ArrayList addEvent(Object newEvent){
		events.add(newEvent);
		return events;
	}
	
	}
