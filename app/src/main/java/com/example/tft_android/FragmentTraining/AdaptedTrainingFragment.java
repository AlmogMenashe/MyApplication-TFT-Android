package com.example.tft_android.FragmentTraining;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tft_android.R;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdaptedTrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdaptedTrainingFragment extends Fragment {

    private ImageButton Heart1, Heart2;
    private Button NextLeval;
    private TextView t;
    int i= 0 , j= 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdaptedTrainingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdaptedTrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdaptedTrainingFragment newInstance(String param1, String param2) {
        AdaptedTrainingFragment fragment = new AdaptedTrainingFragment();
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

        View view = inflater.inflate(R.layout.fragment_adapted_training, container, false);
        Heart1 = view.findViewById(R.id.imageButton1);
        Heart2 = view.findViewById(R.id.imageButton2);
        NextLeval  = view.findViewById(R.id.buttonextlevel);
        t = (TextView) view.findViewById(R.id.textTrain);
        t.setText("Training " + j+":");

       Heart1.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {
                Heart1.setBackgroundResource(R.drawable.red_heart);

                if (j == 1) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(1);
                    i++;
                } else if (j == 2) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(3);
                    i++;
                } else if (j == 3) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(5);
                    i++;
                }
                if(i == 2) {
                    NextLeval.setVisibility(View.VISIBLE);
                }
            }
        });

        Heart2.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {
                Heart2.setBackgroundResource(R.drawable.red_heart);
                if (j == 1) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(2);
                    i++;

                } else if (j == 2) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(4);
                    i++;
                } else if (j ==3) {
                    TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                    trainingActivity.funcHearts(6);
                    i++;
                }
                if(i == 2) {
                    NextLeval.setVisibility(View.VISIBLE);
                }
            }
        });

        NextLeval.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {
                if(i == 2) {
                    Heart1.setBackgroundResource(R.drawable.heart);
                    Heart2.setBackgroundResource(R.drawable.heart);
                    NextLeval.setVisibility(View.GONE);
                    i=0;
                    j++;
                    if (j==4){
                        Heart1.setVisibility(View.GONE);
                        Heart2.setVisibility(View.GONE);
                        t.setVisibility(View.GONE);
                        TrainingActivity trainingActivity = (TrainingActivity) getActivity();
                        trainingActivity.funcHearts(7);
                    }
                }
                if (j<=3){
                    t.setText("Training " + j+":");
                }
            }
        });

        return view;
    }
}
