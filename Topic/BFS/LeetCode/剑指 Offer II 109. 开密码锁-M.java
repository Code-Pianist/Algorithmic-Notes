class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String,Integer> visited = new HashMap<>();
        //将死亡数字写入访问集合里
        for(String dead : deadends) visited.put(dead,-1);

        if(visited.containsKey("0000")) return -1;
        queue.offer("0000");
        visited.put("0000",0);

        while(!queue.isEmpty()) {
            String str = queue.poll();
            for(int i = 0;i < 4;i++) {
                String plusOne = PlusOne(str,i);
                if(!visited.containsKey(plusOne)) {
                    queue.offer(plusOne);
                    visited.put(plusOne,visited.get(str)+1);
                }
                if(plusOne.equals(target))  return visited.get(plusOne);

                String divOne = DivOne(str,i);
                if(!visited.containsKey(divOne)) {
                    queue.offer(divOne);
                    visited.put(divOne,visited.get(str)+1);
                }
                if(divOne.equals(target))  return visited.get(divOne);
            }
        }
        return -1;
    }
    public String PlusOne(String str,int i) {
        char[] ch = str.toCharArray();
        if(ch[i] == '9')
            ch[i]='0';
        else
            ch[i]++;
        return new String(ch);
    }
    public String DivOne(String str,int i) {
        char[] ch = str.toCharArray();
        if(ch[i] == '0')
            ch[i]='9';
        else
            ch[i]--;
        return new String(ch);
    }
}