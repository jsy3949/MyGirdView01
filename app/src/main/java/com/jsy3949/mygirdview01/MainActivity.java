package com.jsy3949.mygirdview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    GridView gridView;
    SingleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new SingleAdapter();

        adapter.addItem(new SingleItem("김만호","010-333-5656",R.drawable.if_aunt_3231118));
        adapter.addItem(new SingleItem("정민주","010-385-4878",R.drawable.if_brother_3231124));
        adapter.addItem(new SingleItem("유예진","010-455-3333",R.drawable.if_daughter_3231126));
        adapter.addItem(new SingleItem("김진호","010-445-6015",R.drawable.if_father_3231125));
        adapter.addItem(new SingleItem("정재희","010-584-9046",R.drawable.if_mother_3231122));


        gridView.setAdapter(adapter);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingleItem(name,mobile,R.drawable.ic_launcher_foreground));
                adapter.notifyDataSetChanged();
            }
        });

    }
    class SingleAdapter extends BaseAdapter{

        ArrayList<SingleItem> items = new ArrayList<SingleItem>();

        @Override
        public int getCount() {
            //배열리스트의 개수를 가져온다.
            return items.size();
        }

        public void addItem(SingleItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingleItemView view = new SingleItemView(getApplicationContext());

            SingleItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImg(item.getResId());

            int numColumns = gridView.getNumColumns();
            int rowIndex = position / numColumns;
            int coIumnIndex = position % numColumns;
            Log.d("SingleAdapter","index :"+ rowIndex+ " , "+coIumnIndex);

            return view;
        }
    }
}
