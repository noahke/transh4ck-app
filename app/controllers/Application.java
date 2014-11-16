package controllers;

import java.util.Random;

import models.Event;
import models.Institution;
import models.Org;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	
	public static int generateId() {
		Random rand = new Random();
    	return rand.nextInt(400000090) + 1;
	}
    
    public static Result createTestData() {
    	// oh god this is so hacky
    	// You will have a mess-load of terrible test data, but it'll exist at least!
    	
    	Institution inst1 = new Institution();
    	int id = generateId();
    	inst1.setId(id);
    	inst1.setName("Generic University " + id);
    	inst1.setLocation("Massachusetts");
    	inst1.setContact("Some University Person!");
    	inst1.setUrl("www.yaycollege.edu");
    	Institution.createInstitution(inst1);
    	
    	Org org1 = new Org();
    	id = generateId();
    	org1.setId(id);
    	org1.setName("Trans H4CK " + id);
    	org1.setContact("http://boston.transhack.org/");
    	org1.setSummary("yay hacking!!");
    	org1.setInstitutionId(inst1.getId());
    	Org.createOrg(org1);
    	
    	Org org2 = new Org();
    	id = generateId();
    	org2.setId(id);
    	org2.setName("Trans H4CK " + id);
    	org2.setContact("Kortney");
    	org2.setSummary("yay hacking!!");
    	org2.setInstitutionId(inst1.getId());
    	Org.createOrg(org2);
    	
    	Event event = new Event();
    	id = generateId();
    	event.setId(id);
    	event.setName("Trans H4CK Boston " + id + "!");
    	event.setLocation("Harvard Innovation Lab");
    	event.setSummary("A super cool hackathon!");
    	event.setEventDate("11/16/14");
    	event.setOrgId(org1.getId());
    	Event.createEvent(event);
    	
    	return ok(views.html.testdata.render(Org.find.all(), Institution.find.all(), Event.find.all()));
    }

}
