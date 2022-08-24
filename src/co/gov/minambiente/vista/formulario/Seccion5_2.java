package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 * Sección 5.2
 * @author Natalia García
 */
public class Seccion5_2 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;

    public Seccion5_2(ControladorSolicitud controlador) {
        initComponents();
        this.setTitle("Sección 5.2");
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
        setEnabledSection1(false);
        setEnabledSection3(false);
        setEnabledSection4(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarMenuPrincipal();
            }
        });
    }
    
    public void mostrarMenuPrincipal(){
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if(opcion == 0){
            this.setVisible(false);
            controlador.mostrarPrincipal();
        } 
    }

    private void setEnabledSection1(boolean state) {
        cmbEstado.setEnabled(state);
        txtOtro.setEnabled(state);
    }

    private void setEnabledSection3(boolean state) {
        cmbTipo3.setEnabled(state);
        cmbEstadoI.setEnabled(state);
        cmbCausa.setEnabled(state);
        txtOtro1.setEnabled(state);
    }

    private void setEnabledSection4(boolean state) {
        cmbTipo.setEnabled(state);
        cmbActividad.setEnabled(state);
        txtSimilar.setEnabled(state);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSiguiente2 = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbCausa = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmb1 = new javax.swing.JRadioButton();
        cmb2 = new javax.swing.JRadioButton();
        cmb4 = new javax.swing.JRadioButton();
        cmb3 = new javax.swing.JRadioButton();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtSimilar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbActividad = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmbEstadoI = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtOtro = new javax.swing.JTextField();
        cmbTipo3 = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtOtro1 = new javax.swing.JTextField();
        btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("    flora silvestre y los productos forestales no maderables");

        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguiente2MouseClicked(evt);
            }
        });
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Similar:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("5. Información sobre el aprovechamiento forestal o manejo sostenible de la");

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setText("5.2. Información asociada a la solicitud de aprovechamiento de árboles aislados (Si aplica):");

        cmbCausa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Estabilidad de suelos", "Canal de agua", "Obras de infraestructura", "Otro" }));
        cmbCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCausaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Tipo:");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Actividad dentro de obras de infraestructura:");

        buttonGroup1.add(cmb1);
        cmb1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cmb1.setText("i. Árboles aislados dentro de la cobertura del bosque natural ");
        cmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cmb2);
        cmb2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cmb2.setText("ii. Árboles aislados fuera de la cobertura del bosque natural");
        cmb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cmb4);
        cmb4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cmb4.setText("iv. Obra pública o privada en centros urbanos");
        cmb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cmb3);
        cmb3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cmb3.setText("iii. Tala o poda de emergencia en centros urbanos");
        cmb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb3ActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Caído por Causas Naturales", "Muerto por Causas Naturales", "Razones de Orden Fitosanitario", "Otro" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Causa o Perjuicio:");

        txtSimilar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSimilarKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Estado del individuo:");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Tipo:");

        cmbActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Construcción/Realización", "Remodelación", "Ampliación", "Instalación", "Similar" }));
        cmbActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActividadActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Estado del individuo:");

        cmbEstadoI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Caído", "Muerto", "Enfermo" }));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Otro:");

        txtOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtroKeyTyped(evt);
            }
        });

        cmbTipo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Tala", "Poda" }));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Tala", "Transplante/Reubicación" }));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Otro:");

        txtOtro1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtro1KeyTyped(evt);
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
                .addGap(40, 40, 40)
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente2)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cmb2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cmb3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstadoI, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOtro1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cmb4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSimilar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addGap(9, 9, 9)
                .addComponent(cmb1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)))
                .addGap(18, 18, 18)
                .addComponent(cmb2)
                .addGap(11, 11, 11)
                .addComponent(cmb3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(cmbTipo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbEstadoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtOtro1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cmb4)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtSimilar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente2)
                    .addComponent(btnPrincipal))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguiente2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguiente2MouseClicked
        this.setVisible(false);
        try {
            new Seccion6(controlador).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Seccion5_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSiguiente2MouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        this.setVisible(false);
        new Seccion5_1(controlador).setVisible(true);
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void cmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb1ActionPerformed
        setEnabledSection1(true);
        setEnabledSection3(false);
        setEnabledSection4(false);
    }//GEN-LAST:event_cmb1ActionPerformed

    private void cmb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb2ActionPerformed
        setEnabledSection1(false);
        setEnabledSection3(false);
        setEnabledSection4(false);
    }//GEN-LAST:event_cmb2ActionPerformed

    private void cmb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb4ActionPerformed
        setEnabledSection1(false);
        setEnabledSection3(false);
        setEnabledSection4(true);
    }//GEN-LAST:event_cmb4ActionPerformed

    private void cmb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb3ActionPerformed
        setEnabledSection1(false);
        setEnabledSection3(true);
        setEnabledSection4(false);
    }//GEN-LAST:event_cmb3ActionPerformed

    private void txtOtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroKeyTyped
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtOtroKeyTyped

    private void txtOtro1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtro1KeyTyped
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtOtro1KeyTyped

    private void txtSimilarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSimilarKeyTyped
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSimilarKeyTyped

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        if (cmbEstado.getSelectedIndex() == 4) {
            txtOtro.setEnabled(true);
        } else {
            txtOtro.setEnabled(false);
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        String estado = (String) cmbEstado.getSelectedItem();
        String otro = txtOtro.getText();
        String tipo = (String) cmbTipo.getSelectedItem();
        String otro1 =  txtOtro1.getText();
         String similar =  txtSimilar.getText();
        String texto = "Árboles aislados fuera de la cobertura del bosque natural";
        String tipoA = (String) cmbTipo3.getSelectedItem();
        String causa = (String) cmbCausa.getSelectedItem();
        String estadoIndividual = (String) cmbEstadoI.getSelectedItem();
        String actividad = (String) cmbActividad.getSelectedItem();
        LinkedList<String> categorias = new LinkedList<>();
        if (cmb1.isSelected()) {
            categorias.add("A");
            if (!estado.equals("Seleccione")) {
                controlador.guardarInformacionSeccion5_2(estado, categorias, tipo, texto, tipoA, causa, estadoIndividual, actividad,otro,otro1,similar);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            }
        }
        if (cmb2.isSelected()) {
            categorias.add("B");
            controlador.guardarInformacionSeccion5_2(estado, categorias, tipo, texto, tipoA, causa, estadoIndividual, actividad,otro,otro1,similar);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
        }
        if (cmb3.isSelected()) {
            categorias.add("C");
            if (!tipoA.equals("Seleccione") && (!estadoIndividual.equals("Seleccione")) && (!causa.equals("Seleccione"))) {
                 controlador.guardarInformacionSeccion5_2(estado, categorias, tipo, texto, tipoA, causa, estadoIndividual, actividad,otro,otro1,similar);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            }
        }
        if (cmb4.isSelected()) {
            categorias.add("D");
            if (!tipo.equals("Seleccione") && (!actividad.equals("Seleccione"))) {
                controlador.guardarInformacionSeccion5_2(estado, categorias, tipo, texto, tipoA, causa, estadoIndividual, actividad,otro,otro1,similar);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            }
            if (!cmb1.isSelected() && !cmb2.isSelected() && !cmb3.isSelected() && !cmb4.isSelected()) {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            }
        }
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void cmbCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCausaActionPerformed
        if (cmbCausa.getSelectedIndex() == 9) {
            txtOtro1.setEnabled(true);
        } else {
            txtOtro1.setEnabled(false);
        }
    }//GEN-LAST:event_cmbCausaActionPerformed

    private void cmbActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActividadActionPerformed
        if (cmbActividad.getSelectedIndex() == 9) {
            txtSimilar.setEnabled(true);
        } else {
            txtOtro1.setEnabled(false);
        }

    }//GEN-LAST:event_cmbActividadActionPerformed

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        mostrarMenuPrincipal();
    }//GEN-LAST:event_btnPrincipalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrincipal;
    public javax.swing.JButton btnSiguiente2;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JRadioButton cmb1;
    public javax.swing.JRadioButton cmb2;
    public javax.swing.JRadioButton cmb3;
    public javax.swing.JRadioButton cmb4;
    public javax.swing.JComboBox<String> cmbActividad;
    public javax.swing.JComboBox<String> cmbCausa;
    public javax.swing.JComboBox<String> cmbEstado;
    public javax.swing.JComboBox<String> cmbEstadoI;
    public javax.swing.JComboBox<String> cmbTipo;
    public javax.swing.JComboBox<String> cmbTipo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField txtOtro;
    public javax.swing.JTextField txtOtro1;
    public javax.swing.JTextField txtSimilar;
    // End of variables declaration//GEN-END:variables
}
