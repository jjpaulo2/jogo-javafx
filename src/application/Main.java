package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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
		
		Pane paneMenu = new Pane();
		Menu menu = new Menu(paneMenu,450,214);
		
		Pane paneJogo = new Pane();	
		Jogo jogo = new Jogo(paneJogo, 450, 214);
		primaryStage.setScene(menu);
		
		menu.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					jogo.limparJogadores(paneJogo);
					jogo.setQuantPlayers(menu.getModoDeJogo());
					jogo.plotarJogadores(paneJogo);
					primaryStage.setScene(jogo);
				}
				
				if(event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.DOWN)) {
					switch (menu.getModoDeJogo()) {
					case 1:
						menu.setModoDeJogo(2);
						menu.navegarMenu(menu.getModoDeJogo());
						break;
					default:
						menu.setModoDeJogo(1);
						menu.navegarMenu(menu.getModoDeJogo());
						break;
					}
				}
			}
		});
		
		jogo.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ESCAPE)) {
					primaryStage.setScene(menu);
				}
				
				if (event.getCode().equals(KeyCode.RIGHT)) {
					jogo.mario.moverX(10);
				}
				if (event.getCode().equals(KeyCode.LEFT)) {
					jogo.mario.moverX(-10);
				}
				if (event.getCode().equals(KeyCode.DOWN)) {	
					// função agachar
				}
				if (event.getCode().equals(KeyCode.UP)) {	
					jogo.mario.pular();
				}
				
				if (event.getCode().equals(KeyCode.D)) {
					jogo.luigi.moverX(10);
				}
				if (event.getCode().equals(KeyCode.A)) {
					jogo.luigi.moverX(-10);
				}
				if (event.getCode().equals(KeyCode.S)) {	
					// função pular
				}
				if (event.getCode().equals(KeyCode.W)) {
					jogo.luigi.pular();
				}
			}
		});
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Super Mario Bros");
		primaryStage.show();
		
	}
	
	
}
