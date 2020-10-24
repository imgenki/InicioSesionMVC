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

public class InicioSesionModel {
	private String username;
	private String password;
	private String md5;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5() {
		this.md5 = DigestUtils.md5Hex(password).toUpperCase();
	}

	public static List<String> leerLineaALinea(File fichero, Charset charset) throws IOException {
		List<String> lines = new ArrayList<String>();
		FileReader fr = new FileReader(fichero, charset);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		br.close();
		fr.close();
		return lines;
	}

	public boolean compareMD5() throws IOException {
		Consumer<String> printer = l -> {
			String[] parts = l.split(",");
			String username = parts[0];
			String password = parts[1];
			
			List<String> lines1 = null;
			try {
				lines1 = leerLineaALinea(new File("datos.csv"), Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lines1.stream().forEach(printer);
		};

	}

}
