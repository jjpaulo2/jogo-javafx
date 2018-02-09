package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * 
 * @author jjpaulo2
 *
 */

public class Menu extends Scene {
	
	private int menu = 1;
	private Label umJogador, doisJogadores;

	public Menu(Pane root, double width, double height) {
		super(root, width, height);

		try {
			// fundo
			Rectangle fundo = new Rectangle(this.getWidth(),this.getHeight());
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
			
			root.getChildren().addAll(umJogador,doisJogadores);
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setModoDeJogo(int menu) {
		this.menu = menu;
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
