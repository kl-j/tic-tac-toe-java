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
         
         
         char[][] gameBoard = new char[3][3];
         System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
         //{{ },{|},{ }, {|}, { }};
         
         
     }
}
    
