import java.util.*;

public class programmers_carFee {
    static class Node{
        String time;
        int number;
        Node(String time, int number){
            this.time = time;
            this.number = number;
        }
    }
    static List<Integer> carNumber = new ArrayList<>();
    
    static List<Node> list = new ArrayList<>();
    static int[] fees = {180, 5000, 10, 600};  // 기본시간 기본요금 단위시간 단위요금
    static String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    public static void main(String[] args) {
        for(int i=0; i<records.length; i++){
            String[] tmp = records[i].split(" ");
            if(!carNumber.contains(Integer.parseInt(tmp[1]))){
                carNumber.add(Integer.parseInt(tmp[1]));
            }
        }

        Collections.sort(carNumber);

        int[][] timeCount = new int[carNumber.size()][2];

        for(int i=0; i<timeCount.length; i++){          // 모든 차번호 정렬하여 시간을 재기 위한 배열 생성 완료
            timeCount[i][0] = carNumber.get(i);
        }

        for(int i=0; i<records.length; i++){
            String[] tmp = records[i].split(" ");

            if(tmp[2].equals("IN")) list.add(new Node(tmp[0], Integer.parseInt(tmp[1])));
            else{
                Node cur = new Node("0",0);
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).number == Integer.parseInt(tmp[1])){
                        cur = list.remove(j);
                        break;
                    }
                }

                for(int j=0; j<timeCount.length; j++){
                    if(cur.number == timeCount[j][0]){
                        String[] inCarTime = cur.time.split(":");
                        String[] outCarTime = tmp[0].split(":");

                        int diff = ((Integer.parseInt(outCarTime[0]) * 60) + Integer.parseInt(outCarTime[1])) - ((Integer.parseInt(inCarTime[0]) * 60) + Integer.parseInt(inCarTime[1]));

                        timeCount[j][1] += diff;
                        break;
                    }
                }
            }
        }
        int index = 0;
        while (!list.isEmpty()){
            Node cur = list.remove(index);

            for(int j=0; j<timeCount.length; j++){
                if(cur.number == timeCount[j][0]){
                    String[] inCarTime = cur.time.split(":");
                    int[] outCarTime = {23,59};

                    int diff = ((((outCarTime[0]) * 60) + outCarTime[1])) - ((Integer.parseInt(inCarTime[0]) * 60) + Integer.parseInt(inCarTime[1]));

                    timeCount[j][1] += diff;
                    break;
                }
            }

        }
        int[] answer = new int[carNumber.size()];

        for(int i=0; i<timeCount.length; i++){

            if(timeCount[i][1] <= fees[0]) answer[i] = fees[1];
            else if(((timeCount[i][1]-fees[0]) % fees[2]) != 0){
                answer[i] = fees[1]+((( (timeCount[i][1] - fees[0]) / (fees[2]))+1) * fees[3]);
            }
            else{
                answer[i] = fees[1]+(( (timeCount[i][1] - fees[0]) / fees[2]) * fees[3]);
            }
        }

        for (int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
