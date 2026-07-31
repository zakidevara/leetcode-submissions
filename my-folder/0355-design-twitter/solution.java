class Twitter {

    Map<Integer, Set<Integer>> followerMap = new HashMap<>(); // userId -> followers

    
    Map<Integer, Set<Integer>> followingMap = new HashMap<>(); // userId -> followed user ids

    Map<Integer, List<Tweet>> tweets = new HashMap<>(); // userId -> tweets posted

    int timestamp = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(timestamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> userTweetToFetch = new ArrayList<>();
        userTweetToFetch.add(userId);
        if (followingMap.containsKey(userId)) userTweetToFetch.addAll(followingMap.get(userId));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[3] - a[3]);
        for (Integer uid : userTweetToFetch) {
            if (!tweets.containsKey(uid)) continue;
            pq.offer(new int[]{uid, tweets.get(uid).size()-1, tweets.get(uid).getLast().tweetId, tweets.get(uid).getLast().timestamp});
        }

        List<Integer> newsFeed = new ArrayList<>();
        while (newsFeed.size() < 10 && pq.size() > 0) {
            int[] curr = pq.poll();
            newsFeed.add(curr[2]);

            if (curr[1] > 0)
                pq.offer(new int[]{curr[0], curr[1] - 1, tweets.get(curr[0]).get(curr[1] - 1).tweetId, tweets.get(curr[0]).get(curr[1] - 1).timestamp});
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        followerMap.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
        followerMap.computeIfAbsent(followeeId, k -> new HashSet<>()).remove(followerId);
    }

    private class Tweet {
        int timestamp;
        int tweetId;

        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
