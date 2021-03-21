package application;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void initialize() {
		readFile();
		view.setVisible(true);
		view.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view.setTextArea("<html>" + model.getRecipes().get(0).toString().replaceAll("\n", "<br/>") + "</html>");
				view.setTextArea(model.getRecipes().get(0).toString());
				view.getButton().setVisible(false);
			}
		});
	}

	public void readFile() {
		try (Scanner fs = new Scanner(new File("recipes.txt"))) {
			fs.nextLine();
			while (fs.hasNextLine()) {
				String line = fs.nextLine();
				String[] values = line.split("\t");
				int id = Integer.parseInt(values[0].trim());
				String name = values[1].trim();
				int prepTime = Integer.parseInt(values[2].trim());
				int bakeTime = Integer.parseInt(values[3].trim());
				String quantity = values[4].trim();
				String[] ingredientsValues = values[5].trim().split(";");
				ArrayList<String> ingredients = new ArrayList<String>();
				for (String s : ingredientsValues) {
					ingredients.add(s);
				}
				String[] instructionsValues = values[6].trim().split(";");
				ArrayList<String> instructions = new ArrayList<String>();
				for (String s : instructionsValues) {
					s.trim();
					instructions.add(s);
				}
				String protein = values[7].trim();
				String category = values[8].trim();
				Recipe recipe = new Recipe(id, name, prepTime, bakeTime, quantity, ingredients, instructions, protein, category);
				model.addRecipe(recipe);
				fs.close();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeFile() {
		File recipeOld = new File("recipes.txt");
		recipeOld.delete();
		
		try (FileWriter fw = new FileWriter(new File("recipes.txt"))) {
			fw.write("ID\tName\tPrepTime\tBakeTime\tQuantity\tIngredients\tInstructions\tProtein\tCategory");
			for (Recipe r : model.getRecipes()) {
				fw.write("\n" + r.getTabbed());
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

