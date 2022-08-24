/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

/**
 *
 * @author valeria
 */
public class RequestFrequency {

    private String departamento;
    private int frecuencia;
    private int tamano;

    public RequestFrequency(String departamento, int frecuencia) {
        this.departamento = departamento;
        this.frecuencia = frecuencia;
    }

    public RequestFrequency() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setCreationDate(String departamento) {
        this.departamento = departamento;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }   

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
