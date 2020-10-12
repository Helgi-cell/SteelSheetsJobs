/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steelworks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class SteelWorks {

    /**
     * Класс main запуска расчета разверток
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
      SwingUtilities.invokeLater(() -> {
        try{  
          MenuDemo menuDemo = new MenuDemo();}
          catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MenuDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
      });   
            }
                }
