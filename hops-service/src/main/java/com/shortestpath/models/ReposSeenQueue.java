package com.shortestpath.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class ReposSeenQueue {
	
	private Map<String, Integer> nodesSeen;
	private int maxDepth;
	private int hops;
	
	public ReposSeenQueue() {
		this.nodesSeen = new ConcurrentHashMap<String, Integer>();
		this.maxDepth = 0;
		this.hops = 0;
	}
	
	/*
	 * Check to see if a thread has found the merge point
	 * Then determine if the current threads is the same number of edges
	 * away from the root. If so, there is no need to continue processing
	 */
	public synchronized boolean shouldContinue(int hops) {
		if (maxDepth == 0 || (maxDepth > 0 && hops <= maxDepth))
			return true;
		Logger.getLogger(this.getClass()).debug("Stop thread. maxDepth set to " + maxDepth);
		return false;
	}
	
	/*
	 * Before adding a new node in the common Map, check if it already exists
	 * If it doesn't, add it in
	 * If it does exist, determine the max no. of edges from the root
	 * * If maxDepth is not set. Set a new maxDepth
	 * * If maxDepth is set and the current thread's depth is less, replace maxDepth (no need to go further)
	 * * calculate the number of hops up to the merge point
	 */
	public synchronized void addNewNode(String name, int hopsIn) {
		if (!nodesSeen.containsKey(name)) {
			Logger.getLogger(this.getClass()).debug(name + " not found. Adding to seen queue");
			nodesSeen.put(name, hopsIn);
		}
		else {
			if (maxDepth == 0 || (maxDepth != 0 && maxDepth >= hopsIn)) {
				maxDepth = hopsIn;
				if (hops == 0 || ( hops !=0 && hops > hopsIn + nodesSeen.get(name) - 1))
					hops = hopsIn + nodesSeen.get(name) - 1;
				Logger.getLogger(this.getClass()).debug("New maxDepth " + maxDepth + " and hops " + hops + " from " + name);
			}
		}
	}

	public Map<String, Integer> getNodesSeen() {
		return nodesSeen;
	}

	public void setNodesSeen(Map<String, Integer> nodesSeen) {
		this.nodesSeen = nodesSeen;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public int getHops() {
		return hops;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

}
