package Practice;

import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i] > priorities[location]) {
                answer++;
            }
        }

        int lastLocation = 0;
        loop1:
        for (int i = 9; i >= 1; i--) {
            if (priorities[location] == i) {
                for (int j = lastLocation + 1; j < priorities.length; j++) {
                    if (j == location) {
                        break loop1;
                    } else if (j != location && priorities[j] == i) {
                        answer++;
                    }
                }
                for (int j = 0; j < lastLocation; j++) {
                    if (j == location) {
                        break loop1;
                    } else if (j != location && priorities[j] == i) {
                        answer++;
                    }
                }
            } else {
                int count = 0;
                for (int j = lastLocation - 1; j >= 0; j--) {
                    if (priorities[j] == i) {
                        count++;
                        lastLocation = j;
                        break;
                    }
                }
                if (count == 0) {
                    for (int j = priorities.length - 1; j > lastLocation; j--) {
                        if (priorities[j] == i) {
                            lastLocation = j;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
