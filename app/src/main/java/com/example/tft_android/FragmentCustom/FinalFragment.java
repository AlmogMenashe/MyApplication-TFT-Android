package com.example.tft_android.FragmentCustom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tft_android.R;
import com.example.tft_android.TrainingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FinalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinalFragment extends Fragment {

    private TextView textView1, textView2, textView3, textView4, textView5, textView6;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FinalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FinalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FinalFragment newInstance(String param1, String param2) {
        FinalFragment fragment = new FinalFragment();
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
        View view =  inflater.inflate(R.layout.fragment_final, container, false);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);

        Bundle b = getArguments();

        String b1 = b.getString("1");
        String b2 = b.getString("2");
        String b3 = b.getString("3");
        String b4 = b.getString("4");
        String b5 = b.getString("5");
        String b6 = b.getString("6");

        textView1.setText(b1);
        textView2.setText(b2);
        textView3.setText(b3);
        textView4.setText(b4);
        textView5.setText(b5);
        textView6.setText(b6);

        return view;
    }
}
