package innova4b.com.receivesms;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillListWithSMS();

    }

    private void fillListWithSMS() {
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/"), null, null, null, null);
        ListView mListView = (ListView) findViewById(R.id.listView);


        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
                        cursor, new String[]{cursor.getColumnName(2), cursor.getColumnName(12)}, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        mListView.setAdapter(simpleCursorAdapter);

        //logColumnNames(cursor);
    }

    private void logColumnNames(Cursor cursor) {
        StringBuffer info = new StringBuffer();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            info.append("Column: " + cursor.getColumnName(i) + "\n");
        }
        Log.println(Log.INFO, "Test", info.toString());
    }
}
