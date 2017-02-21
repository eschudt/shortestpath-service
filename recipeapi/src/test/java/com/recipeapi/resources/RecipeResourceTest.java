package com.recipeapi.resources;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import com.recipeapi.api.Recipe;
import com.recipeapi.dao.RecipeDaoImpl;

import io.dropwizard.jersey.params.LongParam;

public class RecipeResourceTest {
	
	private final RecipeDaoImpl store = Mockito.mock(RecipeDaoImpl.class);
    private final RecipeResource resource = new RecipeResource(store);

	@Test
	public void test() throws InterruptedException {
		final Recipe recipe = Mockito.mock(Recipe.class);
		Mockito.when(store.getRecipe(1)).thenReturn(recipe);
        final Recipe result = resource.getRecipe(new LongParam("1"));
        assertSame(result, recipe);
	}

}
