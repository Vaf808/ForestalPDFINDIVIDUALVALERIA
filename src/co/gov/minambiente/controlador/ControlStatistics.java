/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.DateModel;
import co.gov.minambiente.modelo.RequestModel;
import java.util.ArrayList;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author valeria
 */

public class ControlStatistics {

    /**
     * De aca tomaremos la infomarcion de la fecha con formato (dia/mes/año) 
     * @param data
     * @param selectedDate
     * @return 
     */
    public ArrayList<RequestModel> filterDataByDate(ArrayList<RequestModel> data, DateModel selectedDate){
        
        ArrayList<RequestModel> filterList = new ArrayList<>();
        
        data.forEach((requestModel) -> {
            String creationDateRequest = requestModel.getCreationDate().getDateWithFormat();
            if (creationDateRequest.equals(selectedDate.getDateWithFormat())) {
                filterList.add(requestModel);
            }
        });
        
        return filterList;
        
    }
    
    /**
     * Ayuda a mirar cuantos formularios se crearon por dia en cierto departamento
     * @param filterList
     * @return 
     */
    
    public ArrayList<RequestFrequency> frequencyByDeparmet(ArrayList<RequestModel> filterList){
        
        ArrayList<RequestFrequency> frecuenciasPorDepartamentos = new ArrayList<>();
        
        filterList.forEach((requestModel) -> {
            boolean existeEnFrecuencia = false;
            String departamentoAux = requestModel.getInterested().getAddress().getDepartment();
            for (RequestFrequency frecuenciaFormulario : frecuenciasPorDepartamentos) {
                if(frecuenciaFormulario.getDepartamento().equals(departamentoAux)){
                    frecuenciaFormulario.setFrecuencia(frecuenciaFormulario.getFrecuencia() + 1);
                    existeEnFrecuencia = true;
                }
            }
            if (!existeEnFrecuencia) {
                frecuenciasPorDepartamentos.add(new RequestFrequency(departamentoAux, 1));
            }
        });
        
        return frecuenciasPorDepartamentos;    
    }
    
    /**
     * En este metodo podemos obtener los datos de la lista filtrada
     * @param lista
     * @return 
     */
    public DefaultCategoryDataset crearDataset(ArrayList<RequestFrequency> lista){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        lista.forEach((requestFrequency) -> {
            dataset.setValue(requestFrequency.getFrecuencia(), "Registros", requestFrequency.getDepartamento());
        });
        
        return dataset;
    }
    
    public ArrayList<RequestModel> filterDataByRange(ArrayList<RequestModel> data, DateModel fechaInicial, DateModel fechaFinal){
        
        ArrayList<RequestModel> filterList = new ArrayList<>();
        
        data.forEach((RequestModel requestModel) -> {
            DateModel creationDateRequest = requestModel.getCreationDate();
            if (creationDateRequest.afterDate(fechaInicial) && creationDateRequest.beforeDate(fechaFinal)){
                filterList.add(requestModel);
            }
        });
        
        return filterList;
    }
    
}
