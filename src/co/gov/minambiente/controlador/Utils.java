/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.DepartmentModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Andrés Güiza
 */
public class Utils {

    public static String[] loadFile(File directory) throws IOException, FileNotFoundException {
        int contador = 0;
        String temporal = "";
        String[] cutter;
        FileReader fr = null;
        try {

            fr = new FileReader(directory);
            BufferedReader br = new BufferedReader(fr);
            String entrada;
            int cont = 0;
            try {
                while (((entrada = br.readLine()) != null)) {

                    temporal = temporal + entrada + "\n";
                    cont++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cutter = temporal.split("-");
        return cutter;
    }

    /**
     *
     * @param tabla Archivo File con la dirección de la tabla a cargar
     * @return Retorna una lista de departamentos que tiene a su vez una lista
     * de municipalities
     * @throws IOException Excepcion de entrada y salida
     * @throws FileNotFoundException Excepción de archivo no encontrado
     */
    public static LinkedList<DepartmentModel> loadMunicipalities(File tabla) throws IOException, FileNotFoundException {

        LinkedList<String> municipalities = new LinkedList<>();
        LinkedList<DepartmentModel> departments = new LinkedList<>();
        boolean esPrimero = true;
        int contador = 0;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(tabla), "ISO-8859-1"));
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el directorio");
        }

        String temporal = "";
        String[] cutter;
        String entrada;
        String temporalDepartment = "";

        try {

            while (((entrada = br.readLine()) != null)) {

                temporal = entrada;
                cutter = temporal.split("-");

                if (esPrimero) {
                    esPrimero = false;
                    municipalities.add(cutter[1]);
                } else if (temporalDepartment.equals(cutter[0])) {
                    municipalities.add(cutter[1]);
                } else {
                    departments.add(new DepartmentModel(temporalDepartment, municipalities));
                    municipalities = new LinkedList<>();
                    municipalities.add(cutter[1]);
                }
                temporalDepartment = cutter[0];

            }

            departments.add(new DepartmentModel(temporalDepartment, municipalities));

        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }

    public static String capString(String str, int length) {
        return (length >= str.length() ? str : str.substring(0, length));
    }

    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String stripSpaces(String string){
        String str = "";
        for (char c : string.toCharArray()){
            if (c != ' '){
                str += c;
            }
        }
        return str;
    }
    
    public static String[] toStringArray(java.util.ArrayList<String> list){
        String[] array = new String[list.size()];
        int i = 0;
        for (String s : list){
            array[i] = s;
            i++;
        }
        return array;
    }
    
    public static void main(String[] args) {
        String[] a= splitPath("C:\\path\\to\\somewhere.txt");
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
    
    public static String[] splitPath(String path){
        if (path == null){
            return null;
        }
        String[] array = new String[2];
        array[0] = path.substring(0,path.lastIndexOf("\\")+1);
        array[1] = path.substring(path.lastIndexOf("\\")+1,path.length());
        return array;
    }
    
    public static String modifyExtension(String path, String extension){
        int i = path.lastIndexOf(".");
        if (i == -1){
            return path + "." + extension;
        }
        else {
            return path.substring(0,i+1) + extension;
        }
    }
}
