class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] startSplitted = startTime.split(":");
        int startHour = Integer.parseInt(startSplitted[0]);
        int startMin = Integer.parseInt(startSplitted[1]);
        int startSec = Integer.parseInt(startSplitted[2]);

        
        String[] endSplitted = endTime.split(":");
        int endHour = Integer.parseInt(endSplitted[0]);
        int endMin = Integer.parseInt(endSplitted[1]);
        int endSec = Integer.parseInt(endSplitted[2]);


        // sec
        // 1. end == start, diff = 0
        // 2. end > start, diff = end-start
        // 3. end < start, diff = (60 - start) + end, add start min by 1
        int secDiff = 0;
        if (endSec > startSec) {
            secDiff += endSec-startSec;
        } else if (endSec < startSec) {
            secDiff += 60-startSec+endSec;
            startMin++;
        }

        // min
        // 1. end == start, diff = 0
        // 2. end > start, diff = end-start
        // 3. end < start, diff = (60 - start) + end, add start hr by 1
        if (endMin > startMin) {
            secDiff += (endMin-startMin)*60;
        } else if (endMin < startMin) {
            secDiff += (60-startMin+endMin)*60;
            startHour++;
        }

        
        // hrs
        // 1. end == start, diff = 0
        // 2. end > start, diff = end-start
        // 3. end < start, diff = (24 - start) + end
        if (endHour > startHour) {
            secDiff += (endHour-startHour)*60*60;
        } else if (endHour < startHour) {
            secDiff += (24-startHour+endHour)*60*60;
        }

        return secDiff;
    }
}
