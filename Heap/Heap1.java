import java.util.ArrayList;

public class Heap1 {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {// O(logn)

            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (arr.get(x) < arr.get(par)) {
                int swap = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, swap);

                x = par;
                par = (x - 1) / 2;
            }

        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int swap = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, swap);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));

            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);
            heapify(0);
            return data;
        }

        public boolean isEmpty() {

            return arr.size() == 0;
        }

    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIDX = i;

        if (left < size && arr[left] > arr[maxIDX]) {
            maxIDX = left;
        }
        if (right < size && arr[right] > arr[maxIDX]) {
            maxIDX = right;
        }

        if (maxIDX!=i) {
            int temp=arr[i];
            arr[i]=arr[maxIDX];
            arr[maxIDX]=temp;

            heapify(arr, maxIDX, size);
        }
    }

    public static void hepSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {

            heapify(arr,i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0, i);
        }
    }

    public static void main(String[] args) {

        // Heap pq=new Heap();
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(5);

        // while (!pq.isEmpty()) {
        // System.out.print(pq.peek()+" ");
        // pq.remove();
        // }

        int arr[] = {4 ,1 ,3 ,9 ,7 };
        hepSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
    }
}