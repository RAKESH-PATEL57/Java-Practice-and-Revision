package GFG;

public class RotateArray 
{
    static void rotateArr(int arr[], int d) {
        // Handle cases where d is greater than array length
        d = d % arr.length;
        if (d == 0) return; // No need to rotate if d is 0 or a multiple of array length
    
        ArrayList<Integer> temp = new ArrayList<>();
    
        // Store the first d elements in temp
        for (int i = 0; i < d; i++) {
            temp.add(arr[i]);
        }
    
        // Shift the remaining elements to the left
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
    
        // Copy the elements from temp to the end of the array
        for (int i = 0; i < temp.size(); i++) {
            arr[arr.length - d + i] = temp.get(i);
        }
    }
        
}
