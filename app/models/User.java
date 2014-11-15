package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.Logger;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="users")
public class User extends Model {
	public String name;
	
	private Boolean publicEmail;
	private List<Institution> insts;
	private List<Org> orgs;
	private String bio;
		// public something icon
	private String contact;
	
	
	@Id
	@SequenceGenerator(name="users_seq", sequenceName="users_id_seq", allocationSize=0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
	private int id;
	
	@Required
	@Column(unique=true)
	@Email
	private String email;
	
	@Required
	private String pass;
	
	
	public static void createUser(User user) {
			Logger.debug("Saving user: " + user.toString());
			user.save();
	}
	
	public static void updateUser(User user) {
			Logger.debug("Updating user: " + user.toString());
			user.update();
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
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public boolean getPublicEmail(){
		return publicEmail;
	}
	
	public void setPublicEmail(boolean publicEmail){
		this.publicEmail = publicEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public List<Org> getOrgs() {
		if (orgs.isEmpty()) {
//			setOrgs(User.getOrgsByOwnerId(this.id));
		}
		return orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}
	
	public List<Institution> getInsts() {
		if (insts.isEmpty()) {
//			setInsts(User.getInstitutionByOwnerId(this.id));
		}
		return insts;
	}

	public void setInsts(List<Institution> insts) {
		this.insts = insts;
	}
		
	
	
	public String toString() {
			return "User [id=" + id + ", username=" + name + ", email=" + email
					+ "]";
		}

}

