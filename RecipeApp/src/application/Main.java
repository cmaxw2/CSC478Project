package application;
import java.io.FileNotFoundException;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.initialize();
	}

}
