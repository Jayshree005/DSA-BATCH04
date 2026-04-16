class Pair{

    int num ;
    int freq ;
    Pair(int num , int freq){
        this.num = num ;
        this.freq = freq ;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.freq-b.freq) ;
        
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1) ;
        }

        for(int key : map.keySet()){

            pq.add(new Pair(key,map.get(key))) ;
            if(pq.size() > k){
                pq.poll() ;
            }
        }

        int[] ans = new int[k] ;
        for(int i = 0 ; i<k ; i++){
            if(!pq.isEmpty()){
                ans[i] = pq.poll().num ;
            }
           
        }
        return ans ;
        
    }
}