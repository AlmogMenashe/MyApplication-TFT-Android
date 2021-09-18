package com.example.tft_android.FragmentTraining;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tft_android.FragmentTraining.Power.AbsFragment;
import com.example.tft_android.FragmentTraining.Power.BackFragment;
import com.example.tft_android.FragmentTraining.Power.BicepsFragment;
import com.example.tft_android.FragmentTraining.Power.ChestFragment;
import com.example.tft_android.FragmentTraining.Power.LegsFragment;
import com.example.tft_android.FragmentTraining.Power.ShouldersFragment;
import com.example.tft_android.R;
import com.example.tft_android.RegisterActivity;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PowerFragment extends Fragment {

    private Button BAbs, BBiceps, BLeg, BBack, BShoulder, BChest;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PowerFragment newInstance(String param1, String param2) {
        PowerFragment fragment = new PowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_power, container, false);

        BAbs = view.findViewById(R.id.buttonAbs);
        
        BAbs.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Abs = new AbsFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Abs);
            }
        });

        BBack = view.findViewById(R.id.buttonBack);

        BBack.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Back = new BackFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Back);
            }
        });

        BLeg = view.findViewById(R.id.buttonLeg);

        BLeg.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Leg = new LegsFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Leg);
            }
        });

        BShoulder = view.findViewById(R.id.buttonShoulder);

        BShoulder.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Shoulder = new ShouldersFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Shoulder);
            }
        });

        BChest = view.findViewById(R.id.buttonChest);

        BChest.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Chest = new ChestFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Chest);
            }
        });

        BBiceps = view.findViewById(R.id.buttonBiceps);

        BBiceps.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Biceps = new BicepsFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Biceps);
            }
        });

        return view;
    }
}
