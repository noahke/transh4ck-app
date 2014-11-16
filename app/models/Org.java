package models;
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
@Table(name="organizations")
public class Org extends Model {
	
	private static final long serialVersionUID = 436818248219553589L;

	@Id
	@SequenceGenerator(name="orgs_seq", sequenceName="orgs_id_seq", allocationSize=0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orgs_seq")
	private int id;
	
	@Required
	private String name;
	
	@Required
	private User owner;
	
	@Required
	private String contact;
	
	@Required
	private String summary;
	
	public static Finder<Integer,Org> find = new Finder<Integer,Org>(Integer.class, Org.class);
			
	public static void createOrg(Org org) {
		Logger.debug(org.toString());		
		org.save();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
