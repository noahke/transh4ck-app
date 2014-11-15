package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Event;
import play.mvc.Result;

public class EventsController extends Application {
	
	public static Result foo() {
		List<Event> events = new LinkedList<Event>();
        return ok(views.html.events.render(events));
    }

}
