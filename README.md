# Experiment2

At the first place like the photo below we create Junit tests in Project Structure.

https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/1.png
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/2.png

Then we create test methods for functional methods we wanted like this:
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/3.png

Then We wrote a peice of code to test returnBook method and show its bug.
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/4.png

After the failure we fixed returnBook method so the tests passed like this:
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/5.png

The problem was because returnBook didn't remove the book has been returned from students list of book. This is how we fixed this method:
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/6.png

We fixed lenBook method bug like this after the tests failed.
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/7.png

Then for developing features with TDD, 1- we wrote tests that states the requirements for method searchStudents.
Then we complete this method to pass the requirements.
https://github.com/Software-Engineering-Lab-1402-1403/Experiment2/blob/main/Pics/8.png

Then we did the same thing for method searchBooks.

# Questions
## 1. 
Test-Driven Development (TDD) and Traditional Testing are two common approaches to software testing. Both methods have their own advantages and disadvantages and are better suited for certain types of projects.

The key difference between the two lies in when the tests are written:

### TDD:
Tests are written before any code is written.
### Traditional Testing: 
Tests are written after the code is written.
Comparison based on project type:

TDD is a better fit for projects that are:

Small to medium-sized: TDD can become time-consuming and challenging for large, complex projects.
Subject to changing requirements: TDD helps you adapt quickly to changes in requirements.
Require high quality: TDD helps you catch bugs early and ensure the quality of your code.
Traditional testing is a better fit for projects that are:

Large and complex: Traditional testing can be less efficient for small, simple projects.
Have stable requirements: Traditional testing isn't ideal for projects that require frequent code changes.
Limited in time and budget: TDD can be time-consuming and expensive, especially for projects with tight constraints.

## 2.
In the software development process, both the Development Team and the QA Team (Quality Assurance Team) play a role in software testing. However, each team typically focuses on specific categories of tests:

### Development Team:

Unit Testing: Unit testing involves checking the functionality of individual units of code, like functions or classes. These tests are written by programmers as part of the development process.
Integration Testing: Integration testing focuses on how different units of code interact with each other. These tests are performed by the development team before handing code over to the QA team.
### QA Team:

System Testing: System testing verifies the functionality of the entire system as a whole. The QA team performs these tests to ensure the system meets requirements and is free of defects.
Acceptance Testing: Acceptance testing is conducted by end-users or stakeholders to confirm the system fulfills their needs.

### Each test summary:

Unit Testing: Testing the functionality of individual code units.
Integration Testing: Verifying how different code units work together.
System Testing: Examining the functionality of the entire system.
Acceptance Testing: End-users or stakeholders confirm the system meets their needs.
