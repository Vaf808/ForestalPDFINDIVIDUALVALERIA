package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una fecha
 * @author Daniel
 */
public class DateModel {
    
    private int year, month, day;

    /**
     * Constructor vacío
     */
    public DateModel() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    /**
     * Constructor full
     * @param year Año
     * @param month Mes
     * @param day Día
     */
    public DateModel(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Retorna el año
     * @return Año
     */
    public int getYear() {
        return year;
    }

    /**
     * Asigna el año
     * @param year Año
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retorna el mes
     * @return Mes
     */
    public int getMonth() {
        return month;
    }

    /**
     * Asigna el mes
     * @param month Mes
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Retorna el día
     * @return Día
     */
    public int getDay() {
        return day;
    }

    /**
     * Asigna el día
     * @param day Día
     */
    public void setDay(int day) {
        this.day = day;
    }
    
    /**
     * Retorna la fecha con formato (dd/mm/aa)
     * @return Fecha con formato (dd/mm/aa)
     */
    public String getDateWithFormat(){
        
        String result;
        result = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
        return result; 
    }

    public boolean afterDate(DateModel fechaInicial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean beforeDate(DateModel fechaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
