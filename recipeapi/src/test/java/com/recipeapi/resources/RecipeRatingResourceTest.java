package com.recipeapi.resources;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.mockito.Mockito;

import com.recipeapi.api.Rating;
import com.recipeapi.dao.RecipeDaoImpl;

import io.dropwizard.jersey.params.LongParam;

public class RecipeRatingResourceTest {
	
	private final RecipeDaoImpl store = Mockito.mock(RecipeDaoImpl.class);
    private final RecipeRatingResource resource = new RecipeRatingResource(store);

	@Test
	public void test() {
		Rating rating = Mockito.mock(Rating.class);
        Mockito.when(store.addRating(2, rating)).thenReturn((long) 0);
        Response response = resource.addRating(new LongParam("2"), rating);
        assertEquals(304,response.getStatus());
	}

}
