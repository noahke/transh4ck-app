package models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.Logger;
import play.db.ebean.Model;

@Entity
@Table(name="institutions")
/* from the database:
 * CREATE TABLE institutions (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL UNIQUE,
	location varchar(200) NOT NULL,
	url varchar(200) NOT NULL
);
 */
public class Institution extends Model {
	// Annotations are added so that PostgreSQL successfully generates a new id for each user.
	
	private String name;
	private String location;
	private ArrayList orgs;
	private ArrayList events;
	private String url;
	
	public Institution()	{	
		//this constructor is empty
	}
	
	public static void createInstitution(Institution institution) {
		Logger.debug("Saving institution: " + institution.toString());
		institution.save();
	}
		
	public static void updateInstitution(Institution institution) {
		Logger.debug("Updating user: " + institution.toString());
		institution.update();
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
	public String getURL(){
		return url;
	}
	
	public String setContact(String newURL)	{
		url = newURL;
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
