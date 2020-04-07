# Nizar Mohd - Project Portfolio Page

# Project: OrgaNice!

##  Overview

  OrgaNice! is a command line based application that can help academics with scheduling their tasks and keeping track of them. 
  It also has additional features such as note taking and finding study areas within NUS, to help academics.

## Summary of Contributions

### Code Contributed
Link : [RepoSense Dashboard](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#search=&sort=totalCommits%20dsc&sortWithin=totalCommits%20dsc&timeframe=commit&mergegroup=false&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=NizarMohd&tabRepo=AY1920S2-CS2113T-T12-3%2Ftp%5Bmaster%5D)

### Enhancements implemented:
* **Major Enhancement:**  added the ability to search for study areas based on User's criteria.
	* What it does: It allows user to obtain a list of study areas that meets the criteria entered by the user. Supported criteria includes name, address, faculty, port availability, environment and capacity.
	* Justification: This feature forms one of the intended features of OrgaNice and it gives Students the awareness on actual study areas that they can use to study, if they are new to the faculty or just unfamiliar with NUS. 
	* Highlights: This feature supports lose search when searching by name, address or faculty. Meaning user can enter commonly used abbreviations for locations and still return a result. For example, Starbucks is commonly known as bux or bucks in the current era, and allowing the user to search with the commonly used abbreviations allows for ease of use on the user end. This utilised HashMap to create a mapping between the commonly used abbreviations to the actual attributes of the locations stored in our data files.
	* Credits: The algorithm currently used was suggested by one of our Team Member, Terry. He gave me a verbal idea of the algorithm which allowed me to implement it into code. 
* **Major Enhancement:**  added the ability to view Tasks in calendar view.
	* What it does: Allows user to take a glance on the list of tasks (maximum of https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java4 per day) available in a month period (specified by the User).
	* Justification: This feature improves the product visually, and gives the User ease of access and visibility of the task they have for an entire month.
	* Highlights: The user can view the tasks for any month that they desire, present or future only. The difficulty comes when we have to print the day of the month at the correct boxes and according to the actual day of the week. Next was to print the content such that it does not cause any mismatch in the alignment of Calendar view. Therefore, we only decided to print a maximum of four tasks per day with each tasks detail not exceeding 25 characters. Any details that exceed will have its last three characters (of the 25) displayed as ellipses.
* **Minor Enhancement:** added the ability to mark deadlines as done, by extension, adding a boolean attribute, isDone, to Deadline class.
* **Minor Enhancement:** added the ability to print messages in a specific format, which is with indentation and of a fixed length.
    * Credits: The implementation of the code was extracted from [stackOverflow](https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java)
* **Contributions to UG**
	* Documented the for features (3.13).
* **Contributions to the DG:**
    * Documented Table of Contents, styling of images using css and numbering of figures.
	* Documented the Study Area Component. This includes the documentation of the Object Diagram for the Study Area Component.
	* Documented the implementation for study area search feature and the Sequence Diagram to show the implementation.
	* Documented Non-Functional Requirements.
	* Documented Glossary.
	* Documented Testing.
* **Contributions to team-based tasks :**
	* Assisted with integration of the forking workflow during the earlier stage, as there were mismatch after resolving merge conflicts.
	* Refactored code by removing some of the magic literals into constants and moving constants into its own class, Constant class. 
	* Obtained the design for logo and goodbye dab. Credits: [Generator for logo](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=TypeSomething), [image source for goodbye dab](https://www.netclipart.com/isee/iRwmhJb_bt21-rj-transparent-background/), [generator for goodbye dab](https://asciiart.club/)
* **Review/mentoring contributions:**
	* Reviewed the following PR's: 
		[#75](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/75) [#125](https://github.com/AY1920S2-CS2113T-T12-3/tp/pull/125)
* **Contributions beyond the project team:**
	* Reported 6 bugs during the [PE Dry Run](https://github.com/NizarMohd/ped).
	* Reviewed another team's [DG](https://github.com/nus-cs2113-AY1920S2/tp/pull/28)
	
	
###**Contributions to the Developer's Guide (Extracts)**:

The sections I contributed to in the Developer's Guide are as follows.
Note that the content below just shows an extract of the documentation I have done.
The purpose of the extract is to show my documentation capability.

### Extract 1 (Object Diagram)

### 2.3. Study Area Component  
   
 The Study Area component depends on 3 other components,  
   
  1. Command Component - The Command component issues instructions for the Study Area component to execute based on the 
  user's input. 
  
  2. UI Component - The UI component is used to display the results (and related exceptions) of the commands issued to 
  the Study Area Component.
  
  3. ResourceLoader Component - The ResourceLoader component is used to load data of all existing Study Areas in NUS 
  into text files when the User first run the software. Eventually, data will be referred from the created text file.   
  
![Study Area Component](images/StudyAreaObjectDiagram.png) 
<div>Figure 3. Object diagram for Study Area Component</div>
<br>
 The Study Area component contains 3 separate classes. They are as follows:  
  
   1. Dictionary : Class to map user input to specific terms used in StudyAreaList.
    
   2. StudyArea : Class that is used to model Study Areas. 
   
   3. StudyAreaList : Class that handles the list of available Study Areas based on User input.  


### Extract 2 (Sequence Diagram)

### 3.2. Listing Study Areas 

#### 3.2.1 Implementation 
The Study Area search is facilitated by StudyAreaList. In this class, it has the list of all existing Study Areas, 
stored internally as an ArrayList. This ArrayList is called studyAreaList. 

To list the Study Area, we iterate through the entire list of all existing Study Area and conduct a check. The check is 
as follows :

If in each Study Area, the Study Area meets all the flags stated by the User, the Study Area is then added to the 
list of available Study Area. If not, the iteration is skipped and move on to the subsequent Study Area.

To do as mentioned above, the StudyAreaList class implements the following main methods :

- searchList() : 
    - This method will iterate through all the Study Areas in the ArrayList studyAreaList while calling other methods 
    to carry out the search. Once process has ended, the method will return a list of the Study Area, availStudyArea, 
    that meets the User requirement.
- getFlagsInfo() : 
    - This method will retrieve the flags entered by User, at the same time validating the User input. The criteria 
    entered by the User will be returned as flags, an Array of Strings of fixed size 5 as the software only supports 5 
    flags in version 2.
- isAvailStudyArea() : 
    - This method does the check mentioned above and returns a boolean value. Based on the flags detected, 
    the method will iterate through the flags array and check if the Study Area's attribute matches each flag stated in
    flags. If isAvailStudyArea returns as true for all flags, the Study Area is then added to the output list, 
    availStudyArea. 

Below would be a sequence diagram to demonstrate how the search algorithm is operated.

 * `User enters search key` 
 
![Study Area Sequence_Diagram_Main](images/usersLinteraction.png)  
<div>Figure 9. Interaction between User and Study Area Search Interface</div>
<br>

 * `StudyAreaCommand invokes searchList() of StudyAreaList` 
 
![Study_Area_Sequence_Diagram_subModules](images/sLinteraction.png)
<div>Figure 10. Interaction within Study Area Search Interface</div>
<br>

![Study_Area_Sequence_Diagram_subModules2](images/isAvailStudyArea.png)
<div>Figure 11. Interaction when isAvailStudyArea is invoked</div>
<br>

You can refer [here](#appendix-d-glossary) for a detailed explanation on the terms used in this diagram

#### 3.2.2 Alternative 
Aspect: How to search based on User input.

- Alternative 1 (Current Choice) :
 
    Iterate through the list of all existing Study Areas. Then check if each Study Area 
meets User's Criteria
    - Pros : Lesser data structures required. Therefore lesser memory required.
    - Cons : Linear search, therefore, with bigger size of data, search may take longer. 
    
- Alternative 2 : 
There exists four flags : port availability, indoor, outdoor, capacity.
Create adjacency lists that maps the flag to the Study Area itself. If the Study Area contains that 
attribute, the Study Area is added in that specific attribute list. Depending on the type of attribute, the adjacency
list can be implemented using different data structure.

For example, let's take only the two study areas as the entire data set.

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



This will result in the following adjacency lists : 
Environment: <br>
Indoor -> {Starbucks} 
Outdoor -> {Opposite Town Green (Outside Starbucks)} <br>
*Data Structure* : 2D Array, with only two rows (For indoors and outdoors)<br>
Ports: <br>
Yes -> {Opposite Town Green (Outside Starbucks), Starbucks}
No -> null<br>
*Data Structure* : 2D Array, with only two rows (For Yes and No)<br>
Capacity: <br>
4 -> {Opposite Town Green (Outside Starbucks)} 
5 -> {Starbucks} <br>
*Data Structure* : HashMap<Integer, ArrayList<String>> <br>

The creation and initialisation of the lists are done when the software is setting up.  Therefore, each flag 
has its own list. Based on user criteria, concatenate an output list with the Study Areas that are found in all
of the relevant flag lists stated by the user. If more than one requirement is entered by the user, only the Study 
Areas appears in all the related attributes specified by the User will be added to the output list.

- Pros : Data is categorised based on flags.
- Cons : More memory is required as more data structures are used. Since methods invoked during the search are also 
linear, time taken to complete the search will be longer if more data are present. Overall, this approach is harder 
to implement.

Therefore, the first alternative is chosen, as it is much easier to implement and lesser memory is used while conducting the search.

