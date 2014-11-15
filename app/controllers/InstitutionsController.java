package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Institution;
import play.mvc.Controller;
import play.mvc.Result;

public class InstitutionsController extends Application {
	
	public static Result foo() {
		List<Institution> institutions = new LinkedList<Institution>();
        return ok(views.html.institutions.render(institutions));
    }

}
