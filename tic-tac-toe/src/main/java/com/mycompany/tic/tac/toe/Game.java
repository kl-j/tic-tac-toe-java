/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tic.tac.toe;

/**
 *
 * @author Jade
 */
//USED UTILITIES
 import java.util.Random;
 import java.util.Scanner;
 import java.util.Arrays;
 import java.util.ArrayList;
 import java.util.List;
 
 public class Game {
     
     private ArrayList<Integer> playerPositions = new ArrayList<Integer>();
     private ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
     
    public void play() {     
     char[][] gameBoard = {{' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '}};
     printGameBoard(gameBoard);
     
 
      while(true){
               
         //read move
         Scanner scan = new Scanner(System.in);
         System.out.println("Introduce la casilla que quieres jugar (1-9)");
         int playerPos = scan.nextInt();
         while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){ 
             System.out.println("Posición ocupada. Escoge otra");
             playerPos = scan.nextInt();
             
         }
        
         placePiece(gameBoard, playerPos, "player");
         String result = checkWinner();
         if(result.length() > 0){
             System.out.println(result);
             break;
         }
             
         
         //CPU's turn
         Random rand = new Random();
         int cpuPos = rand.nextInt(9)+1;
         while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){ //check if its cpuPos or 
             cpuPos = rand.nextInt(9)+1;
         }
             
         placePiece(gameBoard, cpuPos, "cpu"); 
         
         printGameBoard(gameBoard);
         result = checkWinner();
         if(result.length() > 0){
             System.out.println(result);
             break;
         }
        }
    }
         
     public static void printGameBoard(char[][] gameBoard) {
         for(char[] row:gameBoard) {
             for(char c: row) {
                 System.out.print(c);
             }
             System.out.println();
         }
     
      }
     public void placePiece(char[][] gameBoard, int pos, String user){
         char symbol = ' ';
         
         if(user.equals("player")){
             symbol = 'x';
             playerPositions.add(pos);
         } else if(user.equals("cpu")){
             symbol = 'o';
             cpuPositions.add(pos);
         }
         
         switch(pos) {
          case 1:
              gameBoard[0][0] = symbol;
              break;
          case 2:
              gameBoard[0][2] = symbol;
              break;
          case 3:
              gameBoard[0][4] = symbol;
              break;
          case 4:
              gameBoard[2][0] = symbol;
              break;
          case 5:
              gameBoard[2][2] = symbol;
              break;
          case 6:
              gameBoard[2][4] = symbol;
              break;
          case 7:
              gameBoard[4][0] = symbol;
              break;
          case 8:
              gameBoard[4][2] = symbol;
              break;
          case 9:
              gameBoard[4][4] = symbol;
              break;
          default:
              break;
      }
     }
     public String checkWinner(){
         
         List topRow = Arrays.asList(1,2,3);
         List midRow = Arrays.asList(4,5,6);
         List botRow = Arrays.asList(7,8,9);
         
         List leftCol = Arrays.asList(2,5,8);
         List midCol = Arrays.asList(2,5,8);
         List rightCol = Arrays.asList(3,6,9);
         
         List cross1 = Arrays.asList(1,5,9);
         List cross2 = Arrays.asList(7,5,3);
         
         List<List> winning = new ArrayList<List>();
         winning.add(topRow);
         winning.add(midRow);
         winning.add(botRow);

         winning.add(leftCol);
         winning.add(midCol);
         winning.add(rightCol);
         
         winning.add(cross1);
         winning.add(cross2);
         winning.add(topRow);
         
         for(List l: winning){
             if(playerPositions.containsAll(l)){
                 return "Felicidades, ganaste!";
             }else if(cpuPositions.containsAll(l)){
                 return "Perdiste :c";
             }else if(playerPositions.size()+ cpuPositions.size() == 9){
                 return "EMPATE";
             }
         }
         return "";
     }
 }
     
 