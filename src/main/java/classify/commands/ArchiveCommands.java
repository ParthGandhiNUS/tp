package classify.commands;

import classify.data.DataHandler;
import classify.student.Student;
import classify.student.StudentList;
import classify.ui.UI;
import classify.user.InputParsing;
import classify.user.NameNumberMatchException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchiveCommands {
    private static final Logger logger = Logger.getLogger(InputParsing.class.getName());

    //@@author blackmirag3
    /***
     * Prompts for student name to search in archive list
     * If student exists, this method removes student from archive list to add to master list
     * Writes archive and student information file in data directory
     *
     * @param masterList ArrayList of Students who are in master list
     * @param archiveList ArrayList of Students who are archived
     * @param name String for student's name
     * @param in Scanner to read user input
     */
    public static void unarchiveStudent(ArrayList<Student> masterList, ArrayList<Student> archiveList,
                                        String name, Scanner in) {

        Student student = getStudent(archiveList, name, in);

        if (student == null) {
            return;
        }

        //@@author Cryolian
        try {
            StudentList.checkNameNumberPair(StudentList.masterStudentList, name, student.getPhoneNumber());
            StudentList.checkNameNumberPair(StudentList.recentlyDeletedList, name, student.getPhoneNumber());
        } catch (NameNumberMatchException e) {
            UI.println("Existing student found with the same name and number");
            UI.printDivider();
            return;
        }
        
        //@@author blackmirag3
        archiveList.remove(student);
        masterList.add(student);

        assert !archiveList.contains(student);
        assert masterList.contains(student);
        UI.println("Unarchive successful.");
        logger.log(Level.INFO, "Unarchived " + student.getName());

        DataHandler.writeArchive(archiveList);
        DataHandler.writeStudentInfo(masterList);
    }

    /***
     * Prompts for student name to search in master student list
     * If student exists, this method removes student from master list to add to archive list
     * Writes archive and student information file in data directory
     *
     * @param masterList ArrayList of Students who are in master list
     * @param archiveList ArrayList of Students who are archived
     * @param name String for student's name
     * @param in Scanner to read user input
     */
    public static void archiveStudent(ArrayList<Student> masterList, ArrayList<Student> archiveList,
                                      String name, Scanner in) {

        Student student = getStudent(masterList, name, in);

        if (student == null) {
            return;
        }

        //@@author Cryolian
        try {
            StudentList.checkNameNumberPair(StudentList.archiveList, student.getName(), student.getPhoneNumber());
        } catch (NameNumberMatchException e) {
            UI.println("Existing student found with the same name and number");
            UI.printDivider();
            return;
        }

        //@@author blackmirag3
        masterList.remove(student);
        archiveList.add(student);

        assert archiveList.contains(student);
        assert !masterList.contains(student);
        UI.println("Archive successful.");
        logger.log(Level.INFO, "Archived " + student.getName());

        DataHandler.writeArchive(archiveList);
        DataHandler.writeStudentInfo(masterList);
    }

    private static Student getStudent(ArrayList<Student> archiveList, String name, Scanner in) {
        if (name == null || name.isBlank()) {
            name = Commands.promptName(in);
        }
        Student student = InputParsing.findStudentByName(archiveList, name, in);
        if (student == null) {
            UI.printStudentNotFound();
            logger.log(Level.INFO, "Student not found.");
            return null;
        }
        logger.log(Level.INFO, "found " + student.getName());
        return student;
    }
}
