/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.CategoryBModel;
import co.gov.minambiente.modelo.CategoryC1Model;
import co.gov.minambiente.modelo.CategoryC2Model;
import co.gov.minambiente.modelo.CategoryC3Model;
import co.gov.minambiente.modelo.CategoryC4Model;
import co.gov.minambiente.modelo.CategoryCModel;
import co.gov.minambiente.modelo.CategoryDModel;
import co.gov.minambiente.modelo.CategoryModel;
import co.gov.minambiente.modelo.CoordinateModel;
import co.gov.minambiente.modelo.GeographicCoordinateModel;
import co.gov.minambiente.modelo.InterestedModel;
import co.gov.minambiente.modelo.PlaneCoordinateModel;
import co.gov.minambiente.modelo.PropertyModel;
import co.gov.minambiente.modelo.RequestModel;
import co.gov.minambiente.modelo.SpecieModel;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés Güiza
 */
public class PdfController {

    public static String espacio = "\u00A0";
    public static LinkedList<Text> texts;
    public static String titleFont = "ArialNarrowBold.ttf";
    public static String bodyFont = "ArialMT.ttf";
    public static Color grayBg = new DeviceRgb(200, 188, 190);
    public static Color greenBg = new DeviceRgb(185, 229, 161);
    public static Color whiteBg = new DeviceRgb(0, 0, 0);
    public static Color blueBg = new DeviceRgb(152, 228, 235);

    public static void fillDocument(PdfWorkspace generatedDoc, RequestModel solicitude) throws MalformedURLException, IOException {

        int lineCounter = drawPage1(generatedDoc, solicitude);
        lineCounter = drawPage2(lineCounter, generatedDoc, solicitude);
        lineCounter = drawPage3(lineCounter, generatedDoc, solicitude);
        lineCounter = drawPage4(lineCounter, generatedDoc, solicitude);
        generatedDoc.crearPdf();
    }

    public static int drawPage1(PdfWorkspace generatedDoc, RequestModel solicitude) throws MalformedURLException {

        try {
            texts = cargarBD();
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int lineCounter = 3;
        try {

            addHeader(generatedDoc, texts);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, grayBg, 0);
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 9);

            Paragraph p;
            p = generatedDoc.nuevoParrafo(new Text(""), titleFont, 10f);
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getName() + "\n");
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getId()) + "\n");
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);

            if (solicitude.getInterested().getAttorney() != null) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getAttorney().getName() + "\n");
                lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter,
                        String.valueOf(solicitude.getInterested().getAttorney().getId()),
                        String.valueOf(solicitude.getInterested().getAttorney().getProfesionalCard()) + "\n");
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "" + "\n");
                lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter,
                        "",
                        "" + "\n");
            }

            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);

            if (!(solicitude.getInterested().getInterestedQuality().equals("Propietario")
                    || solicitude.getInterested().getInterestedQuality().equals("Poseedor")
                    || solicitude.getInterested().getInterestedQuality().equals("Tenedor")
                    || solicitude.getInterested().getInterestedQuality().equals("Ocupante")
                    || solicitude.getInterested().getInterestedQuality().equals("Autorizado")
                    || solicitude.getInterested().getInterestedQuality().equals("Ente territorial")
                    || solicitude.getInterested().getInterestedQuality().equals("Consejo comunitario")
                    || solicitude.getInterested().getInterestedQuality().equals("Resguardo indígena"))) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getInterestedQuality() + "\n");
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            }

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);

            if (solicitude.getInterested().getProjectCost().size() > 0) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getProjectCost().get(0)) + "\n");
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getProjectCost().get(1)) + "\n");
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "No aplica" + "\n");
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "No aplica" + "\n");
            }

            p.setFixedLeading(20);
            p.setBorder(new SolidBorder(0.75f));
            p.setMarginRight(-5);
            p.setMarginLeft(-5);
            p.setPaddingLeft(5);
            p.setRelativePosition(0, -18, 0, 0);
            generatedDoc.empujarParrafo(p);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, blueBg, 27);
            Paragraph q;

            q = generatedDoc.nuevoParrafo(new Text(""), titleFont, 10f);

            //Si es un prórroga...
            if (solicitude.getTypeRequest().equalsIgnoreCase("prórroga")) {
                lineCounter = addBodyLine(q, generatedDoc, lineCounter, solicitude.getFileNumber() + "\n");
                lineCounter = addBodyLine(q, generatedDoc, lineCounter, String.valueOf(solicitude.getActNumber()) + "\n");
            } else {
                lineCounter = addBodyLine(q, generatedDoc, lineCounter, "" + "\n");
                lineCounter = addBodyLine(q, generatedDoc, lineCounter, "" + "\n");
            }

            lineCounter = addBodyTitleLine(q, generatedDoc, lineCounter);

            q.setFixedLeading(20);
            q.setBorder(new SolidBorder(0.75f));
            q.setMarginLeft(-5);
            q.setMarginRight(-5);
            q.setRelativePosition(0, -36, 0, 0);
            q.setPaddingTop(5);
            q.setPaddingLeft(5);
            generatedDoc.empujarParrafo(q);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 45);
            Paragraph r;
            r = generatedDoc.nuevoParrafo(new Text(""), titleFont, 10f);
            lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter, 7.5f);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);

            if (!solicitude.getCategoryB().getTypeOperation().equals("")) {
                lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter, solicitude.getCategoryB().getRevenuesExpected().get(0));
                lineCounter = addBodyLine(r, generatedDoc, lineCounter, solicitude.getCategoryB().getRevenuesExpected().get(1));
                System.out.println("asdasdasd");
            } else {
                lineCounter = addTitleLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            }
            lineCounter = addUndelinedBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            r.setFixedLeading(20);
            r.setBorder(new SolidBorder(0.75f));
            r.setMarginLeft(-5);
            r.setMarginRight(-5);
            r.setPaddingLeft(5);
            r.setPaddingTop(5);
            r.setRelativePosition(0, -54, 0, 0);
            generatedDoc.empujarParrafo(r);

        } catch (IOException ex) {
            System.out.println("Error de entrada y salida de datos" + espacio + ex);
        }
        PdfController.generateCheckBoxes1(generatedDoc, new DeviceRgb(212, 216, 210), solicitude);
        generatedDoc.pasarPagina(2);
        return lineCounter;
    }

    /**
     *
     * @param lineCounter
     * @param generatedDoc
     * @param solicitude
     * @return
     */
    public static int drawPage2(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) {

        try {
            addHeader(generatedDoc, texts);
            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, 8);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            setUpParagraph(p, generatedDoc, 9, 20);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 18);
            p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getName(),
                    solicitude.getProperties().get(0).getSurface() + "\n");
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getStreet());
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getDepartment(),
                    solicitude.getProperties().get(0).getAdress().getMunicipality(),
                    solicitude.getProperties().get(0).getAdress().getSidewalk() + "\n");
            p.add(new Text("\n"));

            if (!solicitude.getProperties().get(0).getRealEstateRegistration().equals("")) {
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getRealEstateRegistration() + "\n");
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
                p.add(new Text("\n"));
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getCadastralIdNumber() + "\n");
                p.add(new Text("\n"));
            }

            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));

            Table t = createTable1(generatedDoc);
            Table t2 = createTable2(generatedDoc);

            if (solicitude.getProperties().get(0).getCoordiantes().size() > 0) {
                if (solicitude.getProperties().get(0).getCoordiantes().get(0) instanceof PlaneCoordinateModel) {
                    fillTable1(t, solicitude, generatedDoc);
                } else {
                    fillTable2(t2, solicitude, generatedDoc);
                }
            }

            p.add(t);
            p.add(new Text("\n \n"));

            p.add(t2);
            p.add(new Text("\n \n"));

            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);

            setUpParagraph(p, generatedDoc, 27, 10);
            PdfController.generateCheckBoxes2(generatedDoc, new DeviceRgb(212, 216, 210), solicitude);
            generatedDoc.pasarPagina(3);

        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCounter;
    }

    public static int drawPage3(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) {
        try {

            addHeader(generatedDoc, texts);
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 9);

            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);

            p.add(new Text("\n"));
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);

            Table t = createTable3(generatedDoc);
            fillTable3(t, solicitude, generatedDoc);
            p.add(t);
            p.add(new Text("\n \n"));

            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);

            //  -> Lógica de llenado sección 5.1
            switch (solicitude.getMethodUtilization()) {
                case "Mecánico":
                    // Casilla Mecánico marcada
                    break;
                case "Manual":
                    // Casilla Manual marcada
                    break;
                case "Mecánico-Manual":
                    // Casilla Mecánico-Manual marcada
                    break;
                default:
                    // Ninguna marcada
                    break;
            }

            // Tabla
            // Rellenar "Indique el uso que se pretende dar a los productos a obtener:" con solicitude.getIntendedUse()
            // <- Lógica de llenado sección 5.1
            // -> Lógica de llenado sección 5.2
            switch (solicitude.getCategoryC().getLocationOrType()) {
                case "i. Árboles aislados dentro de la cobertura del bosque natural":
                    // Marcar casilla "i. Árboles aislados dentro de la cobertura del bosque natural"
                    switch (((CategoryC1Model) solicitude.getCategoryC()).getIndividualStatus()) {
                        case "Caído por Causas Naturales":
                            // Marcar casilla "Caído por Causas Naturales"
                            break;
                        case "Muerto por Causas Naturales":
                            // Marcar casilla "Muerto por Causas Naturales"
                            break;
                        default:
                            // Marcar casilla "Razones de Orden Fitosanitario"
                            // Rellenar "Especifique cuál" con ((CategoryC1Model)solicitude.getCategoryC()).getIndividualStatus()
                            break;
                    }
                    break;
                case "ii. Árboles aislados fuera de la cobertura del bosque natural":
                    // Marcar casilla "ii. Árboles aislados fuera de la cobertura del bosque natural"
                    break;
                case "iii Tala o poda de emergencia en centros urbano":
                    // Marcar casilla "iii Tala o poda de emergencia en centros urbano"
                    if (((CategoryC3Model) solicitude.getCategoryC()).getTipo().equals("Tala")) {
                        // Marcar casilla "Tala"
                    } else {
                        // Marcar casilla "Poda"
                    }
                    switch (((CategoryC3Model) solicitude.getCategoryC()).getIndividualStatus()) {
                        case "Muerto":
                            // Marcar casilla "Muerto"
                            break;
                        case "Enfermo":
                            // Marcar casilla "Enfermo"
                            break;
                        default:
                            // Marcar casilla "Caído"
                            break;
                    }
                    switch (((CategoryC3Model) solicitude.getCategoryC()).getCause()) {
                        case "Estabilidad de suelos":
                            // Marcar casilla "Estabilidad de suelos
                            break;
                        case "Canal de agua":
                            // Marcar casilla "Canal de agua"
                            break;
                        case "Obras de infraestructura":
                            // Marcar casilla "Obras de infraestructura"
                            break;
                        default:
                            // Marcar casilla "Otro"
                            // Rellenar "Especifique cual" con ((CategoryC3Model) solicitude.getCategoryC()).getCause()
                            break;
                    }
                    break;
                case "iv. Obra pública o privada en centros urbanos":
                    // Marcar casilla "iv. Obra pública o privada en centros urbanos"
                    if (((CategoryC4Model) solicitude.getCategoryC()).getTipo().equals("Tala")) {
                        // Marcar casilla "Tala"
                    }
                    switch (((CategoryC4Model) solicitude.getCategoryC()).getActivity()) {
                        case "Construcción/Realización":
                            // Marcar casilla "Construcción/Realización"
                            break;
                        case "Remodelación":
                            // Marcar casilla "Remodelación"
                            break;
                        case "Ampliación":
                            // Marcar casilla "Ampliación"
                            break;
                        case "Instalación":
                            // Marcar casilla "Instalación"
                            break;
                        default:
                            // Marcar casilla "Similar"
                            // Rellenar "Especifique cuál" con ((CategoryC4Model)solicitude.getCategoryC()).getActivity()
                            break;
                    }
                    break;
                default:
                // Ninguna marcada
            }
            // <- Lógica de llenado sección 5.2

            setUpParagraph(p, generatedDoc, 18, 10);
            PdfController.generateCheckBoxes3(generatedDoc, new DeviceRgb(212, 216, 210), solicitude);
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        generatedDoc.pasarPagina(4);
        return lineCounter;
    }

    public static int drawPage4(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) throws MalformedURLException {
        
        try {
            addHeader(generatedDoc, texts);
            
            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getMethodUtilization() + "\n");
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            p.add(new Text("\n"));
            lineCounter++;
            setUpParagraph(p, generatedDoc, 0, 10);
            
            p = new Paragraph();
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 9);
            p.add(new Text("\n"));

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));

            if (solicitude.getInterested().isAuthorization()) {

                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        solicitude.getInterested().getEmailAddress(), solicitude.getInterested().getTelephone() + "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        solicitude.getInterested().getAddress().getStreet(),
                        solicitude.getInterested().getAddress().getMunicipality() + "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        solicitude.getInterested().getAddress().getSidewalk(),
                        solicitude.getInterested().getAddress().getDepartment() + "\n");
                p.add(new Text("\n"));
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        "", "" + "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        "", "" + "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                        "", "" + "\n");
                p.add(new Text("\n"));
            }

            setUpParagraph(p, generatedDoc, 18, 10);
            lineCounter = addSingleTitle(generatedDoc, lineCounter, grayBg, 27);
            p= new Paragraph();
            
            
            
         PdfController.generateCheckBoxes4(generatedDoc, new DeviceRgb(212, 216, 210), solicitude);
        } catch (IOException ex) {
           PdfController.generateCheckBoxes4(generatedDoc, new DeviceRgb(212, 216, 210), solicitude);
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCounter;
    }

    private static Table createTable3(PdfWorkspace generatedDoc) throws IOException {

        Table table = new Table(UnitValue.createPercentArray(8)).setWidth(530).setRelativePosition(10, 0, 0, 0);

        Paragraph q = new Paragraph();
        generatedDoc.pushText(q, new Text("Cantidad"), titleFont, 8);
        Cell cell = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Unidad de medida*"), titleFont, 8);
        Cell cell12 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell12);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Nombre común"), titleFont, 8);
        Cell cell13 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell13);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Nombre científico"), titleFont, 8);
        Cell cell14 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell14);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Aplica para únicamente para manejo\n"
                + "sostenible de flora silvestre y los productos\n"
                + "forestales no maderables"), titleFont, 8);
        Cell cell15 = new Cell(1, 2).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell15);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Veda nacional\n"
                + "o regional\n"
                + "(si aplica) **"), titleFont, 8);
        Cell cell17 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell17);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Categoría\n"
                + "de\n"
                + "amenaza\n"
                + "(si aplica)"), titleFont, 8);
        Cell cell18 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell18);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Parte aprovechada"
                + "(Raíz, Fruto, Semilla,"
                + "Flor, Corteza,"
                + "Exudado, Yema, Hojas,"
                + "Tallos, Ramas, etc.)"), titleFont, 8);
        Cell cell25 = new Cell().add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell25);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Hábito"
                + "(Árbol, Arbusto,"
                + "Hierba terrestre,"
                + "Epífita, Bejuco/liana,"
                + "Hemiepífita, Palma,"
                + "etc.)"), titleFont, 8f);
        Cell cell26 = new Cell().add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell26);

        for (int i = 0; i < 80; i++) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(""), titleFont, 8f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setMinHeight(10);
            table.addCell(temporal);
        }

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Cantidad \n Total"), titleFont, 8f);
        Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
        table.addFooterCell(temporal);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text(""), titleFont, 8f);
        Cell cellFinal = new Cell(1, 7).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addFooterCell(cellFinal);
        
        return table;
    }

    /**
     *
     * @param generatedDoc
     * @return
     * @throws IOException
     */
    private static Table createTable2(PdfWorkspace generatedDoc) throws IOException {

        Table table = new Table(UnitValue.createPercentArray(8)).setWidth(450).setRelativePosition(50, 0, 0, 0);

        Paragraph q = new Paragraph();
        generatedDoc.pushText(q, new Text("Coordenadas geograficas"), titleFont, 8.5f);
        Cell cell = new Cell(1, 8).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Punto"), titleFont, 8.5f);
        Cell cell21 = new Cell(2, 1).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell21).setTextAlignment(TextAlignment.CENTER);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Latitud"), titleFont, 8.5f);
        Cell cell22 = new Cell(1, 3).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell22).setTextAlignment(TextAlignment.CENTER);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Longitud"), titleFont, 8.5f);
        Cell cell25 = new Cell(1, 3).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell25).setTextAlignment(TextAlignment.CENTER);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Altitud"), titleFont, 8.5f);
        Cell cell28 = new Cell(2, 1).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell28).setTextAlignment(TextAlignment.CENTER);

        String[] textFields = {"Grados", "Minutos", "Segundos", "Grados", "Minutos", "Segundos"};
        for (String textField : textFields) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(textField), titleFont, 8.5f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
            table.addHeaderCell(temporal);
        }

        for (int i = 0; i < 96; i++) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(""), titleFont, 8.5f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER);
            table.addCell(temporal).setMinHeight(175);
        }

        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Origen"), titleFont, 8.5f);
        Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
        table.addCell(temporal).setMinHeight(175);

        q = new Paragraph();
        generatedDoc.pushText(q, new Text(""), titleFont, 8.5f);
        Cell cellFinal = new Cell(1, 7).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addCell(cellFinal).setMinHeight(175);

        return table;
    }

    /**
     *
     * @param generatedDoc
     * @return
     */
    public static Table createTable1(PdfWorkspace generatedDoc) {
        Table table = new Table(UnitValue.createPercentArray(3)).setWidth(450).setRelativePosition(50, 0, 0, 0);
        try {

            Paragraph q = new Paragraph();
            generatedDoc.pushText(q, new Text("Coordenadas planas"), titleFont, 8.5f);
            Cell cell = new Cell(1, 3).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            table.addHeaderCell(cell);
            Paragraph c = new Paragraph();
            generatedDoc.pushText(c, new Text("Punto"), titleFont, 8.5f);
            Cell cell21 = new Cell().add(c.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            Paragraph x = new Paragraph();
            generatedDoc.pushText(x, new Text("X"), titleFont, 8.5f);
            Cell cell22 = new Cell().add(x.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            Paragraph y = new Paragraph();
            generatedDoc.pushText(y, new Text("Y"), titleFont, 8.5f);
            Cell cell23 = new Cell().add(y.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            table.addHeaderCell(cell21).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell22).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell23).setTextAlignment(TextAlignment.CENTER);
            for (int i = 0; i < 36; i++) {
                Cell temporal = new Cell().setTextAlignment(TextAlignment.CENTER);
                table.addCell(temporal).setMinHeight(175);
            }

        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }

    public static void fillTable1(Table table, RequestModel solicitude, PdfWorkspace generatedDoc) {

        PlaneCoordinateModel a = new PlaneCoordinateModel(0, 0, 0);

        int counterRow = 0;

        for (CoordinateModel coordiante : solicitude.getProperties().get(0).getCoordiantes()) {

            try {
                a = (PlaneCoordinateModel) coordiante;

                Paragraph p = new Paragraph();
                Cell cell = new Cell().add(p.setTextAlignment(TextAlignment.CENTER));
                generatedDoc.pushText(p, new Text(String.valueOf(a.getPOINT())), titleFont, 8.5f);
                table.getCell(counterRow, 0).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(String.valueOf(a.getX())), titleFont, 8.5f);
                table.getCell(counterRow, 1).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(String.valueOf(a.getY())), titleFont, 8.5f);
                table.getCell(counterRow, 2).add(p);

                counterRow++;
            } catch (IOException ex) {
                Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void fillTable2(Table table, RequestModel solicitude, PdfWorkspace generatedDoc) {

        try {
            GeographicCoordinateModel aux = new GeographicCoordinateModel(0);
            int counterRow = 0;
            Paragraph p = new Paragraph();

            for (CoordinateModel coordiante : solicitude.getProperties().get(0).getCoordiantes()) {
                int counter = 0;

                p = new Paragraph();
                aux = (GeographicCoordinateModel) coordiante;
                generatedDoc.pushText(p, new Text(String.valueOf(aux.getPOINT())), titleFont, 8.5f);

                table.getCell(counterRow, 0).add(p);

                for (Object latitude : aux.getLATITUDE()) {
                    counter++;
                    p = new Paragraph();
                    generatedDoc.pushText(p, new Text(String.valueOf(latitude)), titleFont, 8.5f);
                    table.getCell(counterRow, counter).add(p);
                }

                for (Object longitude : aux.getLONGITUDE()) {
                    counter++;
                    p = new Paragraph();
                    generatedDoc.pushText(p, new Text(String.valueOf(longitude)), titleFont, 8.5f);
                    table.getCell(counterRow, counter).add(p);
                }

                counter++;
                p = new Paragraph();
                generatedDoc.pushText(p, new Text(String.valueOf(aux.getALTITUDE())), titleFont, 8.5f);
                table.getCell(counterRow, counter).add(p);

                counterRow++;
                counter++;

            }

            p = new Paragraph();
            generatedDoc.pushText(p, new Text(aux.getORIGIN()), titleFont, 8.5f);
            table.getCell(counterRow, 1).add(p);
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Table fillTable3(Table table, RequestModel solicitude, PdfWorkspace generatedDoc) {

        int counterRow = 0;
        Paragraph p = new Paragraph("");
        SpecieModel aux = new SpecieModel();

        for (SpecieModel specie : solicitude.getProperties().get(0).getSpecies()) {

            try {

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(String.valueOf(specie.getQuantity())), titleFont, 8.5f);
                table.getCell(counterRow, 0).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getUnit()), titleFont, 8.5f);
                table.getCell(counterRow, 1).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getCommonName()), titleFont, 8.5f);
                table.getCell(counterRow, 2).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getScientificName()), titleFont, 8.5f);
                table.getCell(counterRow, 3).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getHabit()), titleFont, 8.5f);
                table.getCell(counterRow, 4).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getClosure()), titleFont, 8.5f);
                table.getCell(counterRow, 5).add(p);

                p = new Paragraph();
                generatedDoc.pushText(p, new Text(specie.getThreatClassification()), titleFont, 8.5f);
                table.getCell(counterRow, 6).add(p);

            } catch (IOException ex) {
                Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
            }

            counterRow++;

        }
        return table;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param relativePosition
     * @param leading
     */
    public static void setUpParagraph(Paragraph p, PdfWorkspace generatedDoc, int relativePosition, int leading) {
        p.setFixedLeading(leading);
        p.setBorder(new SolidBorder(0.75f));
        p.setMarginRight(-5);
        p.setMarginLeft(-5);
        p.setPaddingLeft(5);
        p.setRelativePosition(0, 0, 0, relativePosition);
        generatedDoc.empujarParrafo(p);
    }

    /**
     * Cada línea de texto en Y, difiere en 20 coordenadas de la anterior
     *
     * @param generatedDoc
     * @param color
     */
    public static void generateCheckBoxes1(PdfWorkspace generatedDoc, Color color, RequestModel solicitude) throws MalformedURLException {
        InterestedModel person = solicitude.getInterested();
        PropertyModel properytyModel = solicitude.getProperties().get(0);
        CategoryModel category = solicitude.getCategoryA();
        CategoryBModel categoryB = solicitude.getCategoryB();
        int y = 817;

        if (solicitude.getTypeRequest() != null) {
            switch (solicitude.getTypeRequest()) {
                case "Nueva":
                    //first
                    generatedDoc.createRectangle2(color, 165, y, 18, 10);
                    generatedDoc.createRectangle(color, 230, y, 18, 10);
                    break;
                case "Prórroga":
                    generatedDoc.createRectangle(color, 165, y, 18, 10);
                    generatedDoc.createRectangle2(color, 230, y, 18, 10);
                    break;
                default:
                    generatedDoc.createRectangle(color, 165, y, 18, 10);
                    generatedDoc.createRectangle(color, 230, y, 18, 10);
                    break;
            }
            if (person.getTypePerson() != null) {
                if (person.getTypePerson().equals("Natural")) {
                    //second
                    generatedDoc.createRectangle2(color, 149, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 244, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 339, y - 40, 18, 10);

                } else if (person.getTypePerson().equals("Jurídica pública")) {
                    generatedDoc.createRectangle(color, 149, y - 40, 18, 10);
                    generatedDoc.createRectangle2(color, 244, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 339, y - 40, 18, 10);

                } else if (person.getTypePerson().equals("Jurídica Privada")) {
                    generatedDoc.createRectangle(color, 149, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 244, y - 40, 18, 10);
                    generatedDoc.createRectangle2(color, 339, y - 40, 18, 10);
                } else {
                    //second
                    generatedDoc.createRectangle(color, 149, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 244, y - 40, 18, 10);
                    generatedDoc.createRectangle(color, 339, y - 40, 18, 10);
                }
                if (person.getTypeId() != null) {
                    if (person.getTypeId().equals("CC")) {
                        //thirth
                        generatedDoc.createRectangle2(color, 146, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 283, y - 80, 18, 10);
                    } else if (person.getTypeId().equals("CE")) {
                        //thirth
                        generatedDoc.createRectangle(color, 146, y - 80, 18, 10);
                        generatedDoc.createRectangle2(color, 191, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 283, y - 80, 18, 10);
                    } else if (person.getTypeId().equals("PA")) {
                        //thirth
                        generatedDoc.createRectangle(color, 146, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 80, 18, 10);
                        generatedDoc.createRectangle2(color, 236, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 283, y - 80, 18, 10);
                    } else if ((person.getTypeId().equals("NIT"))) {
                        //thirth
                        generatedDoc.createRectangle(color, 146, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 80, 18, 10);
                        generatedDoc.createRectangle2(color, 283, y - 80, 18, 10);
                    } else {
                        //thirth
                        generatedDoc.createRectangle(color, 146, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 80, 18, 10);
                        generatedDoc.createRectangle(color, 283, y - 80, 18, 10);
                    }
                }
                if (person.getTypeId() != null) {
                    if (person.getTypeId().equals("CC")) {
                        //Fourth
                        generatedDoc.createRectangle2(color, 146, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 140, 18, 10);
                    } else if (person.getTypeId().equals("CE")) {
                        //Fourth
                        generatedDoc.createRectangle(color, 146, y - 140, 18, 10);
                        generatedDoc.createRectangle2(color, 191, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 140, 18, 10);
                    } else if (person.getTypeId().equals("PA")) {
                        //Fourth
                        generatedDoc.createRectangle(color, 146, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 140, 18, 10);
                        generatedDoc.createRectangle2(color, 236, y - 140, 18, 10);
                    } else {
                        //Fourth
                        generatedDoc.createRectangle(color, 146, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 191, y - 140, 18, 10);
                        generatedDoc.createRectangle(color, 236, y - 140, 18, 10);
                    }
                    if (person.getInterestedQuality() != null) {
                        if (person.getInterestedQuality().equals("Propietario")) {
                            //Fifth
                            generatedDoc.createRectangle2(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Poseedor")) {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Tenedor")) {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Ocupante")) {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Autorizado")) {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Ente territorial")) {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle2(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Consejo comunitario")) {
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
//sixth
                            generatedDoc.createRectangle2(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Resguardo indígena")) {
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            //sixth
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle2(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        } else if (person.getInterestedQuality().equals("Otro")) {
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            //sixth
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle2(color, 286, y - 200, 18, 10);
                        } else {
                            //Fifth
                            generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
                            generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
                        }

                    }
                    if (properytyModel.getTypeProperty() != null) {
                        if (properytyModel.getTypeProperty().equals("Público")) {
                            //Seventh
                            generatedDoc.createRectangle2(color, 143, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 213, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 276, y - 240, 18, 10);

                        } else if (properytyModel.getTypeProperty().equals("Colectivo")) {
                            generatedDoc.createRectangle(color, 143, y - 240, 18, 10);
                            generatedDoc.createRectangle2(color, 213, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 276, y - 240, 18, 10);
                        } else if (properytyModel.getTypeProperty().equals("Privado")) {
                            generatedDoc.createRectangle(color, 143, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 213, y - 240, 18, 10);
                            generatedDoc.createRectangle2(color, 276, y - 240, 18, 10);
                        } else {
                            generatedDoc.createRectangle(color, 143, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 213, y - 240, 18, 10);
                            generatedDoc.createRectangle(color, 276, y - 240, 18, 10);
                        }

                    }
                    if (solicitude.getHowToAcquire() != null) {
                        if (solicitude.getHowToAcquire().equals("Permiso")) {
                            //Eight
                            generatedDoc.createRectangle2(color, 151, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 207, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 292, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 402, y - 483, 18, 10);
                        } else if (solicitude.getHowToAcquire().equals("Asociación")) {
                            //Eight
                            generatedDoc.createRectangle(color, 151, y - 483, 18, 10);
                            generatedDoc.createRectangle2(color, 207, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 292, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 402, y - 483, 18, 10);
                        } else if (solicitude.getHowToAcquire().equals("Concesión Forestal")) {
                            generatedDoc.createRectangle(color, 151, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 207, y - 483, 18, 10);
                            generatedDoc.createRectangle2(color, 292, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 402, y - 483, 18, 10);
                        } else {
                            generatedDoc.createRectangle(color, 151, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 207, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 292, y - 483, 18, 10);
                            generatedDoc.createRectangle(color, 402, y - 483, 18, 10);
                        }

                    }
                    if (person.isAuthorization() != false) {
                        //ninth
                        generatedDoc.createRectangle2(color, 262, y - 503, 18, 10);
                    }
                    if (category.getName() != null) {
                        if (category.getName().equals("A. Productos forestales maderables")) {
                            //Tenth
                            generatedDoc.createRectangle2(color, 180, y - 563, 18, 10);
                            if (solicitude.getMethodUtilization() != null) {
                                if (solicitude.getMethodUtilization().equals("Persistente")) {
                                    //Eleventh
                                    generatedDoc.createRectangle2(color, 292, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 348, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 423, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 559, y - 583, 18, 10);
                                } else if (solicitude.getMethodUtilization().equals("Único")) {
                                    //Eleventh
                                    generatedDoc.createRectangle(color, 292, y - 583, 18, 10);
                                    generatedDoc.createRectangle2(color, 348, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 423, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 559, y - 583, 18, 10);
                                } else if (solicitude.getMethodUtilization().equals("Doméstico")) {
                                    //Eleventh
                                    generatedDoc.createRectangle(color, 292, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 348, y - 583, 18, 10);
                                    generatedDoc.createRectangle2(color, 423, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 559, y - 583, 18, 10);
                                } else if (solicitude.getMethodUtilization().equals("Manejo Forestal Unificado")) {
                                    //Eleventh
                                    generatedDoc.createRectangle(color, 292, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 348, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 423, y - 583, 18, 10);
                                    generatedDoc.createRectangle2(color, 559, y - 583, 18, 10);
                                } else {
                                    //Eleventh
                                    generatedDoc.createRectangle(color, 292, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 348, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 423, y - 583, 18, 10);
                                    generatedDoc.createRectangle(color, 559, y - 583, 18, 10);
                                }
                            }

                        }
                        if (categoryB.getName().equals("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables")) {
                            //Twelft
                            generatedDoc.createRectangle2(color, 363, y - 603, 18, 10);
                            if (categoryB.getTypeOperation().equals("Doméstico")) {
                                //Thirteenth
                                generatedDoc.createRectangle2(color, 292, y - 623, 18, 10);
                                generatedDoc.createRectangle(color, 368, y - 623, 18, 10);
                            } else if (categoryB.getTypeOperation().equals("Persistente ")) {
                                //Thirteenth
                                generatedDoc.createRectangle(color, 292, y - 623, 18, 10);
                                generatedDoc.createRectangle2(color, 368, y - 623, 18, 10);
                            } else if (categoryB.getAssociatedCategory().equals("Pequeños")) {
                                //Fourtheenth
                                generatedDoc.createRectangle2(color, 89, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 173, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 248, y - 745, 18, 10);
                            } else if (categoryB.getAssociatedCategory().equals("Medianos")) {
                                //Fourtheenth
                                generatedDoc.createRectangle(color, 89, y - 745, 18, 10);
                                generatedDoc.createRectangle2(color, 173, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 248, y - 745, 18, 10);
                            } else if (categoryB.getAssociatedCategory().equals("Grandes")) {
                                //Fourtheenth
                                generatedDoc.createRectangle(color, 89, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 173, y - 745, 18, 10);
                                generatedDoc.createRectangle2(color, 248, y - 745, 18, 10);
                            } else {
                                //Fourtheenth
                                generatedDoc.createRectangle(color, 363, y - 603, 18, 10);
                                generatedDoc.createRectangle(color, 89, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 173, y - 745, 18, 10);
                                generatedDoc.createRectangle(color, 248, y - 745, 18, 10);
                                //Thirteenth
                                generatedDoc.createRectangle(color, 292, y - 623, 18, 10);
                                generatedDoc.createRectangle(color, 368, y - 623, 18, 10);
                            }
                        }
                        if (category.getName().equals("C. Árboles Aislados")) {
                            //fitteen
                            generatedDoc.createRectangle2(color, 120, y - 763, 18, 10);
                        } else {
                            //fitteen
                            generatedDoc.createRectangle(color, 120, y - 763, 18, 10);
                        }

                    }
                }

            }

        }
    }

    public static void generateCheckBoxes2(PdfWorkspace generatedDoc, Color color, RequestModel solicitude) throws MalformedURLException {
        String addressTypeArea = solicitude.getProperties().get(0).getAdress().getTypeArea();
        LinkedList<CoordinateModel> coordinate = solicitude.getProperties().get(0).getCoordiantes();
        CategoryModel category = solicitude.getCategoryA();
        CategoryDModel categoryD = solicitude.getCategoryD();

        int y = 817;
        generatedDoc.createRectangle2(color, 150, y + 41, 18, 10);

        if (category.getName().equals("D. Guaduales y bambusales")) {
            generatedDoc.createRectangle2(color, 150, y + 41, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 150, y + 41, 18, 10);
        }
        if (categoryD.getTypeUtilization().equals("Tipo 1")) {
            generatedDoc.createRectangle2(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        }
        if (categoryD.getTypeUtilization().equals("Tipo 2")) {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle2(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        }
        if (categoryD.getTypeUtilization().equals("Cambio definitivo de uso del suelo")) {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle2(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        }
        if (categoryD.getTypeUtilization().equals("Establecimiento y Manejo")) {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle2(color, 431, y + 1, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 65, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 125, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 292, y + 1, 18, 10);
            generatedDoc.createRectangle(color, 431, y + 1, 18, 10);
        }
        if (addressTypeArea.equals("Urbano")) {
            generatedDoc.createRectangle2(color, 285, y - 80, 18, 10);
            generatedDoc.createRectangle(color, 340, y - 80, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 285, y - 80, 18, 10);
            generatedDoc.createRectangle(color, 340, y - 80, 18, 10);
        }
        if (addressTypeArea.equals("Rural")) {
            generatedDoc.createRectangle(color, 285, y - 80, 18, 10);
            generatedDoc.createRectangle2(color, 340, y - 80, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 285, y - 80, 18, 10);
            generatedDoc.createRectangle(color, 340, y - 80, 18, 10);
        }
        if (coordinate.equals("Coordenadas planas")) {
            generatedDoc.createRectangle2(color, 125, y - 240, 18, 10);
            generatedDoc.createRectangle(color, 260, y - 240, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 125, y - 240, 18, 10);
            generatedDoc.createRectangle(color, 260, y - 240, 18, 10);
        }
        if (coordinate.equals("Coordenadas geográficas")) {
            generatedDoc.createRectangle(color, 125, y - 240, 18, 10);
            generatedDoc.createRectangle2(color, 260, y - 240, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 125, y - 240, 18, 10);
            generatedDoc.createRectangle(color, 260, y - 240, 18, 10);
        }

    }

  public static void generateCheckBoxes3(PdfWorkspace generatedDoc, Color color, RequestModel solicitude) throws MalformedURLException {
        CategoryCModel category = solicitude.getCategoryC();

        int y = 817;

        if (solicitude.getMethodUtilization() != null) {
            if (solicitude.getMethodUtilization().equals("Mecánico")) {
                generatedDoc.createRectangle2(color, 285, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 335, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 430, y - 10, 18, 10);
            } else if (solicitude.getMethodUtilization().equals("Manual")) {
                generatedDoc.createRectangle(color, 285, y - 10, 18, 10);
                generatedDoc.createRectangle2(color, 335, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 430, y - 10, 18, 10);
            } else if (solicitude.getMethodUtilization().equals("Mecánico-Manual")) {
                generatedDoc.createRectangle(color, 285, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 335, y - 10, 18, 10);
                generatedDoc.createRectangle2(color, 430, y - 10, 18, 10);
            } else {
                generatedDoc.createRectangle(color, 285, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 335, y - 10, 18, 10);
                generatedDoc.createRectangle(color, 430, y - 10, 18, 10);
            }

        }

    }

    public static void generateCheckBoxes4(PdfWorkspace generatedDoc, Color color, RequestModel solicitude) throws MalformedURLException {
        CategoryModel category = solicitude.getCategoryC();

        int y = 817;
        if (category.getName().equals("C. Árboles Aislados")) {
            //fitteen
            generatedDoc.createRectangle2(color, 285, y - 43, 18, 10);
        } else {
            //fitteen
            generatedDoc.createRectangle(color, 285, y - 43, 18, 10);
        }

        
        if (category instanceof CategoryC1Model) {
            CategoryC1Model category1 = (CategoryC1Model) category;
            if (category1.getIndividualStatus().equals("Caído por Causas Naturales")) {
                generatedDoc.createRectangle2(color, 160, y - 63, 18, 10);
            } else if (category1.getIndividualStatus().equals("Muerto por Causas Naturales")) {
                generatedDoc.createRectangle2(color, 160, y - 83, 18, 10);
            } else if (category1.getIndividualStatus().equals("Razones de Orden Fitosanitario")) {
                generatedDoc.createRectangle2(color, 160, y - 103, 18, 10);
            }
        } else {
            generatedDoc.createRectangle(color, 160, y - 63, 18, 10);
            generatedDoc.createRectangle(color, 160, y - 83, 18, 10);
            generatedDoc.createRectangle(color, 160, y - 103, 18, 10);
        }
        if (category instanceof CategoryC2Model) {
            generatedDoc.createRectangle2(color, 285, y - 143, 18, 10);
        } else {
            generatedDoc.createRectangle(color, 285, y - 143, 18, 10);
        }
        if (category instanceof CategoryC3Model) {
            CategoryC3Model category3 = (CategoryC3Model) category;
            generatedDoc.createRectangle2(color, 250, y - 163, 18, 10);
            if (category3.getTipo().equals("Tala")) {
                generatedDoc.createRectangle2(color, 60, y - 183, 18, 10);
            } else if (category3.getTipo().equals("Poda")) {
                generatedDoc.createRectangle2(color, 120, y - 183, 18, 10);
            } else if (category3.getIndividualStatus().equals("Caído")) {
                generatedDoc.createRectangle2(color, 60, y - 213, 18, 10);
            } else if (category3.getIndividualStatus().equals("Muerto")) {
                generatedDoc.createRectangle2(color, 120, y - 213, 18, 10);
            } else if (category3.getIndividualStatus().equals("Enfermo")) {
                generatedDoc.createRectangle2(color, 200, y - 213, 18, 10);
            } else if (category3.getCause().equals("Estabilidad de Suelos")) {
                generatedDoc.createRectangle2(color, 200, y - 233, 18, 10);
            } else if (category3.getCause().equals("Canal de Agua")) {
                generatedDoc.createRectangle2(color, 295, y - 233, 18, 10);
            } else if (category3.getCause().equals("Obras de Infraestructura/Edificaciones")) {
                generatedDoc.createRectangle2(color, 485, y - 233, 18, 10);
            } else if (category3.getCause().equals("Otro (especifique cuál)")) {
                generatedDoc.createRectangle2(color, 130, y - 243, 18, 10);
            }

        } else {
            generatedDoc.createRectangle(color, 250, y - 163, 18, 10);
            generatedDoc.createRectangle(color, 60, y - 183, 18, 10);
            generatedDoc.createRectangle(color, 120, y - 183, 18, 10);
            generatedDoc.createRectangle(color, 60, y - 213, 18, 10);
            generatedDoc.createRectangle(color, 120, y - 213, 18, 10);
            generatedDoc.createRectangle(color, 200, y - 213, 18, 10);
            generatedDoc.createRectangle(color, 200, y - 233, 18, 10);
            generatedDoc.createRectangle(color, 295, y - 233, 18, 10);
            generatedDoc.createRectangle(color, 485, y - 233, 18, 10);
            generatedDoc.createRectangle(color, 130, y - 243, 18, 10);
        }
        if (category instanceof CategoryC4Model) {
            CategoryC4Model category4 = (CategoryC4Model) category;
            generatedDoc.createRectangle2(color, 230, y - 263, 18, 10);
            if (category4.getTipo().equals("Tala")) {
                generatedDoc.createRectangle2(color, 60, y - 283, 18, 10);
            } else if (category4.getTipo().equals("Trasplante/Reubicación")) {
                generatedDoc.createRectangle2(color, 200, y - 283, 18, 10);
            } else if (category4.getActivity().equals("Construcción /Realización")) {
                generatedDoc.createRectangle2(color, 145, y - 335, 18, 10);
            } else if (category4.getActivity().equals("Remodelación")) {
                generatedDoc.createRectangle2(color, 245, y - 335, 18, 10);
            } else if (category4.getActivity().equals("Ampliación")) {
                generatedDoc.createRectangle2(color, 315, y - 335, 18, 10);
            } else if (category4.getActivity().equals("Instalación")) {
                generatedDoc.createRectangle2(color, 390, y - 335, 18, 10);
            } else if (category4.getActivity().equals("Similares")) {
                generatedDoc.createRectangle2(color, 535, y - 335, 18, 10);
            }

        } else {
            generatedDoc.createRectangle(color, 230, y - 263, 18, 10);
            generatedDoc.createRectangle(color, 60, y - 283, 18, 10);
            generatedDoc.createRectangle(color, 200, y - 283, 18, 10);
            generatedDoc.createRectangle(color, 145, y - 335, 18, 10);
            generatedDoc.createRectangle(color, 245, y - 335, 18, 10);
            generatedDoc.createRectangle(color, 315, y - 335, 18, 10);
            generatedDoc.createRectangle(color, 390, y - 335, 18, 10);
            generatedDoc.createRectangle(color, 535, y - 335, 18, 10);
        }

        if (solicitude.getInterested().isAuthorization()) { 
             generatedDoc.createRectangle(color, 535, y - 395, 18, 10);
        }
    }
    public static int addBodyTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param lineCounter
     * @param datas
     * @return
     * @throws IOException
     */
    public static int addBodyTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, String... datas) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, datas);
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param lineCounter
     * @return
     * @throws IOException
     */
    public static int addTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, int fontSize) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 8f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, String... datas) throws IOException {

        String temporal = "";
        for (String data : datas) {
            texts.get(lineCounter + 1).setText(data + "       ");
            temporal = temporal + texts.get(lineCounter).getText() + texts.get(lineCounter + 1).getText();
            lineCounter += 2;
        }

        generatedDoc.pushText(p, new Text(temporal), bodyFont, 9f);
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, float fontSize) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, fontSize);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addUndelinedBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushUnderlinedText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addSingleTitle(PdfWorkspace generatedDoc, int i, Color color, int relativePosition) throws IOException {
        Paragraph title = generatedDoc.nuevoParrafo(new Text(espacio + espacio), "ArialNarrowBold.ttf", 10f);
        generatedDoc.pushText(title, texts.get(i), "ArialNarrowBold.ttf", 10f);
        title.setBorder(new SolidBorder(0.75f));
        title.setMarginLeft(-5);
        title.setMarginRight(-5);
        title.setPaddingLeft(5);
        i++;
        title.setBackgroundColor(color, 0.75f);
        title.setRelativePosition(0, 0, 0, relativePosition);
        generatedDoc.empujarParrafo(title);
        return i;
    }

    public static LinkedList<Text> cargarBD() throws IOException {
        String[] textoFormatos = Utils.loadFile(new File("resources\\formularioCampos.txt"));
        LinkedList<Text> textsList = new LinkedList<>();

        for (String textoFormato : textoFormatos) {
            textsList.add(new Text(textoFormato));
        }
        return textsList;
    }

    public static void addHeader(PdfWorkspace generatedDoc, LinkedList<Text> texts) throws MalformedURLException, IOException {

        Paragraph encabezado = generatedDoc.nuevoParrafo("minambiente.png", 44, 214, 30, 920);
        encabezado.setTextAlignment(TextAlignment.CENTER);
        //Interlineado
        encabezado.setFixedLeading(12);
        generatedDoc.pushText(encabezado, texts.getFirst().setRelativePosition(10, 0, 0, 0), "ArialNarrowBold.ttf", 11.5f);
        generatedDoc.pushText(encabezado, texts.get(1).setRelativePosition(10, 0, 0, 0), "ArialNarrowBold.ttf", 9.5f);
        generatedDoc.empujarImagen(encabezado, "sina.png", 41, 127, 450, 925);
        encabezado.setBorder(new SolidBorder(0.75f));
        encabezado.setMargin(-5);
        generatedDoc.empujarParrafo(encabezado);

        encabezado = generatedDoc.nuevoParrafo(texts.get(2), "ArialMT.ttf", 8.3f);
        encabezado.setBorder(new SolidBorder(0.75f));
        encabezado.setMarginLeft(-5);
        encabezado.setTextAlignment(TextAlignment.CENTER);
        encabezado.setMarginRight(-5);
        generatedDoc.empujarParrafo(encabezado);
    }
}
