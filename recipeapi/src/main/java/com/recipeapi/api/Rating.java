package com.recipeapi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
	
	private long id;
	private int rating;
	private Customer customer;
	private String comment;

    public Rating() {
        // Jackson deserialization
    }

    public Rating(long id, int rating, Customer customer, String comment) {
        this.id = id;
        this.rating = rating;
        this.customer = customer;
        this.comment = comment;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public int getRating() {
        return rating;
    }
    
    @JsonProperty
    public Customer getCustomer() {
        return customer;
    }
    
    @JsonProperty
    public String getComment() {
        return comment;
    }

}
