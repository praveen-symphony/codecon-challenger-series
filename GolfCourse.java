import java.math.*;
import java.util.*;

public class GolfCourse {

    static final int[][] dirs = { {1, 2}, {2, 1},
        { -1, 2}, { -2, 1},
        {1, -2}, {2, -1},
        { -1, -2}, { -2, -1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<State> q = new ArrayDeque<State>();
        q.offer(new State(0, 0, 0));

        int total = 0;
        while (!q.isEmpty()) {
            State current = q.poll();
            if (current.x == 2 && current.y == 2 && current.n == N) {
                ++total;
                continue;
            }

            if (current.n < N) {
                for (int[] dir : dirs) {
                    if (valid(current.x + dir[0], current.y + dir[1])) {
                        q.offer(new State(current.x + dir[0], current.y + dir[1], current.n + 1));
                    }
                }
            }
        }

        System.out.println(total);
    }

    static boolean valid(int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return true;
        } else {
            return x == 1 && y == 3;
        }
    }

    static class State {
        int x, y, n;
        State(int _x, int _y, int _n) { x = _x; y = _y; n = _n; };
    }

}
