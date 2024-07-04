import java.util.LinkedList;
import java.util.Queue;

public class RemoveCommonChars {
     static void removeCommonChars(Queue<Character> q1, Queue<Character> q2) {
        LinkedList<Character> list1 = new LinkedList<>(q1);
        LinkedList<Character> list2 = new LinkedList<>(q2);

        for (char ch : list1) {
            if (list2.contains(ch)) {
                list2.removeFirstOccurrence(ch);
                q1.remove(ch);
                q2.remove(ch);
            }
        }
    }
}