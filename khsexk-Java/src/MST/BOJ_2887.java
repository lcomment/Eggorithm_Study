package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_2887 {
	static class Planet {
		int idx;
		int x;
		int y;
		int z;
		
		Planet(int idx, int x, int y, int z){
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int[] parents;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Planet> planetList = new ArrayList<>();
		ArrayList<int[]> ternels = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			planetList.add(new Planet(i, input[0], input[1], input[2]));
		}
		
		Collections.sort(planetList, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int[] ternel = {planetList.get(i).idx, planetList.get(i+1).idx, Math.abs(planetList.get(i).x - planetList.get(i+1).x)};
			
			ternels.add(ternel);
		}

		Collections.sort(planetList, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int[] ternel = {planetList.get(i).idx, planetList.get(i+1).idx, Math.abs(planetList.get(i).y - planetList.get(i+1).y)};
			
			ternels.add(ternel);
		}

		Collections.sort(planetList, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int[] ternel = {planetList.get(i).idx, planetList.get(i+1).idx, Math.abs(planetList.get(i).z - planetList.get(i+1).z)};
			
			ternels.add(ternel);
		}
		
		/* 2중 for문이 부하가 훨씬 크고, 메모리를 많이 사용함 
		for(int i=0 ; i<N ; i++) {
			for(int j=i+1 ; j<N ; j++) {
				int[] ternel = new int[3];
				
				ternel[0] = i;
				ternel[1] = j;
				
				
				
				ternel[2] = Math.min(
						Math.min(Math.abs(planetList.get(i).x - planetList.get(j).x), 
								Math.abs(planetList.get(i).y - planetList.get(j).y)), 
						Math.abs(planetList.get(i).z - planetList.get(j).z)
				);
				ternels.add(ternel);
			}
		}
		*/
		parents = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			parents[i] = i;
		}
		
		kruskal(ternels);
		
	}
	
	static void kruskal(ArrayList<int[]> edges) {
		int cost = 0;
		
		Collections.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[2] - e2[2];
			}
		});

		for(int i=0 ; i<edges.size(); i++) {
			if(find(edges.get(i)[0]) != find(edges.get(i)[1])) {
				cost += edges.get(i)[2];
                union(edges.get(i)[0], edges.get(i)[1]);
			}
		}
		
		System.out.println(cost);
	}
	
    static int find(int i) {
        if (parents[i] == i)
            return i;
        return find(parents[i]);
    }

    static void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);

        if (a_parent < b_parent)
            parents[b_parent] = a_parent;
        else
            parents[a_parent] = b_parent;
    }
}
