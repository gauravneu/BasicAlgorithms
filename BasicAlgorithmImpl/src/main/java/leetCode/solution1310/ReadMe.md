Rules with XOR:

A ^ A = 0 (any number XORed with itself is 0)
A ^ 0 = A (XORing with 0 leaves the number unchanged)
A ^ B = B ^ A (order doesn’t matter)
(A ^ B) ^ C = A ^ (B ^ C) (grouping doesn’t matter)
(A ^ B) ^ B = A (XORing twice cancels out)


class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        prefix_xor = [0]*(len(arr) + 1)
        for i in range(len(arr)):
            prefix_xor[i+1] = prefix_xor[i]^arr[i]
        result = [prefix_xor[r+1] ^ prefix_xor[l] for l,r in queries]
        return result