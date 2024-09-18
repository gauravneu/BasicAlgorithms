class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        num_strings = [str(num) for num in nums]
        num_strings.sort(key=lambda a:a*10, reverse = True)
        if num_strings[0] == "0":
            return "0"
        return "".join(num_strings)


//Arrays.sort(nums, (b,a) -> (b+a).compareTo(a+b)) --> This lambda will ensure that strings will be
concatanated and then compared to give larger number as output

//num_strings.sort(key=lambda a:a*10, reverse = True)
a*10 --> aaaaaaaaaa
10*10 --> 10101010101010101010
then these two would be compared to give smaller, then reverse = True would make descending order