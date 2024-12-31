# TowerDefenseEngine
custom tower defense game engine built in Java Swing 

A custom tower defense game engine built from scratch using Java Swing. Features spatial partitioning optimization, JSON-configurable maps, and custom sprite artwork.

## Features
- Custom game engine built with pure Java Swing
- Spatial partitioning system for performance optimization
- JSON-based map configuration
- Original sprite artwork and animations
- Path-following enemy AI
- Multiple tower types with different abilities
- Built-in map editor
- Menu system with map selection

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ, etc.)

### Installation
1. Clone the repository
```bash
git clone https://github.com/wijjam/JavaTowerDefense.git
```
2. Open the project in your preferred Java IDE
3. Run Main.java to start the game

## How to Play
1. Select a map from the dropdown menu
2. Click "Start Game" to begin
3. Place towers by selecting them from the right menu and clicking on valid ground tiles
4. Defend against waves of enemies
5. Earn coins by defeating enemies
6. Use coins to buy more towers

## Map Creation
The game includes a map editor that allows you to create custom maps:
1. Click the "Edit" button from the main menu
2. Use the editor tools to place terrain tiles
3. Save your map as a JSON file in the maps directory

## Project Structure
- `src/` - Source code
  - `sprite/` - Game sprites and images
  - `maps/` - JSON map files
- Key classes:
  - `GameBoard.java` - Main game rendering and logic
  - `Enemy.java` - Enemy movement and behavior
  - `TowerLogic.java` - Tower placement and targeting
  - `SectionLogic.java` - Spatial partitioning system

## Technical Details
- Written in Java
- Uses Swing for graphics
- No external game libraries
- Implements spatial partitioning for optimization
- JSON-based map system

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Built as a learning project for Java game development
- All sprites and artwork are original creations
