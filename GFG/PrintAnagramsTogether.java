 public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, List<String>> mp = new HashMap();
        
        for(String s: arr)
        {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortWord = String.valueOf(ch);
            
            if(!mp.containsKey(sortWord))
            {
                mp.put(sortWord, new ArrayList());
            }
            mp.get(sortWord).add(s);
        }
        
        return new ArrayList(mp.values());
    }