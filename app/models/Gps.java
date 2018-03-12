package models;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Gps extends Model{

    public Integer id;

    @Required
    public File fileGps;
    public String name;

    public Integer getId() {
        return id;
    }

    public static Finder<Integer,Gps> find = new Finder(
            Integer.class, Gps.class
    );

    public static List<Gps> all() {
        return new ArrayList<Gps>();
    }

    public static void delete(Integer id) {
        find.ref(id).delete();
    }

   // public static List<Gps> all() {
        //return new ArrayList<Gps>();}

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setFile(File fileGps){
        this.fileGps = fileGps;
    }

    public File getFile(){
        return fileGps;
    }



}