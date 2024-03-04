package stringAlgos.kmpImpl;

public class KMP {
    private final int R;    // radix or length of characters allowed
    private final int m;    // pattern length
    private int[][] dfa;

    public KMP(String pat) {
        this.R = 256;
        this.m = pat.length();
        dfa = new int[R][m];

        //build DFA from pattern

        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];  //copy mismatch cases
            }
            dfa[pat.charAt(j)][j] = j + 1;  // set match case
            x = dfa[pat.charAt(j)][x];  // restart update state
        }
    }

    public KMP(char[] pattern, int R){
        this.R = R;
        this.m = pattern.length;
        this.dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for(int x = 0, j = 0; j < m; j++){
            for(int c = 0; c < R; c++){
                dfa[c][j] = dfa[c][x];
            }
            dfa[pattern[j]][j] = j+1;
            x = dfa[pattern[j]][x];
        }
    }

    private int search(String txt){
        int n = txt.length();
        int i, j;
        for(i = 0, j = 0; i < n && j < m; i++){
            j = dfa[txt.charAt(i)][j];
        }
        if(j == m) return i - m;
        return n;
    }

    private int search(char[] text){
        int n = text.length;
        int i, j;
        for(i = 0, j = 0; i < n && j < m; i++){
            j = dfa[text[i]][j];
        }if(j == m) return i - m;
        return n;
    }
}
