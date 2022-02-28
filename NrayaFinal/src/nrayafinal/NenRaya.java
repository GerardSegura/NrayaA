/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nrayafinal;

/**
 *
 * @author gerar
 */
class NenRaya extends Partidas {
    Tablero tab = new Tablero();
    public void jugar() {
        tab.inicializar();
        tab.llamartabla();
        tab.proceso();
    }
}
