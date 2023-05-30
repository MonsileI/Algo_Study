package May_Fourth.bj;

import java.io.*;
import java.util.*;
public class bj_10814_나이순정렬_Silver_5 {

    static class Name implements Comparable<Name>{
        int age; String name;int idx;

        public Name(int age, String name,int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(Name o) {
            if(age==o.age) return idx - o.idx;
            return age - o.age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Name[] names = new Name[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            names[i] = new Name(age,name,i);
        }
        Arrays.sort(names);
        StringBuilder sb = new StringBuilder();
        for(Name n : names) sb.append(n.age+" "+n.name).append("\n");
        System.out.println(sb.toString());


    }
}
