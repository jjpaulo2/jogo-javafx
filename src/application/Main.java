package application;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	private int posXmario = 100, posYmario = 150, alturaMario = 30;
	private int posXluigi = 20, posYluigi = 150, alturaLuigi = 30;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,214);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Image fundo = new Image("background.png");
			Image marioImg = new Image("mario.png");
			Image luigiImg = new Image("luigi.png");
			
			Rectangle chao = new Rectangle(0,0,450,214);
			chao.setFill(new ImagePattern(fundo));
			//chao.setFill(Color.FORESTGREEN);
			
			Rectangle mario = new Rectangle(posXmario,posYmario,30,alturaMario);
			mario.setFill(new ImagePattern(marioImg));
			Rectangle luigi = new Rectangle(posXluigi,posYluigi,22,alturaLuigi);
			luigi.setFill(new ImagePattern(luigiImg));

			TranslateTransition puloMario = new TranslateTransition(Duration.millis(500), mario);
			TranslateTransition puloLuigi = new TranslateTransition(Duration.millis(500), luigi);
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.ESCAPE)) {
						primaryStage.close();
					}
					
					if (event.getCode().equals(KeyCode.RIGHT)) {
						posXmario += 10;
						mario.setX(posXmario);
					}
					if (event.getCode().equals(KeyCode.LEFT)) {
						posXmario -= 10;
						mario.setX(posXmario);
					}
					if (event.getCode().equals(KeyCode.DOWN)) {	
						mario.setHeight(alturaMario-20);
						mario.setY(posYmario+20);
					}
					if (event.getCode().equals(KeyCode.UP)) {	
						puloMario.setByY(-40);
						puloMario.setAutoReverse(true);
						puloMario.setCycleCount(2);
						puloMario.play();
					}
					
					if (event.getCode().equals(KeyCode.D)) {
						posXluigi += 10;
						luigi.setX(posXluigi);
					}
					if (event.getCode().equals(KeyCode.A)) {
						posXluigi -= 10;
						luigi.setX(posXluigi);
					}
					if (event.getCode().equals(KeyCode.S)) {	
						luigi.setHeight(alturaLuigi-20);
						luigi.setY(posYluigi+20);
					}
					if (event.getCode().equals(KeyCode.W)) {
						puloLuigi.setByY(-40);
						puloLuigi.setAutoReverse(true);
						puloLuigi.setCycleCount(2);
						puloLuigi.play();
					}
				}
			});
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.DOWN)) {
						mario.setHeight(alturaMario);
						mario.setY(posYmario);
					}
					
					if (event.getCode().equals(KeyCode.S)) {
						luigi.setHeight(alturaLuigi);
						luigi.setY(posYluigi);
					}
				}
			});
			
			
			root.getChildren().add(chao);
			root.getChildren().add(mario);
			root.getChildren().add(luigi);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Super Block Bros");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
