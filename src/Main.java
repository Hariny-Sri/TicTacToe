import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static  char currentPlayer;
    private static  char[][] board;
    private static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the matrix number");
        num = sc.nextInt();
        board = new char[num][num];
        initializeMethod();

        currentPlayer = 'X';
        boolean winVar = false;
        int round = 0;


        while (round < num * num && !winVar) {
            printMethod();
            System.out.printf("Player %c, enter your move (row and columns)", currentPlayer);
            System.out.println();
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (isvalidMove(row, col)) {
                board[row][col] = currentPlayer;
                round++;
                if (checkwin(row, col)) {
                    winVar = true;
                    printMethod();
                    System.out.printf("The player %c won the match",currentPlayer);
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            }
            else {
                System.out.println("invalid input.Please enter a valid input ");

            }
        }
        if(winVar==false){
            printMethod();
            System.out.println("The match end as draw!!!");
        }

        sc.close();
    }



    private static void initializeMethod() {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printMethod() {
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isvalidMove(int row, int col) {
        return  row>=0&&row<num && col<num && col>=0 && board[row][col]=='-';
    }

    private static boolean checkwin(int row, int col) {
        return checkrow(row)||checkcol(col)||checkdaigonal();
    }

    private static boolean checkcol( int col) {
        for(int row=0;row<num;row++){
            if(board[row][col]!=currentPlayer){
                return false;
            }
        }
        return true;

    }

    private static boolean checkrow(int row) {
        for(int col=0;col<num;col++){
            if(board[row][col]!=currentPlayer){
                return false;
            }
        }
        return true;
    }

    private static boolean checkdaigonal() {
        boolean dai1=true,dai2=true;
        for(int i=0;i<num;i++){
            if(board[i][i]!=currentPlayer){
                dai1= false;
            }

            if(board[i][num-i-1]!=currentPlayer){
                dai2 =false;
            }

        }
        return dai1||dai2;
    }

}