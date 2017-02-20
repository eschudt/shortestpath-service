package com.shortestpath.models;

import java.util.LinkedList;

import com.shortestpath.client.RestClient;

public class User implements INode {
	
	private String name;
	private RestClient client;
	
	
	public User(String name, RestClient client) {
		this.name = name;
		this.client = client;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<INode> getAdjacentNodes() {
		return client.getContributions(this.name);
	}

	public String getType() {
		return "user";
	}
	
}
