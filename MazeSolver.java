import java.util.*;
import java.math.*;

public class MazeSolver {

    static final int[][] dirs = {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
    
    static int R, C;
    static char[][] maze;
    static ArrayDeque<State> path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        maze = new char[R][C];
        path = new ArrayDeque<State>();
        for (int i = 0; i < R; i++) {
            maze[i] = sc.nextLine().toCharArray();
        }

        backtrack(1, 0);

        while (!path.isEmpty()) {
            State loc = path.pollFirst();
            System.out.println(loc.y + "," + loc.x);
        }
    }

    static boolean backtrack(int y, int x) {

        if (valid(y, x)) {
            path.offerLast(new State(y, x));
            maze[y][x] = 'X';
        }

        if (y == R - 2 && x == C - 1) return true;

        for (int[] dir : dirs) {
            if (valid(y + dir[0], x + dir[1])) {
                if (backtrack(y + dir[0], x + dir[1])) {
                    return true;
                } else {
                    path.pollLast();
                }
            }
        }

        return false;
    }

    static boolean valid(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C && maze[y][x] == '_';
    }

    static class State {
        int y, x;
        State(int a, int b) { y = a; x = b; }
    }

}