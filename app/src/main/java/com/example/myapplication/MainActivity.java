package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import java.util.ArrayList; // Thêm import này

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText editTextNewItem;
    Button buttonAddItem;
    Button buttonUpdate;
    int selectedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();
        itemList.add("Java");
        itemList.add("C#");
        itemList.add("PHP");
        itemList.add("Kotlin");
        itemList.add("Dart");
        editTextNewItem = findViewById(R.id.editTextNewItem);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editTextNewItem.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    itemList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editTextNewItem.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên khóa học!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemPosition = position;
                editTextNewItem.setText(itemList.get(position));
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemPosition != -1) {
                    String updatedItem = editTextNewItem.getText().toString().trim();
                    if (!updatedItem.isEmpty()) {
                        itemList.set(selectedItemPosition, updatedItem);
                        adapter.notifyDataSetChanged();
                        editTextNewItem.setText("");
                        selectedItemPosition = -1;
                    } else {
                        itemList.remove(selectedItemPosition);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Xóa thành công!!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn khóa học để cập nhật!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
