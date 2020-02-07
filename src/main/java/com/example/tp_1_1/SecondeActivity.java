package com.example.tp_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondeActivity extends AppCompatActivity {
    Animal animal;
    TextView NamaAnimall;
    ImageView imageAnimal;
    TextView AnneNaissance;
    TextView periodeGestat;
    TextView PoindNaissance;
    TextView PoindAdulte;
    EditText Status;
    Button sauvegarde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);


        String  name = getIntent().getStringExtra("name");
        animal = AnimalList.getAnimal(name);

        NamaAnimall=findViewById(R.id.NameAnimal);
        NamaAnimall.setText(name);

         imageAnimal = findViewById(R.id.image);
        int id = getResources().getIdentifier(animal.getImgFile(),"drawable",getPackageName());
        imageAnimal.setImageResource(id);

        AnneNaissance=findViewById(R.id.TextVie);
       AnneNaissance.setText(animal.getStrHightestLifespan());

       periodeGestat=findViewById(R.id.periode);
       periodeGestat.setText(animal.getStrGestationPeriod());

       PoindNaissance=findViewById(R.id.poindNai);
       PoindNaissance.setText(animal.getStrBirthWeight());
       PoindAdulte=findViewById(R.id.poidAdul);
       PoindAdulte.setText(animal.getStrAdultWeight());

       Status=findViewById(R.id.Status);
       Status.setText(animal.getConservationStatus());

       sauvegarde=findViewById(R.id.button);
       sauvegarde.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
          animal.setConservationStatus(Status.getText().toString());
               Toast.makeText(getApplication(),"Sauvegarde effectué",Toast.LENGTH_LONG).show();

           }
       });

    }
}
