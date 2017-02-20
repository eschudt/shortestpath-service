package com.shortestpath.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shortestpath.api.ShortestPath;
import com.shortestpath.client.RestClient;
import com.shortestpath.models.ReposSeenQueue;
import com.shortestpath.search.ShortestPathFinder;

@Path("/shortestpath/{user1}/{user2}")
@Produces(MediaType.APPLICATION_JSON)
public class ShortestPathResource {
    private final int hops;

    public ShortestPathResource(int hops) {
        this.hops = hops;
    }
    
    @GET
    public ShortestPath fetch(@PathParam("user1") String username1,
    							@PathParam("user2") String username2) throws InterruptedException {
    	ReposSeenQueue nodesSeen = new ReposSeenQueue();
		RestClient client = new RestClient();
        ShortestPathFinder finder = new ShortestPathFinder(nodesSeen, client);
        int result = finder.findHops(username1, username2);
        return new ShortestPath(result);
    }
}