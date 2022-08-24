package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una persona
 * @author Maritza
 */
public abstract class PersonModel {

    private String name;
    private String typeId;
    private String id;
    
    /**
     * Constructor vacío
     */
    public PersonModel(){
        
    }

    /**
     * Constructor full
     * @param name Nombre
     * @param typeId Tipo de identificación (CC, CE, PA, NIT)
     * @param id Número de identificación
     */
    public PersonModel(String name, String typeId, String id) {
        this.name = name;
        this.typeId = typeId;
        this.id = id;
    }
    
    /**
     * Retorna el nombre
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna el nombre
     * @param name Nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna el tipo de identificación (CC, CE, PA, NIT)
     * @return Tipo de identificación (CC, CE, PA, NIT)
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Asigna el tipo de identificación (CC, CE, PA, NIT)
     * @param typeId Tipo de identificación (CC, CE, PA, NIT)
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * Retorna el número de identificación
     * @return Número de identificación
     */
    public String getId() {
        return id;
    }

    /**
     * Asigna el número de identificación
     * @param id Número de identificación
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
