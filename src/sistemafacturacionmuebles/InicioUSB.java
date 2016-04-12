/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemafacturacionmuebles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class InicioUSB {

    /**
     * @param args the command line arguments
     */
    public static String leerUSB(String Puerto){
        try {  
            String s="";
           Process p = Runtime.getRuntime().exec("cmd /C vol "+Puerto+":");  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) { 
                s=line;//Al final leera la ultima linea
            }  
            p.destroy();
            if(s!=""){
                return s;
            }
            
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    return "";
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String codigo="";
        
        codigo=leerUSB("F");
        if(!codigo.equals("")){
            codigo=codigo.substring(36);
        } else{
            codigo=leerUSB("I");
            if(!codigo.equals("")){
                codigo=codigo.substring(36);
            } else{
                codigo=leerUSB("E");
                if(!codigo.equals("")){
                    codigo=codigo.substring(36);
                } else{
                    codigo=leerUSB("H");
                    if(!codigo.equals("")){
                        codigo=codigo.substring(36);
                    } else {
                        codigo=leerUSB("G");
                        if(!codigo.equals("")){
                            codigo=codigo.substring(36);
                        }
                    }
                }
            }
        }
        if(codigo.equals("8218-BE34")){
            Login l = new Login();
            l.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se inserto correctamente la usb");
            MsgUSB m = new MsgUSB();
            m.setVisible(true);
        }
        
    }
    
}
