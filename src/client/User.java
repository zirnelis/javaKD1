/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elina
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isValid(String password) {
        return password.length() > 8;
    }
    
    public void writeNewUser(User usr) throws IOException {
        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter("users.txt");
            
            BufferedWriter bw = new BufferedWriter(pw);
            bw.write(usr.getUsername());
//            bw.write("Name");
            System.out.println("Name has been written");
            bw.newLine();
            bw.write(usr.getPassword());
//            bw.write("Pass");
            System.out.println("Password has been written");

            pw.close();
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
