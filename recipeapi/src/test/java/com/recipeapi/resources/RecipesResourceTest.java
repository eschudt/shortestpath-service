package com.recipeapi.resources;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import com.recipeapi.api.Recipe;
import com.recipeapi.dao.RecipeDaoImpl;

public class RecipesResourceTest {

	private final RecipeDaoImpl store = Mockito.mock(RecipeDaoImpl.class);
    private final RecipesResource resource = new RecipesResource(store);

	@Test
	public void test() throws InterruptedException {
		final List<Recipe> list = Mockito.mock(List.class);
		Mockito.when(store.getAllRecipes("21", 1)).thenReturn(list);
        List<Recipe> result = resource.getRecipes(Optional.of("21"), Optional.of(new Integer(1)));
        assertSame(result, list);
	}

}
