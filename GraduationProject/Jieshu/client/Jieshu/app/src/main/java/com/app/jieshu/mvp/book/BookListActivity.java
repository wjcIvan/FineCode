package com.app.jieshu.mvp.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.jieshu.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    JSONArray array;
    JSONArray arrayY;
    boolean isScan = false;
    EditText et;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        lv = findViewById(R.id.lv);
        et = findViewById(R.id.et);
        findViewById(R.id.layout_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        try {
            arrayY = new JSONArray(getIntent().getStringExtra("book"));
            array = arrayY;
            isScan = getIntent().getBooleanExtra("isScan", false);
            lv.setOnItemClickListener(this);
            adapter = new MyAdapter();
            lv.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                array = new JSONArray();
                String str = s.toString();
                if (str.equals("")) {
                    array = arrayY;
                } else {
                    for (int i = 0; i < arrayY.length(); i++) {
                        JSONObject object = arrayY.optJSONObject(i);
                        if(object.optString("bname").contains(str)){
                            array.put(object);
                        }
                    }
                }
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(BookListActivity.this, BookMsgActivity.class).putExtra("object", array.optString(position)).putExtra("isScan", isScan));
    }

    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return array.length();
        }

        @Override
        public Object getItem(int position) {
            return array.optJSONObject(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            JSONObject object = array.optJSONObject(position);
            Holder holder = null;
            if (convertView == null) {
                convertView = BookListActivity.this.getLayoutInflater().inflate(R.layout.item2, null);
                holder = new Holder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            String name = object.optString("bname");
            String author = object.optString("author");


            holder.tvTitle.setText(name);
            holder.tv2.setText("作者：" + author);
            holder.tv3.setText(object.optString("sumary"));
            String img = object.optString("img");
            Picasso.with(BookListActivity.this).load(img).resize(100, 100).centerCrop().into(holder.iv);
            return convertView;
        }
    }

    class Holder {
        ImageView iv;
        TextView tvTitle, tv2, tv3;

        public Holder(View item) {
            this.iv = item.findViewById(R.id.iv);
            this.tvTitle = item.findViewById(R.id.tvTitle);
            this.tv2 = item.findViewById(R.id.tv2);
            this.tv3 = item.findViewById(R.id.tv3);
        }
    }
}
