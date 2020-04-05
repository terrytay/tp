
[comment]: # (@@author GanapathySanathBalaji)

<H1> GanapathySanathBalaji - Project Portfolio </H1>
  
# Project: OrgaNice!

##  Overview

  OrgaNice! is a command line based application that can help academics with scheduling their tasks and keeping track of them. It also has additonal features such as note taking and finding study areas within NUS, to help academics.

## Summary of Contributions

### Code Contributed
Link : [RepoSense Dashboard](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#=undefined&search=ganapathysanathbalaji)

### Enhancements implemented:
* **Major Enhancement:**  added the ability to **auto schedule** tasks based on the user's requirements
	* What it does: It allows the user to auto generate a schedule based on their requirements and add it to the list of tasks tracked by the application for later usage.
	* Justification: This feature improves the product significantly as a user can now automate the process of schedule creation, which might be hard to do manually for a large number of tasks.
	* Highlights: This feature couldn't use the task class used to store generic tasks. Also, modifying it to make it suitable for this feature would have complicated our previous code in a lot of places. Hence, implementation was a bit challenging as the new objects created had to be designed to be able to easily interact with pre-existing classes. The implementation of the algorithm was a bit challenging too.
	* Credits: The EDF (Earliest Deadline First) algorithm was used to implement the task scheduler. The current implementation doesn't support task pre-emption and hence the tasks are run to completion, before the other tasks get a chance to run.
* **Major Enhancement:**  added support for prioritized tasks and the ability to view tasks sorted by their priority
	* What it does: It allows user's to assign priority based on a task's importance when it is created. To provide flexibility, we allow the user to provide any integer value for the priority field. The user can also view tasks sorted based on their priorities.
	* Justification: This feature improves the product significantly as a user can now view the important tasks first and finish them before moving on to the less important tasks.
	* Highlights: Since, this was a feature which was implemented at the very begining, the implementation wasn't hard. However, this increased the complexity of code written based on this feature.
* **Minor Enhancement:** added a feature that allows the user to view the list of tasks sorted based on the date's along with the number of days left.
* **Minor Enhancement:** added a feature that allows the user to edit the details of various tasks directly which saves the user from manually deleting and adding a new task.
* **Contributions to documentation:**
	*  Documented the majority of the features (3.1 to 3.12, 3.15 to 3.17).
	* Documented the command summary for the main features of OrgaNice!.
	* Documented the various formats (for time, date) used for commands (Formats Used section).
* **Contributions to the DG:**
	*  Documented the architecture section, Task component and made their respective UML diagrams.
	* Documented the implementation for scheduling tasks, along with one main sequence diagram and three sub diagrams used as reference frames in the main diagram.
	* Documented a few user stories.
* **Contributions to  team-based tasks :**
	* Managed the release of v1.0 and v2.0.
	* Refactored code and created seperate parser and command classes.
	* Added user stories to the DG.
	* Maintained the issue tracker for a significant amount of time and handled all the issues/bugs raised during the PE-Dry run.
* **Review/mentoring contributions:**
	* Reviewed the following PR's: 
		[#133](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/133), [#127](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/127), [#124](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/124), [#117](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/117), [#112](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/112), [#95](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/95), [#67](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/67), [#65](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/65), [#41](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/41)
	* Helped team by changing the runtest.bat and runtest.sh files to decrease the number of steps required to run the tests.
* **Contributions beyond the project team:**
	* I posted one reponse to [Issue#21](https://github.com/nus-cs2113-AY1920S2/forum/issues/21) on the main forum.
	* Reported 19 bugs during the [PE Dry Run](https://github.com/GanapathySanathBalaji/ped/issues).

* **Contributions to the User Guide (Extracts)**:

		The sections I contributed to in the user guide are as follows. They showcase my ability to write documentation targeting end-users.

## 3 Features 


[comment]: # (@@author GanapathySanathBalaji)

<a name="add-deadline"></a>

### 3.1. Add new Deadline task
Adds a new deadline task to track a task which needs to be finished before a specific date.

#### Usage

#### `deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>` - Adds a new Deadline task to the list of tasks

The command creates a new Deadline task with the description, date, due time and priority value provided.
Note: The date and time should be provided in the correct format as mentioned [here](#formats).

Upon success a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

#### Example of usage: 
The following adds a Math assignment as a deadline task which is due on 04-05-2020 at 6 pm with a priority value of 2.

`deadline Math assignment /d 2020-05-04 /t 18:00 /p 2`

#### Expected outcome:
The Deadline task would be added to the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
    	 A new task with the following information has been added.
    	 [D][PENDING] math assignment is due on May 4 2020 at 18:00
    	 with priority 2
    ________________________________________________________________________________________________


<a name="add-event"></a>

### 3.2 Add new Event task
Adds a new deadline task to track a task which needs to be finished before a specific date.

#### Usage

#### `event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>` - Adds a new Event task to the list of tasks


The command creates a new Event task with the description, date, start time, end time and priority value provided.
Note: The date and time should be provided in the correct format as mentioned [here](#formats).

Upon success a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

#### Example of usage: 
The following adds a Team Meeting which is set to take place on 06-05-2020 from 9 am to 12 pm with a priority value of 3, as an event to the list of tasks.

`event Team Meeting /d 2020-06-06 /s 09:00 /e 12:00 /p 3`

#### Expected outcome:
The Deadline task would be added to the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         A new task with the following information has been added.
         [E] Team Meeting at Jun 6 2020 from 09:00 to 12:00 with
         priority 3
    ________________________________________________________________________________________________

<a name="delete"></a>


### 3.3. Delete task
If a task is done and you want to remove it from the list this command could be used. It deletes the task at the specified index, usually one of the various view command are run to look at the index of the task to be deleted.

#### Usage

##### `delete <index number of task>` - Deletes task at specified index

The command deletes the task at the specifed index, if the index provided is valid.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To delete a task at the 3rd index of the list of tasks.

`delete 3`

Expected outcome:
The task would be deleted from the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Noted! I have removed this task:
         [E] meeting at Apr 4 2020 from 12:00 to 18:00 with
         priority 2
         Now you have 2 task(s) in your list
    ________________________________________________________________________________________________

<a name="done"></a>

### 3.4. Mark deadline as done
If the work to be completed for a deadline is done but you still want to keep it in the list, this command could be used. It marks the deadline at the specified index as done, usually one of the various view command are run to look at the index of the deadline to be deleted.

#### Usage

#### `done <index of deadline>` - Mark the deadline at the specified index as done

The command deletes the task at the specifed index, if the index provided is valid.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To mark a deadline at the 1st index of the list of tasks as done.

`done 1`

Expected outcome:
The task would be marked as done.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
    	 Nice! I've marked this deadline as done!
    	 [D][COMPLETED] math assignment is due on May 4 2020 at
    	 18:00 with priority 2
    ________________________________________________________________________________________________


<a name="edit"></a>

### 3.5. Edit task
If a task has any of it's details altered, you can use this command to edit the appropriate field directly. This saves you the trouble of manually deleting and adding a new task. This command is a multi-stage command so that it is easier for you to do it. This command changes the specified field of the task mentioned by it's index. To view the index of the task, one of the various command to view the list of tasks (view, priority_view, countdown) is run. 

Note: The date and time should be provided in the correct format as mentioned [here](#formats).

#### Multi-Stage

#### Usage 

#### `edit <index number of task>` - Used to edit task at specified index

The interface then displays the task and the set of attributes of the task that can be edited, if the index is valid. You can then enter the field you would like to change and then the new value to change the field into. 

The command edits the task at the specifed index at the field mentioned by you.
Upon success a successful edit message displaying the updated task's information similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To edit the start time of the event at 2nd index of the list.
#### Multi Stage

#### `edit 2` - Specify the index of task to be edited 

Expected outcome:

    ________________________________________________________________________________________________
         The event details are as follows:
         [E] meeting at May 6 2020 from 14:00 to 18:00 with
         priority 4
         Which field of the event to edit? (Enter Corresponding
         Number)
         1. Description
         2. Date
         3. Start Time
         4. End Time
         5. Priority


#### `3` - Specify field to be edited based on list

Expected outcome:

	 Enter new Start Time:
    
#### `12:00` - Enter the new value to be changed to

Expected outcome:

         Updated Details:
         [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
         The task at the mentioned index has been edited
         successfully
    ________________________________________________________________________________________________

<a name="clear"></a>

### 3.6. Clear list of tasks
If you would like to clear the current list of tasks and start on a clean state, this command could be used. Clears the list of tasks stored.

#### Usage

#### `clear` - Clears the list of tasks

The command clears the current list of tasks stored.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To clear the current list of tasks.

`clear`

Expected outcome:
The list of tasks would be cleared.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         The list of tasks is cleared.
    ________________________________________________________________________________________________

<a name="view"></a>

### 3.7. View list of tasks
If you would like to view the current list of tasks, this command could be used. It shows the current list of tasks stored.

#### Usage

#### `view` - Displays the current list of tasks

The command displays the current list of tasks stored.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks.

`view`

Expected outcome:
The list of tasks would be displayed.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks added so far:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
         2) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
    ________________________________________________________________________________________________

<a name="priority"></a>

### 3.8. View list of tasks sorted by their priority
If you would like to view the more important tasks from the current list of saved tasks first, this command could be used. It shows the current list of tasks after they are sorted based on their priority.

#### Usage

#### `priority_view` - Displays the current list of tasks sorted by priority

The command displays the current list of tasks sorted by their priority.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks sorted by their priority.

`priority_view`

Expected outcome:
The list of tasks would be displayed after they are sorted based on their priority.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks added so far displayed in
         decreasing order of priority:
         1) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
         2) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
    ________________________________________________________________________________________________

<a name="countdown"></a>

### 3.9. View list of tasks in a countdown format
If you would like to view the early tasks from the current list of saved tasks first along with the number of days left till the task, this command could be used. It shows the current list of tasks with the number of days left till each task, after they are sorted based on their date.

#### Usage

#### `countdown` - Displays the current list in countdown format

The command displays the current list of tasks current list of tasks with the number of days left till each task sorted by their dates.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks in countdown format.

`countdown`

Expected outcome:
The list of tasks would be displayed in the countdown format.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks with sorted based on the number
         of days left:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2 ---> 40 day(s) left
         2) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4 ---> 41 day(s) left
    ________________________________________________________________________________________________



<a name="search"></a>

### 3.10. Search tasks
If you would like to quickly find a task based on it's description, this command could be used. It performs a linear search of all tasks stored in the list at the point of execution and list
all the tasks containing the keyword in their description in a numbered list.

### Usage

#### `search <keyword found in task>` - Lists all matching tasks in the list containing the keyword 

The command displays all the tasks with description containg the keyword searched for in a numbered list.
Upon success a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 

`search exam`

Expected outcome:
All matching tasks in the list would be displayed in a numbered list.
A response similar to the following one would appear:

    ________________________________________________________________________________________________
         The list of tasks containing the mentioned keyword in
         their description are as follows:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
    ________________________________________________________________________________________________


<a name="help"></a>
    
### 3.11. View commands supported 
If you are a new user or forgot the syntax of any command, our help command could be used. The command displays the list of commands supported by the application.

#### Usage

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
         delete <index of task> -------------------- Delete the task
         edit <index of task> ---------------------- Edit the task
         done <index of task> ---------------------- Mark the deadline as done
         schedule <number of task to be scheduled> - Schedule tasks
         help -------------------------------------- View List Of Commands Supported
         bye --------------------------------------- Terminate task interface
         study ------------------------------------- Enter Study Area search interface
         notes ------------------------------------- Enter Notes
         Notes:
         *All dates should follow YYYY-MM-DD format
         *All timing should follow 24 hour clock
    ________________________________________________________________________________________________


<a name="schedule"></a>

### 3.12. Schedule tasks
If you have a bunch of assignments, projects and exams happening over the next few weeks and are stressed out with 
planning a schedule which can fulfill the requirements, our schedule task command can help you by creating a feasible 
schedule. It creates a schedule based on the tasks details provided by you. 

#### Usage

#### `schedule <number of task to be scheduled>` - Used to schedule a set of tasks specified by the user 

Then a set of lines are displayed which specify the format to be used to specify the new tasks to be scheduled. After you input the relevant data. The application would find a feasible schedule satisfying your constraints, if it is possible to do so. If it is possible, the list of events that were created when the task were scheduled is added to the current list of tasks. If it is impossible, a message to alert the user is specified too.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 

#### `schedule 3` - Schedule 3 tasks

Expected outcome:

    ________________________________________________________________________________________________
         Enter tasks in the following format:
         <task name> /f <Time to finish task in days> /d <Number of
         days left from current day to finish it>
         Enter details for task 1:

#### `math exam /f 2 /d 10` - Details of first task

Expected outcome:

	 Enter details for task 2:
     
#### `physics exam /f 3 /d 7` - Details of second task

Expected outcome:

	 Enter details for task 3:
     
#### `chemistry exam /f 1 /d 4` - Details of third task     

Expected outcome:

         Details captured successfully.
         chemistry exam is scheduled from 2020-03-27 to
         2020-03-27
         physics exam is scheduled from 2020-03-28 to
         2020-03-30
         math exam is scheduled from 2020-03-31 to
         2020-04-01
         Tasks successfully scheduled.
    ________________________________________________________________________________________________
    
#### Future Enhancements
   The current version of the application doesn't take into account the other tasks present, however the priority 
values can still be used to decide the task which is more important. In v3.0 our application will support scheduling tasks 
while avoiding tasks present previously and also add support for tasks to be scheduled preemptively (i.e, tasks can be 
scheduled over non contiguous days) .

  
### 3.15. Saving the data
The tasklist is saved automatically before the application is executed. There is no need to save manually.

<a name="clear-old-tasks"></a>

### 3.16. Clearing old tasks
The tasklist only includes the tasks which have date beyond the current date. This removes the need for you to manually find and delete the old tasks.

<a name="calendar"></a>

### 3.17. Viewing tasks in calendar format [coming in v3.0]
The tasklist only includes the tasks which have date beyond the current date. This removes the need for you to manually find and delete the old tasks.

  
## 5. Command Summary

### OrgaNice Main Features
`deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>` - Adds a new Deadline task to the list of tasks <br>
`event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>` - Adds a new Event task to the list of tasks <br>
`delete <index number of task>` - Deletes task at specified index <br>
`done <index of deadline>` - Mark the deadline at the specified index as done <br>
`edit <index number of task>` - Used to edit task at specified index <br>
`clear` - Clears the list of tasks <br>
`view` - Displays the current list of tasks <br>
`priority_view` - Displays the current list of tasks sorted by priority <br>
`countdown` - Displays the current list in countdown format <br>
`search <keyword found in task>` - Lists all matching tasks in the list containing the keyword <br>
`bye` - Exit the Application / Study Area interface <br>
`study` - Enter study area search interface <br>

<a name="formats"></a>

## 6. Formats Used

Time should be in the form of `HH:MM` (24 Hour Format, HH - Hour, MM - Minute) <br>
Date should be in the form of `YYYY-MM-DD` (YYYY - Year, MM - Month, DD - Day) <br>

**Contributions to the Developer Guide (Extracts)**:

### 2.1. Architecture  
  
![Architecture](../images/Architecture.png)
<div>Figure 1. Overall Architecture of OrgaNice!</div>
<br>

1. Duke - Main component which controls the flow of execution.

1. Ui - Component used to get input from the user and display results on the monitor.

1. Parser - Component used to abstract out the command based on user's input, so that the command can be executed later.

1. Command - Component contains information and implementation on how to execute various types of commands.

1. Task - Component contains details about handling the task list and related operations.

1. StudyArea - Component contains details about handling queries for study area search.

1. Notes - Component contains details about Notes related operations.

1. Exception - Component contains the various types of exceptions encountered when OrgaNice! is run.

1. ResourceLoader - Component handles loading and saving of the task list and study area details to local storage.



### 2.2. Task Component  
  

[comment]: # (@@author GanapathySanathBalaji)  
  
The Task component depends on 3 other components,   
  
 1. Command Component - The Command component issues instructions for the Task component to execute based on the user's input.  
 
 2. UI Component - The UI component is used to display the results (and related exceptions) of the commands issued to the Task Component. 
 
 3. ResourceLoader Component - The ResourceLoader component is used to load the list of tasks stored previously when the application is started and is also used to store the current list of tasks to the local storage upon exit.   

![Task Component](../images/Task_Component_UML.png)   
<div>Figure 2. Object Diagram for Task Component</div>
<br>
The task component contains 8 separate classes. They are as follows:  
 
  1. Task : Abstract class used to model a generic task. 
   
  2. Event : Specialized task class used to model events.  
  
  3. Deadline : Specialized task class used to model a deadline.   
   
  4. TaskType : Enumeration class used to denote the various task types.   
  
  5. TaskList : Container class used to store list of tasks and handle related operations. 
   
  6. SchedulableTask : Class used to model a task which is scheduled based on user's requirements.  
  
  7. TaskComparator : Contains a custom comparator used to compare two schedulable tasks based on their 
  numberOfDaysLeft attribute.  
  
  8.  TaskScheduler : Class used to check for feasibility and schedule a list of tasks based on user's requirements.

## 3. Implementation

### 3.1. Scheduling Tasks 


[comment]: # (@@author GanapathySanathBalaji)

#### 3.1.1 Implementation 
   Inorder to schedule tasks based on the user's requirement a separate SchedulableTask class was created. 
 1. The user's requirements (Name, Time to complete it, Deadline) are captured for each of the tasks to be scheduled. 
 1. The requirements captured are stored in the SchedulableTask object. 
 1. Then, the TaskScheduler object finds the optimum schedule based on the user's requirements using the EDF 
 (Early Deadline First) algorithm.
 1. If a feasible schedule is found it is 
 displayed, else a message stating that a schedule based on the user's requirements can't be made is displayed.
 
	
   The following sequence diagrams explain how tasks are scheduled.
	
 ![Overall Sequence Diagram](../images/Schedule_Overall.png)
<div>Figure 5. Overall Sequence Diagram</div>
<br>
 The three reference frames used are as follows:

 * `Get information regarding the tasks from the user`

 ![Sub Diagram 1](../images/Schedule_Sub1.png)
 <div>Figure 6. Sub Diagram 1</div>
 <br>
 * `Check and Schedule tasks if feasible`

 ![Sub Diagram 2](../images/Schedule_Sub2.png)
 <div>Figure 7. Sub Diagram 2</div>
 <br>
 * `Add the scheduled tasks to current list of tasks`
 
 ![Sub Diagram 3](../images/Schedule_Sub3.png)
 <div>Figure 8. Sub Diagram 3</div>
 <br> 
 
#### 3.1.2 Alternatives
Aspect : How to capture user's requirements and handle it.

 - Alternative 1 (Current Choice) : Create a separate SchedulableTask object to store user's requirements for each task 
                                    to be scheduled.
      - Pros : New class object can be customised without affecting core functionality of the product if the attributes provided by 
      the user (to tasks to be scheduled) changes.
      - Cons : New methods similar to previously implemented methods have to be created instead of being reused.
      
 - Alternative 2 : Modify existing event or deadline class to model user's requirements.
      - Pros : It reuses methods and reduces coupling between classes in the TaskComponent.
      - Cons : Major changes would be required throughout various components of the application to accommodate the new feature. 

     Finally the first alternative was implemented as it was easier to implement and maintain it if changes were required to 
the user's requirements (e.g. Changes to the number of parameters provided by the user).