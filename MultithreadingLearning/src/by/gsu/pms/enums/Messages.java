package by.gsu.pms.enums;

public enum Messages {

    CHOOSE_OPERATION("\tadding - to add\n\tmultiplication - to multiply\n\tsubtracting - to subtract"),
    ENTER_TOP_LIMIT("Enter the top limit for numbers (> 0 and a number) : "),
    ENTER_THREADS("Enter the number of threads (> 0 and a number) : "),
    CHECK_ENTRY("Check entered value!"),
    THREAD_ERROR("Thread was interrupted!"),
    RESULT("\n\n\n Result is : "),
    NUMBERS("\n\n Numbers : "),
    SEPARATOR(", "),
    ;

    private final String text;

    public String getText() {
        return text;
    }

    Messages(String text) {
        this.text = text;
    }
}
