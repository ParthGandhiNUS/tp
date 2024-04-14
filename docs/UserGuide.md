# User Guide for **Classify**

## Table of Contents
- [Preface](#preface)
- [Introduction](#introduction)
- [Quick Start](#quick-start)
- [Features](#features)
- [Usage](#usage) - Pressing the buttons below will lead you to the correct section.
  - [`Add`](#adding-a-student-add)
  - [`View`](#view-details-of-a-student-view)
  - [`Delete`](#delete-a-student-from-the-working-list-delete)
  - [`Edit`](#edit-details-of-a-student-edit)
  - [`Restore`](#restore-a-student-to-the-working-list-restore)
  - [`Undo`](#undo-a-delete-and-restore-the-deleted-student-to-the-working-list-undo)
  - [`List`](#display-the-list-of-students-list)
  - [`Sort`](#sort-the-list-of-students-sort)
  - [`Process`](#process-a-list-of-students-from-a-text-file-process)
  - [`Archive`](#move-a-student-from-the-master-list-to-the-archive-archive)
  - [`Unarchive`](#move-a-student-from-the-archive-back-to-the-master-list-unarchive)
  - [`Help`](#display-instructions-on-how-to-use-classify-help)
  - [`Bye`](#exit-classify-bye)
- [Command Summary](#command-summary)
- [FAQ](#faq)

---

<div style="page-break-after: always;"></div>

## Preface
With the increased competitiveness of cohorts in Singapore, tuition centres have become more prevalent than ever before. 

According to a **[newspaper article](https://www.straitstimes.com/singapore/education/families-spent-14b-on-private-tuition-for-kids-last-year-as-parents-fork-out)** in The Straits Times, billions of dollars are spent in the tuition industry in Singapore every single year. 

These are just the numbers in Singapore. If we go to other countries, the situation is much worse. In India, new tuition centres preparing students for competitive entrance exams like JEE and NEET spring up every single day.

In such a fast-growing market, it is important that these tuition centres use better and more efficient student management systems to increase efficiency and automation of manual laborious tasks.

These systems enable tutors and administrative staff to focus on more pressing issues and work on catering to every students' needs instead of being swamped with paperwork. 

---

<div style="page-break-after: always;"></div>

## Introduction

Classify is a student management system meant to assist administrative staff of private tuition centres. 

The product is capable of storing students, and generating outputs based on provided parameters, such as phone number, or subjects taken.

Within our program, a student can be stored with their 
- Subjects taken
- Number grades of those subjects
- Phone Number
- Gender
- Last Payment Date
- Remarks

We have determined these to be the attributes important to running a working tuition centre. Based on these attributes, our program also has functions to sort students based on subjects taken.

---

## Quick Start

1. Ensure that you have __Java 11 or above__ installed.
2. Download the provided jar file into an empty folder.
3. Open a terminal and change the working directory to the folder with the jar file.
4. Run it from the terminal using the following command:
```
java -jar ./Classify.jar
```
5. Run the command ```help``` within the program to get a quick view of the available commands.
6. Please do not edit the save files Student_Information.txt or student_archive.txt .

---
<div style="page-break-after: always;"></div>

## Features 

### - Add a student

Initialises the process of adding in a student. 

### - View details of a student

Prints out the details of a given student in the interface.

### - Edit details of a student

Initialises the process of editing both academic and non-academic details of a student.

### - Delete a student from the working list
Removes a student from the master list of students. 

### - Add a student to the archive
Removes a student from the master list of students and adds them to the archive.

### - Unarchive a student
Removes a student from the archive and adds them to the master list of students.

### - Produce a list of all the students who takes a subject

Displays a list of all the students with that associated subject taken in the tuition centre.
If user enters different letter cases from subjects stored, the system will still match strings regardless of letter case for user intuitiveness.

### - Produce a list of all students

Displays a list of all the students at the tuition centre with no other parameters shown.

### - Produce a list of all students with total classes attended

Displays a list of all the students with their total classes attended at the tuition centre.

### - Produce a list of students in the archive

Displays a list of all the students that have been moved to archive.

### - Produce a list of students that were recently deleted

Displays a list of all students who were recently deleted.

### - Produce a list of students with their phone numbers

Displays a list of all students with their phone numbers.

### - Sort the list lexicographically, from A to Z

Sorts the master list of students from A to Z. When the user types list, it will generate the updated sorted list.

### - Sort the list by total classes attended

Sorts the master  list of students from the lowest number of classes attended to highest. When the user types list, it will generate the updated sorted list.

### - Sort the list by latest fee payment date

Sorts the master list of students from the oldest date to the most recent. When the user types list, it will generate the updated sorted list.

### - Undo the most recent delete action

Adds in the most recently deleted student back into the runtime database.

### - Restore a specific deleted student

Finds a specific deleted student and adds it back into the runtime database.

### - Process a list of students from a text file

Enables users to add multiple students taking the same subject and having the same number of classes attended all at once.

### - Display help message

Prints a message with instructions on how to use the features of Classify.

### - Exit Classify

Exits the program.

---

<div style="page-break-after: always;"></div>

# Usage

**Please note that if any of the following characters are entered in any string prompts, `#, - and ~`, they will be replaced and your command may be deemed invalid.**

### Adding a student: `add`
Initialises an interface for adding a student and their relevant details to the database. Allows the user to do add or add [name]

Students of the same name can be added so long as they possess a different phone number. Students with the same phone number can be added so long as they have different names.

User is expected to add only student's name as registered in NRIC or passport. 

The first letter of the student's name will be capitalised, while the 2nd letter onwards will be lowercase, regardless of initial input.

However, if the name contains multiple parts, each corresponding first letter after every space will be capitalised as well.

Example:
- James wong bing xuan -> James Wong Bing Xuan
- james WONG BING XUAN -> James Wong Bing Xuan
- jaMeS WONG binG Xuan -> James Wong Bing Xuan

**Format:** `add` or `add NAME`

Depending on whether the user entered the student's name or not during the command, fields will be printed out in the terminal, awaiting a user input each time.

Please note that the user input NUMBER (shown below) must be an *8-digit number starting with 8 or 9*. 
Thus, please be informed and educated that our software only works in countries that have phone numbers that are 8 digits long and start with 8 or 9.
To be specific, this is referring to a city-state republic in South East Asia, that lies in the timezone GMT +8 in the Straits of Johor. 
Some may debate that our time zone is actually GMT+7.5 or GMT+7, but it was changed to facilitate business deals and decisions with other financial hubs in the region thanks to our capitalistic overlords.

Last payment date must be within a range from 1970-01-01 to the day after the current date. This is a buffer to account for situations when storing dates, such as for audit reasons.

<div style="page-break-after: always;"></div>

#### Example usage:
``` 
add wario

Subject (enter nothing to skip): 
SUBJECT

Current marks out of 100 (blank to skip) : 
100

Enter Classes Attended (blank to skip):
1

Do you want to add another subject and grade? (yes/no) 
no

Please input a valid Phone number: 
89718971
.
.
```

###  View details of a student `view`

Views a student's details. Allows the user to do view [name] or just view.

**Format:** `view` or `view NAME`

Depending on whether the user entered the student's name or not during the command, fields will be printed out in the terminal, awaiting a user input each time.
If user enters different letter cases from name stored data, the system will still match strings regardless of letter case for user intuitiveness.

How it works (cases for input):
- In the list: Stored as `James Wong`
- view James Wong -> James Wong
- view james wong -> james wong
- view JAMES WONG -> JAMES WONG
  * Regardless of what capitalisation the user uses for the name, the program will recognise that upper and lower cases should return the same student.

<div style="page-break-after: always;"></div>

#### Example usage:
``` 
view wario

Student details: 
Name: wario
Phone Number: 97655678
Gender: male
Last Payment Date: 12/12/2023
Remarks: Unknown
Subject: subject
Current marks out of 100: 100.0
Classes Attended: 1
```
For any student that exists within the programme's master, archive and recently deleted list, the user cannot add new students with a name-phone number pair that matches that of the existing student.

The following is an example of trying to add a new student that matches the name and phone number of an already existing student.

#### Example usage:
```
add melodie
Subject (enter nothing to skip):
No subjects added.
Please input a valid phone number:
Enter a non-number or blank to exit interface.
88888888
Student and Phone number pair found. If not found in the list, please restore or unarchive the student instead.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Delete a student from the working list `delete`
Deletes the student from the list. Allows the user to do delete [student] or just delete.

**Format:** `delete` or `delete NAME`

Depending on whether the user entered the student's name or not during the command, 
a field will be printed out in the terminal, awaiting a user input.

#### Example usage:
``` 
delete
Enter student name: 
wario
Student removed successfully!
```

### Edit details of a student `edit`
Edit a student's details and subjects. Allows the user to do edit [student] or just edit.

**Format:** `edit` or `edit NAME`

If user has not entered a name, they will be prompted to input a name.
Once programme received name input, the student master list will be searched for the name. Name search is not case-sensitive.

If the name input matches that of an existing student, edit mode will be entered for that student.
If 2 students with the same name is found, the user will be prompted to enter the desired student's phone number to select them.

In edit mode, a list of actions will be printed and user can choose from a list of actions to take.
The following actions (listed along with their indexes) can be executed:
- 1 Add new subject to student
- 2 Modify student's existing subject
- 3 Delete student's existing subject
- 4 Modify student's phone number
- 5 Modify student's remarks
- 6 Modify student's payment date
- 7 Modify student's gender

The user can enter the action's index to execute the respective action, e.g. user can input "1" to add new subject.

Each action has its own step by step prompts for user to follow, as seen in below.

#### Example usages:
```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Welcome to Classify!
What can I do for you today?
>> edit
Name of student to edit (blank to exit):
>> vincent
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Student details: 
Name: Vincent

Phone Number: 99999999
Gender: Unknown
Last Payment Date: 2024-04-08
Remarks: Unknown

No subjects and grades found for this student.
How would you like to edit student? Enter index (blank to exit):
1. Add subject
2. Modify subject
3. Delete subject
4. Modify phone number
5. Modify remarks
6. Modify payment date
7. Edit Gender.
>> 1
Subject (enter nothing to skip): PE
Current marks out of 100 (blank to skip) : 
>> 1
Enter Classes Attended (blank to skip): 
>> 10
Do you want to add another subject and grade? (yes/no)
>> no

```
If no student is found in the master student list, edit mode will not be entered and the programme will resume as per normal.


#### No student found to edit:
```
edit
Name of student to edit (blank to exit):
luigi
No student found to edit!
```

### Restore a student to the working list `restore`
Restores a student deleted in the current session. Allows the user to do restore [student] or just restore.

**Format:** `restore` or `restore NAME`

Depending on whether the user entered the student's name or not during the command, 
a field will be printed out in the terminal, awaiting a user input.

#### Example usage:
```
restore
Enter student name: 
mario
Student has been restored!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Undo a delete and restore the deleted student to the working list `undo`
Undoes the latest "delete student". Used by typing `undo`

**Format:** `undo`

#### Example Usage:
```
undo
Last delete undone!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

Note: This command does not undo changes from the `edit` command.

### Display the list of students `list`
Displays the list of all students, or students with a specified subject. 
The user can further specify if they would like to display the full student list, 
the list with the total classes attended, as well as the list of students in the archive or in the recently deleted list.

**Format:** `list`

Allows the user to specify a subject, then displays all students with that subject. 
If the field is left blank, students will be displayed regardless of the subjects they have.

The user can then select by index, from 5 additional options.
1. Full student list
2. List of students with total classes attended
3. List of students with phone number shown
4. List of students in archive
5. List of students in recently deleted
Alternatively, the user can choose to display either the students in the recently deleted list or the archive.

Do note that there is a difference between 0 and no classes attended found. If the program displays 0 classes attended,
it means that the user entered the field 0 when adding the student. 
If it says no classes found, it means the user skipped that field when adding the student.

#### Example usage:
```
list
Enter subject name (leave blank for all students):
math
Students with the subject "math":
- Toad - Classes Attended for math: 12
- Wario - Classes Attended for math: 5
- Mario - Classes Attended for math: 8
- Luigi - Classes Attended for math: 0
- Moyai - Classes Attended for math: 11
- Peach - No Classes Attended found for math
- Daisy - No Classes Attended found for math
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

list
Enter subject name (leave blank for all students):

Choose the type of list to display: (index only)
1. Full student list
2. List of students with total classes attended
3. List of students with phone number shown
4. List of students in archive
5. List of students in recently deleted
Enter your choice (1, 2, 3, 4 or 5):
2
List of students with total classes attended:
1.Toad - Total Classes Attended: 13
2.Wario - Total Classes Attended: 14
3.Mario - Total Classes Attended: 15
4.Luigi - Total Classes Attended: 16
5.Moyai - Total Classes Attended: 17
6.Peach - Total Classes Attended: 18
7.Daisy - Total Classes Attended: 19
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

list
Enter subject name (leave blank for all students):

Choose the type of list to display: (index only)
1. Full student list
2. List of students with total classes attended
3. List of students with phone number shown
4. List of students in archive
5. List of students in recently deleted
Enter your choice (1, 2, 3, 4 or 5):
3
List of students with phone numbers:
1.Toad - Phone Number: 91234567
2.Wario - Phone Number: 97654321
3.Mario - Phone Number: 81234567
4.Luigi - Phone Number: 87654321
5.Moyai - Phone Number: 88776655
6.Peach - Phone Number: 99887766
7.Daisy - Phone Number: 88997766
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

list
Enter subject name (leave blank for all students):

Choose the type of list to display: (index only)
1. Full student list
2. List of students with total classes attended
3. List of students with phone number shown
4. List of students in archive
5. List of students in recently deleted
Enter your choice (1, 2, 3, 4 or 5):
4
List of students in archive: 
1.Timothee Chalamet
Currently, there is 1 student in the list.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

list
Enter subject name (leave blank for all students):

Choose the type of list to display: (index only)
1. Full student list
2. List of students with total classes attended
3. List of students with phone number shown
4. List of students in archive
5. List of students in recently deleted
Enter your choice (1, 2, 3, 4 or 5):
5
List of students in recently deleted: 
1.Toad
2.Peach
3.Moyai
4.Mario
Currently, there are 4 students in the list.
```

### Sort the list of students `sort`
Sorts the list of students based on the following input. Allows the user to do sort [type] or just sort.

**Format:** `sort`, `sort name`, `sort classes` or `sort payment`

Depending on whether the user entered the student's name or not during the command, 
fields will be printed out in the terminal, awaiting a user input each time.

In the event the commands  **`sort name`**, `sort classes` or `sort payment` was typed, the program would immediately
go into the sort type.


#### Example usage:

```
sort
Sort by: (Choose index) or press enter to escape
1. Name (A to Z):
2. Total number of classes attended:
3. Date of last fee payment: 
1
List of Students:
1. Mario
2. Toad
3. Wario
Currently, there are 3 students in the list.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Sort complete!

sort payment
1.Toad - Date of last payment: 2015-10-21
2.Mario - Date of last payment: 2024-03-30
3.Wario - Date of last payment: 2024-03-30
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Sort complete!
```

### Process a list of students from a text file `process`
Reads a text file in the inputFolder folder located inside the data folder.

 **Format:** `process`, press enter, `filename` (without filetype) **or** `filename.txt` (with file extension)

The processed file will add the students into the masterStudentList with relevant attributes for subject name, grades, and classes attended. 

> **All other student attributes (eg. gender, last payment date, remarks, etc) must be updated by the user.**

Please make sure that the proper format for the input file is followed. Only one subject and class attended value should be present per text file. Otherwise, the program will read in the first subject and class attended, and apply it to all students present in the text file.

Any students with missing or invalid grades or phone number will be skipped.

> The text file which is being processed **MUST** follow the format shown here in the [SampleFile.txt](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/SampleFile.txt)
>
> You can change the subject name, classes attended, name, phone number and grades of the student. 
> When doing so, please follow the given format below:


##### An example is seen below:

![Text File Format](./Text%20File%20Format%20Picture.jpg)

```
Subject: CS2113
Classes Attended: 12
Luigi ~~ 98989898 ~~ 90.0
Daisy ~~ 98989888 ~~ 95.0
Mario ~~ 98988888 ~~ 98.0
Peach ~~ 98888888 ~~ 95.0
Tai Lung ~~ 90909090 ~~ 99.0
```

#### Different types of Processing Possible:

##### Without File extension:
```
process
Current Files in your Input Folder:
1. SampleFile.txt
2. mathclass.txt
3. scienceclass.txt

Please enter the exact name of the file you'd like to process:
mathclass                                                   <---
Fetching the data from mathclass.txt.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

##### With File extension:
```
process
Current Files in your Input Folder:
1. SampleFile.txt
2. mathclass.txt
3. scienceclass.txt

Please enter the exact name of the file you'd like to process:
scienceclass.txt                                            <---
Fetching the data from scienceclass.txt.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
### Move a student from the master list to the archive `archive`
Adds a student to the archive and removes them from the master list.

**Format:** `archive`, `archive NAME`

Depending on whether the user entered the student's name or not during the command,
a field will be printed out in the terminal, awaiting a user input.

For any archived student, the user will be unable to add a student with the same name and contact number pair as the archived.


#### Example usage:
```
archive wario
Archive successful.
```

The user can then view currently archived students using the `list` command.

### Move a student from the archive back to the master list `unarchive`
Removes a student from the archive and adds them back to the master list.

**Format:** `unarchive`, `unarchive NAME`

Depending on whether the user entered the student's name or not during the command,
a field will be printed out in the terminal, awaiting a user input.

The user can then view currently archived students using the `list` command.

#### Valid student in archive:

```
unarchive wario
Unarchive successful.
```

#### Invalid student:

```
unarchive yeeter
No student found!
```
If a student that exists in the archive data file matches the name and phone number of an already existing student,
the archived student will not be loaded into the archive list and will be overwritten subsequently.


### Display instructions on how to use Classify `help`
Prints instructions which detail how to use all the features of Classify.

**Format:** `help`

#### Example usage:
```
help
add
    Adds a student to the student list,
    expects a name, grade and lessons attended
    e.g. add [name]

edit
    Edits a students details, expects a name,
    can be used directly with a name
    e.g. edit [name]

view
    Views a students details, expects a name,
    can be used directly with a name
    e.g. view [name]

delete
    Deletes a student from the student list,
    expects a name,
    can be used directly with a name
    e.g. delete [name]

restore
    Restore a student deleted within the
    current session, expects a name,
    can be used directly by restore [name].

undo
    Restores the last student deleted
    in the current session.

list
    Displays the list of all students
    Currently available types:
    Whole student list
    With total classes attended
    With phone number
    The archived list
    The recently deleted list
    By certain subject only

bye
    Exits Classify

sort
    Sorts the student list by the
    input parameter, expects an attribute
    to sort by,
    can be used directly by sort [type].
    Currently available types:
    Name
    Classes
    Payment

archive
    Removes the specified student from
    the list and archives them,
    expects a name, can be used directly by
    archive [name].

unarchive
    Removes the specified student from the
    archive and adds them to the list,
    expects a name, can be used directly by
    unarchive [name].

process
    Processes a text file containing
    a list of students
    taking the same subject and the
    same number of classes.

help
    Prints this help message
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

### Exit Classify `bye`
Exits the Classify program.

**Format:** `bye`

#### Example usage:
```
bye
Hope you've had a productive day. See you again! Goodbye!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
---

<div style="page-break-after: always;"></div>

## Command Summary
This section provides a quick overview of all the commands used in our Classify.


| Command                                       |Description| View Command|
|-----------------------------------------------|--|--|
| **General**                                   | |
| `add <student>`                               | - Adds a student into the list. <br> - If the name of the student is not specified in the initial command, <br> the program will prompt the user for the name.|[Add](#adding-a-student-add)|
| `view <student>`                              |Views a students details. <br> If the name of the student is not specified in the initial command, the program will prompt the user for the name.|[View](#view-details-of-a-student-view)|
| `delete <student>`                            |Deletes the student from the list. <br> If the name of the student is not specified in the initial command, the program will prompt the user for the name.|[Delete](#delete-a-student-from-the-working-list-delete)|
| `edit <student>`                              |Allows the user to edit the details of the student. <br> If the name of the student is not specified in the initial command, the program will prompt the user for the name.|[Edit](#edit-details-of-a-student-edit)|
| **Listing**                                   | |
| `list`, press enter, <br>  `<subject>`          |Displays the list of students that has taken that subject.|[List](#display-the-list-of-students-list)|
| `list`, press enter, <br> press enter, `<1>`    |Displays the list of students that is registered in the tuition centre.|[List](#display-the-list-of-students-list)|
| `list`,  press enter, <br> press enter, `<2>`   |Displays the list of students that is registered in the tuition centre with the total number of classes taken.|[List](#display-the-list-of-students-list)|
| `list`, press enter, <br> press enter, `<3>`    |Displays the list of students that is registered in the tuition centre with their phone numbers beside their names|[List](#display-the-list-of-students-list)|
| `list`, press enter, <br> press enter, `<4>`    |Displays the list of students who were archived.|[List](#display-the-list-of-students-list)|
| `list`, press enter, <br> press enter, `<5>`    |Displays the list of students who were recently deleted from the master list.|[List](#display-the-list-of-students-list) |
| **Sorting**                                   | |
| `sort <name>`                                 |Sorts the list lexicographically. <br> If the word `name` is not specified in the initial command, the program will prompt the user for an appropriate flag.|[Sort](#sort-the-list-of-students-sort)|
| `sort <payment>`                              |Sorts the list by the last fee payment date of a student. <br> If the word `payment` is not specified in the initial command, the program will prompt the user for an appropriate flag.|[Sort](#sort-the-list-of-students-sort)|
| `sort <classes>`                              |Sorts the list by the number of classes a student has attended. <br> If the word `classes` is not specified in the initial command, the program will prompt the user for an appropriate flag.|[Sort](#sort-the-list-of-students-sort)|
| **Process Text File**                                | |
| `process`, press enter,<br>`<text_file_name>` | Processes a text file containing a list of students taking the same subject and having attended the same number of lessons. <br> Adds all of them into the current list with their individual grades for the subject. <br> Will need to manually input their other attributes (eg. phone number, gender, etc) |[Process](#process-a-list-of-students-from-a-text-file-process)|
| **Archiving**                                 | |
| `archive <student>`                           |Archives specified student. Removes student from current list and adds student to archive.|[Archive](#move-a-student-from-the-master-list-to-the-archive-archive)|
| `unarchive <student>`                         |Unarchives specified student. Moves student from archive to current list.|[Unarchive](#move-a-student-from-the-archive-back-to-the-master-list-unarchive)|
| **Recently Deleted**                          | |
| `undo`                                        |Undoes the last deleted entry.|[Undo](#undo-a-delete-and-restore-the-deleted-student-to-the-working-list-undo)|
| `restore <student>`                           |Restores the student from the current session|[Restore](#restore-a-student-to-the-working-list-restore)|
| **Others**                                    | |
| `help`                                        |Generates the list of commands.|[Help](#display-instructions-on-how-to-use-classify-help)|
| `bye`                                         |Terminates the program.|[Bye](#exit-classify-bye)|

---

<div style="page-break-after: always;"></div>

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Plug out the corresponding drive from the computer you would like to transfer from, and connect it to either the SATA or m.2 port of the computer you would like to transfer to. Please make sure to reinstall any existing drivers to ensure maximum compatibility.

**Q**: How do I transfer my data to another computer **without** removing any components?

**A**: In the jar directory (folder containing jar file), data is stored in the "data" folder (./data). You can import the contents within this data directory to that of the jar directory on the new computer.

**Q**: What inputs are not allowed?

**A**: The inputs that are banned (which are used for file saving) are `#` and `~`, and in all cases except for dates, `-`. 

**Q**: (Follow up from above) Why are other special characters not banned?

**A**: Due to the ever-changing climate of what is considered a name (and more), we have limited the bans to 3 special characters above only. In the event your name or other identification metrics contains `#`, `~` or `-`, we seek for your understanding.

**Q**: What happens if my data file gets corrupted?

**A**: We recommend manually looking through the data file and rectifying any errors, or by running Classify with a corrupted data file, the prompts on screen will guide you to delete all data in the file to restore Classify to a working state.


