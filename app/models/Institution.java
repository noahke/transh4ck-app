package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	// Annotations are added so that PostgreSQL successfully generates a new id for each user.institutions
	
	private static final long serialVersionUID = 1774967170375160665L;

	@Id
	@SequenceGenerator(name="institutions_seq", sequenceName="institutions_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="institutions_seq")
	private int id;
	
	private String name;
	private String location;
	private String url;
	
	public static Finder<Integer,Institution> find = new Finder<Integer,Institution>(Integer.class, Institution.class);
	
	public static void createInstitution(Institution institution) {
		Logger.debug("Saving institution: " + institution.toString());
		institution.save();
	}
		
	public static void updateInstitution(Institution institution) {
		Logger.debug("Updating user: " + institution.toString());
		institution.update();
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
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String setContact(String newURL)	{
		url = newURL;
		return name;
	}
	
}
