/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nrayafinal;

import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Partidas extends jugadores{

    static jugadores[] player = new jugadores[2];

    static boolean fin = false;

    public static void main(String[] args) {
        System.out.println("Ingrese el nombre y apellido de el jugador1");
        player[0] = new jugadores();
        player[0].setNombre();
        player[0].setApellido();

        System.out.println("Ingrese el nombre y apellido de el jugador2");
        player[1] = new jugadores();
        player[1].setNombre();
        player[1].setApellido();
        Scanner datos = new Scanner(System.in);

        System.out.println("Cuantas partidas quiere jugar de N en raya");
        int n = datos.nextInt();
        do {

            for (int j = 0; j < n; j++) {
                NenRaya partida = new NenRaya();
                partida.jugar();
            }

            if (n == 0) {
                fin = true;
            }
        } while (!fin);
        System.out.println("Se han acabado las partidas gracias por jugar");

    }
    
}
