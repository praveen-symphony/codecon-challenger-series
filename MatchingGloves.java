import java.util.*;
import java.math.*;

public class MatchingGloves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> gloves = new HashMap<String, Integer>();
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String normal = sc.next();
            String reverse = new StringBuilder(normal).reverse().toString();

            if (normal.equals(reverse)) continue;

            if (gloves.containsKey(reverse)) {
                ++count;
                gloves.put(reverse, gloves.get(reverse) - 1);
                if (gloves.get(reverse) == 0) gloves.remove(reverse);
            } else {
                gloves.put(normal, gloves.containsKey(normal) ? gloves.get(normal) + 1 : 1);
            }
        }
        
        System.out.println(gloves.size() == 0 ? count : -1);
    }
}
