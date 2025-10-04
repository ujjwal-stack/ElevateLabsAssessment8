package OnlineQuizApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizManager {
    private List<Questions> questions;
    private User currentUser;
    private List<UserAnswer> userAnswers;

    public QuizManager() {
        this.questions = new ArrayList<>();
        this.userAnswers = new ArrayList<>();
        initializeQuestions();
    }

    /**
     * Initialize quiz questions with diverse topics
     */
    private void initializeQuestions() {
        // Java Programming Questions
        questions.add(new Questions(
            "What is the size of int data type in Java?",
            Arrays.asList("8 bits", "16 bits", "32 bits", "64 bits"),
            2,
            "Java Basics"
        ));
        
        questions.add(new Questions(
            "Which keyword is used to inherit a class in Java?",
            Arrays.asList("inherits", "extends", "implements", "super"),
            1,
            "Java OOP"
        ));
        
        questions.add(new Questions(
            "What is the default value of a boolean variable in Java?",
            Arrays.asList("true", "false", "null", "0"),
            1,
            "Java Basics"
        ));
        
        questions.add(new Questions(
            "Which of these is not a Java feature?",
            Arrays.asList("Object-oriented", "Use of pointers", "Portable", "Dynamic"),
            1,
            "Java Features"
        ));
        
        questions.add(new Questions(
            "What is the parent class of all classes in Java?",
            Arrays.asList("System", "Main", "Object", "Class"),
            2,
            "Java OOP"
        ));
        
        // Data Structures Questions
        questions.add(new Questions(
            "Which data structure uses LIFO (Last In First Out)?",
            Arrays.asList("Queue", "Stack", "Tree", "Graph"),
            1,
            "Data Structures"
        ));
        
        questions.add(new Questions(
            "What is the time complexity of binary search?",
            Arrays.asList("O(n)", "O(log n)", "O(n²)", "O(1)"),
            1,
            "Algorithms"
        ));
        
        questions.add(new Questions(
            "Which collection class allows duplicate elements?",
            Arrays.asList("Set", "Map", "List", "None"),
            2,
            "Java Collections"
        ));
        
        // General Programming Questions
        questions.add(new Questions(
            "What does JVM stand for?",
            Arrays.asList("Java Virtual Machine", "Java Visual Machine", "Java Variable Method", "Java Verified Machine"),
            0,
            "Java Basics"
        ));
        
        questions.add(new Questions(
            "Which method is the entry point of a Java application?",
            Arrays.asList("start()", "main()", "run()", "init()"),
            1,
            "Java Basics"
        ));
    }

    public void setUser(User user) {
        this.currentUser = user;
        this.currentUser.setQuizStartTime(LocalDateTime.now());
    }
    
    public List<Questions> getQuestions() {
        return new ArrayList<>(questions);
    }
    
    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }

    public boolean submitAnswer(Questions question, int userAnswer) {
        boolean isCorrect = question.isCorrectAnswer(userAnswer);
        userAnswers.add(new UserAnswer(question, userAnswer, isCorrect));
        
        currentUser.incrementTotalQuestion();
        if (isCorrect) {
            currentUser.incrementScore();
        }
        
        return isCorrect;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public void endQuiz() {
        if (currentUser != null) {
            currentUser.setQuizEndTime(LocalDateTime.now());
        }
    }
    
    public List<UserAnswer> getUserAnswers() {
        return new ArrayList<>(userAnswers);
    }
    
    public Map<String, Integer> getCategoryPerformance() {
        Map<String, Integer> categoryScores = new HashMap<>();
        Map<String, Integer> categoryTotals = new HashMap<>();
        
        for (UserAnswer ua : userAnswers) {
            String category = ua.getQuestion().getCategory();
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0) + 1);
            if (ua.isCorrect()) {
                categoryScores.put(category, categoryScores.getOrDefault(category, 0) + 1);
            }
        }
        
        return categoryScores;
    }

    /**
     * Inner class to store user's answer details
     */
    private static class UserAnswer {
        private Questions question;
        private int userAnswer;
        private boolean correct;
        
        public UserAnswer(Questions question, int userAnswer, boolean correct) {
            this.question = question;
            this.userAnswer = userAnswer;
            this.correct = correct;
        }
        
        public Questions getQuestion() {
            return question;
        }
        
        public int getUserAnswer() {
            return userAnswer;
        }
        
        public boolean isCorrect() {
            return correct;
        }
    }
}
