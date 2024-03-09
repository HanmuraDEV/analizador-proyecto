/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package analizadorproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import analizadorproyecto.Tokens.*;
import java.awt.Color;
import java_cup.runtime.Symbol;


/**
 *
 * @author hanmura
 */
public class Window extends java.awt.Frame {

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
    }
    
private void analizarLexico() throws IOException {
    int cont = 1;

    String expr = (String) txtInsertar.getText();
    Lexer lexer = new Lexer(new StringReader(expr));
    String resultado = "LINEA " + cont + "\t\tTIPO\t\t\n";
    while (true) {
        Tokens token = lexer.yylex();
        if (token == null) {
            txtResultado.setText(resultado);
            return;
        }
        switch (token) {
            case Int:
                resultado += "  <Palabra reservada int>\t" + "Tipo: " + token + "\n";
                break;
            case Float:
                resultado += "  <Palabra reservada float>\t" + "Tipo: " + token + "\n";
                break;
            case String:
                resultado += "  <Palabra reservada String>\t" + "Tipo: " + token + "\n";
                break;
            case Boolean:
                resultado += "  <Palabra reservada Boolean>\t" + "Tipo: " + token + "\n";
                break;
            case Void:
                resultado += "  <Palabra reservada void>\t\t" + "Tipo: " + token +  "\n";
                break;
            case Public:
                resultado += "  <Palabra reservada public>\t" + "Tipo: " + token + "\n";
                break;
            case Private:
                resultado += "  <Palabra reservada private>\t" + "Tipo: " + token  + "\n";
                break;
            case For:
                resultado += "  <Palabra reservada for>\t\t" + "Tipo: " + token +  "\n";
                break;
            case While:
                resultado += "  <Palabra reservada while>\t" + "Tipo: " + token +  "\n";
                break;
            case Switch:
                resultado += "  <Palabra reservada switch>\t" + "Tipo: " + token +  "\n";
                break;
            case Do:
                resultado += "  <Palabra reservada do>\t" + "Tipo: " + token +  "\n";
                break;
            case Protected:
                resultado += "  <Palabra reservada protected>\t" + "Tipo: " + token + "\n";
                break;
            case If:
                resultado += "  <Palabra reservada if>\t" + "Tipo: " + token +  "\n";
                break;
            case Else:
                resultado += "  <Palabra reservada else>\t" + "Tipo: " + token + "\n";
                break;
            case Identificador:
                resultado += "  <Identificador>\t\t" + "Tipo: " + token + "\n";
                break;
            case ERROR:
                resultado += "  <Simbolo no definido>\t\t" + "Tipo: " + token + "\n";
                break;
            case Numero:
                resultado += "  <Numero>\t\t" + "Tipo: " + token +  "\n";
                break;
            case Op_aritmeticos:
                resultado += "  <Operador aritmetico>\t" + "Tipo: " + token +  "\n";
                break;
           
            case Parentesis_abierta:
                resultado += "  <Parentesis de apertura>\t" + "Tipo: " + token + "\n";
                break;
            case Parentesis_cerrada:
                resultado += "  <Parentesis de cierre>\t" + "Tipo: " + token + "\n";
                break;
            case LlaveAbierta:
                resultado += "  <Llave de apertura>\t" + "Tipo: " + token +  "\n";
                break;
            case LlaveCerrada:
                resultado += "  <Llave de cierre>\t" + "Tipo: " + token + "\n";
                break;
            case Coma:
                resultado += "  <Coma>\t\t" + "Tipo: " + token +  "\n";
                break;
            case Main:
                resultado += "  <Palabra reservada main>\t" + "Tipo: " + token +  "\n";
                break;
            case P_coma:
                resultado += "  <Punto y coma>\t" + "Tipo: " + token + "\n";
                break;
            default:
                resultado += "  < " + lexer.lexeme + " >\n";
                break;
        }
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        btnLexico = new javax.swing.JButton();
        btnAnalisisSintactico = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInsertar = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        btnArchivo.setText("Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnLexico.setText("Analisis Lexico");
        btnLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLexicoActionPerformed(evt);
            }
        });

        btnAnalisisSintactico.setText("Analisis Sintactico");
        btnAnalisisSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisSintacticoActionPerformed(evt);
            }
        });

        txtInsertar.setColumns(20);
        txtInsertar.setRows(5);
        jScrollPane1.setViewportView(txtInsertar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane2.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnAnalisisSintactico)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(btnAnalisisSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLexicoActionPerformed
        try {
            // TODO add your handling code here:
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLexicoActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
               JFileChooser chooser = new JFileChooser();
               chooser.showOpenDialog(null);
               File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

            try {
                String text = new String(Files.readAllBytes(archivo.toPath()));
                txtInsertar.setText(text);
        }   catch (FileNotFoundException ex) {
    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalisisSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisSintacticoActionPerformed
        // TODO add your handling code here:
        String text = txtInsertar.getText();
        Sintax s = new Sintax(new analizadorproyecto.LexerCup(new StringReader(text)));
        
        try {
            s.parse();
            txtResultado.setText("Analisis correcto");
            txtResultado.setForeground(new Color(25,11,61));
        } catch (Exception ex) {
           Symbol sym = s.getS();
           
           txtResultado.setText("No se pudo realizar el analisis. Linea: " + (sym.right + 1) + "Columna: " + (sym.left + 1)+ ",Texto: \""+ sym.value + "\"");
            txtResultado.setForeground(Color.RED);
            
        }
    }//GEN-LAST:event_btnAnalisisSintacticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisisSintactico;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLexico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInsertar;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
