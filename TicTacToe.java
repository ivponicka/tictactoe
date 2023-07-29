import java.util.Scanner;

public class TicTacToe{

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to TIC TAC TOE game!");
        char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };

        showBoard(board);

        for(int i = 0; i < 9;  i++){
            if(i % 2 == 0) {
                System.out.print("Turn X: ");
               int[] spot = playerChoice(board);
               board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.print("Turn Y: ");
                int[] spot = playerChoice(board);
                 board[spot[0]][spot[1]] = 'Y';
            }
            showBoard(board);
            int count = checkingWinner(board);
               if (count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins!");
                break;
            }

        }
         
    
     
        

    }

    public static void showBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[i].length; j++){
                    System.out.print(board[i][j] + " ");
                   
           }
            System.out.print('\n');
        }
    }


    public static int[] playerChoice(char[][] board){
        System.out.print("Choose the position (row and column): ");
        int row = input.nextInt();
        int column = input.nextInt();
        if(board[row][column] == 'X' || board[row][column] == 'Y'){
            System.out.println("Ups! This spot is already taken! Choose another one: ");
             row = input.nextInt();
             column = input.nextInt();
        }
        return new int[] {row, column};
    }


    public static int checkingWinner(char[][] board) {    
    int rows = checkRows(board); 
    
    
    if (Math.abs(rows) == 3) 
    return rows; 
    
    int columns = checkColumns(board);
    if (Math.abs(columns) == 3) 
    return columns;  
    
    int leftDiagonal = checkLeft(board);
    if (Math.abs(leftDiagonal) == 3) 
    return leftDiagonal; 
    
    int rightDiagonal = checkRight(board);
    if (Math.abs(rightDiagonal) == 3) 
    return rightDiagonal;

    return -1;
    
}


public static int checkRows(char[][] board) {
    int count = 0;
    for(int i = 0; i < board.length; i++ ){
        for(int j = 0; j < board[i].length; j++){
            if(board[i][j] == 'X'){
                count++;
            } else if (board[i][j] == 'O'){
                count--;
            }
        }
        if(count == 3 || count == -3){
            return count;
        } else {
            count = 0;
        }
    }
    return count;
}

public static int checkColumns(char[][] board) {
    int count = 0;
      for(int i = 0; i < board.length; i++ ){
        for(int j = 0; j < board[i].length; j++){
            if(board[j][i] == 'X'){
                count++;
            } else if (board[j][i] == 'O'){
                count--;
            }
        }
        if(count == 3 || count == -3){
            return count;
        } else {
            count = 0;
        }
    }
    return count;
}


public static int checkLeft(char[][] board) {
    int count = 0;
    for(int i = 0; i < board.length; i++){
        if(board[i][i] == 'X'){
            count++;
        } else if(board[i][i] == 'O'){
            count--;
        }
    }
    return count;
}


public static int checkRight(char[][] board) {
    int count = 0;
     for(int i = 0; i < board.length; i++){
        if(board[2-i][i] == 'X'){
            count++;
        } else if(board[2-i][i] == 'O'){
            count--;
        }
    }
    return count;
}

}