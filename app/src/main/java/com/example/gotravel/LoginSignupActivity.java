package com.example.gotravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import org.apache.commons.io.FileUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class LoginSignupActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private ChooseFragment chooseFragment;
    private LoginFragment loginFragment;
    private SignUpFragment signUpFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login_signup);
        chooseFragment = new ChooseFragment();
        loginFragment = new LoginFragment();
        signUpFragment = new SignUpFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.a_login_content, chooseFragment,
                chooseFragment.getClass().getName()).commit();
    }
    public void navigateToLogin() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction()
               .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                        R.anim.slide_in_left, R.anim.slide_out_right);
        hideAllVisibleFragment(ft);
        if (!loginFragment.isAdded()) {
            ft.add(R.id.a_login_content, loginFragment, loginFragment.getClass().getName());
        } else {
            ft.show(loginFragment);
        }
        ft.addToBackStack(null).commit();
        //finish();

    }
    public void navigateToSignUp() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction()
              .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                       R.anim.slide_in_left, R.anim.slide_out_right);
        hideAllVisibleFragment(ft);
        if (!loginFragment.isAdded()) {
            ft.add(R.id.a_login_content, signUpFragment, signUpFragment.getClass().getName());
        } else {
            ft.show(signUpFragment);
        }
        ft.addToBackStack(null).commit();
        //finish();
    }
    private List<Fragment> getVisibleFragments() {
        List<Fragment> result = new ArrayList<>(3);
        if (chooseFragment.isVisible()) {
            result.add(chooseFragment);
        }
        if (loginFragment.isVisible()) {
            result.add(loginFragment);
        }
        if (signUpFragment.isVisible()) {
            result.add(signUpFragment);
        }

        return result;
    }
    private FragmentTransaction hideAllVisibleFragment(FragmentTransaction fragmentTransaction) {
        for (Fragment fragment : getVisibleFragments()) {
            fragmentTransaction.hide(fragment);
        }
        return fragmentTransaction;
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }



}