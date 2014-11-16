package controllers;

import java.util.LinkedList;
import java.util.List;

import models.Institution;
import play.mvc.Result;

public class InstitutionsController extends Application {
	
	public static Result allInstitutions() {
		List<Institution> institutions = new LinkedList<Institution>();
		institutions = Institution.find.all();
        return ok(views.html.institutions.render(institutions));
    }
	
	public static Result institutionInfo(Integer id) {
		Institution inst = Institution.find.byId(id);
		if (inst == null) {
			return ok(views.html.errorPage.render("Sorry, that institution doesn't exist!!"));
		}
		return ok(views.html.institutionInfo.render(inst));
	}

}
