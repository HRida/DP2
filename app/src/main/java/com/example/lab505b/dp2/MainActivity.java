package com.example.lab505b.dp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btSave;
    private EditText edID,edName;
    private DBHelper2 db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSave = (Button) findViewById(R.id.savebutton);
        edID=(EditText)findViewById(R.id.studentid);
        edName=(EditText) findViewById(R.id.studentname);

        db=new DBHelper2(this);

        btSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                try{
                    int id = Integer.parseInt(edID.getText().toString());
                    String name = edName.getText().toString();
                    db.addStudent(new Student(id,name));
                    Toast.makeText(MainActivity.this,"student added successfully",Toast.LENGTH_SHORT).show();
                }
                catch(Exception ex)
                {
                    Toast.makeText(MainActivity.this,"can't add record",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
