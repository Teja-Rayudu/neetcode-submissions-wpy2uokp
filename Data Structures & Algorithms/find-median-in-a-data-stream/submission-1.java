class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();
    boolean even = true;
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.add(large.poll());
        }
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (small.peek() + large.peek()) / 2.0;
        }
        else{
            return (double)small.peek();
        }
    }
}
