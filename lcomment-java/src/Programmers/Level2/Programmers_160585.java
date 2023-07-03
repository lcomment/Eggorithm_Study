package Programmers.Level2;

public class Programmers_160585 {
    char[][] cBoard = new char[3][3];

    public int solution(String[] board) {
        int x = 0, o = 0;

        for (int i = 0; i < 3; i++) {
            cBoard[i] = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (cBoard[i][j] == 'O') {
                    o++;
                } else if (cBoard[i][j] == 'X') {
                    x++;
                }
            }
        }

        if (x > o || o - x > 1) {return 0;}

        int winO = winCount('O'), winX = winCount('X');
        if (winO > 0 && winX > 0) {return 0;}
        if (winO > 0 && o == x) {return 0;}
        if (winX > 0 && o > x) {return 0;}

        return 1;
    }

    public int winCount(char c) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (c == cBoard[i][0] && cBoard[i][0] == cBoard[i][1] && cBoard[i][1] == cBoard[i][2]) {count++;}
            if (c == cBoard[0][i] && cBoard[0][i] == cBoard[1][i] && cBoard[1][i] == cBoard[2][i]) {count++;}
        }

        if (c == cBoard[0][0] && cBoard[0][0] == cBoard[1][1] && cBoard[1][1] == cBoard[2][2]) {count++;}
        if (c == cBoard[0][2] && cBoard[0][2] == cBoard[1][1] && cBoard[1][1] == cBoard[2][0]) {count++;}

        return count;
    }
}
