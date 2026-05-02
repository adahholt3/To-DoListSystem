# To-Do List Application (Java CLI)

## Overview
This project is a command-line To-Do List application written in Java.  
It allows users to create, manage, and organize tasks using object-oriented design and custom data structures.

The goal of this project was to apply:
- Object-Oriented Programming (OOP)
- Custom data structures
- Input validation
- Modular design

---

## Features

- Add tasks (Simple, Priority, Recurring)
- View all tasks
- Mark tasks as complete
- Remove tasks
- Undo last action (Stack - LIFO)
- Process tasks using a queue (FIFO)
- Filter tasks by type, priority, or completion status

---

## Project Structure

### Core Classes

#### `Task` (Abstract Class)
- Base class for all tasks
- Contains common fields:
  - title
  - description
  - due date
  - completion status
  - priority
- Uses abstraction to force subclasses to implement:
  - `getTaskType()`
  - `getDetails()`

---

#### Task Types
- `SimpleTask` → basic task
- `PriorityTask` → includes priority level
- `RecurringTask` → includes recurrence pattern

These demonstrate:
- Inheritance
- Polymorphism

---

#### `TaskManager`
- Stores all tasks using a **custom ArrayList**
- Handles:
  - adding
  - removing
  - completing tasks
  - filtering

---

## Data Structures Used

### Custom ArrayList (`MyArrayList`)
- Built from scratch (no Java ArrayList used)
- Supports:
  - add
  - remove
  - get
  - set
  - size
- Uses dynamic resizing

**Design Choice:**
- Reinforces understanding of how ArrayLists work internally

---

### Stack (`UndoStack`)
- Uses Java `Stack`
- Stores `UndoAction` objects

**Why a Stack?**
- Follows **LIFO (Last-In-First-Out)**
- Matches undo behavior:
  - last action = first undone

---

### Queue (`TaskQueue`)
- Uses `LinkedList` as a Queue

**Why a Queue?**
- Follows **FIFO (First-In-First-Out)**
- Processes tasks in order added

---

### `UndoAction`
- Stores:
  - action type
  - task
  - index
- Allows reversing actions

---

## Command-Line Interface (Main Class)

The `Main` class:
- Displays a menu
- Handles all user input
- Calls appropriate methods in other classes

### Key Design Choices

#### 1. Use of `nextLine()` for input
- Avoids Scanner bugs caused by mixing `nextInt()` and `nextLine()`
- Ensures consistent input handling

---

#### 2. Input Validation
- Try/catch used to prevent crashes
- Loops ensure valid input for:
  - numbers
  - dates

---

#### 3. Modular Design
- Logic is separated into helper methods:
  - `addTaskMenu`
  - `removeTaskMenu`
  - `completeTaskMenu`
  - etc.

**Benefit:**
- Cleaner code
- Easier debugging
- More readable

---

## How the System Works

1. User selects an option from the menu
2. `Main` processes input
3. Calls methods in:
   - `TaskManager`
   - `UndoStack`
   - `TaskQueue`
4. Data structures handle logic:
   - ArrayList stores tasks
   - Stack tracks undo
   - Queue processes tasks

---

## Example Workflow

- Add a task → stored in TaskManager
- Undo → removes it using stack
- Load today's tasks → adds recurring tasks to queue
- Process task → removes from queue (FIFO)

---

## How to Run

1. Open project in Eclipse or another IDE
2. Make sure all files are in the same package:# To-Do List by Adah And Aamna

## Overview
This project is a To-Do List application written in Java.  
It allows users to create, manage, and organize tasks using object-oriented design and custom data structures.

The goal of this project was to apply:
- Object-Oriented Programming (OOP)
- Custom data structures
- Input validation
- Modular design

---

## Features

- Add tasks (Simple, Priority, Recurring)
- View all tasks
- Mark tasks as complete
- Remove tasks
- Undo last action (Stack - LIFO)
- Process tasks using a queue (FIFO)
- Filter tasks by type, priority, or completion status

---

## Project Structure

### Core Classes

#### `Task` (Abstract Class)
- Base class for all tasks
- Contains common fields:
  - title
  - description
  - due date
  - completion status
  - priority
- Uses abstraction to force subclasses to implement:
  - `getTaskType()`
  - `getDetails()`

---

#### Task Types
- `SimpleTask` → basic task
- `PriorityTask` → includes priority level
- `RecurringTask` → includes recurrence pattern

These demonstrate:
- Inheritance
- Polymorphism

---

#### `TaskManager`
- Stores all tasks using a **custom ArrayList**
- Handles:
  - adding
  - removing
  - completing tasks
  - filtering

---

## Data Structures Used

### Custom ArrayList (`MyArrayList`)
- Built from scratch (no Java ArrayList used)
- Supports:
  - add
  - remove
  - get
  - set
  - size
- Uses dynamic resizing

**Design Choice:**
- Reinforces understanding of how ArrayLists work internally

---

### Stack (`UndoStack`)
- Uses Java `Stack`
- Stores `UndoAction` objects

**Why a Stack?**
- Follows **LIFO (Last-In-First-Out)**
- Matches undo behavior:
  - last action = first undone

---

### Queue (`TaskQueue`)
- Uses `LinkedList` as a Queue

**Why a Queue?**
- Follows **FIFO (First-In-First-Out)**
- Processes tasks in order added

---

### `UndoAction`
- Stores:
  - action type
  - task
  - index
- Allows reversing actions

---

## Command-Line Interface (Main Class)

The `Main` class:
- Displays a menu
- Handles all user input
- Calls appropriate methods in other classes

### Key Design Choices

#### 1. Use of `nextLine()` for input
- Avoids Scanner bugs caused by mixing `nextInt()` and `nextLine()`
- Ensures consistent input handling

---

#### 2. Input Validation
- Try/catch used to prevent crashes
- Loops ensure valid input for:
  - numbers
  - dates

---

#### 3. Modular Design
- Logic is separated into helper methods:
  - `addTaskMenu`
  - `removeTaskMenu`
  - `completeTaskMenu`
  - etc.

**Benefit:**
- Cleaner code
- Easier debugging
- More readable

---

## How the System Works

1. User selects an option from the menu
2. `Main` processes input
3. Calls methods in:
   - `TaskManager`
   - `UndoStack`
   - `TaskQueue`
4. Data structures handle logic:
   - ArrayList stores tasks
   - Stack tracks undo
   - Queue processes tasks

---

## Example Workflow

- Add a task → stored in TaskManager
- Undo → removes it using stack
- Load today's tasks → adds recurring tasks to queue
- Process task → removes from queue (FIFO)

---

## How to Run

1. Open project in Eclipse or another IDE
2. Make sure all files are in the same package:

##Note

I used AI to help me write this README.md
