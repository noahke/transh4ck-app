package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Event;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class EventsController extends Controller {
	
	public static Result foo() {
		List<Event> events = new LinkedList<Event>();
        return ok(views.html.events.render(events));
    }

}
