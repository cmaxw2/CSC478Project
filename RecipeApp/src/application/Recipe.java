package application;

import java.util.ArrayList;

public class Recipe {
	private int id;
	private String name;
	private int prepTime;
	private int bakeTime;
	private String quantity;
	private ArrayList<String> ingredients;
	private ArrayList<String> instructions;
	private String protein;
	private String category;

	public Recipe(int id, String name, int prepTime, int bakeTime, String quantity, ArrayList<String> ingredients,
			ArrayList<String> instructions, String protein, String category) {
		this.id = id;
		this.name = name;
		this.prepTime = prepTime;
		this.bakeTime = bakeTime;
		this.quantity = quantity;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.protein = protein;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalTime() {
		return bakeTime;
	}

	public void setTotalTime(int totalTime) {
		this.bakeTime = totalTime;
	}

	public String getMealType() {
		return category;
	}

	public void setMealType(String mealType) {
		this.category = mealType;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public ArrayList<String> getIngredientList() {
		return ingredients;
	}

	public void setIngredientList(ArrayList<String> ingredientList) {
		this.ingredients = ingredientList;
	}

	public ArrayList<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(ArrayList<String> instructions) {
		this.instructions = instructions;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTabbed() {
		StringBuilder sb = new StringBuilder();
		sb.append(id + "\t" + name + "\t" + prepTime + "\t" + bakeTime + "\t" + quantity);
		boolean firstIngredient = true;
		for (String s : ingredients) {
			if (firstIngredient) {
				sb.append("\t" + s);
				firstIngredient = false;
			} else {
				sb.append(";" + s);
			}
		}
		boolean firstInstruction = true;
		for (String s : instructions) {
			if (firstInstruction) {
				sb.append("\t" + s);
				firstInstruction = false;
			} else {
				sb.append(";" + s);
			}
		}
		sb.append("\t" + protein + "\t" + category);
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name:\n" + name + "\nPrep Time:\n" + prepTime + " minutes \nBake Time:\n" + bakeTime
				+ " minutes \nQuantity:\n" + quantity + "\nIngredients:\n");
		for (String s : ingredients) {
			sb.append(s + "\n");
		}
		sb.append("Instructions:\n");
		for (String s : instructions) {
			sb.append(s + "\n");
		}
		return sb.toString();
	}

}
