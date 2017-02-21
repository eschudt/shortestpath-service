package com.recipeapi.api;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {

	private long id;
	private Date created_at;
	private Date updated_at;
	private String box_type;
	private String title;
	private String slug;
	private String short_Title;
	private String marketingDescription;
	private int calories_kcal;
	private int protein_grams;
	private int fat_grams;
	private int carbs_grams;
	private String bulletpoint1;
	private String bulletpoint2;
	private String bulletpoint3;
	private String recipe_diet_type_id;
	private String season;
	private String base;
	private String protein_source;
	private int preparation_time_minutes;
	private int shelf_life_days;
	private String equipment_needed;
	private String origin_country;
	private String recipe_cuisine;
	private String in_your_box;
	private long gousto_reference;
	private ArrayList<Rating> ratings;
	private double avgRating;
	
	public Recipe() {
        // Jackson deserialization
    }
	
	public Recipe(String id, String created_at, String updated_at, String box_type, String title, String slug,
			String short_Title, String marketingDescription, String calories_kcal, String protein_grams, String fat_grams,
			String carbs_grams, String bulletpoint1, String bulletpoint2, String bulletpoint3, String recipe_diet_type_id,
			String season, String base, String protein_source, String preparation_time_minutes, String shelf_life_days,
			String equipment_needed, String origin_country, String recipe_cuisine, String in_your_box,
			String gousto_reference) throws ParseException {
		super();
		this.id = Long.parseLong(id);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	    Date parsedDate = dateFormat.parse(created_at);
		this.created_at = parsedDate;
		parsedDate = dateFormat.parse(updated_at);
		this.updated_at = parsedDate;
		this.box_type = box_type;
		this.title = title;
		this.slug = slug;
		this.short_Title = short_Title;
		this.marketingDescription = marketingDescription;
		this.calories_kcal = Integer.parseInt(calories_kcal);
		this.protein_grams = Integer.parseInt(protein_grams);
		this.fat_grams = Integer.parseInt(fat_grams);
		this.carbs_grams = Integer.parseInt(carbs_grams);
		this.bulletpoint1 = bulletpoint1;
		this.bulletpoint2 = bulletpoint2;
		this.bulletpoint3 = bulletpoint3;
		this.recipe_diet_type_id = recipe_diet_type_id;
		this.season = season;
		this.base = base;
		this.protein_source = protein_source;
		this.preparation_time_minutes = Integer.parseInt(preparation_time_minutes);
		this.shelf_life_days = Integer.parseInt(shelf_life_days);
		this.equipment_needed = equipment_needed;
		this.origin_country = origin_country;
		this.recipe_cuisine = recipe_cuisine;
		this.in_your_box = in_your_box;
		this.gousto_reference = Long.parseLong(gousto_reference);
		
		// using defaults
		this.avgRating = 0;
		this.ratings = new ArrayList<Rating>();
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty
	public Date getCreated_at() {
		return created_at;
	}

	@JsonProperty
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@JsonProperty
	public Date getUpdated_at() {
		return updated_at;
	}

	@JsonProperty
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@JsonProperty
	public String getBox_type() {
		return box_type;
	}

	@JsonProperty
	public void setBox_type(String box_type) {
		this.box_type = box_type;
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty
	public String getSlug() {
		return slug;
	}

	@JsonProperty
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@JsonProperty
	public String getShort_Title() {
		return short_Title;
	}

	@JsonProperty
	public void setShort_Title(String short_Title) {
		this.short_Title = short_Title;
	}

	@JsonProperty
	public String getMarketingDescription() {
		return marketingDescription;
	}

	@JsonProperty
	public void setMarketingDescription(String marketingDescription) {
		this.marketingDescription = marketingDescription;
	}

	@JsonProperty
	public int getCalories_kcal() {
		return calories_kcal;
	}

	@JsonProperty
	public void setCalories_kcal(int calories_kcal) {
		this.calories_kcal = calories_kcal;
	}

	@JsonProperty
	public int getProtein_grams() {
		return protein_grams;
	}

	@JsonProperty
	public void setProtein_grams(int protein_grams) {
		this.protein_grams = protein_grams;
	}

	@JsonProperty
	public int getFat_grams() {
		return fat_grams;
	}

	@JsonProperty
	public void setFat_grams(int fat_grams) {
		this.fat_grams = fat_grams;
	}

	@JsonProperty
	public int getCarbs_grams() {
		return carbs_grams;
	}

	@JsonProperty
	public void setCarbs_grams(int carbs_grams) {
		this.carbs_grams = carbs_grams;
	}

	@JsonProperty
	public String getBulletpoint1() {
		return bulletpoint1;
	}

	@JsonProperty
	public void setBulletpoint1(String bulletpoint1) {
		this.bulletpoint1 = bulletpoint1;
	}

	@JsonProperty
	public String getBulletpoint2() {
		return bulletpoint2;
	}

	@JsonProperty
	public void setBulletpoint2(String bulletpoint2) {
		this.bulletpoint2 = bulletpoint2;
	}

	@JsonProperty
	public String getBulletpoint3() {
		return bulletpoint3;
	}

	@JsonProperty
	public void setBulletpoint3(String bulletpoint3) {
		this.bulletpoint3 = bulletpoint3;
	}

	@JsonProperty
	public String getRecipe_diet_type_id() {
		return recipe_diet_type_id;
	}

	@JsonProperty
	public void setRecipe_diet_type_id(String recipe_diet_type_id) {
		this.recipe_diet_type_id = recipe_diet_type_id;
	}

	@JsonProperty
	public String getSeason() {
		return season;
	}

	@JsonProperty
	public void setSeason(String season) {
		this.season = season;
	}

	@JsonProperty
	public String getBase() {
		return base;
	}

	@JsonProperty
	public void setBase(String base) {
		this.base = base;
	}

	@JsonProperty
	public String getProtein_source() {
		return protein_source;
	}

	@JsonProperty
	public void setProtein_source(String protein_source) {
		this.protein_source = protein_source;
	}

	@JsonProperty
	public int getPreparation_time_minutes() {
		return preparation_time_minutes;
	}

	@JsonProperty
	public void setPreparation_time_minutes(int preparation_time_minutes) {
		this.preparation_time_minutes = preparation_time_minutes;
	}

	@JsonProperty
	public int getShelf_life_days() {
		return shelf_life_days;
	}

	@JsonProperty
	public void setShelf_life_days(int shelf_life_days) {
		this.shelf_life_days = shelf_life_days;
	}

	@JsonProperty
	public String getEquipment_needed() {
		return equipment_needed;
	}

	@JsonProperty
	public void setEquipment_needed(String equipment_needed) {
		this.equipment_needed = equipment_needed;
	}

	@JsonProperty
	public String getOrigin_country() {
		return origin_country;
	}

	@JsonProperty
	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}

	@JsonProperty
	public String getRecipe_cuisine() {
		return recipe_cuisine;
	}

	@JsonProperty
	public void setRecipe_cuisine(String recipe_cuisine) {
		this.recipe_cuisine = recipe_cuisine;
	}

	@JsonProperty
	public String getIn_your_box() {
		return in_your_box;
	}

	@JsonProperty
	public void setIn_your_box(String in_your_box) {
		this.in_your_box = in_your_box;
	}

	@JsonProperty
	public long getGousto_reference() {
		return gousto_reference;
	}

	@JsonProperty
	public void setGousto_reference(long gousto_reference) {
		this.gousto_reference = gousto_reference;
	}

	@JsonProperty
	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	@JsonProperty
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	@JsonProperty
	public double getAvgRating() {
		return avgRating;
	}

	@JsonProperty
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public void recalcAvgRating(int newRating) {
		this.avgRating = (avgRating + newRating) / ratings.size();
    }
}
