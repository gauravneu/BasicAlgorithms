package stringAlgos.robinKarpImpl;

import java.math.BigInteger;
import java.util.Random;

public class RobinKarp {
    private String pat;
    private long patHash;
    private int m;
    private long q;
    private int R;
    private long RM;

    public RobinKarp(char[] pattern, int R){
        this.pat = String.valueOf(pattern);
        this.R = R;
    }

    public RobinKarp(String pat){
        this.pat = pat;
        this.R = 256;
        this.m = pat.length();
        this.q = longRandomPrime();
        this.RM = 1;
        for(int i = 1; i <= m - 1; i++){
            RM = (R * RM) % q;
            patHash = hash(pat, m);
        }
    }

    private long hash(String key, int m){
        long h = 0;
        for(int j = 0; j < m; j++){
            h = (R*h + key.charAt(j)) % q;
        }
        return h;
    }

    private boolean check(String txt, int i){
        for(int j = 0; j < m; j++){
            if(pat.charAt(j) != txt.charAt(i+j)){
                return false;
            }
        }
        return true;
    }

    public int search(String txt){
        int n = txt.length();
        if(n < m) return n;
        long txtHash = hash(txt, m);
        if((patHash == txtHash) && check(txt, 0)){
            return 0;
        }
        for(int i = m; i < n; i++){
            txtHash = (txtHash + q - RM*txt.charAt(i-m) % q) % q;
            txtHash = (txtHash*R + txt.charAt(i)) % q;

            int offset = i - m + 1;
            if((patHash == txtHash) && check(txt, offset)){
                return offset;
            }
        }
        return n;
    }

    private static long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
