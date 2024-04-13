package classify.data;

import classify.encryption.DES;
import classify.commands.Commands;
import classify.student.Student;
import classify.student.StudentList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@@author blackmirag3
public class DataHandler extends Commands {
    //@@author ParthGandhiNUS
    private static final String DATA_DIRECTORY_PATH = "data/studentInfo";
    private static final String DATA_FILE_PATH = DATA_DIRECTORY_PATH + "/Student_Information.txt";
    private static final String ENCRYPTED_FILE_PATH = DATA_DIRECTORY_PATH + "/Encrypted.txt";
    private static final File STUDENT_INFO_FILE = new File(DATA_FILE_PATH);
    private static final File ENCRYPTED_FILE = new File(ENCRYPTED_FILE_PATH);
    private static final String KEY = "211313-3";
    //@@author blackmirag3
    private static final String ARCHIVE_DIRECTORY_PATH = "data/archive";
    private static final String ARCHIVE_FILE_PATH = ARCHIVE_DIRECTORY_PATH + "/student_archive.txt";

    //@@author ParthGandhiNUS
    /**
     * Function which is called to generate an arrayList "lines" which updates according to the users' inputs.
     * Calls the writeStudentInfoFile function to update Student_Information.txt
     * 
     * @param list ArrayList containing the current students
     */
    public static void writeStudentInfo(List <Student> list) {
        DES.decrypt(KEY,ENCRYPTED_FILE,STUDENT_INFO_FILE);
        DataWriter.writeStudentInfoFile(list, DATA_DIRECTORY_PATH, DATA_FILE_PATH);
        DES.encrypt(KEY,STUDENT_INFO_FILE, ENCRYPTED_FILE);
        STUDENT_INFO_FILE.delete();
    }

    /***
     * Saves master student list to Student_Information.txt
     * Calls the writeStudentInfoFile function to update Student_Information.txt
     */
    public static void writeStudentInfo() {
        DES.decrypt(KEY,ENCRYPTED_FILE,STUDENT_INFO_FILE);
        DataWriter.writeStudentInfoFile(StudentList.masterStudentList, DATA_DIRECTORY_PATH, DATA_FILE_PATH);
        DES.encrypt(KEY,STUDENT_INFO_FILE, ENCRYPTED_FILE);
        STUDENT_INFO_FILE.delete();
    }

    /**
     * This accesses Student_Information.txt and calls the restoreStudentList function
     *
     * @param list ArrayList to read data from txt file into
     * @throws IOException  When unable to get the Student_Information.txt file or has any input errors
     */
    public static void readStudentInfo(ArrayList<Student> list) throws IOException{
        System.out.println("Trying to load Student info");
        if (!ENCRYPTED_FILE.exists()) {
            DataWriter.createParentFileFolder(DATA_DIRECTORY_PATH);
            DES.encrypt(KEY,STUDENT_INFO_FILE, ENCRYPTED_FILE);
            STUDENT_INFO_FILE.delete();
        }
        DES.decrypt(KEY,ENCRYPTED_FILE,STUDENT_INFO_FILE);
        DataReader.initialiseData(list, DATA_FILE_PATH);
        DES.encrypt(KEY,STUDENT_INFO_FILE, ENCRYPTED_FILE);
        STUDENT_INFO_FILE.delete();
    }

    //@@author blackmirag3
    /**
     * writes student info arraylist into archive file and creates new archive file if one is not found
     *
     * @param list ArrayList containing the current students to write
     */
    public static void writeArchive(List<Student> list) {
        DataWriter.writeStudentInfoFile(list, ARCHIVE_DIRECTORY_PATH, ARCHIVE_FILE_PATH);
    }

    /**
     * This accesses archive.txt and fetches information of archived students
     * Updates list input with archived students
     *
     * @param list ArrayList to contain Students from archive.txt
     * @throws IOException  When unable to get the Student_Information.txt file or has any input errors
     */
    public static void readArchive(ArrayList<Student> list) throws IOException {
        System.out.println("Trying to load Student Archive.");
        DataWriter.createParentFileFolder(ARCHIVE_DIRECTORY_PATH);
        DataReader.initialiseData(list, ARCHIVE_FILE_PATH);
    }

    //@@author alalal47
    /**
     * This accesses Student_Information.txt and calls the emptyDataFile function.
     * Only used in cases of data corruption that cannot be resolved by the user.
     */
    public static void deleteStudentInfo() {
        DataWriter.emptyDataFile(DATA_DIRECTORY_PATH, DATA_FILE_PATH);
    }
}
