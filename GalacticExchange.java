import java.util.*;
import java.math.*;

public class GalacticExchange {

	static int n;
	static Planet[] planets;
	static Set<Integer>[] adj;
	static Map<Integer, Set<Integer>> reachable;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());

		planets = new Planet[n];
		for (int i = 0; i < n; i++) {
			String[] tmp = sc.nextLine().split(",");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int z = Integer.parseInt(tmp[2]);
			double r = Double.parseDouble(tmp[3]);
			planets[i] = new Planet(x, y, z, r, tmp[4]);
		}
		sc.close();

		adj = new Set[n];
		for (int i = 0; i < n; i++)
			adj[i] = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;

				double dist = dist(planets[i], planets[j]);
				if (planets[i].r >= dist)
					adj[i].add(j);
				if (planets[j].r >= dist)
					adj[j].add(i);
			}
		}

		reachable = new HashMap<>();
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			if (!visited[i]) {
				visited[i] = true;
				find(i);
			}

		Set<Integer> largest = new HashSet<>();
		for (Set<Integer> e : reachable.values())
			if (e.size() > largest.size())
				largest = e;

		String[] res = new String[largest.size()];
		int i = 0;
		for (int p : largest)
			res[i++] = planets[p].name;

		Arrays.sort(res);
		for (i = 0; i < res.length; i++) {
			if (i != 0) System.out.print(",");
			System.out.print(res[i]);
		}
		System.out.println();
	}

	static Set<Integer> find(int planet) {
		if (reachable.containsKey(planet))
			return reachable.get(planet);

		Set<Integer> able = new HashSet<>();
		able.add(planet);
		reachable.put(planet, able);
		for (int neighbor : adj[planet])
			able.addAll(find(neighbor));

		visited[planet] = true;
		return able;
	}

	static double dist(Planet u, Planet v) {
		int dx2 = (u.x - v.x) * (u.x - v.x);
		int dy2 = (u.y - v.y) * (u.y - v.y);
		int dz2 = (u.z - v.z) * (u.z - v.z);
		return Math.sqrt(dx2 + dy2 + dz2);
	}

	static class Planet {
		int x, y, z;
		double r;
		String name;

		Planet(int _x, int _y, int _z, double _r, String _name) {
			x = _x;
			y = _y;
			z = _z;
			r = _r;
			name = _name;
		}
	}

}
