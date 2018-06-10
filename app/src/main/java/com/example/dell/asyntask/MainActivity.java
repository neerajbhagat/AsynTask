package com.example.dell.asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView mainList;
    private String[] texts={"Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay"
    ,"Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay"
    ,"Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay"
    ,"Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay",
            "Neeraj","Suraj","puran","Tinku","Sandeep","Gourav","Chandan","Tahira","Prinyka","Sonu","Monu","Ajay","Vijay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        mainList=(ListView)findViewById(R.id.listview1);
        mainList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,new ArrayList<String>()));
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, texts[position], Toast.LENGTH_SHORT).show();

            }
        });
        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void,String,Void>{
        private ArrayAdapter<String> adapter;
        private int count=0;
        @Override
        protected void onPreExecute() {
            adapter =(ArrayAdapter<String>)mainList.getAdapter();
            setProgressBarVisibility(true);
            setProgressBarIndeterminate(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(String item : texts){
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            setProgress((int)(((double)count/texts.length)*10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
            Toast.makeText(MainActivity.this,"All Item Addedd",Toast.LENGTH_LONG).show();

        }
    }
}
