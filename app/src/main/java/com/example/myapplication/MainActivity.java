package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.R.layout.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnsubmit;
    TextView textView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

    editText = findViewById(R.id.editText);
    btnsubmit = findViewById(R.id.btnsubmit);
    textView = findViewById(R.id.textView);

    // hide the textview filed at the beging

     textView.setVisibility(View.GONE);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idNumber = editText.getText().toString().trim();
                String dof = idNumber.substring(0,6);

                String date_temp = "";
                for(int i =0; i<dof.length(); i++) {
                    date_temp+= dof.charAt(dof.length()-(i+1));
                }
                //gender
                String gend = Character.toString(idNumber.charAt(6));
                int gender = Integer.parseInt(gend);
                // discover the gender depend on the value of the gender number
                String gender_type;
                if (gender<5)
                    gender_type = "Female";
                else
                    gender_type = "Male";
                //if it is citizen or not
                int citizen = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String citizenType;
                if (citizen!=0 )
                    citizenType = "temporary";
                else
                    citizenType = "citizen";



                textView.setVisibility(View.VISIBLE);
                textView.setText("date of birth "+date_temp+"\n"+
                                    "gender is "+gender_type+"\n"+
                                    "the nationality is "+citizenType+"\n");



            }
        });

    }
}
