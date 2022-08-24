package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de un apoderado
 * @author Maritza
 * @see PersonModel
 */
public class AttorneyModel extends PersonModel {
    
    private String profesionalCard;
    
    /**
     * Constructor vacío
     */
    public AttorneyModel(){
        this.profesionalCard = "";
    }

    /**
     * Constructor
     * @param profesionalCard Número de tarjeta profesional
     */
    public AttorneyModel(String profesionalCard) {
        this.profesionalCard = profesionalCard;
    }

    /**
     * Constructor full
     * @param profesionalCard Número de tarjeta profesional
     * @param name Nombre
     * @param typeId Tipo de identificación
     * @param id Número de identificación
     */
    public AttorneyModel(String profesionalCard, String name, String typeId, String id) {
        super(name, typeId, id);
        this.profesionalCard = profesionalCard;
    }
    
    /**
     * Retorna el número de tarjeta profesional
     * @return Número de tarjeta profesional
     */
    public String getProfesionalCard() {
        return profesionalCard;
    }

    /**
     * Asigna el número de tarjeta profesional
     * @param profesionalCard Número de tarjeta profesional
     */
    public void setProfesionalCard(String profesionalCard) {
        this.profesionalCard = profesionalCard;
    }

        /**
     * Asigna el número de identificación
     * @param id Número de identificación
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }

    /**
     * Retorna el número de identificación
     * @return Número de identificación
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /**
     * Asigna el tipo de identificación
     * @param typeId Tipo de identificación
     */
    @Override
    public void setTypeId(String typeId) {
        super.setTypeId(typeId);
    }

    /**
     * Retorna el tipo de identificación
     * @return Tipo de identificación
     */
    @Override
    public String getTypeId() {
        return super.getTypeId();
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
