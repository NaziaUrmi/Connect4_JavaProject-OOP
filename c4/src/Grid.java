/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sssn
 */
public class Grid {

    private int xsize;
    private int ysize;
    private int[][] matrix;
    private int cells_left = 0;

    public Grid() {
        xsize = 6;
        ysize = 5;

        matrix = new int[xsize][ysize];
        /*for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                matrix[i][j] = 0;
                //cells_left++;
            }
        }*/
    }
    //methods to gain access to internal private data

    public int get_cells_left() {
        return cells_left;
    }

    public int[][] get_matrix() {
        return matrix;
    }

    public boolean matrix_equals(int a, int b, int c) {
        return matrix [a][b] == c;
    }

    public void set_matrix(int a, int b, int temp_player) {
        matrix[a][b] = temp_player;
    }

    public int get_xsize() {//returns the xsize
        return xsize;
    }

    public int get_ysize() {
        return ysize;
    }

    public int find_y(int x) {// collumn CHECK KORA
        int y = -1;
        for (int i = 0; i < ysize; i++) {
            if (matrix[x][i] == 0) {
                y = i;
            }
        }
        return y;
    }

    public int changeplayer(int player, int max_players) {
        player++;
        if (player > max_players) {
            return 1;
        }
        return player;
    }
}
