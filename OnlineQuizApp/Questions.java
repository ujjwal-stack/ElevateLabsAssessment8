package OnlineQuizApp;

import java.util.List;

public class Questions{
    private String questionText;
    private List<String> option;
    private String category;
    private int correctAnswerIndex;
    
    public Questions(String questionText, List<String> option, int correctAnswerIndex, String category) {
        this.questionText = questionText;
        this.option = option;
        this.category = category;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOption() {
        return option;
    }

    public String getCategory() {
        return category;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isCorrectAnswer(int userAnswer){
        return userAnswer == correctAnswerIndex;
    }

    public String getCorrectAnswer(){
        return option.get(correctAnswerIndex);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");
        for(int i=0; i<option.size();i++){
            sb.append((i+1)).append(".").append(option.get(i)).append("\n");
        }
        return sb.toString();
    }

    
}