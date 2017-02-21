package com.recipeapi.resources;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.recipeapi.api.Recipe;
import com.recipeapi.dao.RecipeDao;

import io.dropwizard.jersey.params.LongParam;

@Path("/recipe/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {
	
	private RecipeDao recipeDao;
	
	public RecipeResource(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
		Logger.getLogger(this.getClass()).info("Initiated recipe resource");
	}

	@GET
    @Timed
    public Recipe getRecipe(@PathParam("id") LongParam recipeId) throws InterruptedException {
		Logger.getLogger(this.getClass()).info("Getting Recipe of ID " + recipeId);
		Recipe recipe = recipeDao.getRecipe(recipeId.get());
		if (recipe == null) {
			final String msg = String.format("Recipe %s does not exist", recipeId.toString());
	        throw new WebApplicationException(msg, Status.NOT_FOUND);
		}
        return recipe;
    }
	
	@PUT
    public Response update(@PathParam("id") LongParam recipeId,
                        @NotNull @Valid Recipe recipe) {
        final boolean updated = recipeDao.updateRecipe(recipeId.get(), recipe);
        if (!updated)
        	return Response.notModified().build();
        return Response.created(UriBuilder.fromResource(RecipeResource.class)
                                          .build(recipeId.get(), updated)).build();
    }
	
	public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}
