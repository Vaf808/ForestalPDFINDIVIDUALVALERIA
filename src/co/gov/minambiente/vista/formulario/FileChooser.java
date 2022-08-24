/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.vista.formulario;

// Tomado de: https://www.geeksforgeeks.org/java-swing-jfilechooser/
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class FileChooser extends JFileChooser implements ActionListener {

    // a default constructor
    FileChooser() {
    }

    public String getPath() {
        String path = null;

        // invoke the showsSaveDialog function to show the save dialog
        int r = this.showSaveDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION) {
            path = this.getSelectedFile().getAbsolutePath();
            if (new File(path).exists()) {
                if (!(JOptionPane.showConfirmDialog(null, "El archivo especificado ya existe, ¿desea sobreescribirlo?") == 0)) {
                    return null;
                }
            }
        }
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();

        if (com.equals("save")) {
            // create an object of JFileChooser class
            String path;
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                path = j.getSelectedFile().getAbsolutePath();
                if (new File(path).exists()) {
                    if (!(JOptionPane.showConfirmDialog(null, "El archivo especificado ya existe, ¿desea sobreescribirlo?") == 0)) {
                        return;
                    }
                } else {
                    // PDFController Enviar path para guardar pdf
                }
            }
        }
    }
}
