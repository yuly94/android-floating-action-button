package com.getbase.floatingactionbutton.sample;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by anonymous on 12/12/16.
 */

public class MainActivityDialog extends AppCompatActivity implements MyDialogFragment.UserNameListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FloatingActionButton A = (FloatingActionButton) findViewById(R.id.action_a);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                Fragment frag = fragmentManager.findFragmentByTag("fragment_edit_name");
                if (frag != null) {
                    fragmentManager.beginTransaction().remove(frag).commit();
                }

                MyDialogFragment editNameDialog = new MyDialogFragment();
                editNameDialog.show(fragmentManager, "fragment_edit_name");

            }
        });

        final FloatingActionButton B = (FloatingActionButton) findViewById(R.id.action_b);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                Fragment frag = fragmentManager.findFragmentByTag("fragment_edit_name");

                if (frag != null) {
                    fragmentManager.beginTransaction().remove(frag).commit();
                }

                MyAlertDialogFragment alertDialogFragment = new MyAlertDialogFragment();
                alertDialogFragment.show(fragmentManager, "fragment_edit_name");

            }
        });

    }

    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        // close existing dialog fragments
        FragmentManager manager = getSupportFragmentManager();
        Fragment frag = manager.findFragmentByTag("fragment_edit_name");
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit();
        }
        switch (view.getId()) {
            case R.id.action_a:
                MyDialogFragment editNameDialog = new MyDialogFragment();
                editNameDialog.show(manager, "fragment_edit_name");
                break;
            case R.id.action_b:
                MyAlertDialogFragment alertDialogFragment = new MyAlertDialogFragment();
                alertDialogFragment.show(manager, "fragment_edit_name");
                break;
        }
    }
}