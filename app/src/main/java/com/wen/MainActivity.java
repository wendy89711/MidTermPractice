package com.wen;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView mail;
    private TextView pass;
    private ImageView errorName;
    private ImageView errorPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.ed_username);
        mail = findViewById(R.id.ed_email);
        pass = findViewById(R.id.ed_password);
        errorName = findViewById(R.id.imageView_name);
        errorPassword = findViewById(R.id.imageView_pass);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @SuppressLint("WrongConstant")
    public void registerButton(View view) {
        name.getText();
        pass.getText();
        if (name.length() >= 3 && pass.length() >= 6 && mail.length() != 0) {
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("Registration Success")
//                    .setMessage("Welcome")
//                    .setPositiveButton("OK", null)
//                    .show();
            Intent intent = new Intent(this,ResultActivity.class);
            startActivity(intent);//無法案ok跑到下一個介面
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("Registration Success")
//                    .setMessage("Welcome")
//                    .setPositiveButton("OK", null)
//                    .show();
        } else if (name.length() < 3) {
            errorName.setVisibility(View.VISIBLE);
        } else if (pass.length() < 6) {
            errorPassword.setVisibility(View.VISIBLE);
        } else if (mail.length() == 0) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("email can not empty.")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
