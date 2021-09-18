package com.example.tft_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tft_android.Class.Person;
import com.example.tft_android.FragmentCustom.FinalFragment;
import com.example.tft_android.FragmentCustom.RedHeartFragment;
import com.example.tft_android.FragmentRegister.RegisterOneFragment;
import com.example.tft_android.FragmentTraining.AdaptedTrainingFragment;
import com.example.tft_android.FragmentTraining.Power.AbsFragment;
import com.example.tft_android.FragmentTraining.Power.BackFragment;
import com.example.tft_android.FragmentTraining.Power.BicepsFragment;
import com.example.tft_android.FragmentTraining.Power.ChestFragment;
import com.example.tft_android.FragmentTraining.Power.LegsFragment;
import com.example.tft_android.FragmentTraining.Power.ShouldersFragment;
import com.example.tft_android.FragmentTraining.Run.HalfFragment;
import com.example.tft_android.FragmentTraining.Run.HalfHourFragment;
import com.example.tft_android.FragmentTraining.Run.HourFragment;
import com.example.tft_android.FragmentTraining.TrainingFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class TrainingActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser user;
    String uid, case1 = null, case2, case3, case4, case5, case6;
    boolean Brun = false, Bwalk =false, Blegs= false ,BShoulders=false,BBiceps=false, BBabs=false, BBack=false;
    int index =0;
    ArrayList<String> arrayList = new ArrayList<String>();
    Random random = new Random();
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        TrainingFragment trainingFragment = new TrainingFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.TrainingFrameLayout,trainingFragment).commit();

        mAuth = FirebaseAuth.getInstance();
    }

    public void funcGetFromDB(final TextView key){

        uid = mAuth.getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Person").child(uid);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Person person = dataSnapshot.getValue(Person.class);
                key.setText("Welcome" + " " + person.getName());
                funcBmi(person);
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void LoadSecFragment(Fragment i){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.OptionsFragment,i);
        transaction.commit();
    }

    public void LoadTrainingFragment(Fragment i){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.TrainingFrameLayout,i);
        transaction.commit();
    }

    public void funcBmi(Person person){

        int Bmi = (Integer.parseInt(person.getWeight())/(Integer.parseInt(person.getHeight())))*2;
        if (18.5<Bmi && Bmi>25) {
            Bwalk = true;
        } else Brun = true;

        if (person.getStairs() != null){
            Blegs = true;
            arrayList.add("Chair");
        }

        if(person.getBottles() != null){
            BShoulders = true;
            BBiceps = true;
            arrayList.add("Bottles / Weights");
        }
        if(person.getMattress() != null){
            BBabs = true;
            arrayList.add("Mattress");
        }
        if(person.getPullupbar() != null){
             BBack = true;
            arrayList.add("Pullup Bar");
        }
            index = random.nextInt(arrayList.size() - 1 + 1);
    }

    public void funcHearts(int Heart){

        switch (Heart) {
            case 1:
                if (Bwalk==true){
                    Fragment fragment = new HalfFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.FrameTraining, fragment);
                    Toast.makeText(TrainingActivity.this, "Walk",
                            Toast.LENGTH_SHORT).show();
                    transaction.commit();

                    b.putString("1","Training 1: Walk training - Successfull");

               } else {
                    Fragment fragment = new HalfFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.FrameTraining, fragment);
                    Toast.makeText(TrainingActivity.this, "Run",
                            Toast.LENGTH_SHORT).show();
                    transaction.commit();

                    b.putString("1","Training 1: Run training - Successfull");
                }

                break;
            case 2:
                Fragment fragment2 = new ChestFragment();
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                transaction2.replace(R.id.FrameTraining, fragment2);
                transaction2.commit();

                b.putString("2","Training 1: Chest training - Successfull");
                break;
            case 3:
                if (Bwalk==true){
                    Fragment fragment3 = new HourFragment();
                    FragmentManager manager3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = manager3.beginTransaction();
                    transaction3.replace(R.id.FrameTraining, fragment3);
                    Toast.makeText(TrainingActivity.this, "Walk", Toast.LENGTH_SHORT).show();
                    transaction3.commit();
                    b.putString("3","Training 2: Walk training - Successfull");
                } else {
                    Fragment fragment3 = new HourFragment();
                    FragmentManager manager3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = manager3.beginTransaction();
                    transaction3.replace(R.id.FrameTraining, fragment3);
                    Toast.makeText(TrainingActivity.this, "Run", Toast.LENGTH_SHORT).show();
                    transaction3.commit();
                    b.putString("3","Training 2: Run training - Successfull");
                }
                break;
            case 4:

                 if (arrayList.get(index) == "Chair")
                 {
                  Fragment fragment4 = new LegsFragment();
                     FragmentManager manager4 = getSupportFragmentManager();
                     FragmentTransaction transaction4 = manager4.beginTransaction();
                     transaction4.replace(R.id.FrameTraining, fragment4);
                     transaction4.commit();
                     b.putString("4","Training 2: Legs training - Successfull");
                 }
                if (arrayList.get(index) == "Bottles / Weights")
                {
                    Fragment fragment4 = new BicepsFragment();
                    FragmentManager manager4 = getSupportFragmentManager();
                    FragmentTransaction transaction4 = manager4.beginTransaction();
                    transaction4.replace(R.id.FrameTraining, fragment4);
                    transaction4.commit();
                    b.putString("4","Training 2: Biceps training - Successfull");
                }
                if (arrayList.get(index) == "Mattress")
                {
                    Fragment fragment4 = new AbsFragment();
                    FragmentManager manager4 = getSupportFragmentManager();
                    FragmentTransaction transaction4 = manager4.beginTransaction();
                    transaction4.replace(R.id.FrameTraining, fragment4);
                    transaction4.commit();
                    b.putString("4","Training 2: Abs training - Successfull");
                }
                if (arrayList.get(index) == "Pullup Bar")
                {
                    Fragment fragment4 = new BackFragment();
                    FragmentManager manager4 = getSupportFragmentManager();
                    FragmentTransaction transaction4 = manager4.beginTransaction();
                    transaction4.replace(R.id.FrameTraining, fragment4);
                    transaction4.commit();
                    b.putString("4","Training 2: Back training - Successfull");
                }

                break;
            case 5:
                if (Bwalk==true){
                    Fragment fragment5 = new HalfHourFragment();
                    FragmentManager manager5 = getSupportFragmentManager();
                    FragmentTransaction transaction5 = manager5.beginTransaction();
                    transaction5.replace(R.id.FrameTraining, fragment5);
                    Toast.makeText(TrainingActivity.this, "Walk",
                            Toast.LENGTH_SHORT).show();
                    transaction5.commit();
                    b.putString("5","Training 3: Walk training - Successfull");
                } else {
                    Fragment fragment5 = new HalfHourFragment();
                    FragmentManager manager5 = getSupportFragmentManager();
                    FragmentTransaction transaction5 = manager5.beginTransaction();
                    transaction5.replace(R.id.FrameTraining, fragment5);
                    Toast.makeText(TrainingActivity.this, "Run",
                            Toast.LENGTH_SHORT).show();
                    transaction5.commit();
                    b.putString("5","Training 3: Run training - Successfull");
                }

                break;
            case 6:
                if (arrayList.get(index) == "Chair")
                {
                    Fragment fragment6 = new LegsFragment();
                    FragmentManager manager6 = getSupportFragmentManager();
                    FragmentTransaction transaction6 = manager6.beginTransaction();
                    transaction6.replace(R.id.FrameTraining, fragment6);
                    transaction6.commit();
                    b.putString("6","Training 3: Legs training - Successfull");
                }
                if (arrayList.get(index) == "Bottles / Weights")
                {
                    Fragment fragment6 = new BicepsFragment();
                    FragmentManager manager6 = getSupportFragmentManager();
                    FragmentTransaction transaction6 = manager6.beginTransaction();
                    transaction6.replace(R.id.FrameTraining, fragment6);
                    transaction6.commit();
                    b.putString("6","Training 3: Biceps training - Successfull");
                }
                if (arrayList.get(index) == "Mattress")
                {
                    Fragment fragment6 = new AbsFragment();
                    FragmentManager manager6 = getSupportFragmentManager();
                    FragmentTransaction transaction6 = manager6.beginTransaction();
                    transaction6.replace(R.id.FrameTraining, fragment6);
                    transaction6.commit();
                    b.putString("6","Training 3: Abs training - Successfull");
                }
                if (arrayList.get(index) == "Pullup Bar")
                {
                    Fragment fragment6 = new BackFragment();
                    FragmentManager manager6 = getSupportFragmentManager();
                    FragmentTransaction transaction6 = manager6.beginTransaction();
                    transaction6.replace(R.id.FrameTraining, fragment6);
                    transaction6.commit();
                    b.putString("6","Training 3: Back training - Successfull");
                }

                break;

            case 7:

                Fragment fragment7 = new FinalFragment();
                FragmentManager manager7 = getSupportFragmentManager();
                FragmentTransaction transaction7 = manager7.beginTransaction();
                fragment7.setArguments(b);
                transaction7.replace(R.id.FrameTraining, fragment7);
                transaction7.commit();

                break;

            default:
                System.out.println("L");
        }

    }

}
