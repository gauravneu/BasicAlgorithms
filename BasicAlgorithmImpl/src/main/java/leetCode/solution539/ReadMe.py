class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        minutes = [False] * (1440)
        for time in timePoints:
            h, m = map(int, time.split(":"))
            min_time = h * 60 + m
            if minutes[min_time]:
                return 0
            minutes[min_time] = True
        firstIndex = float("inf")
        lastIndex = float("inf")
        result = float("inf")
        for i in range(1440):
            if minutes[i]:
                if lastIndex != float("inf"):
                    result = min(result, i - lastIndex)
                if firstIndex == float("inf"):
                    firstIndex = i
                lastIndex = i
        return min(result, 1440 - lastIndex + firstIndex)
