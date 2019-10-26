package com.mendoza.lab4menodzaneilarvin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] company, country, industry, ceo, info;
    ListView lstversions;

    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.chinaconstruction, R.drawable.agriculturalbank, R.drawable.bankofamerica,
            R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wellsfargo,
            R.drawable.exxon, R.drawable.att, R.drawable.samsung, R.drawable.citibank,};

    ArrayList<AndroidVersion> versions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        company = getResources().getStringArray(R.array.company);
        country = getResources().getStringArray(R.array.country);
        industry = getResources().getStringArray(R.array.industry);
        ceo = getResources().getStringArray(R.array.ceo);
        info = getResources().getStringArray(R.array.info);

        for (int i = 0; i < company.length; i++) {
            versions.add(new AndroidVersion(logo[i], company[i], "Country: " + country[i], "Industry: " + industry[i], "CEO: " + ceo[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.company, versions);
        lstversions = findViewById(R.id.lvAndroid);
        lstversions.setAdapter(adapter);
        lstversions.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        //Toast.makeText(this, verNames[i], Toast.LENGTH_LONG).show();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(company[i]);
        TextView addInfo = new TextView(this);
        addInfo.setText(info[i]);
        addInfo.setGravity(Gravity.CENTER);
        dialog.setView(addInfo);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, company[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();

    }
}
