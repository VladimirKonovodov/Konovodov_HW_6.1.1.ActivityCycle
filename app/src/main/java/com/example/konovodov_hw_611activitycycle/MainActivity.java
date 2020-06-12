package com.example.konovodov_hw_611activitycycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //public static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY_BUNDLE = "textView";
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        textView.append("\n" + "onCreate()");

        if (savedInstanceState == null) {
            log("onCreate (" + savedInstanceState + ")" + " Bundle - null");
        } else {
            log("onCreate (" + savedInstanceState + ")"+ " Bundle - not null");
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        log("onStart()");
        textView.append("\n" + "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause()");
        textView.append("\n" + "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume()");
        textView.append("\n" + "onResume()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        log("onStop()");
        textView.append("\n" + "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy()");
        textView.append("\n" + "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart()");
        textView.append("\n" + "onRestart()");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        log("onPostCreate()");
        textView.append("\n" + "onPostCreate()");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        log("onPostResume()");
        textView.append("\n" + "onPostResume()");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        log("onKeyDown()");
        textView.append("\n" + "onKeyDown()");
         return super.onKeyDown(keyCode, event);
        //return true;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        log("onKeyLongPress()");
        textView.append("\n" + "onKeyLongPress()");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        log("onBackPressed()");
        textView.append("\n" + "onBackPressed()");
        super.onBackPressed();
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        log("onSaveInstanceState() "+ " сохранили информацию в Bundle");
        textView.append("\n" + "onSaveInstanceState()" );
        outState.putString(KEY_BUNDLE, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        log("onRestoreInstanceState()" +" восстановили информацию из Bundle");
        //textView.append("\n" + "onRestoreInstanceState()");
        textView.setText(savedInstanceState.getString(KEY_BUNDLE)+ "\nonRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);

    }

    private void log(String msg) {
        Log.v("Lifecycle", msg);
    }
}
