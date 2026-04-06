class Solution {
    public int[] sortArray(int[] nums) {
        // heapSort(nums); /
        mergeSort(nums, 0 , nums.length-1);


        return nums;
    }
    private void mergeSort(int[] arr, int l, int h) {
        if(l>=h) return;
        int m = (l+h)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, h);
        merge(arr, l, m, h);
    }
    private void merge(int[] arr, int l, int m, int r) {
        int i = l; int j = m+1 ; 
        ArrayList<Integer> temp = new ArrayList<>();
        while(i <= m && j <= r) {
            if(arr[i] < arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }
        while(i<=m){
            temp.add(arr[i]);
            i++;
        }
        while(j<=r) {
            temp.add(arr[j]);
            j++;
        }

        for(i = l ; i <= r ; i++) {
            arr[i] = temp.get(i-l);
        }

    }
    // private void heapify(int [] a, int n, int i) {
    //     int largest = i;
    //     int l = 2*i+1;
    //     int r = 2*i+2;
    //     if(l < n && a[l] > a[largest]) {
    //         largest = l;
    //     }
    //     if(r < n && a[r] > a[largest]) {
    //         largest = r;
    //     }
    //     if(largest != i) {
    //         int temp = a[i];
    //         a[i] = a[largest];
    //         a[largest] = temp;
    //         heapify(a, n, largest);
    //     }
    // }

    // private void heapSort(int[] a) {
    //     int n = a.length;
    //     for(int i = n/2-1  ; i >= 0 ; i--) {
    //         heapify(a, n, i);
    //     }
    //     for(int i = n-1 ; i > 0; i--) {
    //         int temp = a[0];
    //         a[0] = a[i];
    //         a[i] = temp;
    //         heapify(a, i, 0);

    //     }
    // }
}