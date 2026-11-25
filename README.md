# Java Snake Game

A grid-based Snake game written in Java as a personal programming project. The game runs in a graphical window and uses an object-oriented structure to manage the snake, apples, walls, movement, and collisions.
<img width="980" height="737" alt="image" src="https://github.com/user-attachments/assets/884d214d-92e9-4031-b7f8-4601c5b0f6e4" />
## Features

- Control the snake with the **arrow keys**.
- Move around a grid surrounded by boundary walls.
- Collect randomly placed apples to increase the score.
- Grow the snake after collecting an apple.
- Detect collisions with the boundary walls and the snake's own body.
- Display the final score when the game ends.

## Technologies

- **Language:** Java
- **GUI:** Java Swing-based game window using the provided `AudGameWindow` framework
- **Graphics support:** `AudGraphics` and `AudColor`
- **Core concepts:** Object-oriented programming, inheritance, abstraction, encapsulation, arrays, enums, and methods

## Object-Oriented Design

The project separates the game logic and game objects into several classes:

| Class | Responsibility |
|---|---|
| `SnakeGame` | Entry point and main game logic; handles the game timer, keyboard input, rendering, scoring, collisions, and apple creation. |
| `Snake` | Stores the snake's segments, controls its direction and movement, checks collisions, and handles growth. |
| `GameItem` | Abstract base class for objects placed on the game grid. |
| `Apple` | Represents an apple and provides its score value. |
| `Brick` | Represents the boundary blocks surrounding the playing area. |
| `Point` | Stores the x- and y-coordinates of a position on the grid. |

The project uses inheritance and method overriding through the `GameItem` base class and its `Apple` and `Brick` subclasses. The snake's body is represented with a `Point[]` array, while the boundary is stored in a `Brick[]` array.

The files `AudGameWindow.java`, `AudGraphics.java`, and `AudColor.java` provide the graphical support used by the game. They are included framework classes and are marked in the source code as classes that should not be modified.

## How to Run

### Requirements

- **JDK 17 or later**
- A desktop environment capable of opening a graphical Java window

No additional third-party libraries are required.

### Compile and start

Open a terminal in the project directory and run:

```bash
javac *.java
java SnakeGame
```

## Controls

| Key | Action |
|---|---|
| `↑` | Move up |
| `↓` | Move down |
| `←` | Move left |
| `→` | Move right |

## Concepts Practised

This project provided practical experience with:

- Designing classes and objects using **object-oriented programming (OOP)**.
- Using **inheritance**, **abstract classes**, and **method overriding**.
- Organising program logic into methods.
- Working with **arrays** and moving array elements with `System.arraycopy()`.
- Using an **enum** to represent movement directions.
- Validating method arguments by throwing `IllegalArgumentException` for invalid snake lengths or growth values.

> Note: The project uses exception-based argument validation; it does not currently implement general `try-catch` error recovery in the game logic.

---

This project was developed for learning and practising Java programming concepts.
