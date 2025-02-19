# **Homework-1 Assignment: Refactoring MonolithicAdventureGame Using SOLID Principles**

## **Purpose**
This assignment aims to transform a monolithic game simulation into a well-structured, SOLID-compliant design by dividing responsibilities, incorporating abstractions, and enhancing maintainability.

---

## **Monolithic Code Base**
You have received a monolithic adventure game implementation where:

1. Player Management: Health, experience, and inventory are all managed within a single class.
2. Combat System: Rival encounters and damage calculations are tightly integrated.
3. Item Management: Item pickup and storage occur within the same monolithic structure.
4. Level Progression: Game levels, rival spawns, and resets are controlled by a single method.

---

## **How to Access the Refactoring**

### **1. Identify Responsibilities**
Break the existing **MonolithicAdventureGame** class into distinct components:

| Responsibility           | Suggested Class |
|-------------------------|----------------|
| **Player Management**  | `Player` |
| **Combat System**       | `CombatManager` |
| **Rival Handling**      | `RivalManager` |
| **Item Handling**       | `ItemManager` |
| **Level Progression**   | `LevelManager` |
| **Score Management**    | `ScoreManager` |

---

### **2. Apply SOLID Principles**

#### **вњ… Single Responsibility Principle (SRP)**
- Each class should focus on **only one** responsibility.
- **Example:** The `Player` class should not handle scoring or enemy interactions.

#### **вњ… Open/Closed Principle (OCP)**
- The system should be **open for extension** but **closed for modification**.
- **Example:** New rival types should be **added** without modifying the existing logic.

#### **вњ… Dependency Inversion Principle (DIP)**
- High-level modules should not depend on **low-level modules**.
- Use **interfaces** where applicable to **decouple dependencies**.
- **Example:** The `CombatManager` should rely on an `IRival` interface rather than concrete `Rival` classes.

#### **вњ… Liskov Substitution Principle (LSP)**
- Any subclass should **replace** its superclass **without breaking functionality**.
- **Example:** A `Dwarfs` or `Elves` class should be interchangeable without modifying the combat system.

#### **вњ… Interface Segregation Principle (ISP)**
- Avoid **large, bloated interfaces**вЂ”split them into **focused**, smaller interfaces.
- **Example:** Instead of a **single** `GameEntity` interface, create `IAttackable`, `IDamageable`, and `IItemInteractable`.

---

## **3. Documentation and UML Diagrams**
### **Write-Up**
- Explain **how your refactoring applies SOLID principles**.
- Justify **why** you structured the new classes as you did.

### **UML Diagrams (Optional, but Recommended)**
- **After Refactoring** в†’ Show the **new modular structure** with dependencies.

---

## **Submission Guidelines**
- **Submit:**
  1. **Refactored Java Code** (`.java` files)
  2. **Documentation** (`README.md` or `.pdf`)
  3. **UML Diagrams** (`.png`, `.jpg`, or `.pdf`)
- **Submission Method:** GitHub Repository

---

## **Example Folder Structure (After Refactoring)**
```
рџ“‚ SOLID-Refactored-AdventureGame
в”‚в”Ђв”Ђ рџ“‚ src
в”‚   в”њв”Ђв”Ђ рџ“‚ player
в”‚   в”‚   в”њв”Ђв”Ђ Player.java
в”‚   в”њв”Ђв”Ђ рџ“‚ combat
в”‚   в”‚   в”њв”Ђв”Ђ CombatManager.java
в”‚   в”њв”Ђв”Ђ рџ“‚ rivals
в”‚   в”‚   в”њв”Ђв”Ђ Rival.java
в”‚   в”‚   в”њв”Ђв”Ђ Orcs.java
в”‚   в”‚   в”њв”Ђв”Ђ Dwarfs.java
в”‚   в”‚   в”њв”Ђв”Ђ Elves.java
в”‚   в”њв”Ђв”Ђ рџ“‚ items
в”‚   в”‚   в”њв”Ђв”Ђ ItemManager.java
в”‚   в”‚   в”њв”Ђв”Ђ MiddleEastBones.java
в”‚   в”‚   в”њв”Ђв”Ђ TitanuimSteel.java
в”‚   в”‚   в”њв”Ђв”Ђ Oakshield.java
в”‚   в”њв”Ђв”Ђ рџ“‚ level
в”‚   в”‚   в”њв”Ђв”Ђ LevelManager.java
в”‚   в”њв”Ђв”Ђ рџ“‚ score
в”‚   в”‚   в”њв”Ђв”Ђ ScoreManager.java
в”‚   в”њв”Ђв”Ђ MainGame.java
в”‚
в”‚в”Ђв”Ђ рџ“‚ docs
в”‚   в”њв”Ђв”Ђ UML-Before-Refactor.png
в”‚   в”њв”Ђв”Ђ UML-After-Refactor.png
в”‚   в”њв”Ђв”Ђ SOLID-Refactoring-Report.pdf
в”‚
в”‚в”Ђв”Ђ README.md
```
