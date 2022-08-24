package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría
 * @author Maritza
 */
public abstract class CategoryModel{
    
    private String name;
    
    /**
     * Constructor vacío
     */
    public CategoryModel(){
        this.name = "";
    }
    
    /**
     * Constructor full
     * @param name Nombre
     */
    public CategoryModel(String name){
        this.name = name;
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
}
