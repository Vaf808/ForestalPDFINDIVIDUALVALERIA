package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría C1
 * @author Natalia García
 * @see CategoryCModel
 */
public class CategoryC1Model extends CategoryCModel{
    private String individualStatus;

    /**
     * Constructor
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryC1Model(String locationOrType) {
        super(locationOrType);
        individualStatus = "";
    }

    /**
     * Constructor full
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @param individualStatus Estado del individuo
     */
    public CategoryC1Model(String locationOrType, String individualStatus) {
        super(locationOrType);
        this.individualStatus = individualStatus;
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
