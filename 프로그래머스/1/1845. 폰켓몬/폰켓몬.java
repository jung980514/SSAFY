import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.putIfAbsent(num,0);
        }      
        if(nums.length/2 < map.size()){
            return nums.length/2;
        }
        else{
            return map.size();
        }
    }
}