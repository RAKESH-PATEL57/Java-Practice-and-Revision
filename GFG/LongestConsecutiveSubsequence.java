 private TreeSet<Integer> numbers = new TreeSet<>();
    public int longestConsecutive(int[] arr) 
    {
        int ln = arr.length;
        if (ln == 0) return 0; // Edge case: empty array
        
        int maxRes = 1; // Tracks the longest sequence
        int currentRes = 1; // Tracks the current sequence length

        // Add elements to the TreeSet to ensure sorting and uniqueness
        for (int i = 0; i < ln; i++) {
            numbers.add(arr[i]);
        }

        // Convert TreeSet to a list for easier sequential access
        List<Integer> list = new ArrayList<>(numbers);

        // Iterate through the sorted unique list
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 == list.get(i + 1)) {
                currentRes++; // Increment the current sequence length
                maxRes = Math.max(maxRes, currentRes); // Update the max sequence length
            } else {
                currentRes = 1; // Reset current sequence length
            }
        }

        return maxRes;
    }