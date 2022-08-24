package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una categoría D
 * @author Natalia García
 * @see CategoryModel
 */
public class CategoryDModel extends CategoryModel{
    private String typeUtilization;

    /**
     * Constructor vacío
     */
    public CategoryDModel() {
        super("D. Guaduales y bambusales");
        this.typeUtilization = "";
    }
    
    /**
     * Constructor full
     * @param typeUtilization Tipo de aprovechamiento a utilizar
     */
    public CategoryDModel(String typeUtilization) {
        super("D. Guaduales y bambusales");
        this.typeUtilization = typeUtilization;
    }

    /**
     * Retorna el tipo de aprovechamiento a utilizar
     * @return Tipo de aprovechamiento a utilizar
     */
    public String getTypeUtilization() {
        return typeUtilization;
    }

    /**
     * Asigna el tipo de aprovechamiento a utilizar
     * @param typeUtilization Tipo de aprovechamiento a utilizar
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
