class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for(char c : s1Char)    need.put(c,need.getOrDefault(c,0)+1);

        int left = 0,right = 0;
        int vaild = 0;
        while(right < s2Char.length){
            char now1 = s2Char[right];
            right++;
            if(need.containsKey(now1)){
                window.put(now1,window.getOrDefault(now1,0)+1);
                if(need.get(now1).equals(window.get(now1))){
                    vaild++;
                }
            }

            //System.out.println(s2Char[left]+"===="+s2Char[right]);

            while(right - left >= s1Char.length) {//判断左侧窗口是否要收缩
                if(vaild == need.size())    return true;

                char now2 = s2Char[left];
                left++;
                if(need.containsKey(now2)) {
                    if(need.get(now2).equals(window.get(now2))){
                        vaild--;
                    }
                    window.put(now2,window.getOrDefault(now2,0)-1);
                }
            }
        }
        return false;
    }
}