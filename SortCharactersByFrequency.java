public class SortCharactersByFrequency {
    public String frequencySort(String s) {
    //corner case
    if (s==null) return s;
    int[] charTimes = new int[256]; //count times of each character
    int max = 0; //record the max times
    for (char c: s.toCharArray()) {
      charTimes[c]++;
      max = Math.max(charTimes[c], max);
    }
    
    //use bucket sort to sort character by its times
    String[] buckets = new String[max];
    for (int i=0; i<charTimes.length; i++) {
      if (charTimes[i] != 0) {
        buckets[charTimes[i]-1] = buckets[charTimes[i]-1]==null? ""+ (char) i: buckets[charTimes[i]-1] + (char) i;
      }
    }
    
    //create the result string
    StringBuilder res = new StringBuilder();
    for (int i=buckets.length-1; i>=0; i--) {
      if (buckets[i] != null) {
        for (char c: buckets[i].toCharArray()) {
          for (int j=0; j<=i; j++) {
            res.append(c);
          }
        }
      }
    }
    
    return res.toString();
  }
}
