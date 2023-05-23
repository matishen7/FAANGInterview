package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {
    private List<Integer> time;

    public RecentCounter() {
        time = new ArrayList<>();
    }

    public int ping(int t) {
        int count = 0;
        time.add(t);
        int range = t - 3000;
        for (int i = time.size() - 1; i >=0 ; i--) {
            int ms = time.get(i);
            if (ms >= range) count++;
            else break;
        }
        return count;
    }
}

class RecentCounterProgram {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));
    }
}
