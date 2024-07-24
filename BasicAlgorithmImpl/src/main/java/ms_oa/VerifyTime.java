package ms_oa;
import java.util.*;
public class VerifyTime {
    public int solution(int A, int B, int C, int D) {
        Set<String> set = new HashSet<>();
        List<String> listOfTime = new ArrayList<>();
        permuteTime(A, B, C, D, listOfTime);
        for(String time: listOfTime){
            if(validTime(time)){
                set.add(time);
            }
        }
    return set.size();
    }

    void permuteTime(int A, int B, int C, int D, List<String> list){

        list.add(String.format("%d%d:%d%d",A, B, C, D));
        list.add(String.format("%d%d:%d%d",A, B, D, C));
        list.add(String.format("%d%d:%d%d",A, C, B, D));
        list.add(String.format("%d%d:%d%d",A, C, D, B));
        list.add(String.format("%d%d:%d%d",A, D, B, C));
        list.add(String.format("%d%d:%d%d",A, D, C, B));
        list.add(String.format("%d%d:%d%d",B, A, C, D));
        list.add(String.format("%d%d:%d%d",B, A, D, C));
        list.add(String.format("%d%d:%d%d",B, C, A, D));
        list.add( String.format("%d%d:%d%d",B, C, D, A));
        list.add(String.format("%d%d:%d%d",B, D, A, C));
        list.add(String.format("%d%d:%d%d",B, D, C, A));
        list.add(String.format("%d%d:%d%d",C, A, B, D));
        list.add(String.format("%d%d:%d%d",C, A, D, B));
        list.add(String.format("%d%d:%d%d",C, B, A, D));
        list.add(String.format("%d%d:%d%d",C, B, D, A));
        list.add(String.format("%d%d:%d%d",C, D, A, B));
        list.add(String.format("%d%d:%d%d",C, D, B, A));
        list.add(String.format("%d%d:%d%d",D, A, B, C));
        list.add(String.format("%d%d:%d%d",D, A, C, B));
        list.add(String.format("%d%d:%d%d",D, B, A, C));
        list.add(String.format("%d%d:%d%d",D, B, C, A));
        list.add(String.format("%d%d:%d%d",D, C, A, B));
        list.add(String.format("%d%d:%d%d",D, C, B, A));
    }

    boolean validTime(String time){
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
            if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                return true;
            }
            return false;
    }

    public static void main(String[] args) {
        VerifyTime solution = new VerifyTime();
        System.out.println(solution.solution(1, 1, 1, 1));  // Example usage
    }
}
