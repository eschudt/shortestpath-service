# Shortest Path Between 2 Points in an Incomplete Graph

This project calculates the number of steps between 2 points in an incomplete graph. The graph is built around the two starting points based on incoming data. The path is calculated when a node appears in both graphs to become 1 combined graph.

This project calculates the shortest hops between 2 GitHub users.

## Implementation
The algorithm was built using a modified version of the breadth first search.
* The entire graph of GitHub is not available and bulk requests are not allowed. The graph had to be built from the starting node by calling the GitHub API when getAdjacentNodes() method is called.
* 2 separate threads build the graph using the 2 users are the root nodes respectively
* A breadth first search is done on each additional layer of adjacent nodes populated
* A common Map is kept to store all Nodes that have been seen by each thread
* If a node already exists in the common Map when a thread is about to add one, then the 2 graphs have merged
* It is still possible one thread was faster than the other, and the merge node is not the shortest path
* The other thread will run until it reaches the same level (distance from the root node) as the waiting thread
* At this point, there is no need to continue running as the path will always be longer


## Getting Started

### Prerequisites

This project is a maven project built in Ecplise. You can run maven-install on the project to produce the runnable jar.


### Installing

After your jar file has been built, run the following command in your target directory:

```
java -jar target/hops-service-0.0.1-SNAPSHOT.jar server shortestpath.yml
```

You can then connect to the service by using the following url:

```
http://localhost:8080/shortestpath/user1/user2
```
where
* user1 is the username of the first GitHub user
* user2 is the username of the second GitHub user

The connection to GitHub API was mocked. The mocked graph (after each API call has been made) can be drawn by following the return values of the RestClient Class. It consists of 9 users and 15 repositories.

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Erich Schudt** - *Initial work*

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.
