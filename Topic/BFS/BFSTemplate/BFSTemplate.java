package com.xupt.mobile.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTemplate {
    //普通BFS模板
    public void BFSTemplate_Ord(){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        //1.初始点入队
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()) {//2.队列判空
            //3.弹出队首元素，寻找可达性结点
            int now = queue.poll();
            for(int nextPoint : findNext(now)){
                //4.不满足情况跳出
                if (!isValid(nextPoint)) {
                    continue;
                }
                //5满足条件：入队同时更新visited
                queue.offer(nextPoint);
                visited.add(nextPoint);
            }
        }
    }

    private boolean isValid(int nextPoint) {
        return true;
    }

    private int[] findNext(int now) {
        return new int[1];
    }

    //分层BFS模板
    public void BFSTemplate_Level(){
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Integer> distance = new HashMap<>();

        //1.初始点入队
        queue.offer(0);
        distance.put(0,0);
        while(!queue.isEmpty()) {//2.队列判空
            //3.弹出队首元素，寻找可达性结点
            int now = queue.poll();
            for(int nextPoint : findNext(now)){
                //4.不满足情况跳出
                if(!isValid(nextPoint)){
                    continue;
                }
                //5满足条件：入队同时更新visited
                queue.offer(nextPoint);
                distance.put(nextPoint,distance.get(now)+1);
            }
        }
    }
}
