package com.recipeapi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

	private long id;
	private String username;

    public Customer() {
        // Jackson deserialization
    }

    public Customer(long id, String username) {
        this.id = id;
        this.username = username;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }
}
