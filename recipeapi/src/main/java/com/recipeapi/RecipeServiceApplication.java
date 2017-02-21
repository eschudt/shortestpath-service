package com.recipeapi;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.recipeapi.dao.RecipeDao;
import com.recipeapi.dao.RecipeDaoImpl;
import com.recipeapi.health.TemplateHealthCheck;
import com.recipeapi.resources.RecipeRatingResource;
import com.recipeapi.resources.RecipeResource;
import com.recipeapi.resources.RecipesResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RecipeServiceApplication extends Application<RecipeServiceConfiguration> {

	public static void main(String[] args) throws Exception {
        new RecipeServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "recipeservice";
    }

    @Override
    public void initialize(Bootstrap<RecipeServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(RecipeServiceConfiguration configuration,
                    Environment environment) throws IOException, ParseException {
    	
    	// register data source
    	/*final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final UserDAO dao = jdbi.onDemand(RecipeDao.class);*/
    	RecipeDao recipoeDao = new RecipeDaoImpl();
        
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        
        final RecipeResource recipeResource = new RecipeResource(recipoeDao);
        environment.jersey().register(recipeResource);
        Logger.getLogger(this.getClass()).info("Registered receipe resource");
        
        final RecipesResource recipesResource = new RecipesResource(recipoeDao);
        environment.jersey().register(recipesResource);
        Logger.getLogger(this.getClass()).info("Registered receipes resource");
        
        final RecipeRatingResource recipeRatingResource = new RecipeRatingResource(recipoeDao);
        environment.jersey().register(recipeRatingResource);
        Logger.getLogger(this.getClass()).info("Registered receipe rating resource");
    }
    
}
