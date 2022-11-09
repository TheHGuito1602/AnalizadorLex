/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compiladoresproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo Prieto Velázquez.
 */
public class CompiladoresProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CompiladoresProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CompiladoresProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CompiladoresProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CompiladoresProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        Interfaz i = new Interfaz();
        i.setVisible(true);
        String ruta = "C:/Users/eljug/OneDrive/Documentos/NetBeansProjects/compiladoresProyecto/src/compiladoresproyecto/Lexer.flex";
        generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
    public DefaultTableModel listaLexema(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("TOKEN");
        cabeceras.addElement("COMPONENTE LEXICO");
        cabeceras.addElement("LEXEMA_1");
        cabeceras.addElement("LEXEMA_2");
        
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras,0);
           
        try{
            FileReader FR = new FileReader("Palabras.txt");
            BufferedReader BR = new BufferedReader(FR);
            String d;
            while((d=BR.readLine()) != null){
                
                StringTokenizer dato = new StringTokenizer(d,"★");
                Vector x = new Vector();
                while(dato.hasMoreElements()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return mdlTabla;
    }
    
    /*
    public
    public
    */
}
