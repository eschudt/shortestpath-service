# RESTful JSON based API for Recipe Data

This project is a RESTful API that provides 5 different end points to interact with recipe data.

[Dropwizard](http://www.dropwizard.io/1.0.6/docs/index.html)  was used to create the service. The framework provides a production ready, out of the box high performance RESTful web service. It is also light-weight making deployment into production relatively easy to focus on development.

The API is available for all consumers. But given entire data objects are produced at each request, it may not be ideal for mobile users. Query parameters would have to be included in each get request to allow the consumer to only request for specific data.


## Getting Started

### Prerequisites

This project is a maven project built in Eclipse using Java. Run maven-install on the project to produce the runnable jar.


### Installing

After your jar file has been built, run the following command in your target directory:

```
java -jar recipeapi-0.0.1-SNAPSHOT.jar server ../recipiapi.yml
```

The following end points have been setup on localhost:8080/

```
* GET     /recipe/{id} (com.recipeapi.resources.RecipeResource)
* PUT     /recipe/{id} (com.recipeapi.resources.RecipeResource)
* POST    /recipe/{id}/ratings (com.recipeapi.resources.RecipeRatingResource)
* GET     /recipes/ (com.recipeapi.resources.RecipesResource)
* POST    /recipes/ (com.recipeapi.resources.RecipesResource)
```

No database was used. A CSV file of 10 recipes is loaded at startup. The data can then be modified using the above end points. 

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Erich Schudt** - *Initial work*

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.
