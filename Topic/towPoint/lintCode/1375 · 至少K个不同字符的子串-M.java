public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        if(s.length()==0)   return 0;
        int n = s.length();
        long numOfSubstrings = 0,differentChars = 0;
        Map<Character,Integer> counter = new HashMap<>();
        int j = 0;

        for(int i = 0;i < n;i++){
            while(j < n && differentChars < k){
                int numOfThisChar = counter.getOrDefault(s.charAt(j),0);
                counter.put(s.charAt(j),numOfThisChar+1);
                if(counter.get(s.charAt(j))==1){
                    differentChars++;
                }
                j++;
            }
            if(differentChars == k){
                numOfSubstrings += n-(j-1);//因为j已经++了，所以需减一
            }

            counter.put(s.charAt(i),counter.get(s.charAt(i))-1);
            if(counter.get(s.charAt(i))==0){
                differentChars--;
            }
        }
        return numOfSubstrings;
    }
}