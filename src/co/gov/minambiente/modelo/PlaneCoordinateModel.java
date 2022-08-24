package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una coordenada plana
 * @author Andrés Güiza
 * @see CoordinateModel
 */
public class PlaneCoordinateModel extends CoordinateModel{
    
    private final double X;
    private final double Y;

    /**
     * Constructor full
     * @param x Coordenada en x
     * @param y Coordenada en y
     * @param point Número de punto
     */
    public PlaneCoordinateModel(double x, double y, int point) {
        super(point);
        this.X = x;
        this.Y = y;
    }

    /**
     * Retorna la coordenada en x
     * @return Coordenada en x
     */
    public double getX() {
        return X;
    }

    /**
     * Retorna la coordenada en y
     * @return Coordenada en y
     */
    public double getY() {
        return Y;
    }

    /**
     * Retorna el número de punto
     * @return Número de punto
     */
    @Override
    public int getPOINT() {
        return super.getPOINT(); 
    }
    
}
