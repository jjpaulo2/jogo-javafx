package application;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
			this.setFill(new ImagePattern(new Image("img/marioDireita.png")));
			break;
		case 1:
			this.setFill(new ImagePattern(new Image("img/luigiDireita.png")));
			break;
		case 2:
			this.setFill(new ImagePattern(new Image("img/marioEsquerda.png")));
			break;
		case 3:
			this.setFill(new ImagePattern(new Image("img/luigiEsquerda.png")));
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
