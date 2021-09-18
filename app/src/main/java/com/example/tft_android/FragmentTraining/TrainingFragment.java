package com.example.tft_android.FragmentTraining;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tft_android.FragmentTraining.Power.BicepsFragment;
import com.example.tft_android.LoginActivity;
import com.example.tft_android.MainActivity;
import com.example.tft_android.R;
import com.example.tft_android.RegisterActivity;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingFragment extends Fragment {

    private Button BAllTraining, BCustomTraining;
    private TextView Key = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingFragment newInstance(String param1, String param2) {
        TrainingFragment fragment = new TrainingFragment();
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
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        Key = (TextView) view.findViewById(R.id.KeyText);

        TrainingActivity trainingActivity = (TrainingActivity) getActivity();
        trainingActivity.funcGetFromDB(Key);

        BAllTraining = view.findViewById(R.id.ButtonAllTraining);
        BCustomTraining = view.findViewById(R.id.buttonAdaptedTraining);

        BAllTraining.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment All = new AllTrainingFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadTrainingFragment(All);
            }
        });

        BCustomTraining.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                Fragment Custom = new AdaptedTrainingFragment();
                TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                trainingActivity.LoadTrainingFragment(Custom);
            }
        });


        return view;
    }
}
