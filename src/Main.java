import java.util.Scanner;

public class Main {

    private static int rows;
    private static int column;
    private static int x=0;

    private static int[][] MAT;

    public static void main(String[] args) {

        //input number of rows and number of column;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number of rows");
        rows = reader.nextInt();
        System.out.println("Enter number of column");
        column = reader.nextInt();
        MAT = Generator(rows, column);


        //1 is passable and 0 is not

        for (int c = 0; c < column; c++) {
            if (MAT[0][c] == 1) {
                CheckChild(0, c);
            }
        }
        System.out.println("--------------------");
        System.out.println(x + " holes down");

        // printing matrix after modification
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(MAT[i][j]);
            }
            System.out.println();
        }
    }
    private static void CheckChild(int r, int c) {
        if (c >= 0 && c < column) {     //checking for boundaries
            if (MAT[r][c] == 1) {       //checking if allowing water
                MAT[r][c] = 2;          // setting visited
                if (r != rows - 1) {
                    CheckChild(r, c - 1);
                    CheckChild(r + 1, c - 1);
                    CheckChild(r + 1, c);
                    CheckChild(r + 1, c + 1);
                    CheckChild(r, c + 1);
                } else {
                    x++;
                }
            }
        }
    }

    private static int[][] Generator(int rows, int column) {
        //Generating random matrix
        int[][] MAT = new int[rows][column];
        double rand;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                rand = Math.random();
                if (rand >= 0.5) {
                    MAT[i][j] = 1;
                } else {
                    MAT[i][j] = 0;
                }
                System.out.print(MAT[i][j]);
            }
            System.out.println();
        }
        return MAT;
    }
}
