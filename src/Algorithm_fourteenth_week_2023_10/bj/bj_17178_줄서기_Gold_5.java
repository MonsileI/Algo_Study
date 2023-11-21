package Algorithm_fourteenth_week_2023_10.bj;


import java.util.*;
import java.io.*;
public class bj_17178_줄서기_Gold_5 {

    static class Node {
        int idx; String str;

        public Node(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //무조건 알파벳이 먼저인 사람이 먼저 들어가야한다.
        //넘버링을 해놓고, 자기 넘버가 아니면 stack에 push

        int N = Integer.parseInt(br.readLine());
        Node[]nodeArr = new Node[N*5];
        int idx = 0;
        for(int i=0;i<N;i++){
            String[]tmp = br.readLine().split(" ");
            for(int j=0;j<5;j++){
                nodeArr[idx] = new Node(idx++,tmp[j]);
            }
        }
        Arrays.sort(nodeArr,((o1, o2) -> o1.str.compareTo(o2.str)));
        int[][]arr = new int[N*5][2];
        for(int i=0;i<N*5;i++){
            arr[i][0] = nodeArr[i].idx;
            arr[i][1] = i;
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        Stack<Integer> st =new Stack<>();
        idx = 0;
        for(int i=0;i<N*5;i++){
            if(arr[i][1]==idx) {
                idx++;
                continue;
            }
            if(st.isEmpty())st.push(arr[i][1]);
            else{
                if(st.peek()==idx) {
                    while(!st.isEmpty()){
                        st.pop();
                        idx++;
                        if(st.isEmpty()) break;
                        if(st.peek()!=idx) break;
                    }
                    st.push(arr[i][1]);
                }else st.push(arr[i][1]);
            }
        }
        String answer = "GOOD";
        if(!st.isEmpty()){
            int num = st.pop();
            boolean flag = true;
            while(!st.isEmpty()){
                if(num>st.peek()){
                    flag= false;
                    break;
                }
                num = st.pop();
            }
            if(!flag) answer = "BAD";
        }
        System.out.println(answer);
    }
}
