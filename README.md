# Smart Assignment Scheduler
### Deadline-Based Daily Planning for Students — Java CLI Application

---

## Problem Statement

Students frequently underestimate the time required to complete large assignments. Without a structured plan, work gets deferred until the last day, resulting in poor-quality submissions, missed deadlines, and unnecessary stress. Most calendar apps simply set a reminder — they do not *plan the work*.

This project solves that by automatically distributing assignment workload across available days, factoring in difficulty and deadline urgency, so the student always knows exactly what to work on today.

---

## Features

### Core Features
| Feature | Description |
|---|---|
| Add Assignment | Record name, subject, deadline, estimated hours, and difficulty |
| View Assignments | Tabular list of all assignments with status and days remaining |
| Generate Schedule | Auto-distributes remaining work across available days |
| Mark Progress | Log hours worked per session; auto-completes when done |
| Upcoming Deadlines | Filter assignments by deadline proximity |
| Summary Statistics | Overview of total, completed, pending, and overdue work |
| Persistent Storage | Assignments saved to `data/assignments.txt` and reloaded on startup |

### Advanced Features
| Feature | Description |
|---|---|
| Difficulty Weighting | Hard assignments front-load work to earlier days |
| Overload Detection | Warns when a day exceeds the 6-hour recommended limit |
| Redistribution Tips | Suggests starting earlier if a day is overloaded |
| Deadline Warnings | Alerts when a deadline is ≤ 1 day away |
| Combined Schedule | Merges all assignments into a single daily view |

---

## Technologies Used

- **Java 11+**
- `java.time.LocalDate` — date handling and deadline arithmetic
- `ArrayList`, `LinkedHashMap` — in-memory data structures
- `BufferedReader` / `BufferedWriter` — file I/O for persistence
- `Scanner` — interactive CLI input
- Object-Oriented Design — 5 classes with clear single responsibilities
- Exception Handling — `try-catch` throughout for robust input/file errors

---

## Project Structure

```
SmartAssignmentScheduler/
│
├── src/
│   ├── Main.java               ← CLI menu driver and entry point
│   ├── Assignment.java         ← Data model with serialization
│   ├── Scheduler.java          ← Scheduling algorithm (core logic)
│   ├── AssignmentManager.java  ← Coordinator / business logic layer
│   └── FileHandler.java        ← File read/write (persistence)
│
├── data/
│   └── assignments.txt         ← Auto-created; stores all assignments
│
├── README.md
└── ProjectReport.md
```

---

## How to Run

### Prerequisites
- Java JDK 11 or later installed
- A terminal or command prompt

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/SmartAssignmentScheduler.git
cd SmartAssignmentScheduler

# 2. Compile all source files
mkdir -p out
javac -d out src/*.java

# 3. Run the program (from project root so data/ path resolves correctly)
java -cp out Main
```

---

## Example Output

```
╔══════════════════════════════════════════════════════╗
║       SMART ASSIGNMENT SCHEDULER v1.0                ║
║       Deadline-Based Planning for Students           ║
╚══════════════════════════════════════════════════════╝
  Today's Date: 2025-07-15

  Loaded 0 assignment(s) from data/assignments.txt

┌──────────────────────────────────────┐
│           MAIN MENU                  │
├──────────────────────────────────────┤
│  1. Add Assignment                   │
│  2. View All Assignments             │
│  3. Generate Study Schedule          │
│  4. Mark Assignment Progress         │
│  5. View Upcoming Deadlines          │
│  6. Summary Statistics               │
│  7. Delete Assignment                │
│  8. Save & Exit                      │
└──────────────────────────────────────┘
  Enter choice: 1

  ADD NEW ASSIGNMENT
  ══════════════════════════════════════
  Assignment name   : Operating Systems Project
  Subject           : OS
  Deadline (yyyy-MM-dd): 2026-03-21
  Estimated total hours : 10
  Difficulty (1=Easy, 5=Very Hard): 3

  ✓ Assignment added successfully!

┌─────────────────────────────────────────────────────┐
│  Schedule: Operating Systems Project                │
│  Subject : OS                                       │
│  Deadline: Sat, Mar 21 2026                         │
│  Remaining: 10.0 hrs over 5 day(s)                  │
├─────────────────────────────────────────────────────┤
│  Day 1    Mon, Mar 15 2026           2.75 hours     │
│  Day 2    Tue, Mar 16 2026           2.50 hours     │
│  Day 3    Wed, Mar 17 2026           2.25 hours     │
│  Day 4    Thu, Mar 18 2026           1.50 hours     │
│  Day 5    Fri, Mar 19 2026           1.00 hours     │
└─────────────────────────────────────────────────────┘
```

---

## File Format

Assignments are stored in `data/assignments.txt` as pipe-delimited records:

```
Operating Systems Project|OS|2025-07-20|10.0|3|2.75|false
Data Structures Assignment|DSA|2025-07-18|6.0|4|0.0|false
```

Fields: `name | subject | deadline | totalHours | difficulty | completedHours | isCompleted`

---

## Author

**[Ayushi Gupta]**  
**[24BEC10164]**  
**[VIT Bhopal University]**  
**Course:** [Programming in Java]  


---

