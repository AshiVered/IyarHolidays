package aiv.ashivered.book.iyarholidays;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.io.IOException;
import java.io.InputStream;

public class emList extends AppCompatActivity {
    private SharedPreferences sp;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em_list);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        textView = findViewById(R.id.textView);
        String string = "";
        String getItam = getIntent().getStringExtra("emMenu");

        if (getItam.equals("שחרית")) {
            try {
                InputStream inputStream = getAssets().open(sp.getBoolean("haftara", false)? "em_h_sh" : "em_sh");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                string = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            textView.setText(string);
        }

        else if(getItam.equals("מנחה")){
            try {
                InputStream inputStream = getAssets().open("em_mi");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                string = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            textView.setText(string);
        }
        else if(getItam.equals("ערבית")){
            try {
                InputStream inputStream = getAssets().open(sp.getBoolean("hallel", false)? "em_h_ar" : "em_ar");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                string = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            textView.setText(string);
        }
    }
}