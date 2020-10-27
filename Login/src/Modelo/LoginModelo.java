package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginModelo {

    private String Usuario;
    private String Contraseña;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public boolean BuscarUsuario() {
        String record = null;
        FileReader in = null;
        boolean existe = false;
        try {
            in = new FileReader("src/Registro/Usuarios.txt");
            BufferedReader br = new BufferedReader(in);
            while ((record = br.readLine()) != null) {
                String[] word = record.split(", ");
                if (word[1].equals(this.Usuario.toString()) && Controlador.AES.decrypt(word[2]).toString().equals(this.Contraseña.toString())) {
                    System.out.println("Bienvenido");
                    existe = true;
                }
            }
            if (!existe) {
                System.out.println("Usuario o contraseña incorrecto.");
            }
        } catch (IOException err) {
        } catch (Exception ex) {
        }

        return existe;
    }

}
