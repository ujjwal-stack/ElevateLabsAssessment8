# 🎯 Online Quiz Application
 - A feature-rich, console-based quiz application built with Java that demonstrates object-oriented programming principles, user interaction, and clean code design.

 ## 📋 Table of Contents

- Features
- Project Structure
- Prerequisites
- Installation
- How to Run
- How to Use
- Code Overview
- Screenshots
- Contributing
- Author
- License

---

## ✨ Features
### Core Features

- ✅ User Registration System - Capture user details with validation
- ✅ Multiple Choice Questions - Well-structured quiz with 4 options per question
- ✅ Dynamic Question Pool - 10 diverse questions covering Java, OOP, and Data Structures
- ✅ Real-time Scoring - Instant feedback after each answer
- ✅ Randomized Questions - Questions shuffled for each quiz attempt
- ✅ Category-based Questions - Questions organized by topics

## Advanced Features

- 🎨 Colorful Console UI - Enhanced user experience with ANSI color codes
- ⏱️ Time Tracking - Measure quiz completion time
- 📊 Performance Analytics - Detailed score breakdown and statistics
- 🎓 Grading System - Letter grades (A+ to F) based on percentage
- 📈 Visual Performance Bar - Graphical representation of results
- 🎯 Motivational Messages - Personalized feedback based on performance
- ✔️ Input Validation - Robust error handling and data validation

---

## 📁 Project Structure
### OnlineQuizApp/
    - │
    - ├── Question.java           # Question model with options and correct answer
    - ├── User.java              # User model with scoring and time tracking
    - ├── QuizManager.java       # Quiz logic, question management, and scoring
    - ├── OnlineQuizApp.java     # Main application with UI and flow control
    - └── README.md              # Project documentation (this file)

--- 

## 🔧 Prerequisites
 - Before running this project, ensure you have:

 - Java Development Kit (JDK) - Version 8 or higher

 - Download JDK


   - IDE (Recommended):

     - Visual Studio Code with Java Extension Pack
     - IntelliJ IDEA
     - Eclipse
     - Or any text editor with Java support

---

## 💾 Installation
### Option 1: Clone/Download the Project

- Download all four .java files to a single directory
- Ensure all files are in the same folder

### Option 2: Manual Setup

- Create a new folder named OnlineQuizApp
- Create four files:

  - Question.java
  - User.java
  - QuizManager.java
  - OnlineQuizApp.java

---

## 🚀 How to Run

- Using Command Line
  
```bash
Navigate to the project directory
cd OnlineQuizApp

# Compile all Java files
javac *.java

# Run the application
java OnlineQuizApp
Using VS Code

Open the project folder in VS Code
Open OnlineQuizApp.java
Click the Run button (▶️) above the main method
Or press F5 to run in debug mode
```

---


## 📖 How to Use

```bash
 - Step-by-Step Guide

 - Launch the Application

 - Run the program using any of the methods above

User Registration

   Enter your name: John Doe
   Enter your email: john.doe@example.com

Provide valid name (non-empty)
Provide valid email (must contain @ and .)


Read Instructions

Review quiz rules and format
Total questions and scoring information displayed


Start Quiz

Type yes or y to begin
Type no or n to cancel


Answer Questions

Read each question carefully
Enter option number (1-4)
Receive immediate feedback
Press Enter to continue to next question


View Results

See your final score and percentage
Check your grade (A+ to F)
View time taken
Read performance analysis
```


## 🔍 Code Overview

### Question.java

- Encapsulates question data
- Stores question text, options, correct answer index, and category
- Methods for answer validation and display

### User.java

- Manages user profile and performance
- Tracks score, total questions, and timestamps
- Calculates percentage, grade, and time taken

### QuizManager.java

- Central quiz logic controller
- Initializes question bank
- Handles answer submission and scoring
- Manages quiz flow and user interaction

### OnlineQuizApp.java

- Main application entry point
- User interface and console interactions
- Input validation and error handling
- Result visualization and display

## 📸 Screenshots
```bash
Welcome Screen
╔════════════════════════════════════════════════════════════╗
║                                                            ║
║            🎯  ONLINE QUIZ APPLICATION  🎯                ║
║                                                            ║
║           Test Your Knowledge & Skills                     ║
║                                                            ║
╚════════════════════════════════════════════════════════════╝
Question Display
Question 1 of 10
Category: Java Basics
─────────────────────────────────────────
What is the size of int data type in Java?

  1. 8 bits
  2. 16 bits
  3. 32 bits
  4. 64 bits

Your answer (1-4):
Results Screen
╔════════════════════════════════════════════════════════════╗
║                     QUIZ COMPLETED! 🎉                    ║
╚════════════════════════════════════════════════════════════╝
```

--- 

## 📊 SCORE SUMMARY
```bash
─────────────────────────────────────────
Correct Answers: 8
Incorrect Answers: 2
Total Questions: 10

Percentage: 80.00%
Grade: A

Performance:
[████████████████░░░░]

```

---

## 🤝 Contributing
Contributions are welcome! Here's how you can help:

### Fork the project
- Create a feature branch (git checkout -b feature/AmazingFeature)
- Commit your changes (git commit -m 'Add some AmazingFeature')
- Push to the branch (git push origin feature/AmazingFeature)
- Open a Pull Request

### Contribution Guidelines

 - Follow existing code style
 - Add comments for complex logic
 - Test thoroughly before submitting
 - Update README if adding new features

---

## 👨‍💻 Author
- Name: **Ujjwal Singh**

- Email: **ujjwalrajput1006@gmail.com**
- LinkedIn: [Your LinkedIn Profile](https://www.linkedin.com/in/ujjwal-singh-aa1697202/)
- GitHub: [@yourusername](https://github.com/ujjwal-stack)

## 📄 License
This project is licensed under the MIT License - see below for details:
MIT License

### Copyright (c) 2025 Ujjwal Singh

> [!NOTE]
> Permission is hereby granted, free of charge, to any person obtaining a copy
> of this software and associated documentation files (the "Software"), to deal
> in the Software without restriction, including without limitation the rights
> to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
> copies of the Software, and to permit persons to whom the Software is
>furnished to do so, subject to the following conditions:

> [!CAUTION]
> The above copyright notice and this permission notice shall be included in all
> copies or substantial portions of the Software.

> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
> FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
> AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
> LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
> OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
> SOFTWARE.

---

## 🙏 Acknowledgments

- Thanks to the Java community for excellent documentation
- Inspired by various online quiz platforms
- Built as part of a technical assessment task

## 📞 Support
If you encounter any issues or have questions:

- Ensure all files are in the same directory
- Verify Java is properly installed: java -version
- Open an issue on GitHub (if applicable)


⭐ If you found this project helpful, please consider giving it a star!
Made with ❤️ and ☕ by aspiring Java developers
