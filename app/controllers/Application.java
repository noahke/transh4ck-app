package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Institution;
import models.Org;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	
	public static Result index() {
		return null;
	}
    
    public static Result createTestData() {
    	// oh god this is so hacky
    	Org org = new Org();
    	//inst1.setId(1948320934);
    	org.setName("Trans H4CK");
    	org.setContact("Kortney");
    	org.setUrl("transh4ck.org");
    	org.createOrg(org);
    	List<Org> orgs = new LinkedList<Org>();
    	orgs.add(org);
    	return ok(views.html.testdata.render(orgs));
    }

}
