package application;


import java.util.ArrayList;

public class Model {
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	
	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}
	
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}
	
	public void removeRecipe(int index) {
		this.recipes.remove(index);
	}
	
}
