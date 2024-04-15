# Gandhi Parth Sanjay's Project Portfolio Page

## Project: Classify

Classify is a desktop application used for Tuition Centres to allow for easier management of their enrolled students. 
From allowing users to add new students to sorting them based on their last paid date, Classify is the one-stop app that
all Tuition Centres can employ for ease of student management. To use the app, users can interact with it using CLI.
Overall, the code base has more than 7000 Lines of Code, and is written in Java.

---

#### Given below are my contributions to the project:

**Feature: Data Writing to Student_Information.txt**
* Refers to the writing of data in Student_Information.txt in Classify
* Highlights: Creates a directory and file on your computer if it does not exist. Updates the Student_Information.txt file with all the students' attributes (eg. Name, Phone Number, Gender, Last Payment Date, All subject information, etc). The file is constantly overwritten when a command (eg. Add Student, Delete Student, etc) is used. There is a standardised format used to store all the data. Different Regex are used to differentiate the different types of data and to assist in data parsing (mentioned below).
* Justification: Since the data inputted by the user is what forms our "database" of students we need to constantly update our database with every change to ensure our "database" is updated.
<div style="page-break-after: always;"></div>

**Feature: Data Retrieval and Parsing from Student_Information.txt**
* Refers to the retrieval and parsing of retrieved data in Classify
* Highlights: All the data retrieved goes through a parser which uses 3 types of regex (```~~```, ```##```, and ```#~~#```). Each of the regex serves to break every line of Student_Text.txt into various domains. 
    * ```~~``` separates all the different identifiers of a student (eg. name, phone number etc).
    * ```##``` separates all the different attributes of a subject that the student is taking (eg. Subject name, Subject Grade, Classes Attended).
    * ```#~~#``` separates all the different subjects that a student is taking.
    This process is repeated for every line of code in Student_Information.txt while checking for duplicate entries of a student. All the data is then re-added to the masterStudentList everytime we run the Classify Application
* Justification: Different Regex allows for a much cleaner separation of the different types of information in the Student_Information.txt file. 

**Feature: Process (Text File)**
* Refers to the addition of a class of students via a text file. In that text file, students would be taking a common subject and having the same number of classes attended. This simulates batches of students in a tuition centre.
* Highlights: User can type ```Process```. After that, the user will be able to view all the text files in the folder labelled as InputFolder where they are allowed to add or remove text files. 
    * These text files need to be formatted according to the standard template given to ensure that the process functionality runs smoothly.
    * The user can then select the text file which they want to add to the masterStudentList. 
    * All students in the selected text file will be added to the masterStudentList. In this part of the functionality checks are put in place to see if a student taking this subject already exists in the system. 
    * If a student exists, then the system also performs a check to see if the same subject is already attributed to the student. 
    If true, then the systems skips this student and goes on to process the next student. 
    Otherwise this functionality either attributes the subject in this text file to the existing student or makes a new student with info about this subject and the students' phone number.
    * Just like the data parser, the process here has a separate fully functional parser which parses information a bit differently as compared to the data parser. In the process parser, the only regex used is ```~~``` to ensure that it is simple for users to make the text file for entering into the system. 
* Justification: Process is meant to be a one-stop fast and easy way for administrators to add students. The system already checks for matching students and matching subjects for every student which makes this functionality quite useful in real life. 
<div style="page-break-after: always;"></div>

---
**Code contributed:** [Link to Reposense contribution graph](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=ParthGandhiNUS&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

---

**Documentation:**
* [Contributions to UG](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/UserGuide.md):
    * Did the preface for the project. 
    * Wrote out the functionalities for Process Command 
    
        [Sample File](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/SampleFile.txt)
    
        [Format for writing text file](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/Text%20File%20Format%20Picture.jpg)
    * Made the command summary in Tabular form for easy referencing
    * Refactored and cleaned the UG
    * Made the table of contents for the UG, linking the relevant parts of the markdown file
* [Contributions to DG](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/DeveloperGuide.md):
    * Wrote out the workflow for Process and Data commands in DG
    * Made the table of contents for the DG
    * Assisted in the various UML Diagrams
    * Added manual testing cases for Process Command

---

**Contributions to Team-Based tasks:**
* Built the groundwork for Main.java and main input Parser which enables us to access different functionalities
* Cleared Issues and settled quite a few bugs in our application
* Handling of Pull Requests 
* Contributions to Junit tests
    * [TextFileHandlerTest](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/src/test/java/classify/textfilecode/TextFileHandlerTest.java)
    * [TextFileParserTest](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/src/test/java/classify/textfilecode/TextFileParserTest.java)
    * [TextFileReaderTest](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/src/test/java/classify/textfilecode/TextFileReaderTest.java)
    * [DataReaderTest](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/src/test/java/classify/data/DataReaderTest.java)
    * [DataWriterTest](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/src/test/java/classify/data/DataWriterTest.java)

---