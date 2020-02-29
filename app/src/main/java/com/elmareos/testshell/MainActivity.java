package com.elmareos.testshell;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Helper helper;
    SQLiteDatabase db;
    ListView listView;
    Button btnStart, btnCancel;
    RadioButton rbControlSubject, rbControlTopic, rbStudyTopic;
    int choise = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new Helper(this);
        db = helper.getReadableDatabase();

        btnStart = findViewById(R.id.btnStart);
        btnCancel = findViewById(R.id.btnCancel);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        rbControlSubject = findViewById(R.id.rbControlSubject);
        rbControlSubject.setOnClickListener(this);

        rbControlTopic = findViewById(R.id.rbControlTopic);
        rbControlTopic.setOnClickListener(this);

        rbStudyTopic = findViewById(R.id.rbStudyTopic);
        rbStudyTopic.setOnClickListener(this);

        listView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM topics", null);
            cursor.moveToFirst();
            int index = cursor.getColumnIndex("nameTopic");
            while (!cursor.isAfterLast()){
                list.add(cursor.getString(index));
                cursor.moveToNext();
            }
            ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.list_item, list);
            listView.setAdapter(adapter);
            cursor.close();
            //listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    choise = position;
                }
            });
        }catch (SQLException e){
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                if (rbControlTopic.isChecked()){
                    if (choise == -1) {
                        Toast.makeText(this, "Необходимо выбрать тему!", Toast.LENGTH_LONG).show();
                        break;
                    }else{
                    }
                }
                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            case R.id.rbControlSubject:
                listView.setChoiceMode(ListView.CHOICE_MODE_NONE);
                break;
            case R.id.rbControlTopic:
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                break;
            case R.id.rbStudyTopic:
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                break;
        }
    }
}
