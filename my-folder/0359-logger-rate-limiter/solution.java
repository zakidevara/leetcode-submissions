class Logger {

    private Map<String, Integer> lastSeen = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastSeen.containsKey(message)) {
            lastSeen.put(message, timestamp);
            return true;
        } 

        int diff = timestamp - lastSeen.get(message);
        boolean shouldPrint = diff >= 10;
        if (shouldPrint) lastSeen.put(message, timestamp);
        return shouldPrint;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
