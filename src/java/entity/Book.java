/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author sillamae kutsekool
 */
@Entity
public class Book implements Serializable, EntityInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer publishedYear;
    @OneToOne
    private Cover cover;
    @Basic(fetch = FetchType.LAZY)
    private String text;
    private Integer price;

    public Book() {
    }

    public Book(String name, String author, Integer publishedYear, String text, Integer price, Cover cover) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.text = text;
        this.price = price;
        this.cover = cover;
    }
    public Book(String name, String author, Integer publishedYear, String text, String price, Cover cover) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.text = text;
        this.setPrice(price);
        this.cover = cover;
    }
    public Book(String name, String author, Integer publishedYear, String text, Double price, Cover cover) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.text = text;
        this.setPrice(price);
        this.cover = cover;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "name=" + name 
                + ", author=" + author 
                + ", publishedYear=" + publishedYear 
                + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.author);
        hash = 23 * hash + Objects.hashCode(this.publishedYear);
        hash = 23 * hash + Objects.hashCode(this.cover);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.publishedYear, other.publishedYear)) {
            return false;
        }
        if (!Objects.equals(this.cover, other.cover)) {
            return false;
        }
        return true;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrice(String price) {
       if(price.matches(",")){
           price = price.replaceAll(",", ".");
       }
        try {
            Double d = Double.parseDouble(price);
            this.price = (int)(d * 100);
        } catch (Exception e) {
            throw new NumberFormatException(price);
        }
       
    }
    public String getPriceToStr(){
        double dPrice = this.price/100;
        return String.format("%.2f", dPrice);
    }

    private void setPrice(Double price) {
        this.price = (int)(price*100);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
}
