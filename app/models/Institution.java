package models;

import java.util.*;

public class Institution {
	public String name;
	public String location;
	public ArrayList orgs;
	public ArrayList events;
	public String contact;
	
	public Institution()	{
		orgs = new ArrayList<Object>();
		events = new ArrayList<Object>();
	}
	
	public String getName()	{
		return name;
	}
	
	public String setName(String newName)	{
		name = newName;
		return name;
	}
	
	public String getLocation()	{
		return location;
	}
	
	public String setLocation(String newLocation)	{
		location = newLocation;
		return name;
	}
	public String getContact(){
		return contact;
	}
	
	public String setContact(String newContact)	{
		contact = newContact;
		return name;
	}
	
	public ArrayList getOrgs()	{
		return orgs;
	}
	
	public ArrayList addOrgs(Object newOrg)	{
		orgs.add(newOrg);
		return orgs;
	}
	
	public ArrayList getEvents()	{
		return events;
	}
	
	public ArrayList addEvents(Object newEvent)	{
		events.add(newEvent);
		return events;
	}
}
