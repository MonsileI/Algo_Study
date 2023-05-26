package May_Fourth.pr_;

public class test {
    static int N;
    static int[]arr = {1,2,3,4};

    public static void main(String[] args) {
        N = arr.length;
        comb(0,0,new boolean[N]);
    }
    static void comb(int depth,int idx,boolean[] sel){

        if(idx==N){

            for(int i=0;i<N;i++){
                if(sel[i]) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }


        sel[depth] = true;
        comb(depth+1,idx+1,sel);
        sel[depth] = false;
        comb(depth+1,idx+1,sel);
    }
}
