class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] s2Char = s.toCharArray();
        HashMap<Character,Integer> windows = new HashMap<>();
        int left = 0,right = 0,len = 0;
        while(right < s2Char.length) {
            char pre = s2Char[right];
            right++;
            windows.put(pre,windows.getOrDefault(pre,0)+1);
            //System.out.println(pre+"==p=="+windows.get(pre));
            while(windows.get(pre) > 1) {
                char now = s2Char[left];
                left++;
                windows.put(now,windows.get(now)-1);
               System.out.println(now+"==n=="+windows.get(now));
            }
            //System.out.println(left+"--"+right);

            len = Math.max(len,right-left);//每次都在更新
        }
        return len;
    }
}