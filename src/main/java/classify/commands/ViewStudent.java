package classify.commands;

import classify.student.Student;
import classify.student.StudentAttributes;
import classify.student.SubjectGrade;
import classify.ui.UI;
import classify.user.InputParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewStudent {

    private static final Logger logger = Logger.getLogger(ViewStudent.class.getName());
    private static final String NO_CLASSES_FOUND = "No classes was inputted for the corresponding subject.";

    //@@author tayponghee
    /**
     * Displays the details of a specific student.
     *
     * @param masterStudentList The list of all students.
     * @param in                The scanner object to read user input.
     * @param studentName       The name of the student if the user had entered it
     *                          before being prompted
     */
    public static void viewStudent(ArrayList<Student> masterStudentList, Scanner in, String studentName) {

        String name;

        //@@author alalal47
        if (studentName == null) {
            UI.printStudentNamePrompt();
            name = in.nextLine();
        } else {
            name = studentName;
        }

        //@@author blackmirag3
        assert name != null : "Student name cannot be null";

        //@@author tayponghee
        Student foundStudent = InputParsing.findStudentByName(masterStudentList, name, in);

        if (foundStudent != null) {
            showStudentInfo(foundStudent);
            int totalClassesAttended = getTotalClassesAttended(foundStudent);
            UI.printTotalClassesAttended(totalClassesAttended);
        } else {
            logger.log(Level.WARNING, "Student not found: " + name);
            UI.printStudentNotFound();
        }
    }

    //@@author blackmirag3
    /***
     * Prints all student info, including details and subjects
     * @param foundStudent
     */

    //@@author tayponghee
    public static void showStudentInfo(Student foundStudent) {
        String name;
        name = foundStudent.getName();
        logger.log(Level.INFO, "Viewing student details: " + name);

        UI.printDivider();
        UI.printStudentDetails();
        UI.printStudentName(name);
        UI.printStudentDetails(foundStudent);
        StudentAttributes attributes = foundStudent.getAttributes();
        showAttributes(attributes);
    }

    //@@author tayponghee
    /**
     * Calculates the total number of classes attended by the student across all subjects.
     * If the user does not specify the number of classes the student attended for that subject, i.e.
     * the user left it blank, the total classes attended would not be affected.
     *
     * @param student The student whose total classes attended are to be calculated.
     * @return The total number of classes attended by the student.
     */
    private static int getTotalClassesAttended(Student student) {
        int totalClassesAttended = 0;

        try {
            for (classify.student.SubjectGrade subjectGrade : student.getAttributes().getSubjectGrades()) {
                if (subjectGrade != null && subjectGrade.getClassesAttended() >= 0) {
                    totalClassesAttended += subjectGrade.getClassesAttended();
                }
            }
        } catch (NullPointerException e) {
            UI.println("A NullPointerException occurred while calculating total classes attended for student: "
                    + student.getName());
            UI.printDivider();
            return -1;
        }

        return totalClassesAttended;
    }

    /**
     * Displays the attributes of a student.
     *
     * @param attributes The attributes of the student to display.
     */
    public static void showAttributes(StudentAttributes attributes) {
        if (attributes != null) {
            List<SubjectGrade> subjectGrades = attributes.getSubjectGrades();
            checkIfSubjectGradesIsEmpty(subjectGrades);
        } else {
            UI.printNullAttributeError();
        }
    }

    /**
     * Checks if the list of subject grades is empty and performs appropriate actions.
     *
     * @param subjectGrades The list of SubjectGrade objects to check.
     */
    private static void checkIfSubjectGradesIsEmpty(List<SubjectGrade> subjectGrades) {
        if (!subjectGrades.isEmpty()) {
            printSubjectAttributes(subjectGrades);
        } else {
            UI.printEmptySubjectError();
        }
    }

    /**
     * Prints attributes of each SubjectGrade object in the provided list.
     *
     * @param subjectGrades The list of SubjectGrade objects to print attributes for.
     */
    private static void printSubjectAttributes(List<SubjectGrade> subjectGrades) {
        for (SubjectGrade subjectGrade : subjectGrades) {
            assert subjectGrade != null : "subjectGrade cannot be null";

            UI.printSubjectName(subjectGrade.getSubject());
            UI.printStudentGrades(subjectGrade.getGrade());

            if (subjectGrade.getClassesAttended() >= 0) {
                UI.printClassesAttended(subjectGrade.getClassesAttended());
            } else {
                UI.println(NO_CLASSES_FOUND);
            }
            System.out.println(" ");
        }
        UI.printDivider();
    }
}
