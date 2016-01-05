import java.util.*;

public class Problem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> count = new HashMap<String, Integer>();

        while (sc.hasNextLine()) {
            String article = sc.nextLine();
            if (count.containsKey(article)) {
                count.put(article, count.get(article) + 1);
            } else {
                count.put(article, 1);
            }
        }

        List<String> articles = new ArrayList<String>();
        for (String s : count.keySet()) articles.add(s);
        Collections.sort(articles, String.CASE_INSENSITIVE_ORDER);

        for (String s : articles) {
            if (s.contains("sock")) {
                if (count.get(s) > 1) System.out.printf("%d|%s\n", count.get(s) / 2, s);
                if (count.get(s) % 2 == 1) System.out.printf("%d|%s\n", 0, s);
            } else {
                System.out.printf("%d|%s\n", count.get(s), s);
            }
        }
    }
}