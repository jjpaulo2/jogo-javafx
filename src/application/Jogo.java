package application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


/**
 * 
 * @author jjpaulo2
 *
 */

public class Jogo extends Scene {
	
	private boolean player2;

	// mario			
	public Personagem mario = new Personagem(0, 100, 150, 22, 30);
	
	// luigi
	public Personagem luigi = new Personagem(1, 20, 150, 22, 30);

	public Jogo(Pane root, double width, double height) {
		super(root, width, height);
		
		try {
			
			// cenário
			Image fundoImg = new Image("img/background.png");
			Rectangle fundo = new Rectangle(0,0,450,214);
			fundo.setFill(new ImagePattern(fundoImg));
			
			
			// adicionando fundo na tela
			root.getChildren().add(fundo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void plotarJogadores(Pane root) {
		root.getChildren().add(mario);
		if(player2)	root.getChildren().add(luigi);
	}
	public void limparJogadores(Pane root) {
		root.getChildren().removeAll(mario,luigi);
	}

	public void setQuantPlayers(int quant) {		
		switch (quant) {
		case 1:
			player2 = false;
			break;
		case 2:
			player2 = true;
			break;
		}
	}
	
	public void confirmar() {
		System.out.println("Desenvolvido por João Paulo Carvalho - GitHub @jjpaulo2");
	}
}
