package com.shortestpath.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

import com.shortestpath.models.INode;
import com.shortestpath.models.ReposSeenQueue;

public class GraphBuilder implements Runnable {
	
	private INode startNode;
	private ReposSeenQueue nodesSeen;
	private int hops;
	private String currentType;
	
	public GraphBuilder(INode startNode, ReposSeenQueue queue) {
		this.startNode = startNode;
		this.nodesSeen = queue;
		this.hops = 0;
		this.currentType = startNode.getType();
	}

	/* 
	 * Breadth First Search while building the adjacent nodes
	 */
	public void buildGraph() {
        Queue<INode> queue = new LinkedList<INode>();
        ArrayList<String> explored = new ArrayList<String>();
        queue.add(this.startNode);

        while(!queue.isEmpty() && nodesSeen.shouldContinue(hops)) {
        	INode current = queue.remove();
        	incrementHop(current);
        		
        	if (current.getType().equalsIgnoreCase("repo"))
        		nodesSeen.addNewNode(current.getName(), hops);
        	
        	LinkedList<INode> adjacentNodes = current.getAdjacentNodes();
        	if(adjacentNodes.isEmpty()) {
                break;
        	}
            else {
            	for (int i = 0; i < adjacentNodes.size(); i++) {  
            	    INode node = adjacentNodes.get(i);
            	    if (node !=null && !explored.contains(node.getName()))  {
            	    	queue.add(node);
            	    }
            	}
            }
        	explored.add(current.getName());
        }
        Logger.getLogger(this.getClass()).info("Completed builing graph in line");
	}
	
	/*
	 * Determine the distance away from the root
	 * 1 user to another user (through a repository) is 1 hop
	 */
	public void incrementHop(INode current) {
		if (current.getType().equalsIgnoreCase("repo") && 
				!current.getType().equalsIgnoreCase(this.currentType)) {
			this.hops++;
			this.currentType = current.getType();
			Logger.getLogger(this.getClass()).debug("Hops Incremented on " + current.getName() + ". Hops now: " + this.hops);
		}
		if (current.getType().equalsIgnoreCase("user")) {
			this.currentType = current.getType();
		}
	}

	public INode getStartNode() {
		return startNode;
	}

	public void setStartNode(INode startNode) {
		this.startNode = startNode;
	}

	public ReposSeenQueue getNodesSeen() {
		return nodesSeen;
	}

	public void setNodesSeen(ReposSeenQueue nodesSeen) {
		this.nodesSeen = nodesSeen;
	}

	public int getHops() {
		return hops;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public void run() {
		buildGraph();
	}
	
}