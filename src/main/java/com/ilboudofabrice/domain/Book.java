package com.ilboudofabrice.domain;

import com.google.gson.Gson;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by fabrice on 2017-02-07.
 */

@Entity
@Table(name = "BOOK")
@Proxy(lazy = false)
public class Book implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "editor")
    private String editor;

    @Column(name = "price")
    private double price;

    @Column(name="releaseDate")
    private Date releaseDate;

    @Column(name = "details")
    private String details;

    @Column(name = "coverImage")
    private String coverImage;

    @Autowired
    public Book(){

    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String toJSON(){
        return new Gson().toJson(this);
    }
}
