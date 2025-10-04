package OnlineQuizApp;

import java.time.LocalDateTime;

public class User {
    private String name;
    private String email;
    private int score;
    private int totalQuestions;
    private LocalDateTime quizStartTime;
    private LocalDateTime quizEndTime;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.score= 0;
        this.totalQuestions = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(){
        this.score++;
    }

    public void incrementTotalQuestion(){
        this.totalQuestions++;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public double getPercentage(){
        if(totalQuestions==0){
            return 0;
        }
        return (score * 100.0)/totalQuestions;
    }

    public void setQuizStartTime(LocalDateTime quizStartTime) {
        this.quizStartTime = quizStartTime;
    }

    public void setQuizEndTime(LocalDateTime quizEndTime) {
        this.quizEndTime = quizEndTime;
    }

    public String getTimeTaken() {
        if(quizStartTime == null || quizEndTime == null) return "N/A";
        long seconds = java.time.Duration.between(quizStartTime, quizEndTime).getSeconds();
        long minutes = seconds/60;
        seconds = seconds % 60;
        return String.format("%d min %d sec", minutes, seconds);
    }

    public String getGrade(){
        double percentage = getPercentage();
        if(percentage >= 90) return "A+";
        else if(percentage >=80) return "A";
        else if(percentage >=70) return "B";
        else if(percentage >=60) return "C";
        else if(percentage >=50) return "D";
        else return "F";
    }

    

}
