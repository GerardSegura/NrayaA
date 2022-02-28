package nrayafinal;
import java.util.Scanner;

public class jugadores {

    protected Scanner datos = new Scanner(System.in);
    protected String nombre, apellido;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido() {
        this.apellido = datos.nextLine();
    }

    public void setNombre() {
        this.nombre = datos.nextLine();
    }
}
