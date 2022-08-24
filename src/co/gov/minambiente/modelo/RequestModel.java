package co.gov.minambiente.modelo;

import java.util.LinkedList;

/**
 * Esta clase contiene los métodos y atributos de una solicitud
 * @author Maritza
 */
public class RequestModel {

    private final String REFERENCE;
    private String typeRequest;
    private InterestedModel interested;
    private LinkedList<PropertyModel> properties;
    private String howToAcquire;
    private CategoryAModel categoryA;
    private CategoryBModel categoryB;
    private CategoryCModel categoryC;
    private CategoryDModel categoryD;
    private DateModel creationDate;
    private String fileNumber;
    private String actNumber;
    private String intendedUse;
    private String methodUtilization;

    /**
     * Constructor
     * @param reference  Número de referencia
     */
    public RequestModel(String reference, DateModel date) {
        this.REFERENCE = reference;
        this.typeRequest = "";
        this.interested = new InterestedModel();
        this.properties = new LinkedList<>();
        this.howToAcquire = "";
        this.fileNumber = "";
        this.actNumber = "";
        this.intendedUse = "";
        this.categoryA = new CategoryAModel();
        this.categoryB = new CategoryBModel();
        this.categoryC = new CategoryCModel();
        this.categoryD = new CategoryDModel();
        this.creationDate = date;
        this.methodUtilization = "";
    }
    
    /**
     * Constructor
     * @param reference Número de referencia
     * @param typeRequest Tipo de solicitud (Nueva, Prórroga)
     * @param interested Instancia del interesado el cual realiza la solicitud
     * @param properties Lista con las instancias de los predios objeto de la solicitud
     */
    public RequestModel(String reference, String typeRequest, InterestedModel interested, LinkedList<PropertyModel> properties) {
        this.REFERENCE = reference;
        this.typeRequest = typeRequest;
        this.interested = interested;
        this.properties = properties;
        this.howToAcquire = "";
        this.fileNumber = "";
        this.actNumber = "";
        this.intendedUse = "";
        this.categoryA = new CategoryAModel();
        this.categoryB = new CategoryBModel();
        this.categoryC = new CategoryCModel();
        this.categoryD = new CategoryDModel();
        this.creationDate = new DateModel();
        this.methodUtilization = "";
    }
    
    /**
     * Constructor full
     * @param REFERENCE Número de referencia
     * @param typeRequest Tipo de solicitud (Nueva, Prórroga)
     * @param interested Interesado el cual realiza la solicitud
     * @param properties Lista con las instancias de los predios objeto de la solicitud
     * @param howToAcquire Modo de adquirir el derecho al uso del recurso (Permiso, Asociación, Concesión Forestal, Autorización)
     * @param categoryA Instancia de la categoría A con la información respectiva
     * @param categoryB Instancia de la categoría B con la información respectiva
     * @param categoryC Instancia de la categoría C con la información respectiva
     * @param categoryD Instancia de la categoría D con la información respectiva
     * @param creationDate Fecha de creación
     * @param fileNumber Número de expediente
     * @param actNumber Número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     * @param intendedUse Uso que se pretende dar a los productos a obtener
     * @param methodUtilization Método de aprovechamiento o manejo sostenible (Mecánico, Manual, Mecánico-Manual)
     */
    public RequestModel(String REFERENCE, String typeRequest, InterestedModel interested,
            LinkedList<PropertyModel> properties, String howToAcquire, CategoryAModel categoryA,
            CategoryBModel categoryB, CategoryCModel categoryC, CategoryDModel categoryD,
            DateModel creationDate, String fileNumber, String actNumber, String intendedUse,
            String methodUtilization) {
        this.REFERENCE = REFERENCE;
        this.typeRequest = typeRequest;
        this.interested = interested;
        this.properties = properties;
        this.howToAcquire = howToAcquire;
        this.categoryA = categoryA;
        this.categoryB = categoryB;
        this.categoryC = categoryC;
        this.categoryD = categoryD;
        this.creationDate = creationDate;
        this.fileNumber = fileNumber;
        this.actNumber = actNumber;
        this.intendedUse = intendedUse;
        this.methodUtilization = methodUtilization;
    }

    /**
     * Retorna el tipo de solicitud (Nueva, Prórroga)
     * @return Tipo de solicitud (Nueva, Prórroga)
     */
    public String getTypeRequest() {
        return typeRequest;
    }
    
    /**
     * Asigna el tipo de solicitud
     * @param typeRequest Tipo de solicitud (Nueva, Prórroga)
     */
    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    /**
     * Retorna la instancia del interesado el cual realiza la solicitud
     * @return Instancia del interesado el cual realiza la solicitud
     */
    public InterestedModel getInterested() {
        return interested;
    }
    
    /**
     * Asigna la instancia del interesado el cual realiza la solicitud
     * @param interested Instancia del interesado el cual realiza la solicitud
     */
    public void setInterested(InterestedModel interested) {
        this.interested = interested;
    }

    /**
     * Retorna la lista con las instancias de los predios objeto de la solicitud
     * @return Lista con las instancias de los predios objeto de la solicitud
     */
    public LinkedList<PropertyModel> getProperties() {
        return properties;
    }
    
    /**
     * Agrega un objeto tipo PropertyModel a la lista con las instancias de los predios objeto de la solicitud
     * @param property Instancia del predio a agregar
     */
    public void addProperties(PropertyModel property) {
        this.properties.add(0, property);
    }

    /**
     * Retorna el modo de adquirir el derecho al uso del recurso (Permiso, Asociación, Concesión Forestal, Autorización)
     * @return Modo de adquirir el derecho al uso del recurso (Permiso, Asociación, Concesión Forestal, Autorización)
     */
    public String getHowToAcquire() {
        return howToAcquire;
    }
    
    /**
     * Asigna el modo de adquirir el derecho al uso del recurso (Permiso, Asociación, Concesión Forestal, Autorización)
     * @param howToAcquire Modo de adquirir el derecho al uso del recurso (Permiso, Asociación, Concesión Forestal, Autorización)
     */
    public void setHowToAcquire(String howToAcquire) {
        this.howToAcquire = howToAcquire;
    }

    /**
     * Retorna la instancia de la categoría A con la información respectiva
     * @return Instancia de la categoría A con la información respectiva
     */
    public CategoryAModel getCategoryA() {
        return categoryA;
    }

    /**
     * Asigna la instancia de la categoría A con la información respectiva
     * @param categoryA Instancia de la categoría A con la información respectiva
     */
    public void setCategoryA(CategoryAModel categoryA) {
        this.categoryA = categoryA;
    }

    /**
     * Retorna la instancia de la categoría B con la información respectiva
     * @return Instancia de la categoría B con la información respectiva
     */
    public CategoryBModel getCategoryB() {
        return categoryB;
    }

    /**
     * Asigna la instancia de la categoría B con la información respectiva
     * @param categoryB Instancia de la categoría B con la información respectiva
     */
    public void setCategoryB(CategoryBModel categoryB) {
        this.categoryB = categoryB;
    }

    /**
     * Retorna la instancia de la categoría C con la información respectiva
     * @return Instancia de la categoría C con la información respectiva
     */
    public CategoryCModel getCategoryC() {
        return categoryC;
    }

    /**
     * Asigna la instancia de la categoría C con la información respectiva
     * @param categoryC Instancia de la categoría C con la información respectiva
     */
    public void setCategoryC(CategoryCModel categoryC) {
        this.categoryC = categoryC;
    }

    /**
     * Retorna la instancia de la categoría D con la información respectiva
     * @return Instancia de la categoría D con la información respectiva
     */
    public CategoryDModel getCategoryD() {
        return categoryD;
    }

    /**
     * Asigna la instancia de la categoría D con la información respectiva
     * @param categoryD Instancia de la categoría D con la información respectiva
     */
    public void setCategoryD(CategoryDModel categoryD) {
        this.categoryD = categoryD;
    }

    /**
     * Retorna la fecha de creación
     * @return Fecha de creación
     */
    public DateModel getCreationDate() {
        return creationDate;
    }

    /**
     * Asigna la fecha de creación
     * @param creationDate Fecha de creación
     */
    public void setCreationDate(DateModel creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retorna el número de referencia
     * @return Número de referencia
     */
    public String getREFERENCE() {
        return REFERENCE;
    }

    /**
     * Retorna el número de expediente
     * @return Número de expediente
     */
    public String getFileNumber() {
        return fileNumber;
    }

    /**
     * Asigna el número de expediente
     * @param fileNumber Número de expediente
     */
    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    /**
     * Retorna el número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     * @return Número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     */
    public String getActNumber() {
        return actNumber;
    }

    /**
     * Asigna el número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     * @param actNumber Número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     */
    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    /**
     * Retorna el uso que se pretende dar a los productos a obtener
     * @return Uso que se pretende dar a los productos a obtener
     */
    public String getIntendedUse() {
        return intendedUse;
    }

    /**
     * Asigna el uso que se pretende dar a los productos a obtener
     * @param intendedUse Uso que se pretende dar a los productos a obtener
     */
    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }

    /**
     * Retorna el método de aprovechamiento o manejo sostenible (Mecánico, Manual, Mecánico-Manual)
     * @return Método de aprovechamiento o manejo sostenible (Mecánico, Manual, Mecánico-Manual)
     */
    public String getMethodUtilization() {
        return methodUtilization;
    }

    /**
     * Asigna el método de aprovechamiento o manejo sostenible (Mecánico, Manual, Mecánico-Manual)
     * @param methodUtilization Método de aprovechamiento o manejo sostenible (Mecánico, Manual, Mecánico-Manual)
     */
    public void setMethodUtilization(String methodUtilization) {
        this.methodUtilization = methodUtilization;
    }
}
