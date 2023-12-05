import java.util.*;

public class pro_bestAl{
    static class Node{
        int idx;
        int play;
        Node(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }

        List<String> mapToGenres = new ArrayList<>();
        for(String item : map.keySet()){
            mapToGenres.add(item);
        }

        mapToGenres.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for(String item : mapToGenres){
            List<Node> movies = new ArrayList<>();
            for(int i=0; i< genres.length; i++){
                if(item.equals(genres[i])){
                    movies.add(new Node(i,plays[i]));
                }
            }

            movies.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.play == o2.play){
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }
            });

            answer.add(movies.get(0).idx);
            if(movies.size() != 1){
                answer.add(movies.get(1).idx);
            }
        }
        System.out.println(Arrays.toString(answer.stream().mapToInt(i -> i).toArray()));
    }
}