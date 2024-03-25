import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
        int n = arr.length;
//  최초 힙 구성: n/2 번 만큼 heapify
    // 전체 노드를 반으로 자른 다음에 힙      --> 길이가 10이면 5부터 정렬
        for (int i = arr.length / 2 - 1; i >= 0; i--) {                 // i는 인덱스 값
            heapify(arr,i);
        }
        System.out.println(Arrays.toString(arr));
}
    static void heapify(int[] arr, int root) {             //change가 발생한 부모 index
//        XX 조건의 경우에 change 로직 발생 : left와 right를 비교해서 자리 change
        int max_index=root;
        int left = root*2+1;
        int right = root * 2 + 2;

        if(arr[max_index]<arr[left]){
            max_index=left;
        }
        if(arr[max_index]<arr[right]){
            max_index=right;
        }
        if(max_index!=root){
            int temp= arr[root];
            arr[root]=arr[max_index];
            arr[max_index]=temp;
            heapify(arr,max_index);
        }

     /*   int index1 = root * 2 + 1;
        int index2 = root * 2 + 2;

        if (index1 < arr.length && index2 < arr.length) {
            if (arr[index1] >= arr[index2]) {
                if (arr[root] < arr[index1]) {
                    int temp = arr[root];
                    arr[root] = arr[index1];
                    arr[index1] = temp;
                    heapify(arr, index1);
                }
            }
            if (arr[index1] < arr[index2]) {
                if (arr[root] < arr[index2]) {
                    int temp = arr[root];
                    arr[root] = arr[index2];
                    arr[index2] = temp;
                    heapify(arr, index2);
                }
            }
        }*/
    }
}


