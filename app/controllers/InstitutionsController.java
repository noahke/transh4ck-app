package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class InstitutionsController extends Controller {
	
	public static Result foo() {
        return ok(index.render("Your new application is ready."));
    }

}
