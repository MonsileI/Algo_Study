package May_Fourth.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[]arr = {10,3,2,6,7,9};
        int N = arr.length;
        int temp = 0; int i=0; int j=0;

        for(i=0; i<N-1;i++){
            for(j=0;j<N-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        for(int num : arr) System.out.print(num+", ");
    }
}
