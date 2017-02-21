package com.recipeapi.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.recipeapi.api.Recipe;
import com.recipeapi.dao.RecipeDao;

@Path("/recipes/")
@Produces(MediaType.APPLICATION_JSON)
public class RecipesResource {

private RecipeDao recipeDao;
	
	public RecipesResource(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
		Logger.getLogger(this.getClass()).info("Initiated recipe resource");
	}

	@GET
    @Timed
    public List<Recipe> getRecipes(@QueryParam("cuisine") Optional<String> cuisine,
    		@QueryParam("page") Optional<Integer> page) throws InterruptedException {
		Logger.getLogger(this.getClass()).info("Getting Recipes of cuisine " + cuisine);
		List<Recipe> recipes = recipeDao.getAllRecipes(cuisine.orElse(""), page.orElse(1));
		if (recipes == null) {
			final String msg = "No recipes found";
	        throw new WebApplicationException(msg, Status.NOT_FOUND);
		}
        return recipes;
    }
	
	@POST
    public Response add(@NotNull @Valid Recipe recipe) {
        final long id = recipeDao.addRecipe(recipe);
        if (id == 0)
        	return Response.notModified().build();
        return Response.created(UriBuilder.fromResource(RecipeResource.class)
                                          .build(id)).build();
    }
	
	public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}
