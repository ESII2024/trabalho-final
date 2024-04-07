package Platform;

import Data.print;

public class WebPlatform implements Platform {
    @Override
    public void display() {
        print.log("Displaying quiz on web platform");
    }
}