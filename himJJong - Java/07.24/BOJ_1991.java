import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991{
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node('A',null,null);

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            char a = tmp[0].charAt(0);
            char b = tmp[1].charAt(0);
            char c = tmp[2].charAt(0);

            insertNode(head, a, b, c);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    private static void postOrder(Node n) {
        if(n==null)  return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.value);
    }

    private static void inOrder(Node n) {
        if(n==null)  return;
        inOrder(n.left);
        System.out.print(n.value);
        inOrder(n.right);
    }

    private static void preOrder(Node n) {
        if(n == null)    return;
        System.out.print(n.value);
        preOrder(n.left);
        preOrder(n.right);
    }

    static void insertNode(Node tmp, char root, char left, char right){
        if(tmp.value == root){
            tmp.left = (left =='.'? null : new Node(left,null, null));
            tmp.right = (right =='.'? null : new Node(right,null, null));
        }
        else{
            if(tmp.left != null)    insertNode(tmp.left, root, left, right);
            if(tmp.right != null)    insertNode(tmp.right, root, left, right);
        }
    }
}
