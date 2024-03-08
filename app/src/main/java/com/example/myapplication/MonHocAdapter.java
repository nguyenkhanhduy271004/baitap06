package com.example.myapplication;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


public class MonHocAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<MonHoc> listMonHoc;
    private int positionSelect = -1;

    public MonHocAdapter(Context context, int idLayout, List<MonHoc> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listMonHoc = listLanguage;
    }

    @Override
    public int getCount() {
        if (listMonHoc.size() != 0 && !listMonHoc.isEmpty()) {
            return listMonHoc.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvLanguageName = (TextView) convertView.findViewById(R.id.tvLanguageName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final MonHoc monHoc = listMonHoc.get(position);

        if (listMonHoc != null && !listMonHoc.isEmpty()) {
            tvLanguageName.setText(monHoc.getName());
            String nameMonHoc = monHoc.getName();
            switch (nameMonHoc) {
                case "Java":
                    imageView.setImageResource(R.drawable.download_1);
                    break;
                case "C++":
                    imageView.setImageResource(R.drawable.download_2);
                    break;
                case "Python":
                    imageView.setImageResource(R.drawable.download_3);
                    break;
                case "C#":
                    imageView.setImageResource(R.drawable.download_4);
                    break;
                case "PHP":
                    imageView.setImageResource(R.drawable.download_5);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, monHoc.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}