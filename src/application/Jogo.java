package application;

import javafx.animation.TranslateTransition;
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

public class Jogo extends Stage {

	private int posXmario = 100, posYmario = 150, alturaMario = 30;
	
	private boolean player2;
	private int posXluigi = 20, posYluigi = 150, alturaLuigi = 30;
	
	public void exibir() {
		try {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,214);

			// cenário
			Image fundoImg = new Image("img/background.png");
			Rectangle fundo = new Rectangle(0,0,450,214);
			fundo.setFill(new ImagePattern(fundoImg));

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
						close();
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
			root.getChildren().add(fundo);
			root.getChildren().add(mario);
			if(player2)	root.getChildren().add(luigi);
			
			// configuração da janela
			this.setScene(scene);
			this.setTitle("Super Mario Bros");
			this.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setQuantPlayers(int quant) {
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
}
