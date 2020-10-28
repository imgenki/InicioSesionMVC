package dad.javafx.iniciosesionmvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionModel {
	private StringProperty username = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private String md5;
	private BufferedReader csvReader;
	ArrayList<String> md5List = new ArrayList<>();

	public final StringProperty usernameProperty() {
		return this.username;
	}

	public final String getUsername() {
		return this.usernameProperty().get();
	}

	public final void setUsername(final String username) {
		this.usernameProperty().set(username);
	}

	public final StringProperty passwordProperty() {
		return this.password;
	}

	public final String getPassword() {
		return this.passwordProperty().get();
	}

	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5() {
		this.md5 = DigestUtils.md5Hex(getPassword()).toUpperCase();
	}

	public void loadCSV() {
		try {
			String line;
			csvReader = new BufferedReader(new FileReader("./resources/users.csv", Charset.forName("UTF-8")));

			while ((line = csvReader.readLine()) != null)
				md5List.add(line);

			csvReader.close();
		} catch (IOException e) {

		}
	}

	boolean checkMd5() throws IOException {
		Boolean resultado = false;
		setMd5();
		for (int i = 0; i < md5List.size(); i++) {
			String[] data = md5List.get(i).split(",");
			String username = data[0];
			String password = data[1];

			if (username.equals(getUsername()) && password.equals(getMd5())) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}

}
