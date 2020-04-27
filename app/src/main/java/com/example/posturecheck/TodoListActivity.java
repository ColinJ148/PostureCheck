package com.example.posturecheck;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TodoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Button addBtn = findViewById(R.id.addBtn);

        final LinearLayout taskView = findViewById(R.id.taskList);
        final EditText titleEditText = (EditText) findViewById(R.id.editTitle);
        final EditText contentEditText = (EditText) findViewById(R.id.contentEditText);
        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task(titleEditText.getText().toString(),
                        contentEditText.getText().toString());
                TextView textView = new TextView(getApplicationContext());
                textView.setText(task.getTitle() + ": " + task.getContent());
                textView.setLayoutParams(lp);
                textView.setTextColor(Color.parseColor("#000000"));
                if (!task.getTitle().isEmpty() || !task.getContent().isEmpty()) {
                    taskView.addView(textView);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Enter title and" +
                            " content!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });


    }

}
