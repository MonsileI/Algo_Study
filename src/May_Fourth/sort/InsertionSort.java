package May_Fourth.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[]arr = {10,3,2,6,7,9};
        int N = arr.length;
        int key = 0; int i=0; int j=0;

        for(i=1; i<N;i++){
            key = arr[i];

            for(j=i-1;-1<j;j--){
                if(key < arr[j]) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = key;
        }

        for(int num : arr) System.out.print(num+", ");
    }
}
