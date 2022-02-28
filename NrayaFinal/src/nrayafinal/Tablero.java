import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Tablero extends Partidas {
    
    char espacio = '-';
    boolean jugador = true;
    int fila, columna;
    int n, ultimo;
    char tablero[][];
    static Scanner datos=new Scanner(System.in);
    void proceso() {

        boolean fin = false;
        do {
            //metodo muestra tabla que toma valor de tabla dentro del bucle

            muestraTabla();
            declaracionFichas();
            introducirValores();            //tabla adquiere los valores de fila y columna que sera igual all espacio.
            tablero[fila][columna] = espacio;
            mostrarGanador();

        } while (!fin);
    }
    public void inicializar() {
        System.out.println("Ingresar cantidad de rayas en la partida");
        n = datos.nextInt();
        if (n > 2) {
            tablero = new char[n][n];
        } else {
            System.out.println("Ingrese un numero valido mayor a 2");
            inicializar();
        }

    }
    public boolean declaracionFichas() {
        //si jugador1 es verdadero espacio es = a X si no es =O
        if (jugador) {
            espacio = 'X';
        } else {
            espacio = 'O';
        }

        //si es jugador 1 verdadero mostrar turno jugador 1 sino turno jugador 2 
        if (jugador) {
            System.out.println("Turno de " + player[0].nombre + " " + player[0].apellido);

        } else {
            System.out.println("Turno de " + player[1].nombre + " " + player[1].apellido);
        }
        jugador = !jugador;
        return jugador;
    }

    public void ganador() {
        // si valor es igual a J1 gana J1 y si no pues gana J2
        if (espacio == 'X') {
            System.out.println("El ganador es" + player[0].nombre+" "+player[0].apellido);
        } else if (espacio == 'O') {
            System.out.println("El ganador es" + player[1].nombre + " " + player[1].apellido);
        }
    }

    public boolean mostrarGanador() {
        // igualamos valor al char que devuelve el metodo comprobarLinea
        char valor = comprobarLinea();
        // si es distinto a neutral entra y ejecuta el metodo ganador
        if (valor != espacio) {
            // ejecuta el metodo ganador que nos dira que jugador gana
            ganador();
            return true;
        }
        valor = comprobarColumna();
        if (valor != espacio) {
            ganador();
            return true;
        }
        valor = comprobarDiagonalPrincipal();
        if (valor != espacio) {
            ganador();
            return true;
        }
        valor = comprobarDiagonalInversa();
        if (valor != espacio) {
            ganador();
            return true;
        }
        // en caso de que ninguna condicion se cumpla te mostrara que es un empate
        System.out.println("Es un empate");
        return false;
    }

    public void introducirValores() {
        boolean turnoAcabado = false;
        do {
            System.out.print("");
            System.out.println(" Introducir fila ");
            System.out.print("");
            fila = datos.nextInt();

            System.out.print("");
            System.out.println(" Introducir columna ");
            System.out.print("");
            columna = datos.nextInt();

            if (comprobarExisteOcupado()) {
                tablero[fila][columna] = espacio;
                turnoAcabado = true;
            }
        } while (!turnoAcabado);
    }

    public boolean comprobarExisteOcupado() {

        if (existePosicion() && posicionNoOcupada()) {
            return true;
        }
        return false;

    }

    public boolean existePosicion() {
        if (fila < 0 || fila > tablero.length || columna < 0 || columna >= tablero.length) {
            System.out.println("La posición es incorrecta, introduzca una entre 0 y el numero ingresado " + n);
            return false;
        }
        return true;
    }

    public boolean posicionNoOcupada() {

        if (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
            System.out.println("Esa posición ya está ocupada Selecciona otra.");
            return false;
        } else {
            return true;
        }

    }

    //tabla
    public void llamartabla() {
        for (char[] tabla1 : tablero) {
            for (int j = 0; j < tablero.length; j++) {
                tabla1[j] = '-';
            }
        }
    }

    //mostrar la tabla llamada dentro del bucle do while
    public void muestraTabla() {

        for (char[] tablero1 : tablero) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("[ " + tablero1[j] + " ]");
            }
            System.out.println();
        }
    }

    //Seleccionando el ganador de la partida solucionado con if else
    public boolean comprobaciones() {
        // si se cumplen las condiciones se acaba la partida y si no regresa false para que siga
        if (empate() || comprobarLinea() != espacio
                || comprobarColumna() != espacio
                || comprobarDiagonalPrincipal() != espacio
                || comprobarDiagonalInversa() != espacio) {
            return true;
        }
        return false;
    }

    public char comprobarLinea() {
        // comprobamos si hay coincidencias en las lineas
        char valor;
        boolean comprobar;
        for (int i = 0; i < tablero.length; i++) {
            comprobar = true;
            // igualo valor al primer simbolo de la primera fila y lo uso para comparar
            valor = tablero[i][0];
            // si ya desde el principio es igual a neutral regresa neutral
            if (valor != espacio) {
                for (int j = 1; j < tablero[i].length; j++) {
                    // si es diferente de la siguiente posicion, regresa neutral
                    if (valor != tablero[i][j]) {
                        comprobar = false;
                    }
                }
                // si todo va bien comprobar sigue siendo true y regresa el valor
                if (comprobar) {
                    return valor;
                }
            }
        }
        return espacio;
    }

    public char comprobarColumna() {
        // comprobamos si hay coincidencias en las lineas
        char valor;
        boolean comprobar;
        for (int i = 0; i < tablero.length; i++) {
            comprobar = true;
            // igualo valor al primer simbolo de la primera columna y lo uso para comparar
            valor = tablero[0][i];
            // si ya desde el principio es igual a neutral regresa neutral
            if (valor != espacio) {
                for (int j = 1; j < tablero[i].length; j++) {
                    // si es diferente de la siguiente posicion, regresa neutral
                    if (valor != tablero[j][i]) {
                        comprobar = false;
                    }
                }
                // si todo va bien comprobar sigue siendo true y regresa el valor
                if (comprobar) {
                    return valor;
                }
            }
        }
        return espacio;
    }

    public char comprobarDiagonalPrincipal() {
        // comprobamos si hay coincidencias en las lineas
        char valor;
        boolean comprobar = true;
        // igualo valor al primer simbolo de la primera columna y lo uso para comparar
        valor = tablero[0][0];
        // si ya desde el principio es igual a neutral regresa neutral
        if (valor != espacio) {
            for (int i = 1; i < tablero.length; i++) {
                // damos como fila y columna a i para que vaya aumentando y haga 00 11 y 22
                // que son las posiciones que queremos comprobar y las comparamos con valor
                if (valor != tablero[i][i]) {
                    comprobar = false;
                }
            }
            // si todo va bien comprobar sigue siendo true y regresa el valor
            if (comprobar) {
                return valor;
            }
        }
        return espacio;
    }

    public char comprobarDiagonalInversa() {
        // comprobamos si hay coincidencias en las lineas
        char valor;
        boolean comprobar = true;
        // igualo valor al primer simbolo de la primera fila y la posicion 2
        valor = tablero[0][ultimo];
        // si ya desde el principio es igual a neutral regresa neutral
        if (valor != espacio) {
            // creo dos variables para que una vaya ascendiendo y la otra descendiendo
            // de forma que hagamos 02 11 y 20
            for (int i = 1, j = ultimo - 1; i < tablero.length; i++, j--) {
                // comprobamos las posiciones comparandolas con valor
                if (valor != tablero[i][j]) {
                    comprobar = false;
                }
            }
            // si todo va bien comprobar sigue siendo true y regresa el valor
            if (comprobar) {
                return valor;
            }
        }
        return espacio;
    }

    public boolean empate() {
        // recorremos la matriz y en el momento de que una posicion sea igual a neutral se puede seguir jugando
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == espacio) {
                    return false;
                }
            }
        }
        // si no es igual ninguno regresa true y significa que esta lleno
        return true;
    }

}
