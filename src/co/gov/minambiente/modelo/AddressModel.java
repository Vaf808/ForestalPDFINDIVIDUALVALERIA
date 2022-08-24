package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una dirección
 * @author Maritza
 */
public class AddressModel {
    
    private String street;
    private String typeArea;
    private String department;
    private String municipality;
    private String sidewalk;

   /**
    * Constructor vacío
    */
    public AddressModel(){
        this.street = "";
        this.typeArea = "";
        this.department = "";
        this.municipality = "";
        this.sidewalk = "";
    }
    
    /**
     * Constructor full
     * @param street Dirección
     * @param typeArea Tipo de área (Rural, Urbana)
     * @param department Departamento
     * @param municipality Municipio
     * @param sidewalk Vereda
     */
    public AddressModel(String street, String typeArea, String department, String municipality, String sidewalk){
        this.street = street;
        this.typeArea = typeArea;
        this.department = department;
        this.municipality = municipality;
        this.sidewalk = sidewalk;
    }
    
    /**
     * Constructor
     * @param street Dirección
     * @param typeArea Tipo de área (Rural, Urbana)
     * @param department Departamento
     * @param municipality Municipio
     */
    public AddressModel(String street, String typeArea, String department, String municipality){
        this.street = street;
        this.typeArea = typeArea;
        this.department = department;
        this.municipality = municipality;
    }
    
    /**
     * Retorna la dirección
     * @return Dirección
     */
    public String getStreet() {
        return street;
    }

    /**
     * Asigna la dirección
     * @param street Dirección
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Retorna el tipo de área (Rural, Urbana)
     * @return Tipo de área (Rural, Urbana)
     */
    public String getTypeArea() {
        return typeArea;
    }

    /**
     * Asigna el tipo de área (Rural, Urbana)
     * @param typeArea Tipo de área (Rural, Urbana)
     */
    public void setTypeArea(String typeArea) {
        this.typeArea = typeArea;
    }

    /**
     * Retorna el departamento
     * @return Departamento
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Asigna el departamento
     * @param department Departamento
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Retorna la vereda
     * @return Vereda
     */
    public String getSidewalk() {
        return sidewalk;
    }

    /**
     * Asigna la vereda
     * @param sidewalk Vereda
     */
    public void setSidewalk(String sidewalk) {
        this.sidewalk = sidewalk;
    }

    /**
     * Retorna el municipio
     * @return Municipio
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Asigna el municipio
     * @param municipality Municipio
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    
    
}
