/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador.database;

import co.gov.minambiente.modelo.RequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 *
 * @author daniel
 */
public class JSONController {

    private final String REQUESTS_PATH = "./databases/requests.json";
    private final ObjectMapper om = new ObjectMapper();

    public boolean fileExists(String path){
        return (new File(path).exists());
    }
    
    public void createFile(String path) {
        try{
            FileWriter writer = new FileWriter(path);
            writer.write("[]");
            writer.close();
        } catch (java.io.IOException e){
        }
    }
    
    public void saveRequestsDatabase() {
        ArrayList<RequestModel> db = RequestsDatabase.getDatabase();
        if (!fileExists(REQUESTS_PATH)){
            createFile(REQUESTS_PATH);
        }
        try{
            om.writerWithDefaultPrettyPrinter().writeValue(new File(REQUESTS_PATH), db);
        } catch (java.io.IOException e){
        }
    }

    public void loadRequestsDatabase() {
        System.out.println("load");
        ArrayList<java.util.LinkedHashMap> lista;
        try {
            lista = om.readerFor(ArrayList.class).readValue(new File(REQUESTS_PATH));
            System.out.print("Lista: ");
            System.out.println(lista);
            ObjectInstantiator oi;
            for (java.util.LinkedHashMap hm : lista){
                oi = new ObjectInstantiator(hm);
                RequestsDatabase.add(oi.getRequestInstance());
            }
        } catch (com.fasterxml.jackson.core.JsonProcessingException ex) {
            ex.printStackTrace();
            System.out.println(ex.getClass().getSimpleName());
            System.exit(0);
        } catch (java.io.IOException e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
            System.exit(0);
        }

    }
}
    
