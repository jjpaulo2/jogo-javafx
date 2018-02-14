package application;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 
 * @author jjpaulo2
 *
 */

public class Personagem extends Rectangle {

	private TranslateTransition pulo = new TranslateTransition(Duration.millis(500), this);
	private int direita, esquerda;
	
	public Personagem(int personagem, double posX, double posY, double largura, double altura) {
		this.setImage(personagem);
		this.direita = personagem;
		this.esquerda = personagem + 2;
		this.setX(posX);
		this.setY(posY);
		this.setWidth(largura);
		this.setHeight(altura);
	}
	
	private void setImage(int personagem) {
		switch (personagem) {
		case 0:
			this.setFill(PersonagemImg.MARIO_DIREITA.getImg());
			break;
		case 1:
			this.setFill(PersonagemImg.LUIGI_DIREITA.getImg());
			break;
		case 2:
			this.setFill(PersonagemImg.MARIO_ESQUERDA.getImg());
			break;
		case 3:
			this.setFill(PersonagemImg.LUIGI_ESQUERDA.getImg());
			break;
		}
	}
	
	
	public void moverX(double quant){
		this.setX(this.getX()+quant);
		
		if(quant>=0) this.setImage(direita);
		else this.setImage(esquerda);
	}
	public void moverY(double quant) {
		this.setY(this.getY()+quant);
	}
	
	public void pular() {
		pulo.setByY(-40);
		pulo.setAutoReverse(true);
		pulo.setCycleCount(2);
		pulo.play();
	}
	
	
}
