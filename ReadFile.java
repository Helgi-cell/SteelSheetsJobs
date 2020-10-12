/*
Класс для считывания данных файла help.dat, содержащего
текстовую информацию для помощи.
 */
package steelworks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *Чтение файла Help.data
 * @author User
 */

 public class ReadFile {

    public String readfile() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String string = "";
        BufferedReader str;
        String line ;
            str = new BufferedReader (new InputStreamReader (new FileInputStream ("help.dat"), "UTF-8" ));
         while ((line = str.readLine())!=null) 
            string += line + "\n\r";    
                return string;
    
    }
     
}
