package co.gov.minambiente.controlador;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Border;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import com.itextpdf.forms.fields.PdfButtonFormField;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.source.RandomAccessSourceFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.IPdfPageExtraCopier;
import com.itextpdf.kernel.pdf.PdfAConformanceLevel;
import static com.itextpdf.kernel.pdf.PdfName.List;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Clase creada para utilizar métodos indispensables para el funcionamiento del
 * programa
 *
 * @author Andrés Güiza
 */
public class PdfWorkspace {

    private String nombre;
    private File destino;
    private File destinoImagen;
    //Gestiona el contenido del pdf
    private PdfDocument pdf;
    //Gestiona el diseño del pdf
    private Document document;
    private PdfFont fuente;

    private String rutaFuente;
    private int actualPage;
    
    private PdfCanvas canva;
    
    private PdfAcroForm form;
    private PdfButtonFormField check;

    public PdfWorkspace(String nombre, String destino) {

        this.actualPage = 0;
        this.nombre = nombre;
        this.rutaFuente = "src\\co\\gov\\minambiente\\fonts\\";
        this.destino = new File(destino);
        this.destinoImagen = new File("resources\\images");
        this.rutaFuente = "src\\co\\gov\\minambiente\\fonts\\";
        this.inicializarDocumento();
    }

    //Métodos
    /**
     *
     * @param numeroPaginas El número de páginas que contendrá el documento
     * final (se pueden sumar en el futuro)
     */
    private void inicializarDocumento() {
          
        this.validarDirectorio();
        // Seteo de PdfDocument
        PdfWriter writer = null;
        try{
        writer = new PdfWriter(new File(this.destino.getPath() + "\\"
                + this.nombre)).setSmartMode(true);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.pdf = new PdfDocument(writer);
        this.pdf.setDefaultPageSize(new PageSize(612.0f, 1008.0f));
       /* for (int i = 0; i < numeroPaginas; i++) {
            this.pdf.addNewPage();
        }*/
       
       
        //Seteo del Document
        this.document = new Document(this.pdf);
        this.document.setMargins(30f, 27f, -10f, 34f);
        this.pdf.addNewPage();
        canva = new PdfCanvas(pdf.getFirstPage());
                
    }
    
    public void createRectangle(Color fill, double positionX, double positionY,
            int width, int height){
        
        this.canva.rectangle(positionX, positionY, width, height).setLineWidth(20)
                .setStrokeColor(ColorConstants.BLACK)
                .setColor(fill, true).fill()
                ;
    }
    public void createRectangle2(Color color,float positionX, float positionY,
        int width, int height ) throws MalformedURLException{
        Image temporal = new Image(ImageDataFactory.create("resources\\images\\icons.jpg"));
        temporal.setMaxHeight(width );
        temporal.setMaxWidth(height);
        temporal.setFixedPosition(positionX,positionY );
        this.document.add(temporal);
        
    }
    
    /**
     * Este método revisa si el directorio fue creado
     *
     * @param ruta Este parámetro es la ruta que queremos revisar si existe
     * @return Retorna verdadero si el directorio existe, falso si no
     */
    public static boolean revisarDirectorio(String ruta) {
        File directorio = new File(ruta);
        return directorio.exists();
    }

    /**
     *Comprueba si la ruta de guardado del documento existe. Si no existe, la crea
     */
    private void validarDirectorio() {
        if (revisarDirectorio(this.destino.getPath())) {
            System.out.println("El directorio pdfOutput sí está");
        } else {
            System.out.println("No existe el directorio pdfOutput");
            this.destino.mkdirs();
            System.out.println("Directorio pdfOutput creado");
        }
    }

    /**
     * Este método crea un nuevo párrafo que inicia con texto
     *
     * @param texto El texto a almacenar
     * @param nombreFuente Nombre de la fuente con extensión
     * @param tamano Tamaño de la fuente
     * @return Retorna el párrafo
     * @throws IOException Excepción que ocurre si la ruta de la fuente está mal
     */
    public Paragraph nuevoParrafo(Text texto, String nombreFuente, float tamano) throws IOException {
        FontProgram temporal;
        temporal = FontProgramFactory.createFont(this.rutaFuente + nombreFuente);
        PdfFont auxiliar = PdfFontFactory.createFont(temporal);
        texto.setFont(auxiliar);
        texto.setFontSize(tamano);
        Paragraph parrafo = new Paragraph(texto);
        parrafo.setFontColor(ColorConstants.BLACK);
        return parrafo;
    }

    /**
     * Este método crea un nuevo párrafo que inicia con una imagen
     *
     * @param nombreImagen Nombre en disco de la imagen a insertar
     * @param ancho x
     * @param alto y
     * @param fixAncho Valor de ancho
     * @param fixAlto Valor de alto
     * @return Retorna el párrafo
     * @throws MalformedURLException
     */
    public Paragraph nuevoParrafo(String nombreImagen, int ancho, int alto, 
            int fixAncho, int fixAlto) throws MalformedURLException {
        Image temporal = new Image(ImageDataFactory.create(this.destinoImagen.getPath() 
                + "\\" + nombreImagen));
        Paragraph parrafo = new Paragraph("");
        parrafo.add(temporal);
        temporal.setMaxHeight(ancho * 3 / 4);
        temporal.setMaxWidth(alto * 3 / 4);
        parrafo.setFirstLineIndent(-5);
        temporal.setFixedPosition(fixAncho, fixAlto);
        return parrafo;
    }

    /**
     * Empuja una imagen dentro de un párrafo ya creado
     * @param parrafo Párrafo previamente instanciado
     * @param nombreImagen Nombre en disco de la imagen a insertar
     * @param ancho Ancho en pixeles
     * @param alto Alto en pixeles
     * @param fixX Posición ajustada en x
     * @param fixY Posición ajustada en y
     * @throws MalformedURLException
     */
    public void empujarImagen(Paragraph parrafo, String nombreImagen, int ancho,
            int alto, int fixX, int fixY) throws MalformedURLException {

        Image temporal = new Image
        (ImageDataFactory.create(this.destinoImagen.getPath() + "\\" + nombreImagen));
        temporal.setMaxHeight(ancho * 3 / 4);
        temporal.setMaxWidth(alto * 3 / 4);
        temporal.setFixedPosition(fixX, fixY);
        parrafo.add(temporal);
    }
    
    /**
     * Empuja un texto dentro de un párrafo ya creado
     * @param parrafo Párrafo previamente instanciado
     * @param texto Texto a empujar
     * @param nombreFuente Nombre en disco de la fuente a usar 
     * @param tamano Tamaño de la fuente
     * @throws MalformedURLException
     * @throws IOException 
     */
    public void pushText(Paragraph parrafo, Text texto, String nombreFuente, 
            float tamano) throws MalformedURLException, IOException {
        FontProgram temporal;
        temporal = FontProgramFactory.createFont(this.rutaFuente + nombreFuente);
        PdfFont auxiliar = PdfFontFactory.createFont(temporal);
        texto.setFont(auxiliar);
        texto.setFontSize(tamano);
        parrafo.setFontColor(ColorConstants.BLACK);
        parrafo.add(texto);
    }
    
    public void pushUnderlinedText(Paragraph parrafo, Text texto, String nombreFuente, 
            float tamano) throws MalformedURLException, IOException {
        FontProgram temporal;
        temporal = FontProgramFactory.createFont(this.rutaFuente + nombreFuente);
        PdfFont auxiliar = PdfFontFactory.createFont(temporal);
        texto.setFont(auxiliar);
        texto.setFontSize(tamano);
        texto.setUnderline();
        parrafo.setFontColor(ColorConstants.BLACK);
        parrafo.add(texto);
    }

    /**
     * 
     */
    public void pasarPagina(int i) {
        document.add(new AreaBreak());
        canva =  new PdfCanvas(pdf.getPage(i));
    }

    
    /**
     * 
     * @param p 
     */
    public void empujarParrafo(Paragraph p) {
        this.document.add(p);
    }

    /**
     * Método que escribe el archivo pdf en el disco
     */
    public void crearPdf() {
        //Guarda el pdf en la ruta asignada
        this.document.close();
        System.out.println("Documento creado");
    }
 

    //Setters & getters
    /**
     *
     * @return Retorna la ruta de destino
     */
    public File getDestino() {
        return destino;
    }

    /**
     *
     * @param destino Edita la ruta de destino (debe ser una carpeta)
     */
    public void setDestino(File destino) {
        if (destino.isDirectory()) {
            this.destino = destino;
        }
        System.out.println("No es una carpeta");
    }

    public PdfFont getFuente() {
        return fuente;
    }

    public void setFuente(PdfFont fuente) {
        this.fuente = fuente;
    }

    public PdfDocument getPdf() {
        return pdf;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

}
