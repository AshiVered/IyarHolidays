package aiv.ashivered.book.iyarholidays;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class menuList extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        textView = findViewById(R.id.textView);
        String string = "";
        String getItam = getIntent().getStringExtra("mainMenu");

        if (getItam.equals("אשכנז")) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName("aiv.ashivered.book.iyarholidays", "aiv.ashivered.book.iyarholidays.ashkenaz"));
            startActivity(intent);
            {
            super.onPause();
            finish();
            }
        }
        else if(getItam.equals("ספרד")){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName("aiv.ashivered.book.iyarholidays", "aiv.ashivered.book.iyarholidays.sefard"));
            startActivity(intent);
            {
                super.onPause();
                finish();
            }
        }
        else if(getItam.equals("אודות")){
            try {
                InputStream inputStream = getAssets().open("about");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                string = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            textView.setText(string);
        }
        else if(getItam.equals("הגדרות")){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName("aiv.ashivered.book.iyarholidays", "aiv.ashivered.book.iyarholidays.SettingsActivity"));
            startActivity(intent);
            {
                super.onPause();
                finish();
            }
        }
    }
}