
import java.io.*;
import java.util.*;

public class Planting1 {

    static ArrayList<Integer>[] edges;
    static ArrayList<Integer> allPlants = new ArrayList<>();
    static int[] plants;
    static int plantCount;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));


        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n+1];
        plants = new int[n+1];

        for(int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            if (edges[start] == null) {
                edges[start] = new ArrayList<>();
            }
            edges[start].add(end);

            if (edges[end] == null) {
                edges[end] = new ArrayList<>();
            }
            edges[end].add(start);
        }

        plantCount = 1;
        dfs(n/2, 0, new ArrayList<Integer>());


        pw.println(plantCount -1);
        pw.close();
    }

    static int dfs(int x, int parent, List<Integer> indirectP) {

        HashSet<Integer> availP = new HashSet<>();
        availP.addAll(allPlants);
        availP.removeAll(indirectP);
        availP.remove(Integer.valueOf(plants[parent]));
        if (availP.isEmpty()) {
            availP.add(plantCount);
            allPlants.add(plantCount);
            plantCount++;
        }
        Iterator<Integer> itr = availP.iterator();
        plants[x] = itr.next();
        itr.remove();

        ArrayList<Integer> newC = new ArrayList<>();
        newC.add(plants[parent]);

        for (int k : edges[x]) {
            if (k != parent) {
                int r = dfs(k, x, newC);
                newC.add(r);
            }
        }

        return plants[x];

    }

}

