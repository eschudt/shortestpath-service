package com.recipeapi.resources;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.apache.log4j.Logger;
import com.recipeapi.api.Rating;
import com.recipeapi.dao.RecipeDao;

import io.dropwizard.jersey.params.LongParam;

@Path("/recipe/{id}/ratings")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeRatingResource {

	private RecipeDao recipeDao;
	
	public RecipeRatingResource(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
		Logger.getLogger(this.getClass()).info("Initiated recipe resource");
	}
	
	@POST
    public Response addRating(@PathParam("id") LongParam recipeId,
                        @NotNull @Valid Rating rating) {
        final long id = recipeDao.addRating(recipeId.get(), rating);
        if (id == 0)
        	return Response.notModified().build();
        return Response.created(UriBuilder.fromResource(RecipeResource.class)
                                          .build(recipeId.get(), id)).build();
    }
	
	public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}
