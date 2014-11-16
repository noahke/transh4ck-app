package controllers;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Event;
import models.Org;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class EventsController extends Application {
	
	private static Form<Event> eventForm = Form.form(Event.class);
	
	public static Result allEvents() {
		List<Event> events = new LinkedList<Event>();
        return ok(views.html.events.render(events));
    }
	
	public static Result eventInfo(Integer id) {
		Event event = new Event();
		return ok(views.html.eventInfo.render(event));
	}
	
	public static Result eventCreation() {
		List<Org> orgs = Org.find.all();
		return ok(views.html.eventCreation.render(orgs));
	}
	
	public static Result createEvent() {
		Form<Event> filledForm = eventForm.bindFromRequest();
		ObjectNode result = Json.newObject();
		if (filledForm.hasErrors()) {
			result.put("success", false);
			return ok(result);
		}
		Event newEvent= filledForm.get();
		try {
			Event.createEvent(newEvent);
		} catch (PersistenceException e) {
			Logger.error("Persistence error! " + e.toString());
			result.put("success", false);
			return ok(result);
		}
		result.put("success", true);		
		return ok(result);
	}

}
