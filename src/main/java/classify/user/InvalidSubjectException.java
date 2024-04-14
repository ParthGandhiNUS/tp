package classify.user;

//@@author blackmirag3
public class InvalidSubjectException extends Exception {
    private String message;
    public InvalidSubjectException() {
        super();
    }

    public InvalidSubjectException(String message) {
        super();
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
