package co.gov.minambiente.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Esta clase contiene los métodos y atributos de un interesado
 * @author Maritza
 * @see PersonModel
 */
public class InterestedModel extends PersonModel {
    
    private String typePerson;
    private AttorneyModel attorney;
    private String interestedQuality;
    private ArrayList<String> projectCost;
    private boolean authorization;
    private String emailAddress;
    private String telephone;
    private AddressModel address;
    
    /**
     * Constructor vacío
     */
    public InterestedModel(){
        super();
        this.typePerson = null;
        this.attorney = null;
        this.interestedQuality = null;
        this.projectCost = new ArrayList<>();
        this.authorization = false;
        this.emailAddress = null;
        this.telephone = "";
        this.address = new AddressModel();
    }

    /**
     * Constructor
     * @param typePerson Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @param interestedQuality Calidad del interesado
     * @param projectCost Lista con el costo del proyecto, obra o actividad, en números y en letras
     * @param authorization ¿Autoriza la notificación?
     * @param emailAddress Correo electrónico
     * @param telephone Teléfono
     */
    public InterestedModel(String typePerson,
            String interestedQuality, ArrayList projectCost,
            boolean authorization, String emailAddress, String telephone) {

        this.typePerson = typePerson;
        this.attorney = null;
        this.interestedQuality = interestedQuality;
        this.projectCost = projectCost;
        this.authorization = authorization;
        this.emailAddress = emailAddress;
        this.telephone = telephone;
    }

    /**
     * Constructor
     * @param typePerson Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @param interestedQuality Calidad del interesado
     * @param projectCost Lista con el costo del proyecto, obra o actividad, en números y en letras
     * @param authorization ¿Autoriza la notificación?
     * @param name Nombre
     * @param typeId Tipo de identificación
     * @param id Número de identificación
     */
    public InterestedModel(String typePerson,
            String interestedQuality, ArrayList projectCost,
            boolean authorization, String name, String typeId, String id) {

        super(name, typeId, id);
        this.typePerson = typePerson;
        this.attorney = null;
        this.interestedQuality = interestedQuality;
        this.projectCost = projectCost;
        this.authorization = authorization;
        this.emailAddress = null;
        this.telephone = null;
    }
    
    /**
     * Constructor
     * @param typePerson Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @param interestedQuality Calidad del interesado
     * @param projectCost Lista con el costo del proyecto, obra o actividad, en números y en letras
     * @param authorization ¿Autoriza la notificación?
     * @param emailAddress Correo electrónico
     * @param telephone Teléfono
     * @param name Nombre
     * @param typeId Tipo de identificación
     * @param id Número de identificación
     */
    public InterestedModel(String typePerson,
           String interestedQuality, ArrayList projectCost,
           boolean authorization, String emailAddress, String telephone, 
           String name, String typeId, String id) {

        super(name, typeId, id);
        this.typePerson = typePerson;
        this.attorney = null;
        this.interestedQuality = interestedQuality;
        this.projectCost = projectCost;
        this.authorization = authorization;
        this.emailAddress = emailAddress;
        this.telephone = telephone;
    }    
    
    /**
     * Constructor
     * @param typePerson Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @param attorney Instancia del apoderado
     * @param interestedQuality Calidad del interesado
     * @param projectCost Lista con el costo del proyecto, obra o actividad, en números y en letras
     * @param authorization ¿Autoriza la notificación?
     * @param emailAddress Correo electrónico
     * @param telephone Teléfono
     * @param name Nombre
     * @param typeId Tipo de identificación
     * @param id Número de identificación
     * @param address Instancia de dirección
     */
    public InterestedModel(String typePerson, AttorneyModel attorney,
           String interestedQuality, ArrayList projectCost,
           boolean authorization, String emailAddress, String telephone, 
           String name, String typeId, String id, AddressModel address) {

        super(name, typeId, id);
        this.typePerson = typePerson;
        this.attorney = attorney;
        this.interestedQuality = interestedQuality;
        this.projectCost = projectCost;
        this.authorization = authorization;
        this.emailAddress = emailAddress;
        this.telephone = telephone;
        this.address = address;
    }

    /**
     * Retorna el tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @return Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     */
    public String getTypePerson() {
        return typePerson;
    }

    /**
     * Asigna el tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     * @param typePerson Tipo de persona (Natural, Jurídica Pública, Jurídica Privada)
     */
    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    /**
     * Retorna la calidad del interesado
     * @return Calidad del interesado
     */
    public String getInterestedQuality() {
        return interestedQuality;
    }

    /**
     * Asigna la calidad del interesado
     * @param interestedQuality Calidad del interesado
     */
    public void setInterestedQuality(String interestedQuality) {
        this.interestedQuality = interestedQuality;
    }

    /**
     * Retorna la instancia del apoderado
     * @return Instancia del apoderado
     */
    public AttorneyModel getAttorney() {
        return attorney;
    }

    /**
     * Asigna la instancia del apoderado
     * @param attorney Instancia del apoderado
     */
    public void setAttorney(AttorneyModel attorney) {
        this.attorney = attorney;
    }

    /**
     * Retorna la lista con el costo del proyecto, obra o actividad, en números y en letras
     * @return Lista con el costo del proyecto, obra o actividad, en números y en letras
     */
    public ArrayList getProjectCost() {
        return projectCost;
    }

    /**
     * Asigna la lista con el costo del proyecto, obra o actividad, en números y en letras
     * @param projectCost Lista con el costo del proyecto, obra o actividad, en números y en letras
     */
    public void setProjectCost(ArrayList projectCost) {
        this.projectCost = projectCost;
    }

    /**
     * Retorna si autoriza la notificación
     * @return ¿Autoriza la notificación?
     */
    public boolean isAuthorization() {
        return authorization;
    }
    
    /**
     * Asigna si autoriza la notificación
     * @param authorization ¿Autoriza la notificación?
     */
    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }

    /**
     * Retorna el correo electrónico
     * @return Correo electrónico
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Asigna el correo electrónico
     * @param emailAddress Correo electrónico
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Retorna el teléfono
     * @return Teléfono 
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Asigna el teléfono
     * @param telephone Teléfono
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retorna la instancia de dirección
     * @return Instancia de dirección
     */
    public AddressModel getAddress() {
        return address;
    }

    /**
     * Asigna la instancia de dirección
     * @param address Instancia de dirección
     */
    public void setAdress(AddressModel address) {
        this.address = address;
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
