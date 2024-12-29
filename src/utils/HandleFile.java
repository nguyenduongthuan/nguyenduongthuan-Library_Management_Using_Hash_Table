/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public interface HandleFile<T> {

    /**
     *
     * @param url
     * @param errorMsg
     * @return true if reading the file is successful, returns false if it fails
     */
    default boolean loadFromFile(String url, String errorMsg) {
         try (BufferedReader fileBufferReader = new BufferedReader(new FileReader(url))) {
            String fileLineContent;
            while ((fileLineContent = fileBufferReader.readLine()) != null) {
                handleLine(fileLineContent);
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
//         try {
//             FileInputStream inputStream = new FileInputStream(f);
//             Scanner sc = new Scanner(inputStream, "UTF-8");
//             while (sc.hasNextLine()) {
//                 String line = sc.nextLine();
//                 line = sc.nextLine();
//                 handleLine(line);
//             }
//             return true;
//         } 
         return true;
    }

    /**
     *
     * @param line
     * @@Override this method to be able to use loadFromFile
     */
    public void handleLine(String line);

    /**
     *
     * @param url
     * @param list
     * @param errorMsg
     * @return true if saving the file successfully, false if saving the file
     * fails
     */
    default boolean saveToFile(String url, ArrayList<T> list, String errorMsg) {
        File f = new File(url);
         try (OutputStreamWriter writter = new OutputStreamWriter(new FileOutputStream(f))) {
             for (T items : list) {
                 writter.write(items.toString());
                 writter.write("\n");
             }
             return true;
         } catch (Exception e) {
             System.err.println(errorMsg);
             return false;
         }
        
    }
}
