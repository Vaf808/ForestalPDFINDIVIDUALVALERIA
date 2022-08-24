package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría C
 * @author Natalia García
 * @see CategoryModel
 */
public class CategoryCModel extends CategoryModel{
    private String locationOrType;
    
    /**
     * Constructor vacío
     */
    public CategoryCModel() {
        super("C. Árboles Aislados");
        this.locationOrType = "";
    }
    
    /**
     * Constructor full
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryCModel(String locationOrType) {
        super("C. Árboles Aislados");
        this.locationOrType = locationOrType;
    }

    /**
     * Retorna el nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @return Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public String getLocationOrType() {
        return locationOrType;
    }
    
    /**
     * Asigna el nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public void setLocationOrType(String locationOrType) {
        this.locationOrType = locationOrType;
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
