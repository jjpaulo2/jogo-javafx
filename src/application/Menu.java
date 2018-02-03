package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author jjpaulo2
 *
 */

public class Menu extends Stage {

	private int menu = 1;
	private Label umJogador, doisJogadores;

	private Jogo jogo = new Jogo();
	
	public void exibir(){
		
		try {
			
			Pane root = new Pane();
			Scene scene = new Scene(root,450,214);
			
			// fundo
			Rectangle fundo = new Rectangle(scene.getWidth(),scene.getHeight());
			Image fundoImg = new Image("img/background.png");
			fundo.setFill(new ImagePattern(fundoImg));
			root.getChildren().add(fundo);
			
			// logo do mario
			Rectangle logo = new Rectangle(120,20,160,80);
			logo.setFill(new ImagePattern(new Image("img/logo.jpg")));
			root.getChildren().add(logo);
			
			// menu
			Font fonte = Font.loadFont(Menu.class.getResource("/font/ARCADECLASSIC.TTF").toExternalForm(), 16);

			umJogador = new Label("1 jogador");
			umJogador.setLayoutX(150);
			umJogador.setLayoutY(120);
			umJogador.setFont(fonte);
			
			doisJogadores = new Label("2 jogadores");
			doisJogadores.setLayoutX(150);
			doisJogadores.setLayoutY(140);
			doisJogadores.setFont(fonte);
			
			navegarMenu(menu);
			
			// eventos			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if(event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.DOWN)) {
						switch (menu) {
						case 1:
							menu = 2;
							navegarMenu(menu);
							break;
						default:
							menu = 1;
							navegarMenu(menu);
							break;
						}
					}
					if(event.getCode().equals(KeyCode.ENTER)) {
						jogo.setQuantPlayers(getModoDeJogo());
						hide();
						jogo.exibir();
					}
				}
			});
			
			root.getChildren().addAll(umJogador,doisJogadores);

			// janela			
			this.setScene(scene);
			this.setTitle("Super Mario Bros");
			this.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getModoDeJogo() {
		return menu;
	}
	
	
	public void navegarMenu(int lugar) {
		switch (lugar) {
		case 2:
			umJogador.setTextFill(Color.BEIGE);
			doisJogadores.setTextFill(Color.DARKRED);
			break;
		default:
			umJogador.setTextFill(Color.DARKRED);
			doisJogadores.setTextFill(Color.BEIGE);
			break;
		}
	
	}
}
