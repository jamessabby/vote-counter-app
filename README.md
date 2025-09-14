# Vote Counter App 🗳️

A simple and intuitive Android voting counter application that allows users to track votes for multiple candidates in real-time.

## 📱 Features

- **Multi-Candidate Support**: Track votes for up to 3 candidates simultaneously
- **Real-Time Vote Counting**: Increment/decrement votes with easy-to-use +/- buttons
- **Individual Vote Tracking**: Each candidate maintains their own separate vote count
- **Visual Feedback**: Color-coded display shows which candidate is currently selected
- **Persistent Vote Storage**: Vote counts are preserved when switching between candidates
- **Clean UI Design**: Modern, user-friendly interface with clear visual indicators

## 🎯 How It Works

### Input Page
1. **Enter Candidate Names**: Users can input custom names for up to 3 candidates
2. **Start Voting**: Navigate to the counter page to begin vote tracking

### Counter Page
1. **Select Candidate**: Tap on any candidate button to select them for vote counting
2. **Visual Indication**: The main counter changes color to match the selected candidate:
   - 🟡 **Yellow** for Candidate 1
   - 🟢 **Green** for Candidate 2  
   - 🟠 **Orange** for Candidate 3
3. **Vote Counting**: Use the + and - buttons to adjust the selected candidate's vote count
4. **Individual Tracking**: Each candidate's current vote total is displayed below their name
5. **Switch Between Candidates**: Tap different candidate buttons to switch focus while preserving all vote counts

## 🛠️ Technical Details

### Built With
- **Language**: Java
- **IDE**: Android Studio
- **Target SDK**: Android API Level 36
- **UI Framework**: Android XML Layouts with ConstraintLayout

### Key Components
- **MainActivity**: Landing page with app branding
- **InputPage**: Candidate name input interface
- **CounterPage**: Main voting counter functionality

### Core Functionality
```java
// Individual vote storage for each candidate
int candidate1CountValue = 0;
int candidate2CountValue = 0;  
int candidate3CountValue = 0;

// Selection state tracking
boolean candidate1Selected, candidate2Selected, candidate3Selected;
```

## 📋 Usage Instructions

### Getting Started
1. Launch the app and tap "Start" on the welcome screen
2. Enter names for your candidates (or use default names)
3. Tap "Start Voting" to begin counting

### Voting Process
1. **Select a Candidate**: Tap on the candidate button you want to count votes for
2. **Count Votes**: 
   - Tap **+** to add a vote
   - Tap **-** to subtract a vote (minimum 0)
3. **Switch Candidates**: Tap another candidate button to switch focus
4. **View Results**: Individual vote counts are always visible below each candidate name

## 🔧 Installation

1. Clone this repository
2. Open the project in Android Studio
3. Build and run on an Android device or emulator
4. Ensure your device runs Android API Level 21 or higher

## 📝 Code Structure

```
app/
├── src/main/java/com/example/sabio_activity_2_counter_app/
│   ├── MainActivity.java          # Welcome screen
│   ├── InputPage.java            # Candidate input form
│   └── CounterPage.java          # Main voting counter
├── src/main/res/layout/
│   ├── activity_main.xml         # Main layout
│   ├── activity_input_page.xml   # Input form layout
│   └── activity_counter_page.xml # Counter interface layout
└── src/main/res/drawable/        # UI assets and backgrounds
```

## 🚀 Future Enhancements

Potential improvements for future versions:
- **Data Persistence**: Save vote counts between app sessions
- **Export Results**: Export voting results to CSV or PDF
- **More Candidates**: Support for additional candidates beyond 3
- **Vote History**: Track voting timeline and changes
- **Admin Panel**: Reset votes or manage candidates
- **Themes**: Multiple color themes and UI customization

## 👨‍💻 Developer

Created as a learning project to demonstrate:
- Android Activity navigation
- UI state management
- Event handling and user interactions
- Modern Android development practices

## 📄 License

This project is created for educational purposes. Feel free to use and modify as needed.

---

*Built using Android Studio*
