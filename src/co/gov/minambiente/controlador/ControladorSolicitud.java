package co.gov.minambiente.controlador;

import co.gov.minambiente.controlador.database.RequestsDatabase;
import co.gov.minambiente.modelo.*;
import co.gov.minambiente.vista.formulario.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Esta clase gestiona las vistas
 * @author Natalia García
 */
public class ControladorSolicitud {

    private RequestModel request;
    private Principal principal;
    private Seccion1 seccion1;
    private Seccion2 seccion2;
    private Seccion3 seccion3;
    private Seccion4_1 seccion4_1;
    private Seccion4_2 seccion4_2;
    private Seccion5_1 seccion5_1;
    private Seccion5_2 seccion5_2;
    private Seccion6 seccion6;
    
    /**
     * Constructor vacío.
     */
    public ControladorSolicitud() {
        request = new RequestModel(RequestsDatabase.getNewReference(),RequestsDatabase.getCurrentDate());
    }
    
    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    /**
     * Instancia las ventanas de la aplicación correspondientes a las secciones 1, 2, 4.1, 4.2, 5.1, 5.2 y 6 del formulario, y envía como parámetro de sus constructores la instancia del controlador desde la cual se llame el método.
     */
    public void instanciarVentanas() {
        try {
            seccion1 = new Seccion1(this);
            seccion2 = new Seccion2(this);
            seccion4_1 = new Seccion4_1(this);
            seccion4_2 = new Seccion4_2(this);
            seccion5_1 = new Seccion5_1(this);
            seccion5_2 = new Seccion5_2(this);
            seccion6 = new Seccion6(this);
        } catch (IOException e) {
            System.out.println("No se instancian");
        }
    }
    
    /**
     * Instancia la ventana de la aplicación correspondiente a la sección 3 del formulario, y envía como parámetro de su constructor la instancia del controlador desde la cual se llame el método.
     */
    public void instanciarVentana3(){
        seccion3 = new Seccion3(this);
    }
    
    /**
     * Muestra la ventana principal o el menú de la aplicación.
     */
    public void mostrarPrincipal() {
        principal.mostrar();
    }
    
    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 1 del formulario.
     */
    public void mostrarSeccion1() {
        seccion1.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 2 del formulario.
     */
    public void mostrarSeccion2() {
        seccion2.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 3 del formulario.
     */
    public void mostrarSeccion3() {
        if (seccion3 == null){
            instanciarVentana3();
        }
        seccion3.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 4.1 del formulario.
     */
    public void mostrarSeccion4_1() {
        seccion4_1.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 4.2 del formulario.
     */
    public void mostrarSeccion4_2() {
        seccion4_2.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 5.1 del formulario.
     */
    public void mostrarSeccion5_1() {
        seccion5_1.setVisible(true);
    }

    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 5.2 del formulario.
     */
    public void mostrarSeccion5_2() {
        seccion5_2.setVisible(true);
    }
    
    /**
     * Muestra la ventana de la aplicación correspondiente a la sección 6 del formulario.
     */
    public void mostrarSeccion6() {
        seccion6.setVisible(true);
    }

    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 1 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param tipoSolicitud Tipo de solicitud
     * @param tipoPersonaInteresado Tipo de persona (Natural, Jurídica Pública, Jurídica Privada) del interesado
     * @param nombreInteresado Nombre del interesado
     * @param tipoIdInteresado Tipo de identificación del interesado
     * @param numeroIdInteresado Número de identificación del interesado
     * @param aplicaApoderado ¿Aplica apoderado?
     * @param nombreApoderado Nombre del apoderado
     * @param tipoIdApoderado Tipo de identificación del apoderado
     * @param numeroIdApoderado Número de identificación del apoderado
     * @param TPApoderado Número de la tarjeta profesional del apoderado
     * @param calidad Calidad en la que el interesado actúa sobre el predio
     * @param otro Calidad en la que el interesado actúa sobre el predio en caso de no ser ninguna de las opciones disponibles en el formulario
     * @param tipoPredio Tipo del predio (Público, Colectivo, Privado)
     * @param aplicaCosto ¿Aplica costo del proyecto?
     * @param costo Costo del proyecto en números
     * @param costoLetras Costo del proyecto en letras
     */
    public void guardarInformacionSeccion1(String tipoSolicitud, String tipoPersonaInteresado, String nombreInteresado, String tipoIdInteresado,
            String numeroIdInteresado, boolean aplicaApoderado, String nombreApoderado, String tipoIdApoderado, String numeroIdApoderado,
            String TPApoderado, String calidad, String otro, String tipoPredio, boolean aplicaCosto, String costo, String costoLetras) {
        request.setTypeRequest(tipoSolicitud);
        request.getInterested().setTypePerson(tipoPersonaInteresado);
        request.getInterested().setName(nombreInteresado);
        request.getInterested().setTypeId(tipoIdInteresado);
        request.getInterested().setId(numeroIdInteresado);

        if (aplicaApoderado) {
            request.getInterested().setAttorney(new AttorneyModel(TPApoderado, nombreApoderado, tipoIdApoderado, numeroIdApoderado));
        }

        if (calidad.equals("Otro")) {
            request.getInterested().setInterestedQuality(otro);
        } else {
            request.getInterested().setInterestedQuality(calidad);
        }

        request.addProperties(new PropertyModel(tipoPredio));
        System.out.println(request.getProperties().size());

        if (aplicaCosto) {
            ArrayList<String> cost = new ArrayList<>();
            cost.add(costo);
            cost.add(costoLetras);
            request.getInterested().setProjectCost(cost);
        }
    }
    
    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 2 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param numeroExpediente Número de expediente de la prórroga
     * @param numeroActo Número de acto administrativo mediante el cual se otorgó el derecho al uso del recurso forestal
     */
    public void guardarInformacionSeccion2(String numeroExpediente, String numeroActo) {
        request.setFileNumber(numeroExpediente);
        request.setActNumber(numeroActo);
    }

    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 3 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param terrenosDominio Modo por el cual se pretende adquirir el derecho al uso del recurso forestal (Permiso, Asociación, Concesión Forestal)
     * @param categorias Categoria(s) seleccionada(s) según el producto forestal objeto de la solicitud
     * @param tipoAprovechamientoA En caso de haber seleccionado la opción A: Clase de aprovechamiento a solicitar
     * @param claseManejo En caso de haber seleccionado la opción B: Clase de manejo sostenible a solicitar
     * @param ingresos En caso de haber seleccionado la opción B: Ingresos mensuales en números esperados para la actividad comercial que se pretende realizar
     * @param ingresosLetras En caso de haber seleccionado la opción B: Ingresos mensuales en letras esperados para la actividad comercial que se pretende realizar
     * @param categoriaAsociada En caso de haber seleccionado la opción B y una clase de manejo sostenible persistente: Categoria asociada a la clase de manejo
     * @param tipoAprovechamientoD En caso de haber seleccionado la opción D: Tipo de aprovechamiento a solicitar
     */
    public void guardarInformacionSeccion3(String terrenosDominio, LinkedList<String> categorias, String tipoAprovechamientoA, String claseManejo,
            String ingresos, String ingresosLetras, String categoriaAsociada, String tipoAprovechamientoD) {
        request.setHowToAcquire(terrenosDominio);
        for (String categoria : categorias) {
            switch (categoria) {
                case "A":
                    request.getCategoryA().setTypeUtilization(tipoAprovechamientoA);
                    break;
                case "B":
                    ArrayList<String> revenues = new ArrayList<>();
                    revenues.add(ingresos);
                    revenues.add(ingresosLetras);
                    request.getCategoryB().setTypeOperation(claseManejo);
                    request.getCategoryB().setRevenuesExpected(revenues);
                    request.getCategoryB().setAssociatedCategory(categoriaAsociada);
                    break;
                case "C":
                    break;
                case "D":
                    request.getCategoryD().setTypeUtilization(tipoAprovechamientoD);
                    break;
            }
        }
    }
    
    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 4.1 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param nombre Nombre del predio
     * @param superficie Superficie en hectáreas del predio
     * @param direccion Dirección del predio
     * @param tipo Tipo zona en la cual se encuentra el predio
     * @param departamento Departamento en el que se encuentra el predio
     * @param municipio Municipio en el que se encuentra el predio
     * @param vereda Vereda en la que se encuentra el predio
     * @param matriculaInmobiliaria Matrícula inmobiliaría del predio
     * @param cedulaCatastral Cédula catastral del predio en caso de no tener matrícula inmobiliaría
     */
    public void guardarInformacionSeccion4_1(String nombre, String superficie, String direccion, String tipo, String departamento,
            String municipio, String vereda, String matriculaInmobiliaria, String cedulaCatastral) {
        LinkedList<PropertyModel> properties = request.getProperties();
        properties.get(0).setName(nombre);
        properties.get(0).setSurface(superficie);
        properties.get(0).setAdress(new AddressModel(direccion, tipo, departamento, municipio, vereda));
        properties.get(0).setRealEstateRegistration(matriculaInmobiliaria);
        properties.get(0).setCadastralIdNumber(cedulaCatastral);
    }
    
    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 4.2 del formulario, verifica si se encuentran vacíos y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param coordinates Coordenadas del área objeto de la solicitud
     * @return <ul>
     * <li>true: Se logran guardar los datos correctamente</li>
     * <li>false: No se logran guardar los datos correctamente</li>
     * </ul>
     */
    public boolean guardarInformacionSeccion4_2(LinkedList<Object[]> coordinates) {
        LinkedList<CoordinateModel> lista = new LinkedList();
        if (coordinates.size() > 0) {
            if (coordinates.get(0).length == 3) {
                for (Object[] arr : coordinates) {
                    lista.add(new PlaneCoordinateModel(
                            (double) arr[1],
                            (double) arr[2],
                            (short) arr[0]));
                }
            } else {
                for (Object[] arr : coordinates) {
                    lista.add(new GeographicCoordinateModel(
                            (ArrayList) arr[0],
                            (ArrayList) arr[1],
                            (double) arr[2],
                            (String) arr[3],
                            (short) arr[4]));
                }
            }
            request.getProperties().get(0).setCoordiantes(lista);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 5.1 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param metodo Método de aprovechamiento o manejo sostenible
     * @param datosTabla Especies objeto de la solicitud
     * @param uso Uso que se pretende dar a los productos a obtener
     */
    public void guardarInformacionSeccion5_1(String metodo, ArrayList<ArrayList<String>> datosTabla, String uso) {
        request.setMethodUtilization(metodo);

        for (ArrayList<String> datos : datosTabla) {
            request.getProperties().get(0).getSpecies().add(new SpecieModel(Double.parseDouble(datos.get(0)), datos.get(1), datos.get(2),
                    datos.get(3), datos.get(4), datos.get(5), datos.get(6), datos.get(7)));
        }

        request.setIntendedUse(uso);
    }
    
    /**
     * En caso de haber seleccionado Árboles Aislados como objeto de la solicitud, recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 5.2 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param categorias Categoria seleccionada
     * @param texto Nombre de la categoría
     * @param estado En caso de haber seleccionado Árboles aislados dentro de la cobertura del bosque natural: Estado del individuo
     * @param otro En caso de haber seleccionado Árboles aislados dentro de la cobertura del bosque natural: Estado del individuo en caso de no ser ninguna de las opciones disponibles en el formulario
     * @param tipoA En caso de haber seleccionado Tala o poda de emergencia en centros urbanos: Tala o poda
     * @param estadoIndividual  En caso de haber seleccionado Tala o poda de emergencia en centros urbanos: Estado del individuo
     * @param causa En caso de haber seleccionado Tala o poda de emergencia en centros urbanos: Causa o perjuicio
     * @param otro1 En caso de haber seleccionado Tala o poda de emergencia en centros urbanos: Causa o perjuicio en caso de no ser ninguna de las opciones disponibles en el formulario
     * @param tipo En caso de haber seleccionado Obra pública o privada en centros urbanos: Tala o poda
     * @param actividad En caso de haber seleccionado Obra pública o privada en centros urbanos: Actividad dentro de obras de infrastructura
     * @param similar En caso de haber seleccionado Obra pública o privada en centros urbanos: Actividad dentro de obras de infrastructura en caso de no ser ninguna de las opciones disponibles en el formulario
     */
    public void guardarInformacionSeccion5_2(String estado, LinkedList<String> categorias, String tipo, String texto, String tipoA, String causa, String estadoIndividual, String actividad, String otro, String otro1, String similar) {
        for (String categoria : categorias) {
            switch (categoria) {
                case "A":
                    request.setCategoryC(new CategoryC1Model("i. Árboles aislados dentro de la cobertura del bosque natural", estado));
                    if (estado.equals("Razones de Orden Fitosanitario")) {
                        ((CategoryC1Model)request.getCategoryC()).setIndividualStatus(otro);
                    }
                    break;
                case "B":
                    request.setCategoryC(new CategoryC2Model("ii. Árboles aislados fuera de la cobertura del bosque natural"));
                    break;

                case "C":
                    request.setCategoryC(new CategoryC3Model("iii Tala o poda de emergencia en centros urbano", tipoA, estadoIndividual, causa));
                    if (causa.equals("Otro")) {
                        ((CategoryC3Model)request.getCategoryC()).setCause(otro1);
                    }
                    break;
                case "D":
                    request.setCategoryC(new CategoryC4Model("iv. Obra pública o privada en centros urbanos", tipo, actividad));
                    if (actividad.equals("Similar")) {
                        ((CategoryC4Model)request.getCategoryC()).setActivity(similar);
                    }
                    break;
            }

        }
    }
    
    /**
     * Recibe los datos escritos en la ventana de la aplicación correspondiente a la sección 6 del formulario y se encarga de guardarlos, por medio de setters y getters, en la instancia de RequestModel con la que se esté trabajando.
     * @param correo Correo eléctronico
     * @param telefono Télefono
     * @param direccion Dirección
     * @param departamento Departamento
     * @param vereda Vereda
     * @param municipio Municipio
     */
    public void guardarInformacionSeccion6(String correo, String telefono, String direccion, String departamento, String vereda, String municipio) {
        request.getInterested().setAuthorization(true);
        request.getInterested().setEmailAddress(correo);
        request.getInterested().setTelephone(telefono);
        request.getInterested().setAdress(new AddressModel(direccion, "", departamento, municipio, vereda));
    }

    /**
     * Guarda la instancia de RequestModel con la que se esté trabajando en la base de datos.
     */
    public void guardarSolicitudEnBaseDeDatos(){
        RequestsDatabase.add(request);
    }
    
    /**
     * Verifica si la categoria de la instancia de RequestModel con la que se esté trabajando es de categoria C.
     * @return <ul>
     * <li>true: La solicitud es de categoria C</li>
     * <li>false: La solicitud no es de categoria C</li>
     * </ul>
     */
    public boolean esCategoriaC(){
        String A = request.getCategoryA().getTypeUtilization();
        String B = request.getCategoryB().getTypeOperation();
        String D = request.getCategoryD().getTypeUtilization();
        return A.equals("") && B.equals("") && D.equals("");
    }
    
    /**
     * Verifica si la instancia de RequestModel con la que se esté trabajando representa una solicitud nueva.
     * @return true si es nueva, false si no es nueva (si es prórroga).
     */
    public boolean isNueva(){
        return (request.getTypeRequest().equalsIgnoreCase("nueva"));
    }
    
    /**
     * Obtiene el tipo de predio objeto de la solicitud representada por la instancia de RequestModel con la que se esté trabajando.
     * @return Tipo de propiedad (Pública, Colectiva, Privada).
     */
    public String verTypeProperty() {
        return request.getProperties().get(0).getTypeProperty();
    }

    /**
     * Obtiene una lista con todas las instancias de DepartmentModel.
     * @return Lista con todas las instancias de DepartmentModel
     * @throws IOException 
     */
    public LinkedList<String> cargarDepartamentos() throws IOException {
        LinkedList<DepartmentModel> departamentos = Utils.loadMunicipalities((new File("resources\\MunicipiosDepartamentosColombia.txt")));
        LinkedList<String> nombresDepartamentos = new LinkedList<>();
        for (DepartmentModel departamento : departamentos) {
            nombresDepartamentos.add(departamento.getDEPARTMENTNAME());
        }
        return nombresDepartamentos;
    }
    
    /**
     * Obtiene una lista con todos los municipios de determinado departamento.
     * @param d Departamento
     * @return Lista con todos los municipios de determinado departamento
     * @throws IOException 
     */
    public LinkedList<String> cargarMunicipios(String d) throws IOException {
        LinkedList<DepartmentModel> departamentos = Utils.loadMunicipalities((new File("resources\\MunicipiosDepartamentosColombia.txt")));
        for (DepartmentModel departamento : departamentos) {
            if (departamento.getDEPARTMENTNAME().equals(d)) {
                return departamento.getMUNICIPALITIES();
            }
        }
        return null;
    }

}
