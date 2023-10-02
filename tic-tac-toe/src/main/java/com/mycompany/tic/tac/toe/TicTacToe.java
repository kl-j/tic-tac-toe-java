/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tic.tac.toe;

/**
 *PLATAFORMAS ABIERTAS 1
 * tic tac toe
 * @author jade
 */


public class TicTacToe {
    
  
    
     public static void main(String[] args) {
         
           
    char[][] gameBoard = {{' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '}};
    printGameBoard(gameBoard);
     }
     
     Scanner scan = new Scanner(System.in);
     System.out.println("Introduce la casilla que quieres jugar (1-9)");
     int pos = scan.nextInt();
     
        
     
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row:gameBoard) {
            for(char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }
    
     }
}
    
