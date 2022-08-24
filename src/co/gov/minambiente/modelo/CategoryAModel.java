package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría A
 * @author Andrés Güiza
 * @see CategoryModel
 */
public class CategoryAModel extends CategoryModel {
    
    private String typeUtilization;

    /**
     * Constructor vacío
     */
    public CategoryAModel(){
        super("A. Productos forestales maderables");
        this.typeUtilization = "";
    }

    /**
     * Constructor full
     * @param typeUtilization Clase de aprovechamiento a solicitar (Persistente, Único, Doméstico, Menejo Forestal Unificado)
     */
    public CategoryAModel(String typeUtilization) {
        super("A. Productos forestales maderables");
        this.typeUtilization = typeUtilization;
    }
    
    /**
     * Retorna la clase de aprovechamiento a solicitar (Persistente, Único, Doméstico, Menejo Forestal Unificado)
     * @return Clase de aprovechamiento a solicitar (Persistente, Único, Doméstico, Menejo Forestal Unificado)
     */
    public String getTypeUtilization() {
        return typeUtilization;
    }

    /**
     * Asigna la clase de aprovechamiento a solicitar (Persistente, Único, Doméstico, Menejo Forestal Unificado)
     * @param typeUtilization Clase de aprovechamiento a solicitar (Persistente, Único, Doméstico, Menejo Forestal Unificado)
     */
    public void setTypeUtilization(String typeUtilization) {
        this.typeUtilization = typeUtilization;
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
