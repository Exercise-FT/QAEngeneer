package utilities;

public class BrowserUtils {

    public static String getCurrentTitle(){
        return Driver.get().getTitle();
    }
}
