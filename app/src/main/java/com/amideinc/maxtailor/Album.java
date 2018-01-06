package com.amideinc.maxtailor;

/**
 * Created by Dell on 12/26/2017.
 */

public class Album {
   private String name;
   private String thumbnail;

   public Album() {

   }
   public Album (String name, String thumbnail) {
       this.name  = name;
       this.thumbnail = thumbnail;
   }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
