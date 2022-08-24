package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Sección 1
 * @author Natalia García
 */
public class Seccion1 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;

    public Seccion1(ControladorSolicitud controlador) {
        initComponents();
        this.setTitle("Sección 1");
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
        txtOtro.setEnabled(false);
        txtCosto.setEnabled(false);
        txtCostoLetras.setEnabled(false);
        setEnabledApoderado(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarMenuPrincipal();
            }
        });
    }

    private void setEnabledApoderado(boolean state) {
        txtNombreApoderado.setEnabled(state);
        cmbTipoIdApoderado.setEnabled(state);
        txtNumeroIdApoderado.setEnabled(state);
        txtTPApoderado.setEnabled(state);
    }

    private void mostrarSiguienteVentana() {
        this.setVisible(false);
        if (cmbTipoSolicitud.getSelectedIndex() == 2) {
            controlador.mostrarSeccion2();
        } else {
            controlador.mostrarSeccion3();
        }
    }
    
    public void mostrarMenuPrincipal(){
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if(opcion == 0){
            this.setVisible(false);
            controlador.mostrarPrincipal();
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombreApoderado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOtro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTPApoderado = new javax.swing.JTextField();
        txtNumeroIdApoderado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        cmbTipoIdApoderado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbTipoSolicitud = new javax.swing.JComboBox<>();
        cmbTipoPredio = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNombreInteresado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbTipoIdInteresado = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtNumeroIdInteresado = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cmbTipoPersonaInteresado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmbCalidad = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCostoLetras = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        rbSi = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        rbSi1 = new javax.swing.JRadioButton();
        btnPrincipal = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Urbano", "Rural" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("1. Datos del interesado");

        txtNombreApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreApoderadoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de predio(s):");

        txtOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtroKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Otro:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("TP:");

        txtTPApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTPApoderadoKeyTyped(evt);
            }
        });

        txtNumeroIdApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroIdApoderadoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Tipo de persona:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Número de identificación:");

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setText("       sostenible");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Calidad:");

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        cmbTipoIdApoderado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "CC", "CE", "PA", "NIT" }));
        cmbTipoIdApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoIdApoderadoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel13.setText("1.1. Tipo de solicitud: ");

        cmbTipoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nueva", "Prórroga" }));

        cmbTipoPredio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Público", "Colectivo", "Privado" }));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Nombre:");

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel15.setText("1.2. Identificación del interesado");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Nombre o Razón Social:");

        txtNombreInteresado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreInteresadoKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Tipo de identificación:");

        cmbTipoIdInteresado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "CC", "CE", "PA", "NIT" }));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Número de identificación:");

        txtNumeroIdInteresado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroIdInteresadoKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Tipo de identificación:");

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setText("1.3. Apoderado");

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel21.setText("1.6. Costo del Proyecto, Obra o Actividad");

        cmbTipoPersonaInteresado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Natural", "Jurídica", "Jurídica Privada" }));

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel22.setText("1.4. Calidad en que actúa sobre el predio donde se realizará el aprovechamiento o manejo ");

        cmbCalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Propietario", "Poseedor", "Tenedor", "Ocupante", "Autorizado", "Ente territorial", "Consejo comunitario", "Resguardo indígena", "Otro", " " }));
        cmbCalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCalidadActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel23.setText("1.5. Información del predio objeto de la solicitud");

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("$");

        txtCostoLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoLetrasKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Valor en letras:");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Aplica:");

        rbSi.setText("Sí");
        rbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Aplica:");

        rbSi1.setText("Sí");
        rbSi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSi1ActionPerformed(evt);
            }
        });

        btnPrincipal.setText("Volver a la ventana principal");
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel26)
                        .addGap(12, 12, 12)
                        .addComponent(txtCostoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)
                        .addGap(26, 26, 26))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel13)
                        .addGap(12, 12, 12)
                        .addComponent(cmbTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoPersonaInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoIdInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroIdInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSi))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoIdApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroIdApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTPApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSi1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cmbTipoPersonaInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16)
                    .addComponent(txtNombreInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cmbTipoIdInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumeroIdInteresado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24)
                    .addComponent(rbSi))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTipoIdApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTPApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroIdApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(rbSi1))
                    .addComponent(jLabel21))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCostoLetras, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(txtCosto))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnPrincipal))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        String tipoSolicitud = (String) cmbTipoSolicitud.getSelectedItem();
        String tipoPersonaInteresado = (String) cmbTipoPersonaInteresado.getSelectedItem();
        String nombreInteresado = txtNombreInteresado.getText().trim();
        String tipoIdInteresado = (String) cmbTipoIdInteresado.getSelectedItem();
        String numeroIdInteresado = txtNumeroIdInteresado.getText().trim();
        String nombreApoderado = txtNombreApoderado.getText().trim();
        String tipoIdApoderado = (String) cmbTipoIdApoderado.getSelectedItem();
        String numeroIdApoderado = txtNumeroIdApoderado.getText().trim();
        String TPApoderado = txtTPApoderado.getText().trim();
        String calidad = (String) cmbCalidad.getSelectedItem();
        String otro = txtOtro.getText().trim();
        String tipoPredio = (String) cmbTipoPredio.getSelectedItem();
        String costo = txtCosto.getText().trim();
        String costoLetras = txtCostoLetras.getText().trim();

        if (!tipoSolicitud.equals("Seleccione") && !tipoPersonaInteresado.equals("Seleccione") && !nombreInteresado.equals("")
                && !tipoIdInteresado.equals("Seleccione") && !numeroIdInteresado.equals("") && !calidad.equals("Seleccione")
                && !tipoPredio.equals("Seleccione")) {
            if (calidad.equals("Otro")) {
                if (!otro.equals("")) {
                    if (rbSi.isSelected()) {
                        if (!nombreApoderado.equals("") && !tipoIdApoderado.equals("Seleccione") && !numeroIdApoderado.equals("")
                                && !TPApoderado.equals("")) {
                            if (rbSi1.isSelected()) {
                                if (!costo.equals("") && !costoLetras.equals("")) {
                                    controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                            tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                            numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                            costoLetras);
                                    mostrarSiguienteVentana();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                                }
                            } else {
                                controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                        tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                        numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                        costoLetras);
                                mostrarSiguienteVentana();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                        }
                    } else {
                        if (rbSi1.isSelected()) {
                            if (!costo.equals("") && !costoLetras.equals("")) {
                                controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                        tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                        numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                        costoLetras);
                                mostrarSiguienteVentana();
                            } else {
                                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                            }
                        } else {
                            controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                    tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                    numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                    costoLetras);
                            mostrarSiguienteVentana();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                }
            } else {
                if (rbSi.isSelected()) {
                    if (!nombreApoderado.equals("") && !tipoIdApoderado.equals("Seleccione") && !numeroIdApoderado.equals("")
                            && !TPApoderado.equals("")) {
                        if (rbSi1.isSelected()) {
                            if (!costo.equals("") && !costoLetras.equals("")) {
                                controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                        tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                        numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                        costoLetras);
                                mostrarSiguienteVentana();
                            } else {
                                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                            }
                        } else {
                            controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                    tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                    numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                    costoLetras);
                            mostrarSiguienteVentana();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                    }
                } else {
                    if (rbSi1.isSelected()) {
                        if (!costo.equals("") && !costoLetras.equals("")) {
                            controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                    tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                    numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                    costoLetras);
                            mostrarSiguienteVentana();
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                        }
                    } else {
                        controlador.guardarInformacionSeccion1(tipoSolicitud, tipoPersonaInteresado, nombreInteresado,
                                tipoIdInteresado, numeroIdInteresado, rbSi.isSelected(), nombreApoderado, tipoIdApoderado,
                                numeroIdApoderado, TPApoderado, calidad, otro, tipoPredio, rbSi1.isSelected(), costo,
                                costoLetras);
                        mostrarSiguienteVentana();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        mostrarMenuPrincipal();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void cmbTipoIdApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoIdApoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoIdApoderadoActionPerformed

    private void cmbCalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCalidadActionPerformed
        if (cmbCalidad.getSelectedIndex() == 9) {
            txtOtro.setEnabled(true);
        } else {
            txtOtro.setEnabled(false);
        }
    }//GEN-LAST:event_cmbCalidadActionPerformed

    private void rbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiActionPerformed
        if (rbSi.isSelected()) {
            setEnabledApoderado(true);
        } else {
            setEnabledApoderado(false);
        }
    }//GEN-LAST:event_rbSiActionPerformed

    private void rbSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSi1ActionPerformed
        if (rbSi1.isSelected()) {
            txtCosto.setEnabled(true);
            txtCostoLetras.setEnabled(true);
        } else {
            txtCosto.setEnabled(false);
            txtCostoLetras.setEnabled(false);
        }
    }//GEN-LAST:event_rbSi1ActionPerformed

    private void txtNumeroIdInteresadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdInteresadoKeyTyped
        if (txtNumeroIdInteresado.getText().length() > 15) {
            evt.consume();
        } else {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumeroIdInteresadoKeyTyped

    private void txtNumeroIdApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdApoderadoKeyTyped
        if (txtNumeroIdApoderado.getText().length() > 15) {
            evt.consume();
        } else {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumeroIdApoderadoKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        if (txtCosto.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtNombreInteresadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreInteresadoKeyTyped
        if (txtNombreInteresado.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNombreInteresadoKeyTyped

    private void txtNombreApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApoderadoKeyTyped
        if (txtNombreApoderado.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNombreApoderadoKeyTyped

    private void txtOtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroKeyTyped
        if (txtOtro.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtOtroKeyTyped

    private void txtCostoLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoLetrasKeyTyped
        if (txtCostoLetras.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCostoLetrasKeyTyped

    private void txtTPApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTPApoderadoKeyTyped
        if (txtTPApoderado.getText().length() > 10) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtTPApoderadoKeyTyped

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            this.setVisible(false);
            controlador.mostrarPrincipal();
        }
    }//GEN-LAST:event_btnPrincipalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbCalidad;
    private javax.swing.JComboBox<String> cmbTipoIdApoderado;
    private javax.swing.JComboBox<String> cmbTipoIdInteresado;
    private javax.swing.JComboBox<String> cmbTipoPersonaInteresado;
    private javax.swing.JComboBox<String> cmbTipoPredio;
    private javax.swing.JComboBox<String> cmbTipoSolicitud;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbSi;
    private javax.swing.JRadioButton rbSi1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtCostoLetras;
    private javax.swing.JTextField txtNombreApoderado;
    private javax.swing.JTextField txtNombreInteresado;
    private javax.swing.JTextField txtNumeroIdApoderado;
    private javax.swing.JTextField txtNumeroIdInteresado;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtTPApoderado;
    // End of variables declaration//GEN-END:variables
}
