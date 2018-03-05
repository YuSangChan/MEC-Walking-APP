package maxchan.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is "+getTaskId());
        setContentView(R.layout.second_layout);

        //Intent intent = getIntent();
        //final String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity",data);

        Button button2 = (Button) findViewById(R.id.button_2);
        /*
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(SecondActivity.this,data,Toast.LENGTH_SHORT).show();
                finish();
            }
        });*/

        /*
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               Intent intent = new Intent();
               intent.putExtra("data_return","Hello FirstActivity");
               setResult(RESULT_OK,intent);
               finish();
            }
        });*/

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestory");
    }
}
