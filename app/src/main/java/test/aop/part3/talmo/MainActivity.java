package test.aop.part3.talmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText age;
    private RadioGroup[] rgChk = new RadioGroup[10];
    private Button resultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0 ; i < 10 ; i++){
            rgChk[i] = findViewById(getResources().getIdentifier("rdgrp"+(i+1), "id", getPackageName()));
        }


        resultButton = findViewById(R.id.submit);
        resultButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean test[] = new boolean[10];

                RadioButton[] rValue = new RadioButton[10];
                name = findViewById(R.id.nameEditText);
                age = findViewById(R.id.ageEditText);

                if(name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "이름이 비어 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(age.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "나이가 비어 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                for(int i = 0 ; i < 10 ; i++) {
                    int chkId = rgChk[i].getCheckedRadioButtonId();
                    if (chkId == -1) {
                        Toast.makeText(MainActivity.this, (i+1)+"설문란이 비어 있습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        rValue[i] = findViewById(chkId);
                        if(rValue[i].getText().toString().equals("그렇다")){
                            test[i] = true;
                        }else{
                            test[i] = false;
                        }
                    }

                }
                Intent intent = new Intent(v.getContext() , ResultActivity.class);
                intent.putExtra("test", test);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("age", Integer.parseInt(age.getText().toString()));

                startActivity(intent);
            }
        });
    }

}