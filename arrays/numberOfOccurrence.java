//naive approch

class numberOfOccurrence {
    public static int count(int arr[], int n, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        return count;
    }
}

//binary search approch 
 class numberOfOccurrence2 {

    // Function to find the first occurrence of x
    public static int findFirst(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1; // move towards the left (lower indices)
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Function to find the last occurrence of x
    public static int findLast(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1; // move towards the right (higher indices)
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // Function to count occurrences of x using the two binary search functions
    public static int count(int[] arr, int n, int x) {
        int first = findFirst(arr, n, x);
        if (first == -1) {
            return 0; // x is not present in the array
        }
        int last = findLast(arr, n, x);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        int n = 7;
        int x = 3;
        System.out.println("Count of " + x + " is: " + count(arr, n, x)); // Output should be 2
    }
}
