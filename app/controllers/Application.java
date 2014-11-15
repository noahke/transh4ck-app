package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import models.Org;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	
	public static Result index() {
		return null;
	}
	
	public static int generateId() {
		Random rand = new Random();
    	return rand.nextInt(400000090) + 1;
	}
    
    public static Result createTestData() {
    	// oh god this is so hacky
    	Org org = new Org();
    	
    	// OH GOD THIS IS EVEN WORSE   	
    	org.setId(generateId());
    	org.setName("Trans H4CK");
    	org.setContact("Kortney");
    	org.setSummary("yay hacking!!");
    	Org.createOrg(org);
    	List<Org> orgs = new LinkedList<Org>();
    	orgs.add(org);
    	return ok(views.html.testdata.render(orgs));
    }

}
