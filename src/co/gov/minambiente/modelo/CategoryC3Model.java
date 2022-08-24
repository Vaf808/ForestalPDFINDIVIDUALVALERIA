package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría C3
 * @author Natalia García
 * @see CategoryCModel
 */
public class CategoryC3Model extends CategoryCModel{
    private String tipo;
    private String individualStatus;
    private String cause;

    /**
     * Constructor
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryC3Model(String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.individualStatus = "";
        this.cause = "";
    }
    
    /**
     * Constructor full
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @param tipo Tipo de actividad (Tala, Poda)
     * @param individualStatus Estado del individuo
     * @param cause Causa o perjuicio
     */
    public CategoryC3Model(String locationOrType, String tipo, String individualStatus, String cause) {
        super(locationOrType);
        this.tipo= tipo;
        this.individualStatus = individualStatus;
        this.cause = cause;
    }

    /**
     * Retorna el tipo de actividad (Tala, Poda)
     * @return Tipo de actividad (Tala, Poda)
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de actividad (Tala, Poda)
     * @param tipo Tipo de actividad (Tala, Poda)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el estado del individuo
     * @return Estado del individuo
     */
    public String getIndividualStatus() {
        return individualStatus;
    }

    /**
     * Asigna el estado del individuo
     * @param individualStatus Estado del individuo
     */
    public void setIndividualStatus(String individualStatus) {
        this.individualStatus = individualStatus;
    }

    /**
     * Retorna la causa o perjuicio
     * @return Causa o perjuicio
     */
    public String getCause() {
        return cause;
    }

    /**
     * Asigna la causa o perjuicio
     * @param cause Causa o perjuicio
     */
    public void setCause(String cause) {
        this.cause = cause;
    }
    
    /**
     * Retorna el nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    @Override
    public void setLocationOrType(String locationOrType) {
        super.setLocationOrType(locationOrType);
    }

    /**
     * Asigna el nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @return Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    @Override
    public String getLocationOrType() {
        return super.getLocationOrType();
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
