# User Guide

## Table Of Contents
1. [Introduction](#intro)
2. [Quick Start](#quick-start)
3. [Features](#features)<br>3.2. [Add new Deadline task](#add-deadline)<br>3.3. [Add new Event task](#add-event)<br>3.4. [Delete task](#delete)<br>3.5. [Mark task as done](#mark)<br>3.6. [List all tasks](#list)<br>3.7. [Search tasks](#search)<br>3.8. [Find due deadlines](#due)<br>3.9. [View commands supported](#help)<br>3.10. [Exit](#exit)
4. [FAQ](#faq)
5. [Command Summary](#command-summary)


<a name="intro"></a>

## 1. Introduction

 OrgaNice! is a command line based application that is used for managing tasks.
 The various types of tasks it can handle are:
 * **Deadline** Tasks - Contains the description, completion status and deadline timing details.
 * **Event** Tasks - Contains the description, completion status  and location details of the task.
 
 The application can add, delete tasks. It also provides methods to search for tasks 
  and has the ability of marking the tasks as done when they are completed. It also has the ability
  of storing data to a physical location on the computer, so that the tasks always remain in memory.
  
 As a secondary feature, the application allows the User to locate a study area based on different conditions
 The various conditions are:
 * **Name/Address/Faculty** - User can locate study areas by simply typing this criteria as strings
 * **Port Availability** - User can locate study areas by the availability of charging ports.
 * **Environment** - User can locate study areas by environment, which is strictly indoors or outdoors.
 * **Size Capacity** - User can locate study areas based on the capacity that it can facilitate.


<a name="quick-start"></a>

## 2. Quick Start
 
 * Ensure you have Java 11 or above installed in your Computer.
 * Download the latest OrgaNice!.jar from [here](https://github.com/GanapathySanathBalaji/duke/releases) and place it in an empty folder. 
 * Double-click on OrgaNice!.jar to open it.
 * If it fails do the following:
    * Open Command Prompt.
    * Navigate to the folder with the jar.
    * Type the following command:  java -jar iP.jar to run it.
 
 A text based UI should with appear with the following welcome message and the list of commands supported.
  
        Hello from
        _______/\\\\\_____________________________________________________/\\\\\_____/\\\____________________________________________/\\\____________
        ______/\\\///\\\__________________________________________________\/\\\\\\___\/\\\__________________________________________/\\\\\\\_________
        _____/\\\/__\///\\\____________________/\\\\\\\\___________________\/\\\/\\\__\/\\\___/\\\__________________________________/\\\\\\\\\_______
        _____/\\\______\//\\\___/\\/\\\\\\\____/\\\////\\\___/\\\\\\\\\_____\/\\\//\\\_\/\\\__\///_______/\\\\\\\\______/\\\\\\\\___\//\\\\\\\_______
        _____\/\\\_______\/\\\__\/\\\/////\\\__\//\\\\\\\\\__\////////\\\____\/\\\\//\\\\/\\\___/\\\____/\\\//////_____/\\\/////\\\___\//\\\\\_______
        ______\//\\\______/\\\___\/\\\___\///____\///////\\\____/\\\\\\\\\\___\/\\\_\//\\\/\\\__\/\\\___/\\\___________/\\\\\\\\\\\_____\//\\\_______
        ________\///\\\__/\\\_____\/\\\___________/\\_____\\\___/\\\/////\\\___\/\\\__\//\\\\\\__\/\\\__\//\\\_________\//\\///////_______\///_______
        ____________\///\\\\\/______\/\\\__________\//\\\\\\\\___\//\\\\\\\\/\\_\/\\\___\//\\\\\__\/\\\___\///\\\\\\\\___\//\\\\\\\\\\______/\\\_____
        ______________\/////________\///____________\////////_____\////////\//___\///_____\/////___\///______\////////_____\//////////______\///_____
        What is your name?
        ________________________________________________________________________________________________


After providing the User's name, the application will proceed to list out the supported features.
    
    ________________________________________________________________________________________________
         OrgaNice! Supports the following commands
         Please enter the keywords followed by the information shown in the brackets
         event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>
         ------------------------------------------- Create a new event
         deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>
         ------------------------------------------- Create a new deadline
         view -------------------------------------- View existing events
         priority_view ----------------------------- View existing tasks based on priority
         countdown --------------------------------- View existing tasks based on days left
         clear ------------------------------------- Delete all tasks
         search <keyword found in task> ------------ View existing task that contains the keyword
         delete <index number of task> ------------- Delete the task
         edit <index number of task> --------------- Edit the task
         schedule <number of task to be scheduled> - Schedule tasks
         help -------------------------------------- View List Of Commands Supported
         bye --------------------------------------- Terminate task interface
         study ------------------------------------- Enter Study Area search interface
         Notes:
         *All dates should follow YYYY-MM-DD format
         *All timing should follow 24 hour clock
    ________________________________________________________________________________________________

  * Some example commands you can try:
    * schedule {number of tasks}
    * view
    * search exam
    * bux -i 
  * Refer to Section 3, Features for details of each command.

<a name="features"></a>
## 3 Features 

<a name="taskFeatures"></a>

## 3.1 Tasks Features  <!-- tag sub features as 3.1.x -->

This feature allows you to manage the list of tasks.......

<a name="add-todo"></a>

### 1. Add new ToDo task
Adds a new ToDo task to the list of tasks.

### Usage

<a name="add-deadline"></a>

### 2. Add new Deadline task
Adds a new Deadline task to the list of tasks.

### Usage

#### `deadline description /by yyyy-mm-dd hhmm` - Adds a new Deadline task to the list of tasks


The command creates a new Deadline task with the description and timing details provided.
Note: The date and time should be provided in the correct format
Upon success a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`deadline assignment /by 2020-03-21 1700`

Expected outcome:
The Deadline task would be added to the list.
Upon success a response similar to the following one would appear:

    __________________________________________________________________________________________
     Got it. I've added this task:
        [D][ ] assignment (by: Mar 21 2020 1700 Hrs )
     Now you have 2 tasks in the list.
    __________________________________________________________________________________________



<a name="add-event"></a>

### 3. Add new Event task
Adds a new Event task to the list of tasks.

### Usage

#### `event description /at location` - Adds a new ToDo task to the list of tasks

The command creates a new Event task with the description and the location detail provided.
Upon success a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`event meeting /at school`

Expected outcome:
The ToDo task would be added to the list.
Upon success a response similar to the following one would appear:

    __________________________________________________________________________________________
     Got it. I've added this task:
        [E][ ] meeting (at: school)
     Now you have 3 tasks in the list.
    __________________________________________________________________________________________


<a name="delete"></a>

### 4. Delete task
Deletes the task at the specified index.

### Usage

#### `delete index` - Deletes task at specified index

The command deletes the task at the specifed index, if the index provided is valid.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`delete 2`

Expected outcome:
The task would be deleted from the list.
Upon success a response similar to the following one would appear:

    __________________________________________________________________________________________
     Noted. I've removed this task:
       [D][ ] assignment (by: Mar 21 2020 1700 Hrs )
     Now you have 2 tasks in the list.
    __________________________________________________________________________________________


<a name="mark"></a>

### 5. Mark task as done
Marks the task at the specified index as done.

### Usage

#### `done index` - Marks the task at specified index as done

The command marks the task at the specifed index as done, if the index provided is valid.
Upon success a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`done 1`

Expected outcome:
The task would be marked as done.
Upon success a response similar to the following one would appear:

    __________________________________________________________________________________________
     Nice! I've marked this task as done:
       [T][/] homework
    __________________________________________________________________________________________
 

<a name="list"></a>
   
### 6. List all tasks
List all current tasks stored.

### Usage

#### `list` - Lists all the tasks in the list

The command displays all the current tasks in a numbered list.
Upon success a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`list`

Expected outcome:
All tasks in the list would be displayed in a numbered list.
A response similar to the following one would appear:

    __________________________________________________________________________________________
     Here are the tasks in your list:
     1. [T][/] homework
     2. [E][ ] meeting (at: school)
    __________________________________________________________________________________________
    

<a name="search"></a>

### 7. Search tasks
Performs a linear search of all tasks stored in the list at the point of execution and list
all the tasks containing the keyword in their description in a numbered list.

### Usage

#### `find keyword` - Lists all matching tasks in the list containing the keyword 

The command displays all the tasks with description containg the keyword searched for in a numbered list.
Upon success a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`find meeting`

Expected outcome:
All matching tasks in the list would be displayed in a numbered list.
A response similar to the following one would appear:

    __________________________________________________________________________________________
     Here are the matching tasks in your list:
     1. [E][ ] meeting (at: school)
    __________________________________________________________________________________________   

<a name="due"></a>

### 8. Find due deadlines
Performs a linear search of all deadlines stored in the list at the point of execution and list
all those deadlines which are due on the specified date in a numbered list.

### Usage

#### `due yyyy-mm-dd` - Lists all deadline tasks which are due on the specified date

The command displays all the deadline tasks which are due on the specified date in a numbered list.
Upon success a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
`due 2020-03-25`

Expected outcome:
All matching deadlines in the list would be displayed in a numbered list.
A response similar to the following one would appear:

    __________________________________________________________________________________________
     Here are the deadline(s) due on the specified date:
     1. [D][ ] assignment (by: Mar 25 2020 1700 Hrs )
    __________________________________________________________________________________________ 


<a name="help"></a>
    
### 9. View commands supported 
The command displays the list of commands supported by the application.

### Usage

#### `help` - Displays list of commands supported 

The command displays the list of commands supported by the application.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 
`help`

Expected outcome:
The application would be exited successfully.
A response similar to the following one would appear:

    ________________________________________________________________________________________________
    	 OrgaNice! Supports the following commands
    	 Please enter the keywords followed by the information shown in the brackets
    	 event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>
    	 ------------------------------------------- Create a new event
    	 deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>
    	 ------------------------------------------- Create a new deadline
    	 view -------------------------------------- View existing events
    	 priority_view ----------------------------- View existing tasks based on priority
    	 countdown --------------------------------- View existing tasks based on days left
    	 clear ------------------------------------- Delete all tasks
    	 search <keyword found in task> ------------ View existing task that contains the keyword
    	 delete <index number of task> ------------- Delete the task
    	 edit <index number of task> --------------- Edit the task
    	 schedule <number of task to be scheduled> - Schedule tasks
    	 help -------------------------------------- View List Of Commands Supported
    	 bye --------------------------------------- Terminate task interface
    	 study ------------------------------------- Enter Study Area search interface
    	 Notes:
    	 *All dates should follow YYYY-MM-DD format
    	 *All timing should follow 24 hour clock
    ________________________________________________________________________________________________

<a name="studyArea"></a>

## 3.2 Study Area Search Feature

This feature allows you to search for study areas based on criteria that you desire. 

<a name="enterStudyArea"></a>
### 3.2.1 Entering Study Area Search Interface

To enter the Study Area search interface, you can enter 'study' in the main interface. You will then be 
guided to the study area search interface. 

### Usage

Example of usage: 
`study`

Expected Outcome:

    ________________________________________________________________________________________________
         Please enter the location for your desired study area.
         Enter "help" for a list of supported flags. Flags should
         only come after location, if a criteria for location is
         entered. When you are done with the search, enter "bye".
    ________________________________________________________________________________________________

<a name="studyAreaSearch"></a>
### 3.2.2 Start Search

You can start the search by entering the criteria desired. Supported criteria include name, address, faculty,
ports availability, environment and size capacity. For  name, address or faculty, you simply have to enter it
as a string. For other supported conditions, flags have to be used. 

Below are the supported flags: 
   * -s {size}  : To locate a study area based on the capacity that it can manage.
   * -p         : To locate a study area based on the availability of ports.
   * -i         : To locate a study area that are indoors.
   * -o         : To locate a study area that are outdoors.

Note: if name, address or faculty is specified, flags will have to precede either the name,address or faculty.

### Usage

#### Search by name, address or faculty 

Example of usage:
`bux`

Expected Outcome:

    ________________________________________________________________________________________________
         Here are the available study areas!
         __________________________________________________________
         Name: Opposite Town Green (Outside Starbucks)
         Address: 2 College Avenue West Education Resource Centre,
         Ground Level
         Faculty: Utown
         Port: true
         Indoor: false
         Maximum number of Pax: 4
         __________________________________________________________
         __________________________________________________________
         Name: Starbucks
         Address: 2 College Avenue West Education Resource Centre,
         Ground Level
         Faculty: Utown
         Port: true
         Indoor: true
         Maximum number of Pax: 5
         __________________________________________________________
         Please enter the location for your desired study area.
    ________________________________________________________________________________________________

#### Search by name, address or faculty and with flags

Example of usage:
`bux - o`

Expected Outcome:

    ________________________________________________________________________________________________
         Here are the available study areas!
         __________________________________________________________
         Name: Opposite Town Green (Outside Starbucks)
         Address: 2 College Avenue West Education Resource Centre,
         Ground Level
         Faculty: Utown
         Port: true
         Indoor: false
         Maximum number of Pax: 4
         __________________________________________________________
         Please enter the location for your desired study area.
    ________________________________________________________________________________________________


<a name="exit"></a>
  
### 10. Exit 
You use this command to exit the application. Before the actual application is exited the 
tasks currently in the list are stored in a file. This command is used for exiting the main interface and the
secondary study area search interface.

### Usage

#### `bye` - Exits the application 

The command when issued performs an exit.
Upon success a successful message similar to the one in the example would appear and the application would be exited.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 
`bye`

Expected outcome:
The application would be exited successfully.
A response similar to the following one would appear:

    __________________________________________________________________________________________
     Bye. Hope to see you again soon!
    __________________________________________________________________________________________

<a name="faq"></a>

## 4. FAQ
    Q: How to transfer the task list data from one computer to an other computer?
    A:      Just copy the "TaskList.txt" file which could be found at the same directory
        as the jar file and paste it to the location containing the jar file in the other
        computer. This should transfer the required data.

<a name="command-summary"></a>

## 5. Command Summary
1. `todo description` - Adds a new ToDo task to the list of tasks
2. `deadline description /by yyyy-mm-dd hhmm` - Adds a new Deadline task to the list of tasks
3. `event description /at location` - Adds a new ToDo task to the list of tasks
4. `delete index` - Deletes task at specified index
5. `done index` - Marks the task at specified index as done
6. `list` - Lists all the tasks in the list
7. `find keyword` - Lists all matching tasks in the list containing the keyword
8. `due yyyy-mm-dd` - Lists all deadline tasks which are due on the specified date
9. `help` - Displays list of commands supported 
10. `bye` - Exits the application