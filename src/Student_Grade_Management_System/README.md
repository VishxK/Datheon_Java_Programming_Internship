# Student Grade Management System

A lightweight, console-based Java application for managing students, recording course scores, calculating class-level statistics, and generating student report cards.

The project is intentionally dependency-free and uses only the Java standard library. All records are kept in memory for the duration of the application and are cleared when the program exits.

## Features

- Register students with a unique numeric ID.
- Record scores for individual courses.
- Validate scores on a `0–100` scale.
- Update an existing course score by entering the same course again.
- Calculate class-wide score count, average, and median.
- Generate report cards showing each student's:
  - ID and name
  - GPA
  - Number of recorded courses
  - Course scores

## Technology Stack

- **Language:** Java
- **JDK:** 17 or newer
- **Libraries:** Java Standard Library only
- **Interface:** Command-line console
- **Build system:** Direct `javac` compilation / IntelliJ IDEA

## Project Structure

```text
.
├── src/
│   ├── GradeManager.java       # Application entry point and menu workflow
│   └── Student.java            # Student model, scores, validation, and GPA logic
├── .idea/                      # IntelliJ IDEA project metadata
├── out/                        # Generated compiler output
├── .gitignore
└── README.md
```

## Prerequisites

Install **JDK 17 or newer** and verify that Java is available on your `PATH`:

```bash
java -version
javac -version
```

No database, package manager, or third-party dependency is required.

## Run from the Command Line

From the repository root, compile the source files:

### Windows

```bat
javac -d out\production\Datheon_Java_Programming_Internship src\Student.java src\GradeManager.java
java -cp out\production\Datheon_Java_Programming_Internship GradeManager
```

### macOS/Linux

```bash
mkdir -p out/production/Datheon_Java_Programming_Internship
javac -d out/production/Datheon_Java_Programming_Internship src/Student.java src/GradeManager.java
java -cp out/production/Datheon_Java_Programming_Internship GradeManager
```

## Run in IntelliJ IDEA

1. Open the repository in IntelliJ IDEA.
2. Ensure the project uses JDK 17 or newer.
3. Open `src/GradeManager.java`.
4. Run the `main` method in `GradeManager`.

## Application Workflow

When the application starts, it displays the following menu:

| Option | Action |
| --- | --- |
| `1` | Add a student |
| `2` | Record student marks |
| `3` | Compute class metrics |
| `4` | Generate report cards |
| `5` | Exit |

A typical session is:

1. Add one or more students.
2. Record one or more course scores for each student.
3. Select **Compute Class Metrics** to view the total number of scores, average, and median.
4. Select **Generate Report Cards** to view each student's GPA and course results.
5. Select **Exit**.

## GPA Calculation

GPA is calculated from the average of a student's recorded course scores using the following scale:

| Average score | GPA |
| --- | ---: |
| `85–100` | `4` |
| `70–84` | `3` |
| `55–69` | `2` |
| `40–54` | `1` |
| Below `40` | `0` |

Class metrics are calculated from all recorded course scores across all students, rather than from student GPA values.

## Design Notes

- `GradeManager` controls the console menu, input flow, student collection, and class-level calculations.
- `Student` encapsulates student identity, course scores, score validation, and GPA calculation.
- Course scores are stored by course name. Recording the same course again replaces its previous score.
- Scores outside the `0–100` range are rejected.
- Course display order is not guaranteed because scores are stored in a `HashMap`.

## Limitations

- Data is stored only in memory and is lost when the application exits.
- There is currently no database, file persistence, authentication, or web interface.
- The project does not include an automated test suite or a Maven/Gradle build configuration.
- Input is designed to be entered one response per line.


## License

No license for this project.
