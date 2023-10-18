import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991{
    static class Node{
        char val;
        Node left;
        Node right;
        Node(char val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node('A',null, null);
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            createNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    private static void postOrder(Node tmp) {
        if(tmp == null){
            return;
        }
        postOrder(tmp.left);
        postOrder(tmp.right);
        System.out.print(tmp.val);
    }

    private static void inOrder(Node tmp) {
        if(tmp == null){
            return;
        }
        inOrder(tmp.left);
        System.out.print(tmp.val);
        inOrder(tmp.right);
    }

    private static void preOrder(Node tmp) {
        if(tmp == null){
            return;
        }
        System.out.print(tmp.val);
        preOrder(tmp.left);
        preOrder(tmp.right);
    }

    private static void createNode(Node tmp, char root, char left, char right) {
        if(tmp.val == root){
            tmp.left = (left == '.' ? null : new Node(left,null, null));
            tmp.right = (right == '.' ? null : new Node(right,null, null));
        }
        else{
            if(tmp.left != null)   createNode(tmp.left, root, left, right);
            if(tmp.right != null)   createNode(tmp.right, root, left, right);
        }
    }
}