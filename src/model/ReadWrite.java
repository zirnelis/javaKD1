/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elina
 */
public class ReadWrite {

    public static void saveCandidates( ArrayList<Candidate> cand, String user) throws IOException {
            PrintWriter pw = null;

            pw = new PrintWriter("Candidates.txt");
            
            BufferedWriter bw = new BufferedWriter(pw);
            
            for (int i = 0; i < cand.size(); i++) {
                bw.write(cand.get(i).getName() +"\n "
                        +cand.get(i).getAge()+"\n "
                        +cand.get(i).getComment());
                bw.newLine();
            }
            
            System.out.println("Candidates has been written"); 
            
            pw.close();
    }
    
    public static ArrayList<Candidate> readCandidates(String filename) {
        String name;
        int age;
        String comment;
        
        String fileContent = "";
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("Candidates.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                temp.add(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileContent = sb.toString();
        } catch (IOException ex) {
            System.out.print("File does not exist!");
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Nepilnigs
        for (int i = 0; i < temp.size(); i+=3) {
                name = temp.get(i);  
        }
        for (int i = 1; i < temp.size(); i+=3) {
                age = Integer.parseInt(temp.get(i));
        }
        for (int i = 2; i < temp.size(); i+=3) {
                comment = temp.get(i);
        }
        
        return candidates;
    }
    
    public static void writeLog(String msg) {
        String log;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        log = dateFormat.format(date);
        
        System.out.println(log + msg);
    }
}
