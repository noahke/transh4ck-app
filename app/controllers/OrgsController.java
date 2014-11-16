package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Institution;
import models.Org;
import play.mvc.Controller;
import play.mvc.Result;

public class OrgsController extends Application {
	
	public static Result allOrgs() {
		List<Org> orgs = new LinkedList<Org>();
		orgs = Org.find.all();
        return ok(views.html.orgs.render(orgs));
    }
	
	public static Result orgInfo(Integer id) {
		Org org = new Org();
		return ok(views.html.orgInfo.render(org));
	}

}
