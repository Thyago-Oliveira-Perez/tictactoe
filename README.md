# Tic-Tac-Toe Android App  

**A modern implementation of the classic Tic-Tac-Toe game for Android, featuring offline gameplay, smart draw detection, and clean UI with Jetpack Compose.**  

## 🎯 Key Features  

- **Two-player offline mode** (play on the same device)  
- **Smart AI detection**: Automatically identifies inevitable draws and resets the game  
- **Visual feedback**: X (Blue) vs O (Red) with Material Design 3 styling  
- **Score tracking**: Win counters for both players  
- **Responsive UI**: Works on phones and tablets  

## 🛠️ Technologies  

| Category       | Technologies Used |  
|----------------|-------------------|  
| **Language**   | Kotlin            |  
| **UI Toolkit** | Jetpack Compose   |  
| **Architecture** | MVVM            |  
| **Dependency Management** | Gradle Version Catalog (libs.versions.toml) |  

## 🎮 Game Logic Highlights  

1. **Draw Detection**:  
   ```kotlin  
   fun checkForDraw(board: List<Player?>): Boolean {  
       // Checks if no winning moves remain  
   }  
   ```  

2. **Win Validation**:  
   ```kotlin  
   val winPatterns = listOf(  
       listOf(0, 1, 2), // Rows  
       listOf(0, 3, 6), // Columns  
       listOf(0, 4, 8)  // Diagonals  
   )  
   ```  

## 🎨 UI Components  

| Component       | Description |  
|----------------|-------------|  
| `GameBoard`    | 3x3 grid with touch handling |  
| `BoardCell`    | Individual cell with X/O display |  
| `ScoreBoard`   | Shows player win counts |  
| `GameDialog`   | Displays win/draw messages |  

## 🚀 Future Roadmap  

- [ ] **Online multiplayer** (LAN/WiFi)  
- [ ] **Player profiles** with avatars  
- [ ] **Animated transitions** between moves  

## 📥 Installation  

1. Clone the repository:  
   ```bash  
   git clone https://github.com/Thyago-Oliveira-Perez/tictactoe.git
   ```  

2. Open in Android Studio (Giraffe or newer recommended)  

3. Build and run on emulator/device  

## 📜 License  

```  
MIT License  
Copyright (c) 2023 Thyago de Oliveira Perez 
```  

---

**Contributions welcome!** 🎉 For feature requests or bug reports, please open an issue.  

*Made with ❤️ using modern Android development tools*