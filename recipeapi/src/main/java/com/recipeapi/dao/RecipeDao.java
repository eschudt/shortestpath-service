package com.recipeapi.dao;

import java.util.List;

import com.recipeapi.api.Rating;
import com.recipeapi.api.Recipe;

public interface RecipeDao {

	public List<Recipe> getAllRecipes(String params, int page);
	public Recipe getRecipe(long id);
	public boolean updateRecipe(long id, Recipe recipe);
	public void deleteRecipe(Recipe recipe);
	public long addRecipe(Recipe recipe);
	public long addRating(long id, Rating rating);
	
}
