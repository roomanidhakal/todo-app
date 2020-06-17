# Todo List
This is a simple app where you can add, update and remove a task. This app is designed to orginize your daily activities on the go.

## Features
* [Splash Screen](#splash-screen)
* [Pattern Lock](#pattern-lock)
* [Home Ui](#home-ui)
* [Add Task](#add-task)
* [Voice Dictation](#voice-dictation)
* [Update Task](#update-task)
* [Share Task](#share-task)
* [Delete Task](#delete-task)
* [Menu Item](#menu-item)
* [Delete Alert](#delete-alert)

## Splash Screen
This screen shows the logo of the app for about 3 sesonds and redirects it to the next activity via an explicit intent.
![splash_screen.png]

## Pattern Lock
This is the activity that the splash screen redirects to. Here a user draws a pattern to enter the app. When first installed, the activity asks the user to create a pattern which is saved and used to later check whether the entered pattern is correct or not.
![pattern.png]
When pattern is incorrect:
![incorrect_pattern.png]
When pattern is correct:
![correct_pattern.png]

## Home Ui
The home ui uses recycler view to show the list of tasks the user has added via the floting action button below.
![home_ui.png]

## Add Task
Here you can add a new task with the task description, the priority(high, medium, low) and the current date.
![add_ui.png]
After multiple tasks are added, the tasks are sorted by priority.
![tasks_sort_by_priority.png]

## Voice Dictation
Here you can use voice dictation to give the task description.
![microphone_intent.png]
![microphone_receive_text.png]

## Update Task
Here you can update a pre-existing task.
![update_ui.png]
After update:
![task_updated.png]

## Share Task
The share button in the update ui when clicked uses an implicit intent to show the apps to share your tasks with.
![share_text.png]

## Delete Task
You can delete a single task by swiping the task to either left or right.
![swipe_to_delete.png]
After Swipe:
![task3_deleted.png]

## Menu Item
The menu item for this app is "Delete All Tasks".
![menu_delete_all_task.png]

## Delete Alert
When the "Delete All Tasks" menu item is clicked it opens a pop up alert dialog box which asks for user confirmation to delete all tasks.
![delete_confirm_alert.png]
When pressed "Cancel".
![delete_cancel.png]
When pressed "Ok".
![delete_ok.png]


