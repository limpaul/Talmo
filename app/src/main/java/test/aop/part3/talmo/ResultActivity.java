package test.aop.part3.talmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    //private TextView answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10, userInfo;
   // private TextView[] answers;
    private TextView userInfo;
    private String[] answerInfo = new String[10];
    private TextView[] answers = new TextView[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        userInfo = findViewById(R.id.userInfo);
        answerInfo = new String[]{getString(R.string.a1), getString(R.string.a2), getString(R.string.a3), getString(R.string.a4), getString(R.string.a5),
                getString(R.string.a6), getString(R.string.a7), getString(R.string.a8), getString(R.string.a9), getString(R.string.a10)};

        for(int i = 0; i < 10 ; i++){
            answers[i] = findViewById(getResources().getIdentifier("answer"+(i+1),"id", getPackageName()));
        }

        Intent intent = getIntent();
        boolean[] test = intent.getBooleanArrayExtra("test");
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 20);
        String info = name+"님의 나이 "+age+"살님 진단 결과입니다";

        userInfo.setText(Html.fromHtml("<b>"+info+"</b>"+" "));
        for(int i = 0 ; i <test.length ; i++){
            if(test[i] == true){
                answers[i].setText(Html.fromHtml("<b>"+answerInfo[i]+"</b>"+" "));
            }else{
                answers[i].setText("걱정하지 마세요.!");
            }
        }

    }
}