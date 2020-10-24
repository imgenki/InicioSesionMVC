package dad.javafx.iniciosesionmvc;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InicioSesionView extends FlowPane {
	Label usuarioLabel;
	TextField usuarioText;
	Label contrasenaLabel;
	PasswordField contrasenaPassword;
	Button accederButton;
	Button cancelarButton;
	GridPane loginGrid;
	HBox botonesBox;
	Alert acierto;
	Alert fallo;
	public InicioSesionView() {
		
		usuarioLabel = new Label("Usuario:");
		usuarioText = new TextField();
		usuarioText.setPromptText("Usuario");

		contrasenaLabel = new Label("Contraseña:");
		contrasenaPassword = new PasswordField();
		contrasenaPassword.setPromptText("Contraseña");

		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		botonesBox = new HBox();
		botonesBox.getChildren().addAll(accederButton, cancelarButton);
		botonesBox.setSpacing(10);
		loginGrid = new GridPane();
		
		loginGrid.addRow(0, usuarioLabel, usuarioText);
		loginGrid.addRow(1, contrasenaLabel, contrasenaPassword);
		loginGrid.addRow(2, botonesBox);
		
		loginGrid.setColumnSpan(botonesBox, 2);
		loginGrid.setHalignment(botonesBox, HPos.CENTER);
		loginGrid.setGridLinesVisible(true);
		getChildren().addAll(loginGrid);
		
		setHgap(2);
		setVgap(4);
		setAlignment(Pos.CENTER);
		setOrientation(Orientation.HORIZONTAL);
		
		
		
		
	}
	
	// Ventana en caso de acierto
	public void acierto() {
		acierto = new Alert(AlertType.INFORMATION);
		acierto.setTitle("Iniciar sesión");
		acierto.setHeaderText("Acceso Permitido");
		acierto.setContentText("Las credenciales de acceso son válidas");

		acierto.showAndWait();
	}
	
	// Ventana en caso de fallo
	public void fallo(String mayorMenor, int numIntroducido) {
		fallo = new Alert(AlertType.WARNING);
		fallo.setTitle("Iniciar sesión");
		fallo.setHeaderText("Acceso denegado");
		fallo.setContentText("El usuario y/o la contraseña no son válidos");

		fallo.showAndWait();

	}
	public Button getAccederButton() {
		return accederButton;
	}
	public Button getCancelarButton() {
		return accederButton;
	}
	public TextField getUsuarioText() {
		return usuarioText;
	}
	
	public PasswordField getConstrasenaPassword() {
		return contrasenaPassword;
	}
	}
