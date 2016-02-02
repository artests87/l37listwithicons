package com.example.artests.l37listwithicons;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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

    private String[] mDateArray = { "21 марта - 20 апреля", "21 апреля - 20 мая",
            "21 мая - 21 июня", "22 июня - 22 июля", "23 июля - 23 августа",
            "24 августа - 23 сентября", "24 сентября - 23 октября",
            "24 октября - 22 ноября", "23 ноября - 21 декабря",
            "22 декабря - 20 января", "21 января - 20 февраля",
            "21 февраля - 20 марта" };

    Integer[] mImageArray = { R.drawable.aries, R.drawable.taurus,
            R.drawable.gemini, R.drawable.cancer, R.drawable.lion,
            R.drawable.virgo, R.drawable.libra, R.drawable.scorpio,
            R.drawable.sagittarius, R.drawable.capricorn, R.drawable.aquarius,
            R.drawable.pisces };

    private MyAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*setListAdapter(new ArrayAdapter<>(this, R.layout.list_item,
                R.id.textViewCatName, mCatNames));*/
        // меняем на свой адаптер
        //setListAdapter(new MyCustomAdapter(this, R.layout.list_item, mSignArray));
        mAdapter = new MyAdapter(this);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // super.onListItemClick(l, v, position, id);
        //String selection = l.getItemAtPosition(position).toString();
        String selection = mAdapter.getString(position);
        Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }
    // Пишем свой класс-адаптер
    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        public MyAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return mSignArray.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public String getString(int position) {
            return mSignArray[position] + " (" + mDateArray[position] + ")";
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.list_item, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            image.setImageResource(mImageArray[position]);

            TextView signTextView = (TextView) convertView.findViewById(R.id.textViewSign);
            signTextView.setText(mSignArray[position]);

            TextView dateTextView = (TextView) convertView.findViewById(R.id.textViewDate);
            dateTextView.setText(mDateArray[position]);
            //convertView.setBackgroundColor((position & 1) == 1 ? Color.WHITE : Color.LTGRAY);
            if (position % 2 == 0) {
                convertView.setBackgroundResource(R.drawable.selector_1);
            } else {
                convertView.setBackgroundResource(R.drawable.selector_2);
            }
            return convertView;
        }
    }
    /*public class MyCustomAdapter extends ArrayAdapter<String> {

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
    }*/
}
