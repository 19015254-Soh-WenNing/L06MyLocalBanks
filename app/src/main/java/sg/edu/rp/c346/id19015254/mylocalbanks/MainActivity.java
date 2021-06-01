package sg.edu.rp.c346.id19015254.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS)
        {
            wordClicked = "DBS";
        }
        else if (v == tvOCBC)
        {
            wordClicked = "OCBC";
        }
        else if (v == tvUOB)
        {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        if (wordClicked.equalsIgnoreCase("DBS"))
        {
            if(item.getItemId()==0)
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800-111-1111"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==2)
            {
                if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    tvDBS.setTextColor(getResources().getColor(R.color.red));
                }
                else if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.red))
                {
                    tvDBS.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
        else if (wordClicked.equalsIgnoreCase("OCBC"))
        {
            if(item.getItemId()==0)
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800-363-3333"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==2)
            {
                if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    tvOCBC.setTextColor(getResources().getColor(R.color.red));
                }
                else if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.red))
                {
                    tvOCBC.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
        else if (wordClicked.equalsIgnoreCase("UOB"))
        {
            if(item.getItemId()==0)
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800-222-2121"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==2)
            {
                if (tvUOB.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    tvUOB.setTextColor(getResources().getColor(R.color.red));
                }
                else if (tvUOB.getCurrentTextColor() == getResources().getColor(R.color.red))
                {
                    tvUOB.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error Translation");
            tvOCBC.setText("Error Translation");
            tvUOB.setText("Error Translation");
        }
        return super.onOptionsItemSelected(item);
    }
}