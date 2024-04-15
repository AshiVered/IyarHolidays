package aiv.ashivered.book.iyarholidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class em extends AppCompatActivity {

    ListView lsview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em);

        lsview = (ListView) findViewById(R.id.lstview);

        String[] chapter = {
                "שחרית",
                "מנחה",
                "ערבית",
        };

        ArrayAdapter< String > adapter = new ArrayAdapter < String > (this, android.R.layout.simple_list_item_1, chapter) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView mytxt = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        lsview.setAdapter(adapter);


        lsview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > parent, View view, int position, long id) {

                String iteam = lsview.getItemAtPosition(position).toString();

                Intent start = new Intent(getApplicationContext(), emList.class);
                start.putExtra("emMenu", iteam);
                startActivity(start);

            }
        });
    }
}