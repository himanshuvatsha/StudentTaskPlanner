# Smart Student Task Planner

A console-based Java application that helps students manage academic tasks with priority levels and automatic data persistence across sessions.

---

## Problem Statement

Students managing multiple assignments, deadlines, and lab submissions often rely on paper lists or mental tracking — both of which fail as workload grows. This project provides a focused, low-friction digital alternative: a tool where recording a task takes under thirty seconds and data persists reliably between sessions.

---

## Features

- **Add tasks** with a title and priority level (High / Medium / Low)
- **View all tasks** showing title, priority, and completion status
- **Mark tasks complete** without deleting them
- **Delete tasks** that are no longer needed
- **Automatic persistence** — tasks are saved to `tasks.txt` and reloaded every time the program starts

---

## Technologies Used

- **Java** (Core Java, no external libraries)
- Object-Oriented Programming (OOP)
- File I/O — `BufferedReader`, `BufferedWriter`
- `ArrayList<Task>` for in-memory task management
- `Scanner` for console input

---

## About Java

Java is a high-level, class-based, object-oriented programming language designed to have as few implementation dependencies as possible. It follows the **"Write Once, Run Anywhere"** (WORA) principle — compiled Java bytecode runs on any platform that has a Java Virtual Machine (JVM) installed, without needing to be recompiled.

Key characteristics that made Java the right choice for this project:

- **Object-Oriented** — everything in Java is built around classes and objects, making it a natural fit for modelling real-world entities like tasks with state (title, priority, completion status)
- **Strongly Typed** — Java catches type errors at compile time rather than runtime, reducing bugs in data handling
- **Robust Exception Handling** — Java's checked exceptions force the programmer to explicitly handle error cases like missing files, which is central to this project's persistence design
- **Rich Standard Library** — `java.io` provides `BufferedReader`, `BufferedWriter`, and `FileReader` out of the box, making file-based persistence straightforward without any external dependencies
- **Platform Independent** — any machine with a JVM can run this program without recompilation, which matters for a student tool meant to work across different lab machines and personal computers

Java was first released by Sun Microsystems in 1995 and is currently maintained by Oracle. It consistently ranks among the top programming languages worldwide and is widely used in enterprise software, Android development, and academic instruction — which is why it forms the foundation of this course.

---

## Project Structure
```
StudentTaskPlanner/
├── Task.java          # Data model — stores title, priority, completion status
├── TaskManager.java   # Business logic + file persistence (load/save)
├── Main.java          # Menu loop and user interaction
└── tasks.txt          # Auto-generated on first run; stores task data
```

Each class has a single, clearly defined responsibility. `Main` never touches the file system; `Task` never reads user input. This separation makes every part independently readable and changeable.

---

## How to Run

### Prerequisites
- Java JDK 8 or later installed
- Any terminal or command prompt

### Step 1 — Clone the repository
```bash
git clone https://github.com/Aaryanvyas/StudentTaskPlanner.git
cd StudentTaskPlanner
```

### Step 2 — Compile
```bash
javac *.java
```

### Step 3 — Run
```bash
java Main
```

---

## Sample Session
```
=== Smart Student Task Planner ===
1. Add Task   2. View Tasks   3. Mark Complete   4. Delete Task   5. Exit

Choose an option: 1
Enter task title: Submit operating systems assignment
Enter priority (High / Medium / Low): High
Task added successfully.

Choose an option: 2
[0] Submit operating systems assignment | Priority: High | Status: Pending

Choose an option: 3
Enter task index to mark complete: 0
Task marked as completed.

Choose an option: 5
Goodbye!
```

Tasks are written to `tasks.txt` after every operation and restored automatically on the next run.

---

## Known Limitations

| Limitation | Workaround / Fix Planned |
|---|---|
| Task titles cannot contain commas | Avoid commas in titles; pipe-delimited format planned for v2 |
| Priority is stored as free text | No validation on input; enum enforcement planned for v2 |
| Index-based selection shifts after deletion | Always view the task list before deleting |

---

## Planned Enhancements

- **Due date support** with sort-by-deadline view
- **Priority enum** (`HIGH`, `MEDIUM`, `LOW`) replacing free-text string
- **Pipe-delimited storage** to eliminate the comma-in-title limitation
- **Filter views** — show only pending, only completed, or filter by priority
- **Keyword search** across task titles
- **Swing GUI** with colour-coded priority rows

---

## Concepts Demonstrated

This project was built as a BYOP (Bring Your Own Project) submission for a Core Java course. It demonstrates:

- OOP principles — encapsulation, single responsibility, class design
- File handling — reading and writing persistent data with `BufferedReader`/`BufferedWriter`
- `ArrayList` management — add, iterate, remove, update
- Exception handling — graceful handling of missing files and invalid input
- Menu-driven console interaction with `Scanner`

---

## Author

**Aryan Vyas** — 24BAI10343  
[github.com/Aaryanvyas](https://github.com/Aaryanvyas)
