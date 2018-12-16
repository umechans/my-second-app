package controllers;
import static play.data.Form.*;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class HomeController extends Controller {

		public static class SampleForm{
			public String message;
		}

	    public Result index() {
	    	Form<SampleForm> f1 = form(SampleForm.class);
	        return ok(index.render("何か書いて。", f1));
	    }

	    public Result send() {
	    	Form<SampleForm> f2 =  form(SampleForm.class).bindFromRequest();
	    	if (!f2.hasErrors()) {
	    	SampleForm data = f2.get();
	    	String msg = "you typed:" + data.message;
	    	return ok(index.render(msg,f2));
	    }else{
	    	return badRequest(index.render("ERROR", form(SampleForm.class)));
	    }
	}
}
