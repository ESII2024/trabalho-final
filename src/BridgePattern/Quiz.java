package BridgePattern;

import Educational.EducationalContent;
import Platform.Platform;

public class Quiz implements EducationalContent {
    private Platform platform;

    public Quiz(Platform platform) {
        this.platform = platform;
    }

    @Override
    public void display() {
        platform.display();
    }
}