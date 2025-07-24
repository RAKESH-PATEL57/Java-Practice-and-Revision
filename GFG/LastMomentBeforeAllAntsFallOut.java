package GFG;

public class LastMomentBeforeAllAntsFallOut {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int lastMoment = 0;
    
        // Find the maximum distance an ant going left has to travel
        for (int position : left)
        {
            lastMoment = Math.max(lastMoment, position);
        }
        
        // Find the maximum distance an ant going right has to travel
        for (int position : right)
        {
            lastMoment = Math.max(lastMoment, n - position);
        }
        
        return lastMoment;
    }
}
