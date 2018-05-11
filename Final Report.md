# BSc (Hons) Computer Science and Software

# Engineering

# University of Bedfordshire

# Devaka Devinda Kumarasinghe

# 1723149

# Recycling Machine Assignment

## Comparative Integrated Systems

## May 2018


## Abstract

Pollution has been a major concern in the 21st century, is it poisoning our waters, land,
animals and our own wellbeing. The world is moving towards a sustainable approach in
every aspect, governments and various organisation around the world have started to
encourage people to think more sustainably. Recycling Inc is a company that allows people
to recycle items in return for cash, this concept encourages people to recycle items without
letting them contribute to pollution. This report will look into the development of the system
used by Recycling Inc. to carry out its operation effectively from different geographical
locations.


- Abstract
- Introduction
- Planning
- Requirement Gathering
   - Functional Requirements
      - Recycling Machine Functionality
      - Engineer Functionality
      - Head Office Function Functionality
   - Non-functional Requirements
- System Design
   - Use Case
- Implementation
   - Recycling Machine
   - Security and Authentication
   - Authentication Process
   - Two Factor Authentication
   - XML-RPC Implementation
   - RMI Implementation
- Testing
   - Functional Testing
         - Test Case:
         - Test Case:
         - Test Case:
- Evaluation
      - Recycling Machine Functionality
      - Engineer Functionality
      - Head Office Function Functionality
      - Non-functional Requirements
- Conclusion
- References


## Introduction

This report looks into the development of the Recycling Inc system, furthermore, it will outline
the tasks carried out at different stages of the development planning, design and
implementation. Later the report will cover the testing carried out to check the standard and
the reliability of the program.

## Planning

The project is planned to be concluded in a time span of 12 weeks. From the 5th of
February, 2018 to the 7th of May, 2018.
Figure 1 is the Gantt chart of the project.
Figure 1


## Requirement Gathering

### Functional Requirements

#### Recycling Machine Functionality

```
● Deposit Items
● Undo added item
● Print Receipt
● Clear the screen
● Log all events
● Keep track of statistics
● Reset on inactivity
```
#### Engineer Functionality

```
● Empty the Recycling Machine
● View Stats
```
#### Head Office Function Functionality

```
● View Overall Statistics
● Turn off a Recycling Machine remotely
● Create new user accounts
● Update the value of items in the system
```
### Non-functional Requirements

```
● Connect 25 recycling machines to the system
● Additional Level of Security for all users
● Head office and Recycling machine communicate using XML-RPC and RMI
```

## System Design

### Use Case

Figure 2 is the Use Case diagram, consists of 3 types of users.
Figure 2


## Implementation

### Recycling Machine

This is the acts as the interface of the system to the users, and these will be placed in
different geographical locations. Users are able to deposit items such as Cans, Crates,
Plastic Bottles, Glass Bottles, Paper bags and Polythene Bags, they also have the ability to
clear the screen and undo the last item they have added. While the user is adding the items,
the current weight and the size of items inside the machine at that moment is shown as a
percentage against the maximum capacity of the machine. The user can also view the total
value of items as they are being added, a receipt could be viewed upon the completion of
adding items. This receipt will be displayed on the machine, but no printout will be issued as
it is against the code of Recycling Inc.
Figure 3 shows the Graphical User Interface of the Recycling Machine.
Figure 3


Figure 4 shows the GUI of the Recycling Machine after a receipt has been printed on the
screen.
Figure 4
Figure 5 shows the GUI for the Engineer, to get this interface the Settings icon on the
Recycling machine should be clicked and identity should be validated.
Figure 5


GUI of the Head office Consists of 3 tabbed panes, Connected Machines, Usage Summary
and Administration. Figure 6 shows the Connected Machines tab of the Head Office GUI
Figure 6
Figure 7 shows the Usage Summary tab, which shows the details of items deposited broken
down by category of the item.
Figure 7


The head office has the ability to change the prices in the entire system. Figure 8 shows the
GUI that allows the Head Office Admin to changes prices of the system.
Figure 8

### Security and Authentication

Invasion of unauthorised users into the system can cause a lot of damage not only to the
system but the company as well. Security of the system is considered to be a top-level
priority, especially since this system deals with funds. There are two types of users that can
make critical changes in the system Engineers and Head Office Admins, these users need to
log in prior to making any changes in the system. User account creation can only be done
through the Head Office.


Figure 9 shows the login for the Head Office admins
Figure 9

### Authentication Process

All the user credentials are managed in the Head Office under passwordmanager.java. Any
login attempt would be sent to this class and is validated. Even though the username and
the password are correct, the second layer of security restricts entry for unauthorised users.
Figure 10 shows the window that prompts the user for a Two Factor Authentication Code
after the Username and Password have been validated.
Figure 10


### Two Factor Authentication

An extra layer of security is mandatory for all users, Two-factor authentication is enabled for
every user upon the creation of the user account. A third-party Authentication application
(eg. Google Authenticator, LastPass) is required for this process. (GitHub, 2018)
Figure 11 shows the GUI used to create a new user.
Figure 11
Figure 12 shows the window that appears for the activation of Two Factor Authentication.
Figure 12


Once the QR code is scanned through a 3rd-party Authentication application, there will be a
6 digit code showing at any given time. Figure 13 shows the code being displayed inside the
Google Authenticator app.
Figure 13


### XML-RPC Implementation

For the communication of the Head Office and the Recycling Machines, XMLRPC has been
implemented into the system.
Figure 14 shows a code snippet, this sends a XMLRPC request to the server placed in the
Head office.
Figure 14
Figure 15 shows the code snippet that starts the XMLRPC server on the Recycling Machine.
Figure 15


Figure 16 shows the code snippet that starts the XMLRPC server on the Head Office.
Figure 16
When the prices are updated from the Head Office, it is communicated using XMLRPC.
Figure 17 shows the code snippet sending prices to the Recycling Machines through
XMLRPC.
Figure 17


### RMI Implementation

RMI was also implemented into the system for the communication of the Head office and
Recycling Machines.
Figure 18 and Figure 19 shows two code snippets of the implementation of RMI into the
Head Office.
Figure 18
Figure 19


## Testing

### Functional Testing

Test Case: 1
Description: Testing the Recycling GUI
**Step Action Expected Result Status**
1 Click Can
Click Can
Click Paper Bag
Click Receipt
System prints a
receipt on the Text
Area and updates
Stats
Passed
2 Click Can
Click Clear
Click Receipt
System prints an
error
Passed
3 Click Paper Bag
Click Can
Click Undo
Click Receipt
System prints a
receipt for only for a
Paper Bag
Passed
Test Case: 2
Description: Testing the Engineer Login
**Step Action Expected Result Status**
1 Click Login No change Passed
2 Enter a correct Username and
Wrong Password
Click Login
Show error Passed
3 Enter the Wrong Username and
Password
Click Login
Show error Passed
4 Enter valid username and
Password
Click Login
Enter wrong two-factor code
Show error Passed


5 Enter valid Username
Enter a password from another
user
Click Login
Show error Passed
6 Enter valid username and
Password
Click Login
Enter the correct two-factor code
Get access to
Engineer GUI
Passed
Test Case: 3
Description: Testing the Head Office GUI
**Step Action Expected Result Status**
1 Click Refresh Show Connected Machines Passed
2 Click Option Show Error Passed
3 Type Location Name
on Text field
Click Option
Show Error Passed
4 Type wrong IP
Click Option
Show Error Passed
5 Type a correct IP
Click Get Number of
items
Get the actual number of items
in the Recycling Machine
Passed
6 Type a correct IP
Click Turn Off
Machine
Recycling Machine shuts down Passed
7 Click Update Prices
Type “45” for Cans
Click Update
Click No
~~
(on Recycling
Machine)
Click Can
Click Receipt
Value of a can wouldn’t be
changed to 45
Passed


```
8 Click Update Prices
Type “80” for Cans
Click Update
Click Yes
~~
(on Recycling
Machine)
Click Can
Click Receipt
Value of Can would be 80 Passed
9 Click Shut down
System
All Recycling Machines Shut
down
Head office Shuts Down
Passed
```
## Evaluation

#### Recycling Machine Functionality

```
Deposit Items Available and Working
Undo added item Available and Working
Print Receipt Available and Working
Reset on inactivity Available and Working
Keep track of statistics Available and Working
Log all events Available and Working
Clear the screen Available and Working
```
#### Engineer Functionality

```
Empty the Recycling Machine Available and Working
View Stats Available and Working
```

#### Head Office Function Functionality

```
View Overall Statistics Available and Working
Turn off a Recycling Machine remotely Available and Working
Create new user accounts Available and Working
Update the value of items in the system Available and Working
```
#### Non-functional Requirements

```
Connect 25 recycling machines to the
system
Available and Working
Additional Level of Security for all users Available and Working
Head office and Recycling machine
communicate using XML-RPC and RMI
Available and Working
```
## Conclusion

The delivered system enables people to deposit items into the Recycling Machine, in return
cash is given. These Recycling machines are effectively located all over the country and use
XML-RPC and RMI technologies for communication between the systems. Head office of
Recycling Inc. has the capability to monitor the entire operation, each Recycling Machine
has an allocated engineer who is responsible for emptying/resting the machine. Admins at
the Head office and the Engineers need to log in prior to making any changes in the system,
all the user accounts are protected with Two-Factor Authentication. The report discussed the
all the stages of the Software Development Life Cycle of this system, finally, the system was
tested and proved to have all the use cases covered as planned. The system has been
developed and implemented to meet the requirements of Recycling Inc, which is catering to
a massive global problem.


## References

#### GitHub. (2018). ​ j256/two-factor-auth ​. [online] Available at:

https://github.com/j256/two-factor-auth [Accessed 13 Apr. 2018].



