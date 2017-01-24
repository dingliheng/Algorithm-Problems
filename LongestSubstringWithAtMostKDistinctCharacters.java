c class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //corner case
        if (s==null || s.length() == 0 || k < 1) {
            return 0;
        }
        //use sliding window with begin and end of the window
        int begin = 0; 
        int end = 0;
        
        int max = 0;
        //use hashmap to record the occurrence number of each character
        Map<Character, Integer> occurrences = new HashMap<Character, Integer>();
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (occurrences.size() < k) {
                if (occurrences.containsKey(endChar)) {
                    occurrences.put(endChar, occurrences.get(endChar)+1);
                }else {
                    occurrences.put(endChar, 1);
                }
            }else {
                if (occurrences.containsKey(endChar)) {
                    occurrences.put(endChar, occurrences.get(endChar)+1);
                }else {
                    char beginChar = s.charAt(begin++);
                    if (occurrences.get(beginChar) == 1) {
                        occurrences.remove(beginChar);
                    }else {
                        occurrences.put(beginChar, occurrences.get(beginChar)-1);
                    }
                    end--;
                }
            }
            end++;
            if (max < end - begin) max = end - begin;
        }
        return max;
    }
}
