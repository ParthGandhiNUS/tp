package classify;

import classify.data.DataHandler;
import classify.student.StudentList;
import classify.textfilecode.TextFileHandler;
import classify.ui.UI;
import classify.user.InputParsing;
import classify.user.UserInput;
import java.io.IOException;
import java.util.Scanner;

public class Classify {
    public static Scanner in = new Scanner(System.in);
    private static final String INPUT_TEXT_FILE_DIRECTORY = "./data/inputFolder";

    /**
     * Main entry-point for the Classify application.
     * 
     * @param args          Input arguments when running the program.
     * @throws IOException  Thrown when error reading file.
     */
    public static void main(String[] args) throws IOException {
        //@@author ParthGandhiNUS
        DataHandler.readStudentInfo(StudentList.masterStudentList);
        DataHandler.readArchive(StudentList.archiveList);

        //@@author ParthGandhiNUS
        TextFileHandler.createTextFileDirectory(INPUT_TEXT_FILE_DIRECTORY);
        UI.printWelcomeMessage();
        
        // Takes in input from the user, and processes input to determine if it contains a command and a name   
        String[] userCommand = null;

        // Set up polling for the first word input by the user.
        // If user's first word is "bye", will exit the while loop.
        while (userCommand == null || !(userCommand[0].equals("bye"))) {
            UI.printSubsequentUserPrompt();
            userCommand = UserInput.processInput(in.nextLine());
            InputParsing.parseUserCommand(userCommand, StudentList.masterStudentList, StudentList.recentlyDeletedList,
                    StudentList.archiveList, in);
            DataHandler.writeStudentInfo();
            DataHandler.writeArchive(StudentList.archiveList);
        }
    }
}
