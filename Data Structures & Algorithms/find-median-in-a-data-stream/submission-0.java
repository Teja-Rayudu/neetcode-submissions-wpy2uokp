class MedianFinder {
    ArrayList<Integer> pq;
    public MedianFinder() {
        pq = new ArrayList<>();
    }
    
    public void addNum(int num) {
        pq.add(num);
    }
    
    public double findMedian(){
        Collections.sort(pq);
        int n = pq.size();
        if(n % 2== 1){
            return pq.get(n / 2);
        }
        else{
            return (pq.get(n / 2) + pq.get(n/2 - 1)) / 2.0;
        }
    }
}
