package com.amideinc.maxtailor;

/**
 * Created by Dell on 12/23/2017.
 */

public class Kapra {
    private String name;
    private int noofpic;
    private int thumbnail;
    private String keyword;

    public Kapra() {
    }
    public Kapra(String name, int noofpic, int thumbnail, String keyword) {
        this.name = name;
        this.noofpic = noofpic;
        this.thumbnail = thumbnail;
        this.keyword = keyword;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name  = name;
    }

    public int getNoofpic() {
        return noofpic;
    }
    public String getKeyword(){
        return keyword;
    }


    public int getThumbnail() {
        return thumbnail;
    }

}
