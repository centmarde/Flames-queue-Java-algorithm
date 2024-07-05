public class FlamesResult {
    public String getFlamesResult(int count) {
        String[] flames = {"Friends", "Lovers", "Anger", "Marriage", "Engagement", "Soulmates"};
        
        
        int adjustedIndex = (count - 1) % 6;
       
        return flames[adjustedIndex];
    }
}
