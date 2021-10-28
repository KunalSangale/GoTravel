package com.example.gotravel;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private static final String TAG="EmailPassword";
    EditText email,password;
    Button loginButton;
    FirebaseAuth.AuthStateListener mAuthListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login2, container, false);
        mAuth=FirebaseAuth.getInstance();
        loginButton = v.findViewById(R.id.f_login_button);
        email=v.findViewById(R.id.email);
        password=v.findViewById(R.id.password);
        loginButton.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v) {

        if(v.getId() == loginButton.getId())
        {
            signIn();
        }

    }
    public void signIn()
    {
        Log.d(TAG,"signIn"+email);
        if(!validateForm()){
            return;
        }
        String em=email.getText().toString();
        String pass=password.getText().toString();
        mAuth.signInWithEmailAndPassword(em,pass)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getActivity(),MainActivity.class));
                        }else{
                            Log.w(TAG,"signInWithEmail:failure",task.getException());
                            Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private boolean validateForm(){
        boolean valid=true;
        String em=email.getText().toString();
        if(TextUtils.isEmpty(em)) {
            email.setError("Required");
            valid=false;
        }else{
            email.setError(null);
        }
        String pass=password.getText().toString();
        if(TextUtils.isEmpty(pass)) {
            password.setError("Required");
            valid=false;
        }else{
            password.setError(null);
        }

        return valid;

    }


}
