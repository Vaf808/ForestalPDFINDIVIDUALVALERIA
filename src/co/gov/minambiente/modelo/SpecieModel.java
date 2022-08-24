package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos una especie objeto de la solicitud
 * @author Andrés Güiza
 */
public class SpecieModel {
    
    private double quantity;
    private String unit;
    private String commonName;
    private String scientificName;
    private String partUsed;
    private String habit;
    private String closure;
    private String threatClassification;
    
    /**
     * Constructor vacío
     */
    public SpecieModel(){
        this.quantity = 0;
        this.unit = "";
        this.commonName = "";
        this.scientificName = "";
        this.partUsed = "";
        this.habit = "";
        this.closure = "";
        this.threatClassification = "";
    }
    
    /**
     * Constructor full
     * @param quantity Cantidad
     * @param unit Unidad de medida
     * @param commonName Nombre común
     * @param scientificName Nombre científico
     * @param partUsed Parte aprovechada
     * @param habit Hábito
     * @param closure Vereda nacional o regional
     * @param threatClassification Categoría de amenaza
     */
    public SpecieModel(double quantity, String unit, String commonName,
            String scientificName, String partUsed, String habit, String closure, 
            String threatClassification) {
        this.partUsed = partUsed;
        this.quantity = quantity;
        this.unit = unit;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.habit = habit;
        this.closure = closure;
        this.threatClassification = threatClassification;
    }
    
    /**
     * Retorna la cantidad
     * @return Cantidad
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Asigna la cantidad
     * @param quantity Cantidad
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Retorna la unidad de medida
     * @return Unidad de medida
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Asigna la unidad de medida
     * @param unit Unidad de medida
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /** 
     * Retorna el nombre común
     * @return Nombre común
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * Asigna el nombre común
     * @param commonName Nombre común
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * Retorna el nombre científico
     * @return Nombre científico
     */
    public String getScientificName() {
        return scientificName;
    }

    /**
     * Asigna el nombre científico
     * @param scientificName Nombre científico
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    /**
     * Retorna el hábito
     * @return Hábito
     */
    public String getHabit() {
        return habit;
    }

    /**
     * Asigna el hábito
     * @param habit Hábito
     */
    public void setHabit(String habit) {
        this.habit = habit;
    }

    /**
     * Retorna la vereda nacional o regional
     * @return Vereda nacional o regional
     */
    public String getClosure() {
        return closure;
    }

    /**
     * Asigna la vereda nacional o regional
     * @param closure Vereda nacional o regional
     */
    public void setClosure(String closure) {
        this.closure = closure;
    }

    /**
     * Retorna la categoría de amenaza
     * @return Categoría de amenaza
     */
    public String getThreatClassification() {
        return threatClassification;
    }

    /**
     * Asigna la categoría de amenaza
     * @param threatClassification Categoría de amenaza
     */
    public void setThreatClassification(String threatClassification) {
        this.threatClassification = threatClassification;
    }
}
