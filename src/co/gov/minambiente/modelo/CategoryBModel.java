package co.gov.minambiente.modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase contiene los métodos y atributos de una categoría B
 * @author Natalia García
 * @see CategoryModel
 */
public class CategoryBModel extends CategoryModel{
    private String typeOperation;
    private ArrayList<String> revenuesExpected;
    private String associatedCategory;

    /**
     * Constructor vacío
     */
    public CategoryBModel() {
        super("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables");
        this.typeOperation = "";
        this.revenuesExpected = new ArrayList<>();
        this.associatedCategory = "";
    }

    /**
     * Constructor full
     * @param typeOperation Clase de manejo sostenible a solicitar (Doméstico, Persistente)
     * @param revenuesExpected Lista de los ingresos esperados de la actividad que se desea realizar en números y letras
     * @param associatedCategory Categoría asociada
     */
    public CategoryBModel(String typeOperation, ArrayList<String> revenuesExpected, String associatedCategory) {
        super("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables");
        this.typeOperation = typeOperation;
        this.revenuesExpected = revenuesExpected;
        this.associatedCategory = associatedCategory;
    }
    
    /**
     * Retorna la clase de manejo sostenible a solicitar (Doméstico, Persistente)
     * @return Clase de manejo sostenible a solicitar (Doméstico, Persistente)
     */ 
    public String getTypeOperation() {
        return typeOperation;
    }

    /**
     * Asigna la clase de manejo sostenible a solicitar (Doméstico, Persistente)
     * @param typeOperation Clase de manejo sostenible a solicitar (Doméstico, Persistente)
     */
    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    /**
     * Retorna la lista de los ingresos esperados de la actividad que se desea realizar en números y letras
     * @return Lista de los ingresos esperados de la actividad que se desea realizar en números y letras
     */
    public ArrayList<String> getRevenuesExpected() {
        return revenuesExpected;
    }

    /**
     * Asigna la lista de los ingresos esperados de la actividad que se desea realizar en números y letras
     * @param revenuesExpected Lista de los ingresos esperados de la actividad que se desea realizar en números y letras
     */
    public void setRevenuesExpected(ArrayList<String> revenuesExpected) {
        this.revenuesExpected = revenuesExpected;
    }

    /**
     * Retorna la categoría asociada
     * @return Categoría asociada
     */
    public String getAssociatedCategory() {
        return associatedCategory;
    }

    /**
     * Asigna la categoría asociada
     * @param associatedCategory Categoría asociada
     */
    public void setAssociatedCategory(String associatedCategory) {
        this.associatedCategory = associatedCategory;
    } 
    
    /**
     * Asigna el nombre
     * @param name Nombre
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Retorna el nombre
     * @return Nombre
     */
    @Override
    public String getName() {
        return super.getName();
    }
}
