public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        //统计target中字出现的个数
        int m = target.length();
        Map<Character,Integer> targetMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int numOfTargerChar =  targetMap.getOrDefault(target.charAt(i), 0);
            targetMap.put(target.charAt(i),numOfTargerChar+1);
        }

        int matchNum = targetMap.size();
        int n = source.length(),j = 0,start = 0;
        Map<Character,Integer> sourceMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int matchedChar = 0;
        for(int i = 0;i < n;i++){
            while(j < n && matchedChar < matchNum){
                int numOfSourceChar = sourceMap.getOrDefault(source.charAt(j), 0);
                sourceMap.put(source.charAt(j),numOfSourceChar+1);
                if(sourceMap.get(source.charAt(j)).equals(//如果字符出现次数相同，则匹配度加一
                        targetMap.get(source.charAt(j))
                )){
                    matchedChar++;
                }
                j++;
            }
            if(matchedChar == matchNum){
                if(minLength > j-i){
                    minLength = j-i;
                    start = i;
                }
            }

            sourceMap.put(source.charAt(i),sourceMap.getOrDefault(source.charAt(i),0)-1);//如果减去一后次数相差一，则匹配度减一
            if(sourceMap.get(source.charAt(i)).equals(
                    targetMap.getOrDefault(source.charAt(i), 0)-1
            )){
                matchedChar--;
            }

        }
        if(minLength==Integer.MAX_VALUE){
            return "";
        }
        return source.substring(start, start+minLength);
    }
}