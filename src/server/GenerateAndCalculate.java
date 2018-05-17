/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.Random;
import javasem04.activity.PersonList;
import model.Candidate;

/**
 *
 * @author Elina
 */
public class GenerateAndCalculate {

    static PersonList list = new PersonList();
    static ArrayList<Candidate> candidates = new ArrayList();
    Random rand = new Random();
    static Candidate tmp;
    int randomAge;
    
    public GenerateAndCalculate() {
    }
    
    public void generateCandidates() {
        
        for(int i = 0; i < list.getList().size() i++) {
            randomAge = rand.nextInt(88)+18;
            tmp = new Candidate(list.getList().get(i).getName(), randomAge, "");
            candidates.add(tmp);
        }
    }
    
    public static void calculateResults() {
        /*...*/
    }
}
