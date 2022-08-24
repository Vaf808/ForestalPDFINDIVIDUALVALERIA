/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import static co.gov.minambiente.controlador.PdfController.espacio;
import static co.gov.minambiente.controlador.Utils.loadMunicipalities;
import co.gov.minambiente.modelo.AddressModel;
import co.gov.minambiente.modelo.AttorneyModel;
import co.gov.minambiente.modelo.CategoryBModel;
import co.gov.minambiente.modelo.CoordinateModel;
import co.gov.minambiente.modelo.DateModel;
import co.gov.minambiente.modelo.DepartmentModel;
import co.gov.minambiente.modelo.GeographicCoordinateModel;
import co.gov.minambiente.modelo.InterestedModel;
import co.gov.minambiente.modelo.PlaneCoordinateModel;
import co.gov.minambiente.modelo.PropertyModel;
import co.gov.minambiente.modelo.RequestModel;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Andrés Güiza
 */
public class Controlador {

    public static void main(String[] args) throws FileNotFoundException, IOException, FontFormatException {
        PdfWorkspace generatedDoc = new PdfWorkspace("Prueba.pdf", "pdfOutput");

        RequestModel form1 = new RequestModel("1", new DateModel());
        ArrayList<String> a = new ArrayList<>();
       // a.add("1200000");
       // a.add("Doce millones de pesos");

        InterestedModel interested = new InterestedModel("Natural",
                "Propietario", a, false, "bob_esponja@gmail.com", "304446985", "Bob Esponja", "CC", "1101760080");

        AttorneyModel attorney = new AttorneyModel("856413T", "Patricio Estrella",
                "CC", "552116447");

        interested.setAttorney(attorney);

        LinkedList<CoordinateModel> sddd = new LinkedList<>();
        /* sddd.add(new PlaneCoordinateModel(1,1, 2));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1,2,5));
        sddd.add(new PlaneCoordinateModel(1, 2, 5));
        sddd.add(new PlaneCoordinateModel(1, 2, 5));
        sddd.add(new PlaneCoordinateModel(1, 2, 5));*/

        ArrayList<Object> latitud = new ArrayList<>();
        latitud.add(58);
        latitud.add(20);
        latitud.add(15);

        ArrayList<Object> longitud = new ArrayList<>();
        longitud.add(58);
        longitud.add(12);
        longitud.add(63);
        GeographicCoordinateModel s = new GeographicCoordinateModel(latitud, longitud, 1200, espacio, 5);
        LinkedList<CoordinateModel> f = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            f.add(new GeographicCoordinateModel(latitud, longitud, 2350, "as", 2));

        }

        f.add(s);

        form1.setTypeRequest("nueva");
        form1.setInterested(interested);
        form1.setCategoryB(new CategoryBModel());
        PropertyModel miCasita = new PropertyModel();
        miCasita.setName("Casa de Andrés");
        miCasita.setSurface("101");
        miCasita.setCadastralIdNumber("55965-41UD4");
        miCasita.setCoordiantes(f);

        AddressModel miDireccion = new AddressModel();
        miDireccion.setStreet("Calle de Patricio salvaje");
        miDireccion.setMunicipality("Municipio de la soledad");
        miDireccion.setSidewalk("Vereda de tu corason");
        miDireccion.setDepartment("Departamento del mal");
        miCasita.setAdress(miDireccion);
        form1.addProperties(miCasita);
        form1.setMethodUtilization("Lorem ipsum dolor sit amet, consectetur "
                + "adipiscing elit. Nulla quis nibh justo. Praesent eu auctor "
                + "massa. Sed sagittis iaculis enim in convallis. Maecenas ligula"
                + " purus, scelerisque at bibendum ut, scelerisque eu quam. Nunc"
                + " pretium lacus at vehicula faucibus. Aenean convallis auctor "
                + "ipsum, id bibendum purus vehicula eget. Sed id auctor enim. "
                + " tincidunt massa a diam mattis, sit amet luctus quam cursus. "
                + "Nullam a ultricies felis. Nullam eu augue nibh. Morbi rutrum "
                + " tortor id auctor.");

        PdfController.fillDocument(generatedDoc, form1);

    }
}
