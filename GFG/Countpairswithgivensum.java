public class Countpairswithgivensum {
    int countPairs(int arr[], int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
    
        int count = 0;

        for (int num : arr) {
            // Calculate the complement
            int neededNumber = target - num;

            // Check if the complement exists in the map
            if (map.containsKey(neededNumber)) {
                count += map.get(neededNumber); // Add the frequency of the complement
            }

            // Update the frequency of the current element
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
