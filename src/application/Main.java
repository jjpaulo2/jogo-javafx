package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author jjpaulo2
 *
 */

public class Main extends Application {

	public static void main(String[] args) {
		
		launch();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Menu menu = new Menu();
		menu.exibir();
		
	}
	
	
}
