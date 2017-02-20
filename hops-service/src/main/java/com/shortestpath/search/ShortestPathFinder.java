package com.shortestpath.search;

import org.apache.log4j.Logger;
import com.shortestpath.client.RestClient;
import com.shortestpath.models.INode;
import com.shortestpath.models.ReposSeenQueue;
import com.shortestpath.models.User;

public class ShortestPathFinder {

	private ReposSeenQueue nodesSeen;
	private RestClient client;
	
	public ShortestPathFinder(ReposSeenQueue nodesSeen, RestClient client) {
		this.nodesSeen = nodesSeen;
		this.client = client;
	}
	
	/*
	 * Start 2 threads to build their respective graphs
	 */
	public int findHops(String username1, String username2) throws InterruptedException {
		INode user1 = new User(username1, client);
		INode user2 = new User(username2, client);
		
		GraphBuilder builder1 = new GraphBuilder(user1, nodesSeen);
		Thread t1 = new Thread(builder1);
        t1.start();
        Logger.getLogger(this.getClass()).info("Thread1 Building Graph with " + username1 + " as root");
		
		GraphBuilder builder2 = new GraphBuilder(user2, nodesSeen);
		Thread t2 = new Thread(builder2);
        t2.start();
        Logger.getLogger(this.getClass()).info("Thread2 building Graph with " + username2 + " as root");
        
        t1.join();
        t2.join();
        
        int result = this.nodesSeen.getHops();
        resetFinder();
        Logger.getLogger(this.getClass()).debug("Request complete");
        return result;
	}
	
	public void resetFinder() {
		this.nodesSeen.getNodesSeen().clear();
		this.nodesSeen.setMaxDepth(0);
		this.nodesSeen.setHops(0);
	}
	
}
