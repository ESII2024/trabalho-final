package Platform;

import Data.print;

public class MobilePlatform implements Platform {
    @Override
    public void display() {
        print.log("Displaying quiz on mobile platform");
    }
}

