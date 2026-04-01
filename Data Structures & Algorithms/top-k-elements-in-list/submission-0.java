class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<int[]> elements = new ArrayList();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            elements.add(new int[]{entry.getValue(), entry.getKey()});
        }

        elements.sort((a,b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = elements.get(i)[1];
        }

        return res;
    }
}
