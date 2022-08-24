package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría C2
 * @author Natalia García
 * @see CategoryCModel
 */
public class CategoryC2Model extends CategoryCModel{

    /**
     * Constructor
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryC2Model(String locationOrType) {
        super(locationOrType);
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
