package by.it.academy.enums;

public enum Status {
    NEW("New"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}