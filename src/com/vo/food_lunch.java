
package com.vo;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "food_lunch")
public class food_lunch
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "date")
    String date;
    @Column(name = "lunchmenu")
    String lunchmenu;
    @Column(name = "lunchprice")
    int lunchprice;
    
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
    
    public String getLunchmenu() {
        return this.lunchmenu;
    }
    
    public void setLunchmenu(final String lunchmenu) {
        this.lunchmenu = lunchmenu;
    }
    
    public int getLunchprice() {
        return this.lunchprice;
    }
    
    public void setLunchprice(final int lunchprice) {
        this.lunchprice = lunchprice;
    }
}