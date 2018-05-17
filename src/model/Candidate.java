/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javasem04.activity.Person;

/**
 *
 * @author Elina
 */
public abstract class Candidate extends Person{

    private static int no ;
    private int votes = 0;
    
    public Candidate(String name, int age, String comment) {
        super(name, age, comment);
        no++;
    }

    public static int getNo() {
        return no;
    }

    public int getVotes() {
        return votes;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public String getComment() {
        return comment;
    }
    
    

    public static void setNo(int no) {
        if(no > 0) {
            Candidate.no = no;
        }
    }

    public void setVotes(int votes) {
        if(votes > 0) {
            this.votes = votes;
        }
    }
    
    
    
    
    
}
