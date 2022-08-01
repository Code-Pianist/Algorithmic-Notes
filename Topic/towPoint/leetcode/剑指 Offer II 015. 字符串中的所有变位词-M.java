class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> windows = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        char[] s2Char = s.toCharArray();
        char[] p2Char = p.toCharArray();
        for(char n : p2Char)    need.put(n,need.getOrDefault(n,0)+1);

        int left = 0,right = 0,vaild = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        while(right < s2Char.length) {
            char now1 = s2Char[right];
            right++;
            if(need.containsKey(now1)) {
                windows.put(now1,windows.getOrDefault(now1,0)+1);
                if(need.get(now1).equals(windows.get(now1))) {
                    vaild++;
                }
            }

           // System.out.println(left+"===="+right+"--"+vaild);

            while(right - left >= p2Char.length) {//注意是字符串长度
                if(vaild == need.size()) {
                    res.add(left);
                }
                char now2 = s2Char[left];
                left++;
                if(need.containsKey(now2)) {
                    if(windows.get(now2).equals(need.get(now2))) {
                        vaild--;
                    }
                    windows.put(now2,windows.get(now2)-1);
                }
            }
        }
        return res;
    }
}