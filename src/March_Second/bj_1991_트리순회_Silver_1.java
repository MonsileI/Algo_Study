package March_Second;

import java.util.*;
import java.io.*;
public class bj_1991_트리순회_Silver_1 {
    static class Tree{
        Node Root;

        public void add(char self,char left,char right){
            if(Root==null){
                if(self!='.') Root = new Node(self);

            }
        };
    }
    static class Node{

        char self;
        Node leftNode;
        Node rightNode;

        public Node(char self) {
            this.self = self;

        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        Node[]nodes = new Node[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            char mom = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);



        }



            /*
            7
            A B C
            B D .
            C E F
            E . .
            F . G
            D . .
            G . .
              */





    }
}
