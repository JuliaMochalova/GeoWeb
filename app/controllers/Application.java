package controllers;

import models.Gps;
import play.Logger;
import play.api.mvc.MultipartFormData;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;

import static play.data.Form.form;

public class Application extends Controller {

    static Form<Gps> gpsForm = form(Gps.class);

    public static Result index() {
        return ok(views.html.index.render(Gps.all(), gpsForm));
    }

    public static Result main() {
        return ok(views.html.index.render(Gps.all(), gpsForm));
    }

    public static Result insertGPS() {

        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart RequestFile = body.getFile("GpsFile");
        if (RequestFile != null) {
            if (RequestFile.getContentType().equals("application/octet-stream")) {
                Gps Gps = new Gps();
                Gps.setName(RequestFile.getFilename());
                Gps.setFile(RequestFile.getFile());

                return ok("File uploaded");
            } else {
                flash("error", "Wrong type " + RequestFile.getContentType());
                return badRequest();
            }
        } else {
            flash("error", "Missing file");
            return badRequest();
        }
    }

    public static Result DownloadSubmit(){
        return null;
    }
}
