package co.gov.minambiente.modelo;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Esta clase contiene los métodos y atributos de un departamento
 * @author Andrés Güiza
 */
public class DepartmentModel{
    
    private final String DEPARTMENTNAME;
    private final LinkedList<String> MUNICIPALITIES;
    
    /**
     * Constructor vacío
     */
    public DepartmentModel(){
        this.DEPARTMENTNAME = new String();
        this.MUNICIPALITIES = new LinkedList<>();
    }
    
    /**
     * Constructor
     * @param departmentName Nombre
     */
    public DepartmentModel(String departmentName){
        this.MUNICIPALITIES = new LinkedList<>();
        this.DEPARTMENTNAME = departmentName;
    }
    
    /**
     * Constructor full
     * @param departmentName Nombre
     * @param MUNICIPALITIES Lista de municipios
     */
    public DepartmentModel(String departmentName, LinkedList<String> MUNICIPALITIES){
        this.DEPARTMENTNAME = departmentName;
        this.MUNICIPALITIES = MUNICIPALITIES;
    }
    
    /**
     * Retorna el nombre
     * @return Nombre
     */
    public String getDEPARTMENTNAME() {
        return DEPARTMENTNAME;
    }

    /**
     * Retorna la lista de municipios
     * @return Lista de municipios
     */
    public LinkedList<String> getMUNICIPALITIES() {
        return MUNICIPALITIES;
    }
    
    /**
     * Retorna el nombre del departamento con su lista de municipios
     * @return Nombre del departamento con su lista de municipios
     */
    @Override
    public String toString() {
        return "Department{" + "departmentName=" + DEPARTMENTNAME + ", MUNICIPALITIES=" + MUNICIPALITIES + '}';
    }  
}
