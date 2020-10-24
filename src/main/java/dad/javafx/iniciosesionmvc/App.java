package dad.javafx.iniciosesionmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private InicioSesionController inicioSesionController;
	
	public void start(Stage primaryStage) throws Exception {
		inicioSesionController = new InicioSesionController();
		
		Scene scene = new Scene(inicioSesionController.getView(), 640, 480);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Inicio de Sesión");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
