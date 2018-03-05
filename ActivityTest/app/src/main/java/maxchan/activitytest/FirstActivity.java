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

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is"+getTaskId());
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                finish();
            }
        });*/


        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String data ="Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });*/

        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String data ="Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });*/

        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent("com.example.activitytest.ACTION_STRAT");
                intent.addCategory("com.example.activitytest.MY_CATRGORY");
                startActivity(intent);
            }
        });*/

        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case 1:
                if (requestCode==RESULT_OK)
                {
                    // Log.v("success","return Result_ok");
                    String returnedData = data.getStringExtra("data_return");
                    System.out.println(returnedData);
                    Log.d("FirstActivity", returnedData);
                    //Toast.makeText(FirstActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Log.v("default","in default");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d ("FirstActivity","onRestart");
    }
}
