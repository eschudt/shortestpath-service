package com.shortestpath.client;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.shortestpath.models.INode;
import com.shortestpath.models.Repository;
import com.shortestpath.models.User;

/*
 * Mock Restful Client
 * Configuration left out. Would be configured with Dropwizard
 * Note: Github API does not allow bulk requests
 */
public class RestClient {
	
	public RestClient() {
		Logger.getRootLogger().debug("Rest Client Created");
	}
	
	/*
	 * Mock Data returned for each request made for contributions
	 * User's name used in request to get list of repositories contributed to
	 */
	public LinkedList<INode> getContributions(String name) {
		LinkedList<INode> contributions = new LinkedList<INode>();
		if (name.equals("user1")) {
			Repository repo = new Repository("rr", "repo1", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo2", this);
			contributions.add(repo);
		}
		else if (name.equals("user2")) {
			Repository repo = new Repository("rr", "repo4", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo5", this);
			contributions.add(repo);
		}
		else if (name.equals("user3")) {
			Repository repo = new Repository("rr", "repo1", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo9", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo10", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo11", this);
			contributions.add(repo);
		}
		else if (name.equals("user4")) {
			Repository repo = new Repository("rr", "repo1", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo8", this);
			contributions.add(repo);
			Logger.getRootLogger().info("User4 Called");
		}
		else if (name.equals("user5")) {
			Repository repo = new Repository("rr", "repo1", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo6", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo7", this);
			contributions.add(repo);
		}
		else if (name.equals("user6")) {
			Repository repo = new Repository("rr", "repo14", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo8", this);
			contributions.add(repo);
		}
		else if (name.equals("user7")) {
			Repository repo = new Repository("rr", "repo4", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo12", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo15", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo20", this);
			contributions.add(repo);
		}
		else if (name.equals("user8")) {
			Repository repo = new Repository("rr", "repo4", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo13", this);
			contributions.add(repo);
		}
		else if (name.equals("user9")) {
			Repository repo = new Repository("rr", "repo15", this);
			contributions.add(repo);
			repo = new Repository("rr", "repo14", this);
			contributions.add(repo);
		}
		return contributions;
	}
	
	/*
	 * Mock Data returned for each request made for contributers
	 * Repository's name and owner used in request to get list of contributors
	 */
	public LinkedList<INode> getContributers(String owner, String name) {
		LinkedList<INode> contributers = new LinkedList<INode>();
		if (name.equals("repo1")) {
			INode user = new User("user1", this);
			contributers.add(user);
			user = new User("user3", this);
			contributers.add(user);
			user = new User("user4", this);
			contributers.add(user);
			user = new User("user5", this);
			contributers.add(user);
		}
		else if (name.equals("repo2")) {
			INode user1 = new User("user1", this);
			contributers.add(user1);
		}
		else if (name.equals("repo3")) {
			
		}
		else if (name.equals("repo4")) {
			INode user = new User("user2", this);
			contributers.add(user);
			user = new User("user7", this);
			contributers.add(user);
			user = new User("user8", this);
			contributers.add(user);
		}
		else if (name.equals("repo5")) {
			INode user = new User("user2", this);
			contributers.add(user);
		}
		else if (name.equals("repo6")) {
			INode user = new User("user5", this);
			contributers.add(user);
		}
		else if (name.equals("repo7")) {
			INode user = new User("user5", this);
			contributers.add(user);
		}
		else if (name.equals("repo8")) {
			INode user = new User("user4", this);
			contributers.add(user);
			user = new User("user6", this);
			contributers.add(user);
		}
		else if (name.equals("repo9")) {
			INode user = new User("user3", this);
			contributers.add(user);
		}
		else if (name.equals("repo10")) {
			INode user = new User("user3", this);
			contributers.add(user);
		}
		else if (name.equals("repo11")) {
			INode user = new User("user3", this);
			contributers.add(user);
		}
		else if (name.equals("repo12")) {
			INode user = new User("user7", this);
			contributers.add(user);
		}
		else if (name.equals("repo13")) {
			INode user = new User("user8", this);
			contributers.add(user);
		}
		else if (name.equals("repo14")) {
			INode user = new User("user9", this);
			contributers.add(user);
			user = new User("user6", this);
			contributers.add(user);
		}
		else if (name.equals("repo15")) {
			INode user = new User("user7", this);
			contributers.add(user);
			user = new User("user9", this);
			contributers.add(user);
		}
		else if (name.equals("repo20")) {
			INode user = new User("user7", this);
			contributers.add(user);
		}
		return contributers;
	}

}
