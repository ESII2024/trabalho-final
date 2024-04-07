package Educational;

import DecoratorPattern.Quiz;

public class EducationalObjectFactory {
    public static EducationalObject createObject(String type) {
        switch (type) {
            case "quiz":
                return new Quiz();
            case "video":
                return new Video();
            case "article":
                return new Article();
            default:
                throw new IllegalArgumentException("Invalid object type: " + type);
        }
    }
}
