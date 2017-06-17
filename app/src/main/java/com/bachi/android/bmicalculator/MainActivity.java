package com.bachi.android.bmicalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.bachi.android.bmicalculator.R.id.action_about;
import static com.bachi.android.bmicalculator.R.id.etHeight;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//create action bar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//item selected action bar
        if (item.getItemId() == R.id.action_about) {
            Intent xAbout = new Intent(this, About.class);
            startActivity(xAbout);
        }

        if (item.getItemId() == R.id.action_developer) {
            Intent xDeveloper = new Intent(this, Developer.class);
            startActivity(xDeveloper);

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etHeight = (EditText) findViewById(R.id.etHeight);
        final EditText etWeight = (EditText) findViewById(R.id.etWeight);
        final TextView tvResulta = (TextView) findViewById(R.id.textView6);
        final TextView tvComents = (TextView) findViewById(R.id.tvComents);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton rbMan = (RadioButton) findViewById(R.id.rbMan);
        final RadioButton rbWoman = (RadioButton) findViewById(R.id.rbWoman);


        etHeight.requestFocus();


        Button btnCalc = (Button) findViewById(R.id.button);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {


                if (rbMan.isChecked() == false && rbWoman.isChecked() == false) {
                    msgGenderNull();

                } else if (etHeight.getText().length() == 0) {
                    msgHeightNull();


                } else if (etWeight.getText().length() == 0) {
                    msgWeightNull();


                } else {
                    float height = Float.parseFloat(etHeight.getText().toString());
                    float weight = Float.parseFloat(etWeight.getText().toString());
                    float bmi = weight / (height * height);

                    if (height > 2.5) {
                        msgHeightTooBig();
                    } else if (height < 0.5) {
                        msgHeightTooShort();
                    } else if (weight > 250) {
                        msgWeightTooBig();
                    } else if (weight < 20) {
                        msgWeightTooShort();
                    } else {
                        DecimalFormat df = new DecimalFormat("0.#");
                        tvResulta.setText(String.valueOf(df.format(bmi)));

                        if (rbMan.isChecked()) {
                            if (bmi < 18.5) {
                                tvComents.setText("Underweight!");
                            } else if (bmi < 25) {
                                tvComents.setText("Health Weight!");
                            } else if (bmi < 30) {
                                tvComents.setText("Overweight!");
                            } else {
                                tvComents.setText("Obese!");
                            }

                        } else {
                            if (bmi < 18.5) {
                                tvComents.setText("Underweight!");
                            } else if (bmi < 25) {
                                tvComents.setText("Health Weight!");
                            } else if (bmi < 30) {
                                tvComents.setText("Overweight!");
                            } else {
                                tvComents.setText("Obese!");
                            }
                        }
                    }
                }
                ;


            }


            public void msgGenderNull() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //message.setTitle("Alert");
                message.setMessage("Select gender");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgHeightNull() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Fill the field Height");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgWeightNull() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Fill the field Weight");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgHeightTooBig() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Height too big");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgHeightTooShort() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Height too Short");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgWeightTooBig() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Weight too big");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;

            public void msgWeightTooShort() {

                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                //mensagem.setTitle(titulo);
                message.setMessage("Weight too Short");
                message.setNeutralButton("OK", null);
                message.show();
            }

            ;


        });


    }
}