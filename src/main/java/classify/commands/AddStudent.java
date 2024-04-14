
package classify.commands;

import classify.student.Student;
import classify.student.StudentAttributes;
import classify.student.StudentList;
import classify.student.SubjectGrade;
import classify.ui.UI;
import classify.user.InputParsing;
import classify.user.InvalidCharacterException;
import classify.user.InvalidSubjectException;
import classify.user.NameNumberMatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import static classify.user.InputParsing.LOGGER;
import static classify.user.InputParsing.readInString;

//@@author tayponghee
public class AddStudent {
    private static final String NOT_EMPTY = "THIS STRING IS NOT EMPTY";
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String SUBJECT_ENTER_NOTHING_TO_SKIP = "Subject (enter nothing to skip): ";
    private static final String STUDENT_ADDED_SUCCESSFULLY = "Student added successfully.";
    private static final String NUMBER_IS_OUTSIDE_THE_ACCEPTABLE_RANGE = "Number is outside the acceptable range.";

    /**
     * Adds a new student to the list of students.
     * Does not allow for students of the same name to be added.
     * Checks if attributes added are in the correct format.
     * Allows for multiple subjects to be added, along with their grades and classes
     * attended.
     *
     * @param masterStudentList The list of all students.
     * @param in                The scanner object to read user input.
     * @param studentName       The name of the student if the user had entered it
     *                          before being prompted
     */
    public static void addStudent(ArrayList<Student> masterStudentList, Scanner in, String studentName) {
        String name;

        try {
            name = checkForEmptyName(masterStudentList, in, studentName);
        } catch (InvalidCharacterException e) {
            UI.printDivider();
            return;
        } 

        Student student = new Student(name);
        addSubject(in, student.getAttributes());

        int number = 0;

        // @@author Cryolian
        try {
            number = InputParsing.promptForPhoneNumber(in);
        } catch (NumberFormatException e) {
            UI.println("Non-number, invalid number or blank character found.");
            UI.println("Exiting the adding interface.");
            UI.printDivider();
            return;
        }

        //@@author ParthGandhiNUS
        assert number > 0 && number < 100000000 : NUMBER_IS_OUTSIDE_THE_ACCEPTABLE_RANGE;

        //@@author Cryolian

        try {
            StudentList.checkNameNumberPair(StudentList.masterStudentList, name, number);
            StudentList.checkNameNumberPair(StudentList.recentlyDeletedList, name, number);
            StudentList.checkNameNumberPair(StudentList.archiveList, name, number);
        } catch (NameNumberMatchException e) {
            UI.println("Student and Phone number pair found. If not found in the list, " +
                    "please restore or unarchive the student instead.");
            UI.printDivider();
            return;
        } catch (NullPointerException e) {
            UI.printNullPointerException();
            UI.printDivider();
            return;
        }

        //@@author tayponghee
        try {
            setAttributesForStudent(masterStudentList, in, student, number);
        } catch (Exception e) {
            UI.println("An error occurred while setting attributes for the student: " + e.getMessage());
            UI.printDivider();
        }
    }

    //@@author cryolian
    /**
     * Sets attributes for a given student, including phone number, gender, last payment date, and remarks.
     *
     * @param masterStudentList The list of all students.
     * @param in The Scanner object for user input.
     * @param student The student whose attributes are being set.
     * @param number The phone number to set for the student.
     */
    private static void setAttributesForStudent(ArrayList<Student> masterStudentList,
                                                Scanner in, Student student, int number) {
        student.getAttributes().setPhoneNumber(number);

        UI.promptForGender();
        student.getAttributes().setGender(InputParsing.readInString(in));

        student.getAttributes().setLastPaymentDate(InputParsing.readInDate(in));

        UI.promptForRemarks();
        student.getAttributes().setRemarks(InputParsing.readInString(in));

        //@@author tayponghee
        masterStudentList.add(student);
        LOGGER.log(Level.INFO, STUDENT_ADDED_SUCCESSFULLY);
        UI.printStudentAdded();
        UI.printDivider();
    }

    /**
     * Prompts the user to enter a non-empty name for a student and checks if it
     * already exists in the list.
     * If the name is empty or already exists, prompts the user again until valid
     * input is provided.
     *
     * @param masterStudentList The list of all students.
     * @param in                The scanner object to read user input.
     * @param studentName       The name of the student if the user had entered it
     *                          before being prompted
     * @return The valid non-empty name entered by the user.
     */
    public static String checkForEmptyName(ArrayList<Student> masterStudentList, Scanner in, String studentName)
            throws InvalidCharacterException {
        String name;

        while (true) {

            //@@author alalal47
            if (studentName == null) {
                UI.printStudentNamePrompt();
                name = in.nextLine().trim();
            } else {
                name = studentName.trim();
                studentName = NOT_EMPTY;
                
                //@@author tayponghee
                assert studentName != null;
            }

            if (name == null || name.isEmpty()) {
                UI.printEmptyNameMessage();
                UI.printDivider();
            } else {
                InputParsing.checkForSpecialCharacters(name);
                name = splitName(name);
                break;
            }

        }

        return name;

    }

    /**
     * Capitalizes the first letter of each word in a string.
     *
     * @param name The input string to capitalize.
     * @return The string with the first letter of each word capitalized.
     */
    public static String splitName(String name) {
        if (!name.isEmpty()) {
            StringBuilder result = new StringBuilder();
            String[] words = name.split("\\s");
            return capitaliseFirstLetters(words, result);
        }
        return name;
    }

    /**
     * Iterates through each word in the input array, capitalizes the first letter,
     * and converts every other letter to lowercase.
     *
     * @param words The array of words to capitalize.
     * @param result The StringBuilder object to store the capitalized words.
     * @return The string with the first letter of each word capitalized and every other letter in lowercase.
     */
    private static String capitaliseFirstLetters(String[] words, StringBuilder result) {
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    /**
     * Prompts the user to enter attributes for a student, including subject, grade,
     * and classes attended.
     * Continues to prompt the user until user enters blank to exit.
     *
     * @param in         The scanner object to read user input.
     * @param attributes The StudentAttributes object to store the attributes of the
     *                   student.
     */
    public static void addSubject(Scanner in, StudentAttributes attributes) {
        while (true) {
            //@@author blackmirag3
            System.out.print(SUBJECT_ENTER_NOTHING_TO_SKIP);
            String subject = readInString(in);
            assert subject != null;

            if (subject.isBlank() || subject.equals(InputParsing.DEFAULT_STRING_VALUE)) {
                UI.printNoSubjectsAdded();
                break;
            }

            try {
                StudentList.checkExistingSubject(attributes, subject, null);
            } catch (InvalidSubjectException e) {
                e.printMessage();
                return;
            }

            if (isValidSubjectResponse(in, attributes, subject)) {
                //@@author tayponghee
                return;
            }
        }
    }

    /**
     * Checks for a valid response from the user when prompted to add another subject and grade.
     *
     * @param in         The scanner object to read user input.
     * @param attributes The attributes of the student.
     * @param subject    The subject to be added.
     * @return True if the user chooses not to add another subject and grade, false otherwise.
     */
    private static boolean isValidSubjectResponse(Scanner in, StudentAttributes attributes, String subject) {
        double grade = Math.max(InputParsing.promptForGrade(in), 0);
        int classesAttended = promptForClassesAttended(in);

        SubjectGrade subjectGrade = new SubjectGrade(subject, grade, classesAttended);
        attributes.addSubjectGrade(subjectGrade);

        while (true) {
            UI.printAddSubject();
            String response = in.nextLine().trim().toLowerCase();

            if (response.equals(YES)) {
                break;
            } else if (response.equals(NO)) {
                return true;
            } else {
                UI.printInvalidResponse();
            }

        }
        return false;
    }

    /**
     * Checks the format of the input for the number of classes attended.
     * Prompts the user to enter a valid integer until one is provided.
     *
     * @param in The scanner object to read user input.
     * @return The valid number of classes attended.
     */
    public static int promptForClassesAttended(Scanner in) {
        while (true) {
            UI.printClassesAttendedPrompt();
            String classesAttendedInput = in.nextLine();

            if (classesAttendedInput.isBlank()) {
                return -1;
            }

            //@@author ParthGandhiNUS
            int classesAttended;
            try {
                classesAttended = Integer.parseInt(classesAttendedInput);
            } catch (NumberFormatException e) {
                //@@author tayponghee
                UI.printWrongNumberFormat();
                //@@author ParthGandhiNus
                UI.printDivider();
                classesAttended = promptForClassesAttended(in);
            }

            if (InputParsing.isValidClassesAttended(classesAttended)) {
                return classesAttended;
            }
        }
    }

}
