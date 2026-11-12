class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        int[] queriesDup = Arrays.copyOf(queries, queries.length);
        Arrays.sort(queriesDup);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;

        for(int q : queriesDup){
            while(i < intervals.length && intervals[i][0] <= q){
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
            
        }

        int[] output = new int[queries.length];
        for(int j = 0; j < queries.length; j++){
            output[j] = map.get(queries[j]);
        }

        return output;
    }
}
