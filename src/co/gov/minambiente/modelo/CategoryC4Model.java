package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría C4
 * @author Natalia García
 * @see CategoryCModel
 */
public class CategoryC4Model extends CategoryCModel{
    private String tipo;
    private String activity;
    
    /**
     * Constructor
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryC4Model(String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.activity = "";
    }
    
    /**
     * Constructor full
     * @param tipo Tipo de actividad (Tala, Transplante/Reubicación)
     * @param activity Actividad dentro de obras de infraestructura
     * @param locationOrType Nombre (Ubicación o tipo de solicitud de los individuos objeto de aprovechamiento)
     */
    public CategoryC4Model(String tipo, String activity, String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.activity = activity;
    }

    /**
     * Retorna el tipo de actividad (Tala, Transplante/Reubicación)
     * @return Tipo de actividad (Tala, Transplante/Reubicación)
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de actividad (Tala, Transplante/Reubicación)
     * @param tipo Tipo de actividad (Tala, Transplante/Reubicación)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna la actividad dentro de obras de infraestructura
     * @return Actividad dentro de obras de infraestructura
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Asigna la actividad dentro de obras de infraestructura
     * @param activity Actividad dentro de obras de infraestructura
     */
    public void setActivity(String activity) {
        this.activity = activity;
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
