package com.example.tobibur.cgpacalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText one, two, thr, fou, fiv, six, sev, eig;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (EditText) findViewById(R.id.editText1);
        two = (EditText) findViewById(R.id.editText2);
        thr = (EditText) findViewById(R.id.editText3);
        fou = (EditText) findViewById(R.id.editText4);
        fiv = (EditText) findViewById(R.id.editText5);
        six = (EditText) findViewById(R.id.editText6);
        sev = (EditText) findViewById(R.id.editText7);
        eig = (EditText) findViewById(R.id.editText8);

        txt = (TextView) findViewById(R.id.textView11);
    }

    public void CgpaMethod(View v) {


        //hiding the keyboard after typing
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(eig.getWindowToken(), 0);

        try {
            int tot_credit = 0;//=27+29+30+30+30+30;
            String a = sev.getText().toString();
            float se = Float.parseFloat(a);
            if (se != 0) {
                tot_credit += 30;
            }
            String b = eig.getText().toString();
            float ei = Float.parseFloat(b);
            if (ei != 0) {
                tot_credit += 30;
            }
            String c = one.getText().toString();
            float on = Float.parseFloat(c);
            if (on != 0) {
                tot_credit += 27;
            }
            String d = two.getText().toString();
            float tw = Float.parseFloat(d);
            if (tw != 0) {
                tot_credit += 29;
            }
            String e = thr.getText().toString();
            float th = Float.parseFloat(e);
            if (th != 0) {
                tot_credit += 30;
            }
            String f = fou.getText().toString();
            float fo = Float.parseFloat(f);
            if (fo != 0) {
                tot_credit += 30;
            }
            String g = fiv.getText().toString();
            float fi = Float.parseFloat(g);
            if (fi != 0) {
                tot_credit += 30;
            }
            String h = six.getText().toString();
            float si = Float.parseFloat(h);
            if (si != 0) {
                tot_credit += 30;
            }
            float sgpa;
            sgpa = on * 27 + tw * 29 + th * 30 + fo * 30 + fi * 30 + si * 30 + se * 30 + ei * 30;
            float cgpa;
            cgpa = sgpa / tot_credit;
            String cg = "CGPA=" + String.valueOf(cgpa);
            txt.setText(cg);
            Toast.makeText(MainActivity.this, "Your CGPA is " + cgpa, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Sorry, Inputs cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.id_clear){
            one.setText("");
            two.setText("");
            thr.setText("");
            fou.setText("");
            fiv.setText("");
            six.setText("");
            sev.setText("");
            eig.setText("");
            txt.setText("");
            return true;
        }
        if (id==R.id.id_exit){
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


}
