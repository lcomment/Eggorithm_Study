import java.io.*;
import java.util.*;
public class BOJ_20006 {
    static class Room{
        List<User> users = new ArrayList<>();
    }
    static public class User implements Comparable<User> {
        int level;
        String nickName;

        public User(int level, String nickName) {
            this.level = level;
            this.nickName = nickName;
        }

        @Override
        public int compareTo(User o) {
            return nickName.compareTo(o.nickName);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int roomSize = Integer.parseInt(st.nextToken());
        ArrayList<Room> rooms = new ArrayList<>();

        for(int i=0; i<people; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            boolean flag = false;
            for(Room room : rooms) {
                if(room.users.size() >= roomSize) continue;         // roomSize 크기 이상이라면 새로운 room 만들기 위해 continue
                if(!room.users.isEmpty() && room.users.get(0).level - 10
                        <= level && level <= room.users.get(0).level + 10) {
                    flag = true;
                    room.users.add(new User(level,id));
                    break;
                }
            }
            if(!flag){                                      //초기 방이 없거나, 해당 조건을 만족하지 못하여 새로운 room 생성 후
                Room room = new Room();                     //rooms에 room 추가
                room.users.add(new User(level, id));
                rooms.add(room);                            //전체 각각의 방들을 모아놓은 ArrayList<room> rooms
            }
        }

        for (Room room : rooms) {                           //전체 rooms들 중에서
            Collections.sort(room.users);                   //Room 클래스 내 List<User> 중 User 클레스 타입내 필드인 level,id가 있고
            if(room.users.size() == roomSize )              //이 중 comparable 사용으로 id로 정렬
                bw.write("Started!\n");
            else
                bw.write("Waiting!\n");
            for(int i=0;i<room.users.size();i++)            //각각 room의 정보 내에 저장된 level 과 id 값을 bw.wirte
            {
                int level = room.users.get(i).level;
                String nickName = room.users.get(i).nickName;

                bw.write(level + " " + nickName+"\n");
            }
        }
        bw.flush();                                         //후 출력
    }
}
