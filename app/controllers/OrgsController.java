package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Org;
import play.mvc.Controller;
import play.mvc.Result;

public class OrgsController extends Controller {
	
	public static Result foo() {
		List<Org> orgs = new LinkedList<Org>();
        return ok(views.html.orgs.render(orgs));
    }

}
