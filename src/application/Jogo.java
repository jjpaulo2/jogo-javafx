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


/**
 * 
 * @author jjpaulo2
 *
 */

public class Jogo extends Application {

	int posXmario = 100, posYmario = 150, alturaMario = 30;
	
	private static boolean player2;
	int posXluigi = 20, posYluigi = 150, alturaLuigi = 30;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,214);

			// cenário
			Image fundo = new Image("img/background.png");
			Rectangle chao = new Rectangle(0,0,450,214);
			chao.setFill(new ImagePattern(fundo));

			// mario			
			Image marioImg = new Image("img/mario.png");
			Rectangle mario = new Rectangle(posXmario,posYmario,30,alturaMario);
			mario.setFill(new ImagePattern(marioImg));
			
			TranslateTransition puloMario = new TranslateTransition(Duration.millis(500), mario);

			// luigi
			Image luigiImg = new Image("img/luigi.png");
			Rectangle luigi = new Rectangle(posXluigi,posYluigi,22,alturaLuigi);
			luigi.setFill(new ImagePattern(luigiImg));

			TranslateTransition puloLuigi = new TranslateTransition(Duration.millis(500), luigi);
			
			
			// eventos
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
			
			// adicionando elementos na tela
			root.getChildren().add(chao);
			root.getChildren().add(mario);
			if(player2)	root.getChildren().add(luigi);
			
			// configuração da janela
			primaryStage.setScene(scene);
			primaryStage.setTitle("Super Block Bros");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setQuantPlayers(int quant) {
		switch (quant) {
		case 1:
			player2 = false;
			break;
		case 2:
			player2 = true;
			break;
		default:
			break;
		}
	}
	
	public static void executar() {
		launch();
	}
}
