package com.shortestpath.search;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shortestpath.client.RestClient;
import com.shortestpath.models.INode;
import com.shortestpath.models.ReposSeenQueue;
import com.shortestpath.models.Repository;
import com.shortestpath.models.User;

public class GraphBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIncrementHop() {
		User user = new User("test1", new RestClient());
		ReposSeenQueue queue = new ReposSeenQueue();
		GraphBuilder builder = new GraphBuilder(user, queue);
		assertSame(0, builder.getHops());
		assertSame("user", builder.getCurrentType());
		
		Repository repo = new Repository("owner", "reponame", new RestClient());
		builder.incrementHop(repo);
		assertSame(1, builder.getHops());
		assertSame("repo", builder.getCurrentType());
		
		builder.incrementHop(repo);
		assertSame(1, builder.getHops());
		assertSame("repo", builder.getCurrentType());
		
		builder.incrementHop(user);
		assertSame(1, builder.getHops());
		assertSame("user", builder.getCurrentType());
		
		builder.incrementHop(repo);
		assertSame(2, builder.getHops());
		assertSame("repo", builder.getCurrentType());
	}
	
	@Test
	public void testBuildGraph() {
        User userTest = Mockito.mock(User.class);
        Repository repoTest = Mockito.mock(Repository.class);
        Mockito.when(repoTest.getAdjacentNodes()).thenReturn(new LinkedList<INode>());
        Mockito.when(repoTest.getType()).thenReturn("repo");
        Mockito.when(repoTest.getName()).thenReturn("repo1");
        LinkedList<INode> list = new LinkedList<INode>();
        list.add(repoTest);
        Mockito.when(userTest.getAdjacentNodes()).thenReturn(list);
        Mockito.when(userTest.getType()).thenReturn("name");
        Mockito.when(userTest.getName()).thenReturn("user1");
        
		ReposSeenQueue queue = new ReposSeenQueue();
		GraphBuilder builder = new GraphBuilder(userTest, queue);
		builder.buildGraph();
		assertSame(1, builder.getNodesSeen().getNodesSeen().size());
		
		builder.setStartNode(repoTest);
		assertSame(1, builder.getNodesSeen().getNodesSeen().size());
	}

}
