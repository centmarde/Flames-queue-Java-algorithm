import java.util.LinkedList;
import java.util.Queue;

public class CountLeftover {
    private RemoveCommonChars remover = new RemoveCommonChars(); 

    
    public int getCountLeftover(String name1, String name2) {
        Queue<Character> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();

        for (char c : name1.toCharArray()) {
            q1.offer(c);
        }

        for (char c : name2.toCharArray()) {
            q2.offer(c);
        }

       
        remover.removeCommonChars(q1, q2);

       
        int leftoverCount = q1.size() + q2.size();
        return leftoverCount;
    }
}
