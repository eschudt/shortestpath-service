package com.shortestpath.models;

import java.util.LinkedList;

import com.shortestpath.client.RestClient;

public class Repository implements INode {

	private String name;
	private String owner;
	private RestClient client;
	
	public Repository(String owner, String name, RestClient client) {
		this.name = name;
		this.owner = owner;
		this.client = client;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public LinkedList<INode> getAdjacentNodes() {
		return client.getContributers(owner, name);
	}

	public String getType() {
		return "repo";
	}
	
}
