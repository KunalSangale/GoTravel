package com.example.gotravel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.gotravel.LoginSignupActivity;
import com.google.firebase.auth.FirebaseAuth;

public class ChooseFragment extends Fragment implements View.OnClickListener {

    private Button signUpButton;
    private Button logInButton;
    private FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose, container, false);
        logInButton = (Button) v.findViewById(R.id.f_choose_log_in);
        logInButton.setOnClickListener(this);
        signUpButton = (Button) v.findViewById(R.id.f_choose_sign_up);
        signUpButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == logInButton.getId()) {
            ((LoginSignupActivity) getActivity()).navigateToLogin();
        } else if (view.getId() == signUpButton.getId()) {
            ((LoginSignupActivity) getActivity()).navigateToSignUp();
        }
    }
}