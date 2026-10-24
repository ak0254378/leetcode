class RecentCounter {

    private int[] calls;
    private int front, rear;

    public RecentCounter() {
        calls = new int[10001];
        front = 0;
        rear = 0;
    }

    public int ping(int t) {
        calls[rear++] = t;

        while (front < rear && calls[front] < t - 3000) {
            front++;
        }

        return rear - front;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
