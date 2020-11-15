package dad.javafx.iniciosesionmvc;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

public class InicioSesionController {
	InicioSesionView view = new InicioSesionView();
	InicioSesionModel model = new InicioSesionModel();
	public InicioSesionController() {
		view.getAccederButton().setOnAction(e -> onAccederButtonAction(e));
		view.getCancelarButton().setOnAction(e -> onCancelarButtonAction(e));
		//Cargamos el csv	
		model.loadCSV();
	}
	public InicioSesionView getView() {
		return view;
	}
	public InicioSesionModel getModel() {
		return model;
	}

	private void onAccederButtonAction (ActionEvent e){
		//Establecer Usuario y Contraseña en el modelo
		model.usernameProperty().set(view.getUsuarioText().textProperty().getValue());
		model.passwordProperty().set(view.getConstrasenaPassword().textProperty().getValue());
		
		//Convertimos nuestra contraseña a MD5
		model.setMd5();
		
		//Comprobamos si coincide o no
		try {
			if (model.checkMd5())
				view.getAciertoAlert();
			else
				view.getFalloAlert();
		} catch (IOException e1) {
			//view.getFalloAlert();
			System.out.print("algo no va bien");
		}
			
	}
	
	private void onCancelarButtonAction (ActionEvent e){
		Platform.exit();
	}

}