package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Event;
import models.Org;
import play.mvc.Result;

public class OrgsController extends Application {
	
	public static Result allOrgs() {
		List<Org> orgs = new LinkedList<Org>();
		orgs = Org.find.all();
        return ok(views.html.orgs.render(orgs));
    }
	
	public static Result orgInfo(Integer id) {
		Org org = Org.find.byId(id);
		if (org == null) {
			return ok(views.html.errorPage.render("Sorry, that org doesn't exist!!"));
		}
		List<Event> mostRecentEvents = new LinkedList<Event>();
		for (Event event: org.getEvents()) {
			if (mostRecentEvents.size() <= 3) {
				mostRecentEvents.add(event);
			} else {
				break;
			}
		}
		return ok(views.html.orgInfo.render(org, mostRecentEvents));
	}

}
