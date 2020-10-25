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

public class InicioSesionView extends GridPane {
	Label usuarioLabel;
	TextField usuarioText;
	Label contrasenaLabel;
	PasswordField contrasenaPassword;
	Button accederButton;
	Button cancelarButton;
	HBox botonesBox;
	Alert aciertoAlert;
	Alert falloAlert;

	public InicioSesionView() {
		// Usuario
		usuarioLabel = new Label("Usuario:");
		usuarioText = new TextField();
		usuarioText.setPromptText("Usuario");
		
		// Contrasena
		contrasenaLabel = new Label("Contraseña:");
		contrasenaPassword = new PasswordField();
		contrasenaPassword.setPromptText("Contraseña");
		
		//HBox botones
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		botonesBox = new HBox();
		botonesBox.getChildren().addAll(accederButton, cancelarButton);
		botonesBox.setSpacing(10);
		botonesBox.setAlignment(Pos.CENTER);
		botonesBox.setPadding(new Insets(5));
		
		//Panel Login
		addRow(0, usuarioLabel, usuarioText);
		addRow(1, contrasenaLabel, contrasenaPassword);
		addRow(2, botonesBox);

		setPadding(new Insets(15));
		setHgap(35);
		setVgap(15);
		setAlignment(Pos.CENTER);
		GridPane.setColumnSpan(botonesBox, 2);
	}

	// Ventana en caso de acierto
	public void getAciertoAlert() {
		aciertoAlert = new Alert(AlertType.INFORMATION);
		aciertoAlert.setTitle("Iniciar sesión");
		aciertoAlert.setHeaderText("Acceso Permitido");
		aciertoAlert.setContentText("Las credenciales de acceso son válidas");

		aciertoAlert.showAndWait();
	}

	// Ventana en caso de fallo
	public void getFalloAlert() {
		falloAlert = new Alert(AlertType.WARNING);
		falloAlert.setTitle("Iniciar sesión");
		falloAlert.setHeaderText("Acceso denegado");
		falloAlert.setContentText("El usuario y/o la contraseña no son válidos");

		falloAlert.showAndWait();

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
