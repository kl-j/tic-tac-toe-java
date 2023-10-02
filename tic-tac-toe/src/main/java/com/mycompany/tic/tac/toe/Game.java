/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tic.tac.toe;

/**
 *tictactoe game implementation
 * @author JNSJ, SSDV
 */


 import java.util.Random;
 import java.util.Scanner;
 import java.util.Arrays;
 import java.util.ArrayList;
 import java.util.List;
 
 public class Game {
     
     private ArrayList<Integer> playerPositions;
     private ArrayList<Integer> cpuPositions;
     
     
     //CONSTRUCTOR
     public Game(){
         
         playerPositions = new ArrayList<>();
         cpuPositions = new ArrayList<>();
     }
     
     /**
     * Starts and manages the game loop.
     * No parameters
     * returns void
     */
    public void play() {     
     char[][] gameBoard = {{' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '}};
     printGameBoard(gameBoard);
     
 
      while(true){
               
         //read player's move
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
         
    
     /**
     * Prints the game board to the console.
     *
     * @param gameBoard (char array) The game board to be printed.
     * returns void
     */
     public static void printGameBoard(char[][] gameBoard) {
         for(char[] row : gameBoard) {
             for(char c : row) {
                 System.out.print(c);
             }
             System.out.println();
         }
     
      }
     
     /**
     * Places a player's or CPU's piece on the game board.
     *
     * @param gameBoard The game board.
     * @param pos       The position where the piece is to be placed (1-9).
     * @param user      The user (player or cpu).
     */
     
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
     
     
      /**
     * Checks if a player or the CPU has won or if it's a draw.
     *No parameter
     * @return The result message indicating the game outcome.
     */
     
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
     
 