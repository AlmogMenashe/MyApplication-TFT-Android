package com.example.tft_android.FragmentRegister;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tft_android.R;
import com.example.tft_android.RegisterActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterOneFragment extends Fragment {

    private Button b;
    private EditText rEmail, rPassword, rName = null, rAge = null, rWeight = null, rHeight = null;
    private Spinner rSex, rTime;
    private CheckBox rMattress, rStairs, rBottles, rPullupBar;
    private String mattress = null, stairs = null, bottles = null, pullupbar = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterOneFragment newInstance(String param1, String param2) {
        RegisterOneFragment fragment = new RegisterOneFragment();
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
        View view = inflater.inflate(R.layout.fragment_register_one, container, false);

        b = (Button)view.findViewById(R.id.buttonRegisterSignUp);

        rEmail= (EditText)view.findViewById(R.id.inputRegisterEmail);
        rPassword= (EditText)view.findViewById(R.id.inputRegisterPassword);
        rName= (EditText)view.findViewById(R.id.inputFullName);
        rAge= (EditText)view.findViewById(R.id.inputAge);
        rWeight= (EditText)view.findViewById(R.id.inputWeight);
        rHeight= (EditText)view.findViewById(R.id.inputHeight);
        rSex= (Spinner)view.findViewById(R.id.spinnerSex);
        rTime= (Spinner)view.findViewById(R.id.spinnerTime);
        rMattress= (CheckBox)view.findViewById(R.id.checkBoxMattress);
        rStairs= (CheckBox)view.findViewById(R.id.checkBoxStairs);
        rBottles= (CheckBox)view.findViewById(R.id.checkBoxBottles);
        rPullupBar= (CheckBox)view.findViewById(R.id.checkBoxPullupBar);

        b.setOnClickListener(new View.OnClickListener() {  // קלאס פנימי
            @Override
            public void onClick(View view) {

                String email = rEmail.getText().toString();
                String password = rPassword.getText().toString();
                String name = rName.getText().toString();
                String age = rAge.getText().toString();
                String weight = rWeight.getText().toString();
                String height = rHeight.getText().toString();
                String sex = rSex.getSelectedItem().toString();
                String time = rTime.getSelectedItem().toString();

                if (rMattress.isChecked()) {
                    mattress = rMattress.getText().toString();
                }
                if (rStairs.isChecked()) {
                    stairs = rStairs.getText().toString();
                }
                if (rBottles.isChecked()) {
                    bottles = rBottles.getText().toString();
                }
                if (rPullupBar.isChecked()) {
                    pullupbar = rPullupBar.getText().toString();
                }

                RegisterActivity reg = (RegisterActivity) getActivity();
                reg.ButtonRegisterSignUp(email,password,name,age,weight,height,sex,time,mattress,stairs,bottles,pullupbar);

            }
        });

        return view;

    }
}
