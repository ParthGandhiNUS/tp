package classify.student;

import java.util.ArrayList;

import classify.user.InvalidSubjectException;
import classify.user.NameNumberMatchException;

/**
 * Class to represent a list of Students.
 */
public class StudentList {
    // @@authorParthGandhiNUS
    public static final String DOT = ".";
    public static final String ZERO_STUDENT_MESSAGE = "Currently, there are 0 students in the list.";
    public static final String ONE_STUDENT_MESSAGE = "Currently, there is 1 student in the list.";
    public static final String CURRENTLY_THERE_ARE = "Currently, there are ";
    public static final String STUDENTS_IN_THE_LIST = " students in the list.";
    public static ArrayList<Student> masterStudentList = new ArrayList<>();
    public static ArrayList<Student> recentlyDeletedList = new ArrayList<>();
    public static ArrayList<Student> archiveList = new ArrayList<>();

    // @@author Cryolian
    public ArrayList<Student> studentList;

    // @@author Cryolian
    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    // @@author ParthGandhiNUS
    /**
     * Used in the "list" command to print all the Current Tasks in the proper
     * format
     * 
     * @param currentList takes in an array to print out the name and other
     *                    attributes of the Student
     */
    public static void printCurrentArrayList(ArrayList<Student> currentList) {
        for (int i = 1; i <= currentList.size(); i++) {
            System.out.println(i + DOT + currentList.get(i - 1));
        }
    }

    // @@author ParthGandhiNUS
    /**
     * Prints a statement displaying the number of students in the Student List
     * 
     * @param currentList takes in a Student list to get its size
     */
    public static void printCurrentArrayMessage(ArrayList<Student> currentList) {
        int numberOfStudents = currentList.size();

        switch (numberOfStudents) {
        case 0:
            System.out.println(ZERO_STUDENT_MESSAGE);
            break;

        case 1:
            System.out.println(ONE_STUDENT_MESSAGE);
            break;

        default:
            System.out.println(CURRENTLY_THERE_ARE + numberOfStudents + STUDENTS_IN_THE_LIST);
            break;
        }

    }

    // @@author Cryolian
    /**
     * Adds in an instance of a student to the student list.
     * 
     * @param s The student to add to the list.
     */
    public void addStudent(Student s) {
        this.studentList.add(s);
    }

    /**
     * Removes a student of a certain id from the student list.
     * 
     * @param id The id of the student to remove.
     */
    public void removeStudent(int id) {
        this.studentList.remove(id);
    }

    // @@author Cryolian
    /**
     * Removes the first student in the list with a name matching
     * the given string.
     * 
     * @param name The string to search among the names of the student to remove.
     */
    public void removeStudent(String name) {

        for (Student s : studentList) {

            if (s.getName().equals(name)) {
                studentList.remove(s);
                return;
            }
        }
    }

    /**
     * Function checks if a name and number pair already exists in a given list.
     * Throws an exception if it does.
     * @param studentList               List to check through for the name and number.
     * @param name                      Name of the student to find.
     * @param number                    Phone number of the student to find.
     * @throws NameNumberMatchException Thrown if a match is found.
     */
    public static void checkNameNumberPair(ArrayList<Student> studentList, String name, int number)
            throws NameNumberMatchException, NullPointerException {
        
        if (studentList == null || studentList.isEmpty()) {
            return;
        }

        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name) && s.getPhoneNumber() == number) {
                throw new NameNumberMatchException("Student with the same " +
                        "name and phone number found.");
            }
            //@@author blackmirag3
            assert !(s.getName().equalsIgnoreCase(name) && s.getPhoneNumber() == number) : "something went wrong";

            //@@author Cryolian
        }

    }

    /**
     * Function checks if a name and number pair already exists in a given list.
     * Throws an exception if it does.
     * @param studentList               List to check through for the name and number.
     * @param name                      Name of the student to find.
     * @param number                    Phone number of the student to find.
     * @throws NameNumberMatchException Thrown if a match is found.
     */
    public static void checkNameNumberPair(StudentList studentList, String name, int number)
            throws NameNumberMatchException, NullPointerException {
        
        if (studentList.studentList == null || studentList.studentList.isEmpty()) {
            return;
        }

        for (Student s : studentList.studentList) {
            if (s.getName().equalsIgnoreCase(name) && s.getPhoneNumber() == number) {
                throw new NameNumberMatchException("Student with the same " +
                        "name and phone number found.");
            }
        }

    }

    //@@author blackmirag3
    /**
     * Checks if a new subject name matches that of any subject under a student
     * Throws exception if match is found
     * @param attributes                Student's subjects to compare to
     * @param newSubject                New subject name to search for in student's subjects
     * @param oldName                   Current subject name
     * @throws InvalidSubjectException  Thrown if match is found
     */
    public static void checkExistingSubject(StudentAttributes attributes, String newSubject,
                                            String oldName) throws InvalidSubjectException {
        if (newSubject.equals(oldName)) {
            throw new InvalidSubjectException("New subject name same as current.");
        }
        SubjectGrade foundSubject = attributes.findSubject(newSubject);

        if (foundSubject != null) {
            throw new InvalidSubjectException("Subject already exists.");
        }
    }

}
