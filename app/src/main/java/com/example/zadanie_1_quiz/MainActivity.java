package com.example.zadanie_1_quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton=findViewById(R.id.true_button);
        falseButton=findViewById(R.id.false_button);
        nextButton=findViewById(R.id.next_button);
        questionTextView=findViewById(R.id.question_text_wiew);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                checkAnswerCorrectness(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                checkAnswerCorrectness(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex=(currentIndex+1)%questions.length;
                setNextQuestion();
            }
        });
        setNextQuestion();

    }

    private Question[] questions = new Question[]{
            new Question(R.string.q_kobayashi,true),
            new Question(R.string.q_legia,true),
            new Question(R.string.q_mbappe,true),
            new Question(R.string.q_messi,false),
            new Question(R.string.q_stoch,false)

    };
    private int currentIndex=0;
    private void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId=0;
        if(userAnswer==correctAnswer){
            resultMessageId=R.string.correct_anwer;
        }
        else{
            resultMessageId=R.string.incorrect_anwer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }
    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }

}