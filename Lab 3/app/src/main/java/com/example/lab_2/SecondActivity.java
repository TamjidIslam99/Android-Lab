package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    public class Disease{
        List<String>getInfo(String dis){
            List<String>info= new ArrayList<>();
            if(dis.equals("Ebola")) {
                info.add("How It Spreads:\nContact with bodily fluids of infected people or animals.");
                info.add("\nSymptoms:\nEarly: Fever, sore throat.\nLater: Vomiting, diarrhea, bleeding.");
                info.add("\nPrecautions:\nAvoid contact with sick individuals.\nPractice good hygiene and use protective gear.");
                info.add("\nTreatment:\nSupportive care (hydration, pain relief).\nExperimental treatments and vaccines.");
            }

            if(dis.equals("Dengue")) {
                info.add("How It Spreads:\nThrough mosquito bites (Aedes mosquitoes).");
                info.add("\nSymptoms:\nEarly: High fever, severe headache.\nLater: Severe pain behind eyes, joint and muscle pain.");
                info.add("\nPrecautions:\nAvoid mosquito bites using repellents.\nUse mosquito nets and wear long sleeves.");
                info.add("\nTreatment:\nSupportive care (hydration, pain relief).\nNo specific antiviral treatment available.");
            }

            if(dis.equals("Monkey Pox")) {
                info.add("How It Spreads:\nContact with bodily fluids of infected people or animals.");
                info.add("\nSymptoms:\nEarly: Fever, sore throat.\nLater: Rash, swollen lymph nodes, pustules.");
                info.add("\nPrecautions:\nAvoid contact with infected individuals or animals.\nPractice good hygiene.");
                info.add("\nTreatment:\nSupportive care (hydration, pain relief).\nSmallpox vaccine may offer some protection.");
            }

            if(dis.equals("Covid 19")) {
                info.add("How It Spreads:\nThrough respiratory droplets from coughs, sneezes, or talking.");
                info.add("\nSymptoms:\nEarly: Fever, cough, fatigue.\nLater: Shortness of breath, loss of taste or smell.");
                info.add("\nPrecautions:\nWear masks, practice social distancing.\nWash hands frequently and use hand sanitizer.");
                info.add("\nTreatment:\nSupportive care (hydration, pain relief).\nAntiviral medications and vaccines available.");
            }

            return info;
        }
    }
    private Disease expert= new Disease();
    public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.text);
        List<String> infoList =expert.getInfo(messageText);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Information");
        messageView .setText(infoFormatted);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}