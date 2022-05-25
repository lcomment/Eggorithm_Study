package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_7568  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Person> people = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			String[] input = br.readLine().split(" ");
			people.add(new Person(Integer.parseInt(input[1]), Integer.parseInt(input[0])));
		}
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(i!=j) {
					int result_tall = people.get(i).tall - people.get(j).tall;
					int result_weight = people.get(i).weight - people.get(j).weight;
					
					if(result_tall < 0 && result_weight < 0) {
						people.get(i).rank++;
					}
				}
			} // for_j
		} // for_i
		
		for(Person p : people)
			System.out.print(p.rank + " ");
	}
}

class Person{
	int tall;
	int weight;
	int rank = 1;
	
	Person(int tall, int weight){
		this.tall = tall;
		this.weight = weight;
	}
}
