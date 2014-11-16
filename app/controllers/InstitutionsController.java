package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Event;
import models.Institution;
import play.mvc.Controller;
import play.mvc.Result;

public class InstitutionsController extends Application {
	
	public static Result allInstitutions() {
		List<Institution> institutions = new LinkedList<Institution>();
		institutions = Institution.find.all();
        return ok(views.html.institutions.render(institutions));
    }
	
	public static Result institutionInfo(Integer id) {
		Institution institution = new Institution();
		return ok(views.html.institutionInfo.render(institution));
	}

}
