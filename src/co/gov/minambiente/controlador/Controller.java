 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.vista.formulario.Principal;

/**
 *
 * @author daniel
 */
public class Controller {
    public static void main(String[] args) {
        co.gov.minambiente.controlador.database.RequestsDatabase.init();
        new Principal().setVisible(true);
    }
}
