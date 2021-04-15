package com.vo;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "food_dinner")
public class food_dinner
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "date")
    String date;
    @Column(name = "dinnermenu")
    String dinnermenu;
    @Column(name = "dinnerprice")
    int dinnerprice;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(final String date) {
        this.date = date;
    }
    
    public String getDinnermenu() {
        return this.dinnermenu;
    }
    
    public void setDinnermenu(final String dinnermenu) {
        this.dinnermenu = dinnermenu;
    }
    
    public int getDinnerprice() {
        return this.dinnerprice;
    }
    
    public void setDinnerprice(final int dinnerprice) {
        this.dinnerprice = dinnerprice;
    }
}