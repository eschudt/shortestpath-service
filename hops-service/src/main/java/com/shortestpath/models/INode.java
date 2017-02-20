package com.shortestpath.models;

import java.util.LinkedList;

public interface INode {
	
	public LinkedList<INode> getAdjacentNodes();
	public String getName();
	public String getType();
	
}