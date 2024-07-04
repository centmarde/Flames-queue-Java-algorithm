public class FlamesResult {
    public String getFlamesResult(int count) {
        String[] flames = {"Friends", "Lovers", "Anger", "Marriage", "Engagement", "Soulmates"};
        
        // Adjust count to be within bounds
        int adjustedIndex = (count - 1) % 6;
       
        return flames[adjustedIndex];
    }
}
