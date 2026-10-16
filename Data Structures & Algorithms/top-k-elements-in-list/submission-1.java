class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        int[] topK = new int[k];

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()){
            minHeap.add(key);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        for(int i = k - 1; i >= 0; i--){
            topK[i] = minHeap.poll();
        }

        return topK;
    }
}
