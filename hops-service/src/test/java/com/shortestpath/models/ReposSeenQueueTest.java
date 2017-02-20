package com.shortestpath.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReposSeenQueueTest {

	@Test
	public void testShouldContinue() {
		ReposSeenQueue queue = new ReposSeenQueue();
		assertTrue(queue.shouldContinue(0));
		assertTrue(queue.shouldContinue(5));
		queue.setMaxDepth(100);
		assertTrue(queue.shouldContinue(100));
		assertTrue(queue.shouldContinue(99));
		assertFalse(queue.shouldContinue(101));
	}
	
	@Test
	public void testAddNewNode() {
		ReposSeenQueue queue = new ReposSeenQueue();
		
		queue.addNewNode("test1", 2);
		assertSame(1, queue.getNodesSeen().size());
		assertSame(0, queue.getMaxDepth());
		assertSame(0, queue.getHops());
		
		queue.addNewNode("test2", 5);
		assertSame(2, queue.getNodesSeen().size());
		assertSame(0, queue.getMaxDepth());
		assertSame(0, queue.getHops());
		
		queue.addNewNode("test1", 1);
		assertSame(2, queue.getNodesSeen().size());
		assertSame(1, queue.getMaxDepth());
		assertSame(2, queue.getHops());
		
		queue.addNewNode("test1", 8);
		assertSame(2, queue.getNodesSeen().size());
		assertSame(1, queue.getMaxDepth());
		assertSame(2, queue.getHops());
	}

}
