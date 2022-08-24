package co.gov.minambiente.modelo;

import java.util.ArrayList;

/**
 * Esta clase contiene los métodos y atributos de una coordenada geográfica
 * @author Andrés Güiza
 * @see CoordinateModel
 */
public class GeographicCoordinateModel extends CoordinateModel {
    
    private final ArrayList<Object> LATITUDE; 
    private final ArrayList<Object> LONGITUDE;
    private final double ALTITUDE;
    private final String ORIGIN;
    
    /**
     * Constructor full
     * @param LATITUDE Latitud
     * @param LONGITUDE Longitud
     * @param ALTITUDE Altitud
     * @param ORIGIN Origen
     * @param point Número de punto
     */
    public GeographicCoordinateModel(ArrayList<Object> LATITUDE, ArrayList<Object> LONGITUDE, double ALTITUDE, String ORIGIN, int point) {
        super(point);
        this.LATITUDE = LATITUDE;
        this.LONGITUDE = LONGITUDE;
        this.ALTITUDE = ALTITUDE;
        this.ORIGIN = ORIGIN;
    }

    public GeographicCoordinateModel(int point) {
        super(point);
        this.LATITUDE = new ArrayList<>();
        this.LONGITUDE = new ArrayList<>();
        this.ALTITUDE = 0;
        this.ORIGIN = "";
    }

   
    /**
     * Retorna la latitud
     * @return Latitud
     */
    public ArrayList<Object> getLATITUDE() {
        return LATITUDE;
    }

    /**
     * Retorna la longitud
     * @return Longitud
     */
    public ArrayList<Object> getLONGITUDE() {
        return LONGITUDE;
    }

    /**
     * Retorna la altitud
     * @return Altitud
     */
    public double getALTITUDE() {
        return ALTITUDE;
    }

    /**
     * Retorna el origen
     * @return Origen
     */
    public String getORIGIN() {
        return ORIGIN;
    }

    /**
     * Retorna el número de punto
     * @return Número de punto
     */
    @Override
    public int getPOINT() {
        return super.getPOINT(); //To change body of generated methods, choose Tools | Templates.
    }

}
