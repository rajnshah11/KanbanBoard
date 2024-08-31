# Kanban Board - Project Management System
 
 _**There are 4 main entities**_ -

    1) User - (int id(PK), String name)

    2) Task - (int id(PK), Timestamp due_date, String description)

    3) Comment - (int id(PK), int task_id(FK), int user_id(FK), String comment_description)

    4) State - (int id(PK), String name)

_**There are 2 join tables**_ -

    1) Task and User - TaskUser(int Id(PK), int task_id(FK), int user_id(FK))

    2) State and Task - StateTask(int id(PK), int state_id(FK), int task_id(FK), Timestamp created_on)

**_How am I storing history of the state changes?_**

    The timestamp of anytime the state is assigned or modified will be stored in the created on/modified on column. We can save the details and timing of all state changes by creating a new item each time. It aids in keeping the table's history.
    As you can see in the above table, task_id 1 has state_id 1 assigned to it and task_id 2 has state_id 2 assigned to it but it changes to 3 later.
    It also stores user_id to store the user_assigned to that task
    This table will store all the past history for state changes.

**_Are we making good sized tasks? How long does it take to finish a task?_**

    We can find if we are making a good sized tasks by....
    I am storing created_on date and due_date to check how long it takes to finish a task.

**_How long after a task is created is it moved to State=Doing?_**

    The field created_on/modified_on in the state_task table will have all the timestamps of whenever the state changes.

**Usage of each table** - 

**_Task_** - This table keeps information such as the task description and due date of that task to see if we are finishing a task on time. 

**_User_** - This table is used to store data for each user.

**_Comment_** - This table contains information such as the comment's description, the user's ID, which is used to keep track of the user's identity and the task's id.

**_State_** - This holds the name and ID of the state( To-Do, Doing, Done) in a manner similar to that of a constant table.

**_Task and User_** - This table holds the mapping of task and the users assigned to that task. It can hold multiple users for each task.

| task_id | user_id |
|---------|---------|
| 1       | 2       |
| 2       | 4       |
| 2       | 5       |

As you can see in the above table, task_id 1 has user 2 assigned to it and task 2 has two users 4 and 5.

**_State and Task_**  - The mapping between status and task is kept in this table. With created on/modified on field, it records timestamps anytime the state is changed or initially assigned, it is able to store all state changes.

| state_id | task_id | created_on / modified_on      | user_id |
|----------|---------|-------------------------------|---------|
| 1        | 1       | 2022-10-29T04:24:25.610+00:00 | 2
| 2        | 2       | 2022-10-29T04:24:25.610+00:00 | 4
| 3        | 2       | 2022-10-29T04:24:25.610+00:00 | 4


**---------------------------User APIs---------------------------**

    POST - /user/addUser 
This API will add user/engineer to the user table.

    POST - /addUsers 
This API will add multiple users to the table

    GET - /users
This API will print all the users in the table

    GET - /userById/{id}
This API will print all details about a specific user.

    DELETE - /deleteUser/{id}  
This will delete a specific user

**------------------------------Task APIs----------------------------** 

    POST - /task/addTask  
This will add a task

    PUT - /task/editDescription
This will edit description of the specific task

    DELETE - /task/deleteTask/{task_id} 
This will delete a specific task

    GET - /task/getTaskDetails/{task_id}
This will bring all the previous and current state changes with all the task details and comments and users assigned.


**--------------------------State APIs-------------------------------**

    POST - /state/addState 
This will add a state to the state table

    DELETE - /state/deleteState
This will delete a specific state

    GET /state/getStates 
This will bring all the states in the state table

    GET /state/getStates/{state_id} 
This will print the details of the specific state

**-----------------------Comment APIs----------------------------**

    POST  /comment/addComment 
This will add Comment to a specific task

    GET /comment/getComment/{comment_id} 
This will print the specific comment

    GET /comment/getAllComments 
This will bring all the comments

    GET /comment/getCommentOfTask/{task_id} 
This will print the list of comments of that specific task


**----------------State - Task Join APIs-----------------------** 

    POST /addStateToTask 
This will add state to the created task. This will help store all the history of state changes as the created_on/modified_on column will store the timestamp of whenever the state change happens. This is how we can store the history of all the state changes.

    GET /getAllStateChanges/{task_id} 
This will bring all the state history of that specific task given as a request

    GET /getCurrentTaskState/{task_id}
This will give the current state of that task

**------------------Task - User Join APIs-----------------------**

    POST  {task_id}/assignUser/{user_id}
This will assign user to a task

    POST /{task_id}/removeUserFromTask/{user_id}  
This will remove an assigned user from the specific task


For storing history, 
I have added a new table called state_history which stores 
Id - history_id (PK){AI}
int task_id(FK)
int user_id(FK)
int change_id (this can be task, comment, user, state) changed
String change_id_type

I have added 4 functions 
**addUserToTask()** - This will add a row in history table stating that there was a user assigned
**removeUserFromTask()** - This function will add an entry in the history table when user is removed from the task.
**addStateToTask()** - This function will add an entry in the history table when a state is assigned to a task
**addCommentToTask()** - This function will add an entry in the history table when a comment is added to a task

























# KanbanBoard
