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
                if(room.users.size() >= roomSize) continue;
                if(!room.users.isEmpty() && room.users.get(0).level - 10
                        <= level && level <= room.users.get(0).level + 10) {
                    flag = true;
                    room.users.add(new User(level,id));
                    break;
                }
            }
            if(!flag){
                Room room = new Room();
                room.users.add(new User(level, id));
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            Collections.sort(room.users);
            if(room.users.size() == roomSize )
                bw.write("Started!\n");
            else
                bw.write("Waiting!\n");
            for(int i=0;i<room.users.size();i++)
            {
                int level = room.users.get(i).level;
                String nickName = room.users.get(i).nickName;

                bw.write(level + " " + nickName+"\n");
            }
        }
        bw.flush();
    }
}
