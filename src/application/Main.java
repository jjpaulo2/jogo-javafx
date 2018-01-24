package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private int posX = 20;
	private int posY = 120;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,350);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			
			Rectangle chao = new Rectangle(0,150,400,200);
			chao.setFill(Color.FORESTGREEN);
			
			Rectangle personagem = new Rectangle(posX,posY,30,30);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.RIGHT)) {
						posX += 10;
						personagem.setX(posX);
					}
					if (event.getCode().equals(KeyCode.LEFT)) {
						posX -= 10;
						personagem.setX(posX);
					}
					if (event.getCode().equals(KeyCode.ESCAPE)) {
						primaryStage.close();
					}
				}
			});
			root.getChildren().add(personagem);
			root.getChildren().add(chao);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("movendo quadro");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
