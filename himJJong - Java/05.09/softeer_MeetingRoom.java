import java.io.*;
import java.util.*;

public class softeer_MeetingRoom {
    static class object implements Comparable<object> {
        String name;
        int start;
        int end;
        int[] data;
        object(String name, int start, int end,int[] data){
            this.name = name;
            this.start = start;
            this.end = end;
            this.data = data;
        }

        @Override
        public int compareTo(object o) {
            return this.name.compareTo(o.name);
        }
    }
    static int[] check = new int[19];
    static List<object> carList = new ArrayList<>();
    static List<Integer> answerList = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int carCount = Integer.parseInt(st.nextToken());
        int timeData = Integer.parseInt(st.nextToken());

        String[] carName = new String[carCount];

        for(int i=0; i<carCount; i++){
            int[] tmp = check.clone();
            carName[i] = br.readLine();
            carList.add(new object(carName[i],0,0, tmp));
        }

        for(int i=0; i<timeData; i++){
            String[] tmp = br.readLine().split(" ");

            for(int j=0; j<carList.size(); j++){
                if(tmp[0].equals(carList.get(j).name)){
                    int a = ((Integer.parseInt(tmp[1]) - 9)*2) + 1;
                    int b = (Integer.parseInt(tmp[2]) - 9)*2;

                    for(int k=a; k<b; k++){
                        carList.get(j).data[k] = 1;
                    }
                    break;
                }
            }
        }

        Collections.sort(carList);

        for(int i=0; i<carList.size(); i++){
            printAnswer(carList.get(i));
            if(i!=carList.size()-1) System.out.println("-----");
        }
    }

    private static void printAnswer(object object) {
        System.out.println("Room "+object.name+":");
        int front = 0;
        int end = 0;
        int zeroCheck = 0;

        for(int i=0; i<19; i++){
            if(object.data[i] == 0){
                if(i==18){
                    front = i-zeroCheck;
                    end = i;

                    if(front == end)    continue;
                    answerList.add(front/2+9);
                    answerList.add(end/2+9);
                }
                zeroCheck++;
            }
            else{
                if(zeroCheck >=3){
                    front = i-zeroCheck;
                    end = i-1;

                    if(front == end)    continue;
                    answerList.add(front/2+9);
                    answerList.add(end/2+9);

                    zeroCheck = 0;
                }
                else{
                    zeroCheck = 0;
                }
            }
        }

        if(answerList.size()!=0){
            System.out.println(answerList.size()/2+" available:");
            for(int i=0; i<answerList.size() ;i++){
                if(answerList.get(i) < 10){
                    System.out.println("0"+answerList.get(i)+"-"+answerList.get(i+1));
                }
                else{
                    System.out.println(answerList.get(i)+"-"+answerList.get(i+1));
                }
                i++;
            }
            answerList.clear();
        }
        else{
            System.out.println("Not available");
        }
    }
}