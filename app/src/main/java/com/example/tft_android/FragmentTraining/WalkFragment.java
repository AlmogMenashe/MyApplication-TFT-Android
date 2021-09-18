package com.example.tft_android.FragmentTraining;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tft_android.FragmentTraining.Run.HalfFragment;
import com.example.tft_android.FragmentTraining.Run.HalfHourFragment;
import com.example.tft_android.FragmentTraining.Run.HourFragment;
import com.example.tft_android.FragmentTraining.Run.TwoHourFragment;
import com.example.tft_android.R;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WalkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WalkFragment extends Fragment {

    private Button BHalf, BHour, BHalfHour, BTwoHour;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WalkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WalkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WalkFragment newInstance(String param1, String param2) {
        WalkFragment fragment = new WalkFragment();
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
        View view = inflater.inflate(R.layout.fragment_walk, container, false);

        BHalf = view.findViewById(R.id.buttonWalk30);
        BHour = view.findViewById(R.id.buttonWalk60);
        BHalfHour = view.findViewById(R.id.buttonWalk90);
        BTwoHour = view.findViewById(R.id.buttonWalk120);

        BHalf.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Half = new HalfFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Half);
            }
        });

        BHour.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Hour = new HourFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(Hour);
            }
        });

        BHalfHour.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment HalfHour = new HalfHourFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(HalfHour);
            }
        });

        BTwoHour.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment TwoHour = new TwoHourFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadSecFragment(TwoHour);
            }
        });

        return view;
    }
}
