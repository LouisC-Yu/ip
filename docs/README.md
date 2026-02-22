# Dude User Guide

![Dude UI Screenshot](UI.png)

## Introduction

**Dude** is a simple task management chatbot with a chat-style user interface!
You interact with Dude by typing commands, and it helps you manage tasks such as 
todos, deadlines, and events

Your task list is saved with the **bye** command, allowing you to continue where you
left off in future sessions

---

## How to Run Dude

### Prerequisites

Ensure that **Java 17 or later** is installed.

You can check your Java version using:
```
java -version
```

If Java is not installed, please install a Java 17+ distribution

---

### Running Dude

1. Download or copy `Dude.jar` onto your computer.
2. Open a terminal (Command Prompt, PowerShell, or shell).
3. Navigate to the directory containing `Dude.jar`.
4. Run the following command:
```
java -jar Dude.jar
```

---

## Listing tasks

Lists all tasks currently stored in Dude.

Example interaction:
```
> list
>
> 1. [ ] homework
> 2. [X] Return library book (by: 2026-02-28)
> 3. [ ] Mom's Birthday (from: 2026-03-01 to: 2026-03-02)
```

---

## Adding todo tasks

Adds a simple task with only a name.

Example interaction:
```
> todo homework
>
> Sure dude! added:
> [ ] homework
> Now you have 1 task(s) in the list
```

---

## Adding deadline tasks

Adds a task with a specific due date.

Format:
deadline <task name> /by <yyyy-mm-dd>

Example interaction:
```
> deadline Return library book /by 2026-02-28
>
> Sure dude! added:
> [ ] Return library book (by: 2026-02-28)
> Now you have 2 task(s) in the list
```

---

## Adding event tasks

Adds a task with a start and end date.

Format:
event <task name> /from <yyyy-mm-dd> /to <yyyy-mm-dd>

Example interaction:
```
> event Mom's Birthday /from 2026-03-01 /to 2026-03-02
>
> Sure dude! added:
> [ ] Mom's Birthday (from: 2026-03-01 to: 2026-03-02)
> Now you have 3 task(s) in the list
```

---

## Marking tasks as done

Marks a task as completed.

Example interaction:
```
> mark 3
>
> Sure dude! I'll mark that as done:
> [X] Mom's Birthday (from: 2026-03-01 to: 2026-03-02)
```

---

## Unmarking tasks

Marks a completed task as not done.

Example interaction:
```
> unmark 3
>
> Sure dude! I'll unmark that as not done:
> [ ] Mom's Birthday (from: 2026-03-01 to: 2026-03-02)
```

---

## Deleting tasks

Deletes a task from the list.

Example interaction:
```
> delete 2
>
> Sure dude! Deleting this task:
> [X] Return library book (by: 2026-02-28)
> Now you have 2 task(s) in the list
```

---

## Exiting Dude

Saves all tasks and exits the application.

Example interaction:
```
> bye
>
> Okay, bye dude!
```

---

## Notes

- All dates must be in the yyyy-mm-dd format
- Task numbers correspond to the indices shown in the list command
- Tasks are saved automatically when exiting using bye