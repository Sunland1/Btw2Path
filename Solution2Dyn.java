import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {



    public static void afficheMatrice(int[][] matrice)
	{
		for(int i = 0 ; i < matrice.length ; i++)
		{
			for (int j = 0 ; j < matrice[i].length ; j++)
				System.err.format("%6d", matrice[i][j]);
			System.err.println();
		}
	}

    public static int[][] formatMatrix(int[][] matrix){

        matrix[0][0] = -1;
        for(int i = 1; i < matrix.length; i++) {

            if(matrix[i][0] == 0 && matrix[i - 1][0] != 0) {
                matrix[i][0] = -1;
            }
            else if(matrix[i][0] == 1) {
                matrix[i][0] = 0;
            }
        }
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0 && matrix[0][j - 1] != 0) {
              matrix[0][j] = -1;
            }
            else if(matrix[0][j] == 1) {
              matrix[0][j] = 0;
            }
        }

        return matrix ; 
    }


    public static int nbOfPaths(int[][] matrix) {
        //Phase de calcule des chemins possible avec matrix[M][N] = matrix[M][N-1] + matrix[M-1][N]
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
                else if(matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }


        //Declaration du de la Matrice de travaille
        int[][] matrix = new int[M][N];
        

        //Initialisation de la Matrice de travaille et conversion de la chaine de caractère en int 
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
            for(int j = 0; j < N; j++) {
              matrix[i][j] = Integer.parseInt(String.valueOf(ROW.charAt(j)));  
            }
        }

        //Formatage de la Matrice de travaille
        matrix = formatMatrix(matrix) ; 

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...")
        System.out.println(nbOfPaths(matrix));
    }
}