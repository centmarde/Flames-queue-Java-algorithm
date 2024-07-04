public class UI {
    public static String getResultUI(String result) {
        switch (result) {
            case "Lovers":
            case "Marriage":
            case "Engagement":
                return getHeartUI();
            case "Friends":
                return getThumbsUpUI();
            case "Anger":
                return getAngerUI();
            case "Soulmates":
                return getBirdUI();
            default:
                return "";
        }
    }
    
    public static String getHeartUI() {
        return "❤️" ;
    }
    
    public static String getThumbsUpUI() {
        return "👍";
              
    }
    
    public static String getAngerUI() {
        return "😠";
    }
    
    public static String getBirdUI() {
        return "🕊️";
               
    }
    
}
