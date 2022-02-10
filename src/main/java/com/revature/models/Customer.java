package com.revature.models;

import com.revature.daka.persistence.Column;
import com.revature.daka.persistence.Entity;
import com.revature.daka.persistence.Id;
import com.revature.daka.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    @Id(type = "default")
    @Column(name = "c_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "favorite_store")
    private int favoriteStore;
    @Column(name = "vc_member")
    private boolean vcMember;

    public Customer() {
    }

    public Customer(String firstName, String lastName, int favoriteStore, boolean vcMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteStore = favoriteStore;
        this.vcMember = vcMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFavoriteStore() {
        return favoriteStore;
    }

    public void setFavoriteStore(int favoriteStore) {
        this.favoriteStore = favoriteStore;
    }

    public boolean isVcMember() {
        return vcMember;
    }

    public void setVcMember(boolean vcMember) {
        this.vcMember = vcMember;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", favoriteStore=" + favoriteStore +
                ", vcMember=" + vcMember +
                '}';
    }
}
