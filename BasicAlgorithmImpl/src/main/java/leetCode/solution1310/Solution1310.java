package leetCode.solution1310;

public class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n+1];
        for(int i = 0; i < n; i++){
            prefixXOR[i+1] = prefixXOR[i]^arr[i];
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            result[i] = prefixXOR[queries[i][1] +1] ^ prefixXOR[queries[i][0]];
        }
        return result;
    }
}
