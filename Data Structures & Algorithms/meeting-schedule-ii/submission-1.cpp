/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        unordered_map<int, int> line;
        int minMeetingTime = INT_MAX;
        int maxMeetingTime = INT_MIN;

        for (Interval i : intervals) {
            line[i.start]++;
            line[i.end]--;
            minMeetingTime = min(minMeetingTime, i.start);
            maxMeetingTime = max(maxMeetingTime, i.end);
        }
        int count = 0;
        int res = 0;

        for (int i = minMeetingTime; i <= maxMeetingTime; i++) {
            count += line[i];
            res = max(res, count);
        }
        return res;
    }
};
