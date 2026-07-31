class BoundedBlockingQueue {
    
    private final Queue<Integer> queue;
    private final ReentrantLock lock;
    private final int capacity;
    private Condition notFull;
    private Condition notEmpty;

    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        
        lock.lock();
        try {
            
            while (queue.size() >= capacity) {
                notFull.await();
            }

            // lock acquired
            queue.offer(element);
            
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        
    }
    
    public int dequeue() throws InterruptedException {
        
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            // lock acquired
            int element = queue.poll();
            notFull.signal();
            return element;
            
        } finally {
            lock.unlock();
        }
        
        
    }
    
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
