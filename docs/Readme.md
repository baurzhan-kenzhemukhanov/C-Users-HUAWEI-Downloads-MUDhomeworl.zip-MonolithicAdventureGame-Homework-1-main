# Adventure Game Refactoring Implementation
Made by Baurzhan Kenzhemukhanov / ShP 2223


## Review
This project showcases the transformation of a monolithic adventure game into a well-structured design that adheres to SOLID principles. Initially, all game logic was confined to a single class, leading to multiple SOLID violations. The refactored version organizes functionalities into separate components, enhancing maintainability, scalability, and testability.

## Project Structure
```
src/
в”њв”Ђв”Ђ рџ“‚ interfaces/
в”‚   в”њв”Ђв”Ђ IEntity.java        # Base interface for all game entities
в”‚   в”њв”Ђв”Ђ IEntityType.java    # Entity type definitions
в”‚   в”њв”Ђв”Ђ ICombatant.java     # Interface for combat-capable entities
в”‚   в”њв”Ђв”Ђ IItem.java          # Interface for collectible items
в”‚   в””в”Ђв”Ђ IItemType.java      # Item type definitions
в”њв”Ђв”Ђ рџ“‚ player/
в”‚   в””в”Ђв”Ђ Player.java         # Player implementation
в”њв”Ђв”Ђ рџ“‚ rival/
в”‚   в”њв”Ђв”Ђ Rival.java          # Base abstract class for rivals
в”‚   в”њв”Ђв”Ђ Orcs.java           # Orcs rival implementation
в”‚   в”њв”Ђв”Ђ Dwarfs.java         # Dwarfs rival implementation
в”‚   в””в”Ђв”Ђ Elves.java          # Elves rival implementation
в”њв”Ђв”Ђ рџ“‚ items/
в”‚   в”њв”Ђв”Ђ Weapon.java            # Items that can help to improve attack power 
в”‚   в”њв”Ђв”Ђ MiddleEastBones.java   # Health regeneration item
в”‚   в”њв”Ђв”Ђ TitanuimSteel.java     # Experience-giving item
в”‚   в””в”Ђв”Ђ Oakshield.java         # Experience-boosting item
в”њв”Ђв”Ђ рџ“‚ locations/
в”‚   в”њв”Ђв”Ђ Room.java              # Simple room logic
в”‚
в”њв”Ђв”Ђ рџ“‚ managers/
в”‚   в”њв”Ђв”Ђ CombatManager.java  # Handles combat interactions
в”‚   в””в”Ђв”Ђ LevelManager.java   # Manages level progression and spawning
в”њв”Ђв”Ђ рџ“‚ controller/
в”‚   в”њв”Ђв”Ђ MUDController.java  # Handles user commands using Scanner
в”‚   в””в”Ђв”Ђ LevelManager.java   # Manages level progression and spawning
в”‚в”Ђв”Ђ Game.java               # Main game orchestration
в”‚
в”њв”Ђв”Ђ рџ“‚ test/
в”‚   в”њв”Ђв”Ђ TestMUD.java  # Main class for playing with MUD controller, with predefined game map.

```

## SOLID Principles Implementation

### 1пёЏвѓЈ Single Responsibility Principle (SRP)
Each class has been designed with a single, well-defined responsibility:
- `Player`: Manages player state and attributes
- `Rivals`: Defines base rivals behavior
- `CombatManager`: Handles combat logic exclusively
- `LevelManager`: Manages level progression and entity spawning
- `Item` classes: Each handles its specific item behavior
- Type interfaces: Separate enums into dedicated interfaces (`IEntityType`, `IItemType`)

### 2пёЏвѓЈ Open/Closed Principle (OCP)
The design is open for extension but closed for modification:
- New rivals types can be added by extending `Rivals` without modifying existing code
- New items can be implemented through the `IItem` interface
- New combat mechanics can be added by extending `CombatManager`
- New level types can be added in `LevelManager` without changing other components
- New entity or item types can be added to their respective type interfaces

### 3пёЏвѓЈ Liskov Substitution Principle (LSP)
All derived classes can be used in place of their base classes:
- All rivals (Orcs, Dwarfs, Elves) are interchangeable through the `Rivals` base class
- All items are usable through the `IItem` interface
- All combat participants implement `ICombatant` consistently

### 4пёЏвѓЈ Interface Segregation Principle (ISP)
Interfaces are focused and minimal:
- `IEntity`: Basic entity properties (name, type)
- `IEntityType`: Entity type enumeration
- `ICombatant`: Combat-specific behaviors (health, damage, experience)
- `IItem`: Item-specific behaviors (use effect)
- `IItemType`: Item type enumeration

### 5пёЏвѓЈ Dependency Inversion Principle (DIP)
High-level modules depend on abstractions:
- Game class depends on interfaces rather than concrete implementations
- Managers work with interfaces (`ICombatant`, `IItem`) rather than specific classes
- Combat system is decoupled from specific entity implementations
- Type systems use interface-based enums for better encapsulation

## Key Components

### Player System
- Player class implements `ICombatant`
- Manages health, experience, and inventory
- Damage calculation based on experience level

### Rivals System
- Base `Rivals` class with common functionality
- Specific rivals types with unique attributes:
  - Orcs: Low health, low damage
  - Dwarfs: Medium health, medium damage
  - Elves: High health, high damage

### Item System
- Items implement `IItem` interface
- Three types of items:
  - Middle East Bones: Regeneration of player health
  - Titanuim Steel: Gives a small experience level
  - Oakshield: Gives a bigger experience level

### Combat System
- Handles attack and counter-attack mechanics
- Manages damage calculation and health updates
- Provides combat feedback through console output

### Level Management
- Controls level progression
- Manages rivals and item spawning
- Tracks level completion conditions

## Expansibility
The updated design makes it easy to add:
1. New Rivals Types: Create new class extending `Rivals`
2. New Items: Implement `IItem` interface
3. New Combat Mechanics: Extend `CombatManager`
4. New Level Types: Add to `LevelManager`

## Refactoring Choise
1. Greater maintainability via distinct responsibilities
2. Improved testability with well-defined boundaries
3. Cleaner and more readable code
4. Well-structured separation of game mechanics

## Class Structure Meaning
The refactored classes follow SOLID principles, improving maintainability, testability, and extensibility. By separating concerns, each class has a single responsibility, reducing complexity. Interfaces decouple dependencies, enabling modular design and easy feature additions like new rivals, items, or mechanics without affecting existing code.

## Running the Game
```java
public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
```

The game features a console-based interface that displays:

1. Combat encounters
2. Item pickups
3. Level progression
4. Player status updates
5. The final game outcome
