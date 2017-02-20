package com.shortestpath.search;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shortestpath.client.RestClient;
import com.shortestpath.models.ReposSeenQueue;

public class ShortestPathTest {

	@Test
	public void testFindHops() throws InterruptedException {
		ReposSeenQueue nodesSeen = new ReposSeenQueue();
		RestClient client = new RestClient();
        ShortestPathFinder finder = new ShortestPathFinder(nodesSeen, client);
        assertSame(5, finder.findHops("user1", "user2"));
        assertSame(4, finder.findHops("user4", "user8"));
        assertSame(1, finder.findHops("user1", "user5"));
        assertSame(3, finder.findHops("user1", "user9"));
        assertSame(0, finder.findHops("user1", "user99"));
	}

}
