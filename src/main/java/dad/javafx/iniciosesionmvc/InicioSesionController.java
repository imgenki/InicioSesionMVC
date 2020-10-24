package dad.javafx.iniciosesionmvc;

import javafx.event.ActionEvent;
import javafx.scene.Scene;

public class InicioSesionController {
	InicioSesionView view = new InicioSesionView();
	InicioSesionModel model = new InicioSesionModel();
	public InicioSesionController() {
		view.getAccederButton().setOnAction(e -> onAccederButtonAction(e));
		view.getCancelarButton().setOnAction(e -> onCancelarButtonAction(a));
	}
	public InicioSesionView getView() {
		return view;
	}
	private void onAccederButtonAction (ActionEvent e){
		model.setUsername(view.getUsuarioText().textProperty());
		model.setPassword(view.getConstrasenaPassword().textProperty());
		model.setMd5();
		model.compareMD5;
	}
	
	private void onCancelarButtonAction (ActionEvent a){
		
	}
//	public InicioSesionModel getModel() {
		
	}

