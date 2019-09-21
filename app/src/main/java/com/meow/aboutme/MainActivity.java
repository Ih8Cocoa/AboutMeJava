package com.meow.aboutme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.meow.aboutme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // (1) Create a data binding field to bind the layout of activity_main.
    // This is much faster than findViewById()
    private ActivityMainBinding binding;

    // (8) Now for binding data. Declare a field of MyName type
    private MyName myName = new MyName("Meow");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // (2) Instead of setContentView(), initialize the data binding field
        // setContentView(R.layout.activity_main);          (deleted after (2))
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // (3) From the data binding field, retrieve the done_button,
        // and add the on-click listener to it
        binding.doneButton.setOnClickListener(this::addNickname);

        // (9) The variables declared inside the XML file
        // can be accessed and modified through the binding field's getter and setter
        binding.setMyName(myName);
    }

    // Add the nickname
    private void addNickname(View view) {
        // (4) first off, get the text from the EditText through the binding field
        String text = binding.nicknameEdit.getText().toString();

        // (5) then set the text to nicknametext though binding field
        // binding.nicknameText.setText(text);              (added in (5) - deleted after (9))

        // (10) Retrieve the name from EditText and set it to the myName field
        myName.setName(text);

        // (6) although, a downsize to this is that you have to manually inform the app
        // when your data changes, so it could discard the old data and refresh the view.
        // Perfectly balanced.
        binding.invalidateAll();

        // (7) Hide the input button and display nicknameText.
        // Though the binding field, of course
        binding.nicknameEdit.setVisibility(View.GONE);
        binding.doneButton.setVisibility(View.GONE);
        binding.nicknameText.setVisibility(View.VISIBLE);

        // (copy-paste) Just a snippet to hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            IBinder windowToken = view.getWindowToken();
            imm.hideSoftInputFromWindow(windowToken, 0);
        }
    }
}
