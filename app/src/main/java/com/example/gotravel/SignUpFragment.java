package com.example.gotravel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class SignUpFragment extends Fragment implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private static final String TAG="EmailPassword";
    EditText email,password,conPassword;
    Button signUpButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        mAuth=FirebaseAuth.getInstance();
        email=v.findViewById(R.id.email);
        password=v.findViewById(R.id.password);
        conPassword=v.findViewById(R.id.cpassword);
        signUpButton = v.findViewById(R.id.f_signUp_button);

        signUpButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == signUpButton.getId())
        {
            signUp();
        }


    }
    private void signUp()
    {
        Log.d(TAG,"signup"+email);
        if(!validateForm()){
            return;
        }
        String em=email.getText().toString();
        String pass=password.getText().toString();
        mAuth.createUserWithEmailAndPassword(em,pass)
                .addOnCompleteListener((Activity) requireContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(),MainActivity.class));
                            //getActivity().finish();
                        }else{
                            Log.w(TAG,"signUpWithEmail:failure",task.getException());
                            Toast.makeText(getContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        //getActivity().finish();
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
        String cpass=conPassword.getText().toString();
        if(TextUtils.isEmpty(cpass)) {
            conPassword.setError("Required");
            valid=false;
        }else{
            conPassword.setError(null);
        }
        if(!TextUtils.equals(pass,cpass)){
            conPassword.setError("Password does not match");
            valid=false;
        }else{
            conPassword.setError(null);
        }
        return valid;

    }
}
