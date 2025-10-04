package OnlineQuizApp;

import java.util.List;
import java.util.Scanner;

public class OnlineQuizApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuizManager quizManager = new QuizManager();
    
    // ANSI color codes for better UI
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";
    
    public static void main(String[] args) {
        displayWelcomeBanner();
        
        User user = registerUser();
        quizManager.setUser(user);
        
        displayQuizInstructions();
        
        if (confirmStart()) {
            startQuiz();
            displayResults();
        } else {
            System.out.println(YELLOW + "\nQuiz cancelled. Come back when you're ready!" + RESET);
        }
        
        scanner.close();
    }
    
    /**
     * Display welcome banner with ASCII art
     */
    private static void displayWelcomeBanner() {
        clearScreen();
        System.out.println(CYAN + BOLD);
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║              ONLINE QUIZ APPLICATION                       ║");
        System.out.println("║                                                            ║");
        System.out.println("║           Test Your Knowledge & Skills                     ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }
    
    /**
     * Register user and collect basic information
     */
    private static User registerUser() {
        System.out.println(BLUE + "\nUSER REGISTRATION" + RESET);
        System.out.println("─────────────────────────────────────────");
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        
        while (name.isEmpty()) {
            System.out.print(RED + "Name cannot be empty. Please enter your name: " + RESET);
            name = scanner.nextLine().trim();
        }
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();
        
        while (!isValidEmail(email)) {
            System.out.print(RED + "Invalid email format. Please enter a valid email: " + RESET);
            email = scanner.nextLine().trim();
        }
        
        System.out.println(GREEN + "\n✓ Registration successful! Welcome, " + name + "!" + RESET);
        
        return new User(name, email);
    }
    
    /**
     * Basic email validation
     */
    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.length() > 5;
    }
    
    /**
     * Display quiz instructions
     */
    private static void displayQuizInstructions() {
        System.out.println(YELLOW + "\nQUIZ INSTRUCTIONS" + RESET);
        System.out.println("─────────────────────────────────────────");
        System.out.println("Total Questions: " + quizManager.getQuestions().size());
        System.out.println("Each correct answer gives you 1 point");
        System.out.println("Enter the option number (1, 2, 3, or 4) for your answer");
        System.out.println("You cannot skip questions");
        System.out.println("Results will be shown at the end");
        System.out.println("─────────────────────────────────────────");
    }
    
    /**
     * Confirm if user wants to start the quiz
     */
    private static boolean confirmStart() {
        System.out.print("\nAre you ready to start the quiz? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
    
    /**
     * Main quiz logic - iterate through questions
     */
    private static void startQuiz() {
        List<Questions> questions = quizManager.getQuestions();
        quizManager.shuffleQuestions(); // Randomize question order
        
        System.out.println(GREEN + BOLD + "\nQUIZ STARTED!" + RESET);
        System.out.println("════════════════════════════════════════\n");
        
        for (int i = 0; i < questions.size(); i++) {
            Questions question = questions.get(i);
            displayQuestion(i + 1, question);
            
            int userAnswer = getUserAnswer(question.getOption().size());
            boolean isCorrect = quizManager.submitAnswer(question, userAnswer);
            
            provideFeedback(isCorrect, question);
            
            if (i < questions.size() - 1) {
                pressEnterToContinue();
            }
        }
        
        quizManager.endQuiz();
    }
    
    /**
     * Display a single question with options
     */
    private static void displayQuestion(int questionNumber, Questions question) {
        clearScreen();
        System.out.println(CYAN + "Question " + questionNumber + " of " + 
                         quizManager.getQuestions().size() + RESET);
        System.out.println(YELLOW + "Category: " + question.getCategory() + RESET);
        System.out.println("─────────────────────────────────────────");
        System.out.println(BOLD + "\n" + question.getQuestionText() + RESET);
        System.out.println();
        
        List<String> options = question.getOption();
        for (int i = 0; i < options.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + options.get(i));
        }
        System.out.println();
    }
    
    /**
     * Get and validate user's answer
     */
    private static int getUserAnswer(int maxOptions) {
        int answer = -1;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Your answer (1-" + maxOptions + "): ");
            try {
                String input = scanner.nextLine().trim();
                answer = Integer.parseInt(input) - 1; // Convert to 0-based index
                
                if (answer >= 0 && answer < maxOptions) {
                    validInput = true;
                } else {
                    System.out.println(RED + "Please enter a number between 1 and " + maxOptions + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input. Please enter a number." + RESET);
            }
        }
        
        return answer;
    }
    
    /**
     * Provide immediate feedback for the answer
     */
    private static void provideFeedback(boolean isCorrect, Questions question) {
        System.out.println();
        if (isCorrect) {
            System.out.println(GREEN + "✓ Correct! Well done!" + RESET);
        } else {
            System.out.println(RED + "✗ Incorrect!" + RESET);
            System.out.println(YELLOW + "The correct answer is: " + 
                             question.getCorrectAnswer() + RESET);
        }
    }
    
    /**
     * Display final quiz results with detailed statistics
     */
    private static void displayResults() {
        clearScreen();
        User user = quizManager.getCurrentUser();
        
        System.out.println(CYAN + BOLD);
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                     QUIZ COMPLETED!                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println(RESET);
        
        System.out.println(BLUE + "\nPARTICIPANT DETAILS" + RESET);
        System.out.println("─────────────────────────────────────────");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Time Taken: " + user.getTimeTaken());
        
        System.out.println(BLUE + "\nSCORE SUMMARY" + RESET);
        System.out.println("─────────────────────────────────────────");
        System.out.println("Correct Answers: " + GREEN + user.getScore() + RESET);
        System.out.println("Incorrect Answers: " + RED + 
                         (user.getTotalQuestions() - user.getScore()) + RESET);
        System.out.println("Total Questions: " + user.getTotalQuestions());
        
        double percentage = user.getPercentage();
        String grade = user.getGrade();
        
        System.out.println("\nPercentage: " + BOLD + String.format("%.2f%%", percentage) + RESET);
        System.out.println("Grade: " + BOLD + getGradeColor(grade) + grade + RESET);
        
        displayPerformanceBar(percentage);
        displayFinalMessage(percentage);
        
        System.out.println(CYAN + "\n─────────────────────────────────────────");
        System.out.println("Thank you for taking the quiz!");
        System.out.println("─────────────────────────────────────────" + RESET);
    }
    
    /**
     * Display visual performance bar
     */
    private static void displayPerformanceBar(double percentage) {
        System.out.println("\nPerformance:");
        System.out.print("[");
        
        int filled = (int) (percentage / 5); // 20 blocks for 100%
        for (int i = 0; i < 20; i++) {
            if (i < filled) {
                System.out.print(GREEN + "||" + RESET);
            } else {
                System.out.print("||");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Get color based on grade
     */
    private static String getGradeColor(String grade) {
        switch (grade) {
            case "A+":
            case "A":
                return GREEN;
            case "B":
            case "C":
                return YELLOW;
            default:
                return RED;
        }
    }
    
    /**
     * Display motivational message based on performance
     */
    private static void displayFinalMessage(double percentage) {
        System.out.println();
        if (percentage >= 90) {
            System.out.println(GREEN + "Outstanding performance! You're a star!" + RESET);
        } else if (percentage >= 70) {
            System.out.println(YELLOW + "Great job! Keep up the good work!" + RESET);
        } else if (percentage >= 50) {
            System.out.println(YELLOW + "Good effort! A little more practice will help!" + RESET);
        } else {
            System.out.println(RED + "Don't give up! Practice makes perfect!" + RESET);
        }
    }
    
    /**
     * Wait for user to press Enter
     */
    private static void pressEnterToContinue() {
        System.out.print(CYAN + "\nPress Enter to continue..." + RESET);
        scanner.nextLine();
    }
    
    /**
     * Clear screen (works on most terminals)
     */
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clear doesn't work, just print new lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
