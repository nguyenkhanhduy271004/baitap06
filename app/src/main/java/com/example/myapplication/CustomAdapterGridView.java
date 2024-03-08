package com.example.myapplication;

import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class CustomAdapterGridView extends AppCompatActivity {
    private GridView gridView;
    private List<MonHoc> listMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        gridView = (GridView) findViewById(R.id.gridview);

        listMonHoc = new ArrayList<>();
        listMonHoc.add(new MonHoc("Java", "Mô tả lập trình Java"));
        listMonHoc.add(new MonHoc("C++", "Mô tả lập trình C++"));
        listMonHoc.add(new MonHoc("Python", "Mô tả lập trình Python"));
        listMonHoc.add(new MonHoc("C#", "Mô tả lập trình C#"));
        listMonHoc.add(new MonHoc("PHP", "Mô tả lập trình PHP"));
        listMonHoc.add(new MonHoc("Java", "Mô tả lập trình Java"));
        MonHocAdapter adapter = new MonHocAdapter(this, R.layout.row_monhoc, listMonHoc);
        gridView.setAdapter(adapter);
    }
}
