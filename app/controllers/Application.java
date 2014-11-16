package controllers;

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
    	// You will have a mess-load of terrible test data, but it'll exist at least!

    	Org org1 = new Org();
    	org1.setId(generateId());
    	org1.setName("Trans H4CK " + generateId());
    	org1.setContact("Kortney");
    	org1.setSummary("yay hacking!!");
    	Org.createOrg(org1);
    	
    	Org org2 = new Org();
    	org2.setId(generateId());
    	org2.setName("Trans H4CK " + generateId());
    	org2.setContact("Kortney");
    	org2.setSummary("yay hacking!!");
    	Org.createOrg(org2);
    	
    	return ok(views.html.testdata.render(Org.find.all()));
    }

}
