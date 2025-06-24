package GFG;

public class FascinatingNumber {
    boolean fascinating(long n) {
        // code here
        String str = "" + n + (n * 2) + (n * 3);

        // If length is not 9, cannot be fascinating
        if(str.length() != 9) return false;

        // Create array to check occurrence of digits 1-9
        int[] count = new int[10]; // index 0 to 9

        for(char c : str.toCharArray()) {
            int digit = c - '0';
            // If digit is 0 or already counted (means digit appears more than once), return false
            if(digit == 0 || count[digit] > 0) return false;
            count[digit]++;
        }

        // All digits from 1 to 9 should appear exactly once
        for(int i = 1; i <= 9; i++) {
            if(count[i] != 1) return false;
        }

        return true;
    }
}
