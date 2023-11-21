import java.util.HashMap;

public class pro_phonebook {
    public static void main(String[] args) {
        String[] phoneBook = {"123", "456", "789"};

        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i = 0; i < phoneBook.length; i++)  {
            for (int j = 0; j < phoneBook[i].length(); j++) {
                System.out.println(phoneBook[i].substring(0, j));
                if (map.containsKey(phoneBook[i].substring(0, j))) {
                    System.out.println("실패");
                    System.exit(0);
                }
            }
        }

        System.out.println("성공");
    }
}
