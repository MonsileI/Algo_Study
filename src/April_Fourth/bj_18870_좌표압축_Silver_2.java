package April_Fourth;

import java.util.*;
import java.io.*;
public class bj_18870_좌표압축_Silver_2 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //정답을 위한 배열
        String[] arr = br.readLine().split(" ");
        // Sort한 배열
        int[] an = new int[N];
        // 정답 밸류를 위한 cnt
        int cnt = 0;
        //입력
        for (int i = 0; i < N; i++) an[i]=Integer.parseInt(arr[i]);
        //오리진 배열
        int[]tmp = new int[N];
        //딥 카피
        for(int i=0;i<N;i++) tmp[i] = an[i];
        //오름차순  정렬
        Arrays.sort(an);
        // 맵 만듦
        Map<Integer, Integer> hmap = new HashMap<>();
        //만약 hmap에 an[i]값이 없으면, cnt++하고 put 해준다 ( 어차피 같은 값이면 같은 벨류니까 안함)
        //오름차순이기 때문에 무조건 cnt++이 될거임(갈수록 숫자는 커지니까) - 이러니까 개느리지
        for (int i=0;i<N;i++) if (!hmap.containsKey(an[i])) hmap.put(an[i], cnt++);
        // for문을 돌면서 hmap.get[오리진 값]을 어펜드 해줌.(어차피 벨류는 다 다를테니 숫자가 다르면.)
        for (int i=0;i<N;i++) sb.append(hmap.get(tmp[i])).append(" ");
        //투스트링
        System.out.println(sb.toString());
    }
}