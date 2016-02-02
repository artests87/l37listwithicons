package com.example.artests.l37listwithicons;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by artests on 02.02.2016.
 */
public class ListViewWithIconsActivity extends ListActivity {

    // определяем массив типа String
    /*private final String[] mCatNames = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
            "Кузя", "Китти", "Масяня", "Симба" };*/
    // Строка, которую мы выводим в список
    private String[] mSignArray = { "Овен", "Телец", "Близнецы", "Рак", "Лев", "Дева",
            "Весы", "Скорпион", "Стрелец", "Козерог", "Водолей", "Рыбы" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*setListAdapter(new ArrayAdapter<>(this, R.layout.list_item,
                R.id.textViewCatName, mCatNames));*/
        // меняем на свой адаптер
        setListAdapter(new MyCustomAdapter(this, R.layout.list_item, mSignArray));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // super.onListItemClick(l, v, position, id);
        String selection = l.getItemAtPosition(position).toString();
        Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }
    // Пишем свой класс-адаптер
    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.list_item, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textViewSign);
            label.setText(mSignArray[position]);
            ImageView iconImageView = (ImageView) row.findViewById(R.id.imageViewIcon);
            // Если текст содержит кота, то выводим значок Льва
            if (mSignArray[position] == "Лев") {
                iconImageView.setImageResource(R.drawable.lion);
            } else {
                iconImageView.setImageResource(R.drawable.ic_launcher);
            }
            return row;
        }
    }
}
