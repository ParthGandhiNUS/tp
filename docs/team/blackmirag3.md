# Siew Shui Hon's (blackmirag3) Project Portfolio Page

## Project: Classify

### Overview
Classify is a desktop-based CLI application used for Tuition Centres to allow for easier management of their enrolled students. Classify is the one-stop app that
all Tuition Centres can employ for ease of student management.

### Summary of Contributions

- **Code Contributed**
  * [blackmirag3's RepoSense](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=blackmirag3&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=blackmirag3&tabRepo=AY2324S2-CS2113-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)


- **Enhancements Implemented**
  * Feature: `Edit`
    * Added base feature to access students' attributes and details.
    * Implemented sub-features such as adding, removing or editing existing subjects.

  * Feature: `Archive` and `Unarchive`
    * Implemented archiving and unarchiving feature.
    * Implemented `DataHandler` class to manage reading and writing of archived students within a data file.

  * Non-features:
    * Implemented `SubjectGrade` class. 
    * Wrote `EditTest` class to test edit feature.
    * Implemented helper functions and exceptions re-used by the team, such as:
      * `findSubject` method which finds whether a subject exists under a student
      * `isValidGrade` method which validates input format for grade.
      * `InvalidSubjectException` exception which prevents duplicate subjects. Used by `AddSubject` and `EditSubject` classes.


- **Contributions to [UG](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/UserGuide.md)**
  * Wrote for `edit`, `archive`, `unarchive` features.
  * Finalised formatting in UG, such as standardising the layout under `Usage` section.


  
- **Contributions to [DG](https://github.com/AY2324S2-CS2113-T13-3/tp/blob/master/docs/DeveloperGuide.md)**
  * Wrote `EditStudent` and `ArchiveCommands` component
  * Wrote `Archiving/unarchiving a student` and `Editing a student's details` manual testing.
  * Created UML sequence diagram for 'EditStudent' and 'ArchiveCommands' component each.


- **Contributions to Team-Based tasks:**
  * Refactored/rewrote at least 300 LoC (authored by teammates) to improve code quality, such as for [input checking](https://github.com/AY2324S2-CS2113-T13-3/tp/commit/23f3ac553d243b9d31d80fdd05ff2ac3b3a2d57e) and [file IO](https://github.com/AY2324S2-CS2113-T13-3/tp/commit/932b51fbdb542b59f3ecdcaa1c04c65eda873ff1).
  * Established TP's current code organisation, such as refactoring project into respective packages `commands`, `data`, `ui` etc.
  * Maintained team's GitHub Project, such as updating status and priority of project items.
 

- **Review/mentoring contributions**
    * Actively reviewed and approved team's PRs, with some recent examples [here](https://github.com/AY2324S2-CS2113-T13-3/tp/pull/258) or [here](https://github.com/AY2324S2-CS2113-T13-3/tp/pull/246).


- **Contributions beyond project team**
    * Did [exploratory testing of T13-4's TP](https://github.com/orgs/AY2324S2-CS2113-T13-4/discussions/256) before their final release.