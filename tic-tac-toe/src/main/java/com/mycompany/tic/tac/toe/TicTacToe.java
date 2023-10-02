/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tic.tac.toe;


/**
 *PLATAFORMAS ABIERTAS 1
 * tic tac toe
 * @author jade
 */
import java.util.Scanner;

public class TicTacToe {
    
     public static String greetPlayer(String playerName){
           return "Bienvenido " +playerName + "! Juguemos Tic-Tac-Toe!";
       }
     
     
     
    //instance of Game class by calling its constructor (new object)
   public static void main(String[] args) {
       
       Game game = new Game();
       
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String playerName = scan.nextLine();
        
        String greeting = greetPlayer(playerName); // Call the greetPlayer method
        System.out.println(greeting);
       //play method invoked
        game.play();
    }
}
    
