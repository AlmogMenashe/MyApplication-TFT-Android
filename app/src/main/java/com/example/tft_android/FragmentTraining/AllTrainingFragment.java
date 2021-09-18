package com.example.tft_android.FragmentTraining;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tft_android.FragmentTraining.Power.BicepsFragment;
import com.example.tft_android.R;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllTrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllTrainingFragment extends Fragment {

    private Button BRun, BWalk, BPower;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllTrainingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllTrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllTrainingFragment newInstance(String param1, String param2) {
        AllTrainingFragment fragment = new AllTrainingFragment();
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
        View view = inflater.inflate(R.layout.fragment_all_training, container, false);

        BRun = view.findViewById(R.id.ButtonRun);
        BWalk = view.findViewById(R.id.ButtonWalk);
        BPower = view.findViewById(R.id.ButtonPower);

        BRun.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Run = new RunFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Run);
            }
        });

        BWalk.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Walk = new WalkFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Walk);
            }
        });

        BPower.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Power = new PowerFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Power);
            }
        });

        return view;
    }
}
