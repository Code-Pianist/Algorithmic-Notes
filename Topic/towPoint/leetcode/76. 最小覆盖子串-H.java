class Solution {
    public String minWindow(String s, String t) {
        char[] s2Char = s.toCharArray();
        char[] t2Char = t.toCharArray();
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for(char c : t2Char){
            need.put(c,need.getOrDefault(c,0)+1);
            // System.out.println(c+"="+ need.get(c));
        }

        int start = 0,len = Integer.MAX_VALUE;
        int valid = 0;
        int left = 0,right = 0;
        while(right < s2Char.length){
            char now = s2Char[right];
            right++;
            if(need.containsKey(now)){
                window.put(now,window.getOrDefault(now,0)+1);
                if(window.get(now) .equals( need.get(now))){
                    valid++;
                    System.out.println(valid);
                }
            }

            System.out.println(s2Char[left]+"----"+ s2Char[right-1]);

            while(valid == need.size()){
                if(len > right-left){//哎，注意不是right-start
                    start = left;
                    len = right-left;
                    //System.out.println("len=="+len);
                }
                char now2 = s2Char[left];
                left++;
                if(need.containsKey(now2)){
                    if(window.get(now2).equals( need.get(now2))){
                        valid--;
                    }
                    window.put(now2,window.get(now2)-1);
                }
                //System.out.println("left->"+s2Char[left]);
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}