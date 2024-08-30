

public class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
      int floor = -1;  // Initialize floor as -1 (not found)
        int ceil = -1;   // Initialize ceil as -1 (not found)
        
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = (low +high) / 2;
            
            if (a[mid] == x) {
                // If element at mid is x, both floor and ceil are x
                return new int[] {x, x};
            } else if (a[mid] < x) {
                // If a[mid] < x, update floor to a[mid]
                floor = a[mid];
                low = mid + 1;
            } else {
                // If a[mid] > x, update ceil to a[mid]
                ceil = a[mid];
                high = mid - 1;
            }
        }
        
        return new int[] {floor, ceil};
    }
    
}