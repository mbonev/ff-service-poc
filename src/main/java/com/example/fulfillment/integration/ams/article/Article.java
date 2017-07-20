package com.example.fulfillment.integration.ams.article;

/**
 * Created by luchob on 7/19/17.
 */
//TODO: e.g. JSON annotations
public class Article {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
