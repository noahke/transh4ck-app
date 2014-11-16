package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Event;
import models.Org;
import play.mvc.Result;

public class EventsController extends Application {
	
	public static Result allEvents() {
		List<Event> events = new LinkedList<Event>();
        return ok(views.html.events.render(events));
    }
	
	public static Result eventInfo(Integer id) {
		Event event = new Event();
		return ok(views.html.eventInfo.render(event));
	}

}
