package com.example.proj1.Articles;

import com.example.proj1.Products.Products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Articles {

    @Id
    private String id;
    private String name;
    private String content;
    private String date;

    @ManyToOne
    private Products products;

    public Articles(String id, String name, String content, String date, Products products) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.products = products;
    }

    public Articles() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
