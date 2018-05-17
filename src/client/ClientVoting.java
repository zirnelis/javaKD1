/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;

/**
 *
 * @author Elina
 */
public class ClientVoting {
    private static ArrayList<User> users = new ArrayList<User>();
    
    public static void createUserList() {
        User user1 = new User("Elina", "123456789");
        User user2 = new User("Maija", "987654321");
        
        users.add(user1);
        users.add(user2);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    
    
}
