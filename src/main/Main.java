/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import client.ClientVoting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;

import model.Candidate;


/**
 *
 * @author Elina
 */
public class Main extends JDialog {

    static ClientVoting clientVote = new ClientVoting();
    static ArrayList<Candidate> candidates = new ArrayList<>();
    
    static Candidate candidate1 = new Candidate("Caune Vairis", 65, null) ;
    static Candidate candidate2 = new Candidate("Korats Guntars", 35, null) ;
    static Candidate candidate3 = new Candidate("Bambis Raivo", 27, null) ;
    
    
    public static void main(String args[]) throws FileNotFoundException, IOException {
       
        clientVote.createUserList();
        candidates.add(candidate1);
        candidates.add(candidate2);
        candidates.add(candidate3);
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter user name : ");
        String username = null;
        try {
          username = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.print("Please enter password : ");
        String password = null;
        try {
          password = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        boolean isValid = false;
        for (int i = 0; i < clientVote.getUsers().size(); i++) {
            if(username == clientVote.getUsers().get(i).getUsername()) {
                System.out.println("You have succesfully logged in!");
                isValid = true;
            } 
        }
        String decision;
        int end = candidates.size();
        if(isValid) {
            System.out.println("Voting started. Please add 'YES' or 'NO' for each candidate");
            while(end!=0){
                for (int i = 0; i < candidates.size(); i++) {
                    System.out.println("Would you like to vote for: " + candidates.get(i).getName() +" "+candidates.get(i).getAge());
                    try {
                        decision = reader.readLine();
                        System.out.println(decision);
                        if(decision=="YES"){
                            int tmp = candidates.get(i).getVotes() + 1;
                            candidates.get(i).setVotes(tmp);
                        } if (decision=="NO") {
                        
                        } else {
                            System.out.println("Vote again!");
                        } 
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
            }
        }
        
        Candidate winner = new Candidate("temp", 0, "");
        PrintWriter pw = null;

        for (int i = 0; i < candidates.size(); i++) {
            for (int j = 0; j < 10; j++) {
                if(candidates.get(i).getVotes() > candidates.get(j).getVotes()) {
                    winner = candidates.get(i);
                }
            }
        }
            
        pw = new PrintWriter("candidates_"+winner.getName()+".txt");    
            
        BufferedWriter bw = new BufferedWriter(pw);
            
        bw.newLine();
            
        System.out.println("Winner has been written"); 
            
        pw.close();
        
    }         

   

}
