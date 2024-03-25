import java.util.Arrays;

public class HeapSort2 {
//    1. 최초 힙구성 이후에 0번째 노드와 마지막번째 노드 change
//    2. 0번째부터 heapify -> 마지막번째 (n-1), 0번째 change
//    3. 다시 0번째부터 heapify -> 다시 자리 change

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
        int n = arr.length;
        for (int i = arr.length/2-1; i >= 0; i--) {                 // i는 인덱스 값
            heapify(arr,n,i);
        }
        System.out.println(Arrays.toString(arr));

        for (int i=n; i>0; i--) {
            int temp = arr[0];
            arr[0]= arr[n-1];
            arr[n-1]=temp;
            n--;
            heapify(arr,n ,0);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int[] arr, int n, int root) {             //change가 발생한 부모 index
        int max_index=root;
        int left = root*2+1;
        int right = root * 2 + 2;

        if(left<n && arr[max_index]<arr[left]){
            max_index=left;
        }
        if(right<n && arr[max_index]<arr[right]){
            max_index=right;
        }
        if(max_index!=root){
            int temp= arr[root];
            arr[root]=arr[max_index];
            arr[max_index]=temp;
            heapify(arr,n,max_index);
        }
    }
}


