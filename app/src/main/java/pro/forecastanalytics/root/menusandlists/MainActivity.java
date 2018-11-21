package pro.forecastanalytics.root.menusandlists;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listCities;
    ArrayList <String> data;
    ArrayAdapter <String> adapter;
    ListView city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listCities= findViewById(R.id.listCities);
        data= new ArrayList<String>();
        data.add("Nairobi");
        data.add("Mombasa");
        data.add("Kisumu");
        data.add("Jinja");
        data.add("Dodoma");
        data.add("Thika");
        data.add("Kakamega");
        data.add("New York");

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, data);
        listCities.setAdapter(adapter);

        listCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String city =data.get(position);
                Toast.makeText(MainActivity.this, city, Toast.LENGTH_SHORT).show();
            }
        });



      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id==R.id.menu_clear)
        {
            data.clear();
            adapter.notifyDataSetChanged();
        }
        else if (id==R.id.menu_share)
        {
            adapter.insert("Juja", 0);

        }

        else if (id==R.id.menu_contact)
        {
            // adapter.insert("Shangai",);
             data.add("Shangai");
             adapter.notifyDataSetChanged();
        }


        return super.onOptionsItemSelected(item);
    }
}
