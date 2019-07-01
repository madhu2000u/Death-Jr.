package com.example.deathjr;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Debug;
import android.os.PersistableBundle;
import android.renderscript.ScriptGroup;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.text.InputType;
import android.content.DialogInterface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String age;
    private int maxTries=5;
    int tries=1;



    public int crt_tries=0, incrt_tries=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("msg","onCreate() is called");
        //Log.d("msg",""+crt_tries);
        //Log.d("msg",""+incrt_tries);
        final EditText eText = findViewById(R.id.editText);
        ConstraintLayout current_layout=findViewById(R.id.layout);
        current_layout.setBackgroundResource(R.color.default_white);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);

       final TextView tview=findViewById(R.id.text_view);
       tview.setText("");

       final Button incrt_button=findViewById(R.id.incrt_score);
       final Button crct_button=findViewById(R.id.crt_score);
       crct_button.setText(""+crt_tries);
       incrt_button.setText(""+incrt_tries);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=eText.getText().toString();
                ConstraintLayout view=findViewById(R.id.layout);

                if(tries<maxTries) {

                    if (age == null) {
                        infoDialog("Age is not set");
                    } else {
                        try {
                            tview.setText("");

                            TextView tview = findViewById(R.id.text_view);

                            int x = Integer.parseInt(val);
                            int y = Integer.parseInt(age);
                            //Log.d("msg", val);
                            //Log.d("msg", age);
                            //Log.d("msg", "Difference" + "  " + Math.abs((x - y)));
                            int abs_val=Math.abs((x-y));
                            if (x == y) {
                                view.setBackgroundResource(R.color.perfect_guess);

                                tview.setText(R.string.perfect_guess);
                                crt_tries++;
                            } else if (abs_val <= 5 && abs_val >= 1) {
                                view.setBackgroundResource(R.color.c_1TO5);
                                incrt_tries++;
                            } else if (abs_val <= 10 && abs_val > 6) {
                                view.setBackgroundResource(R.color.c_6TO10);
                                incrt_tries++;
                            } else if (abs_val <= 15 && abs_val >= 11) {
                                view.setBackgroundResource(R.color.c_11TO15);
                                incrt_tries++;
                            } else if (abs_val <= 20 && abs_val>=16) {
                                view.setBackgroundResource(R.color.c_16TO20);
                                incrt_tries++;
                            }else if(abs_val <= 25 && abs_val>=21){
                                view.setBackgroundResource(R.color.c_21TO25);
                                incrt_tries++;
                            }else if (abs_val<=30 && abs_val>=26){
                                view.setBackgroundResource(R.color.c_26TO30);
                                incrt_tries++;
                            }else if (abs_val<=35 && abs_val>=31){
                                view.setBackgroundResource(R.color.c_31TO35);
                                incrt_tries++;
                            }else if (abs_val<=40 && abs_val>=36){
                                view.setBackgroundResource(R.color.c_36TO40);
                                incrt_tries++;
                            }else if (abs_val<=45 && abs_val>=41){
                                view.setBackgroundResource(R.color.c_41TO45);
                                incrt_tries++;
                            }else if (abs_val<=50 && abs_val>=46){
                                view.setBackgroundResource(R.color.c_46TO50);
                                incrt_tries++;
                            }else if (abs_val<=55 && abs_val>=51){
                                view.setBackgroundResource(R.color.c_51TO55);
                                incrt_tries++;
                            }else if (abs_val<=60 && abs_val>=56){
                                view.setBackgroundResource(R.color.c_56TO60);
                                incrt_tries++;
                            }else if (abs_val<=65 && abs_val>=61){
                                view.setBackgroundResource(R.color.c_61TO65);
                                incrt_tries++;
                            }else if (abs_val<=70 && abs_val>=66){
                                view.setBackgroundResource(R.color.c_66TO70);
                                incrt_tries++;
                            }else if (abs_val<=75 && abs_val>=71){
                                view.setBackgroundResource(R.color.c_71TO75);
                                incrt_tries++;
                            }else if (abs_val<=80 && abs_val>=76){
                                view.setBackgroundResource(R.color.c_76TO80);
                                incrt_tries++;
                            }else if (abs_val<=85 && abs_val>=81){
                                view.setBackgroundResource(R.color.c_81TO85);
                                incrt_tries++;
                            }else if (abs_val<=90 && abs_val>=86){
                                view.setBackgroundResource(R.color.c_86TO90);
                                incrt_tries++;
                            }else if (abs_val<=95 && abs_val>=91){
                                view.setBackgroundResource(R.color.c_91TO95);
                                incrt_tries++;
                            }else if (abs_val<=100 && abs_val>=96){
                                view.setBackgroundResource(R.color.very_wrong);
                                incrt_tries++;

                            }

                            tries++;
                            EditText etxt=findViewById(R.id.editText);
                            etxt.setText("");

                        } catch (NumberFormatException e1) {
                            Toast toast=Toast.makeText(getApplicationContext(),getString(R.string.null_age_entered), Toast.LENGTH_SHORT);
                            toast.show();

                            //Log.d("msg", String.valueOf(Integer.parseInt(String.valueOf(view.getSolidColor()))));


                        }
                    }
                }else {
                    infoDialog("You have taken too many tries!!\n\nYou Lost!!");
                    age=null;
                    tries=0;
                    TextView tview=findViewById(R.id.text_view);
                    tview.setText("");
                    EditText edtxt=findViewById(R.id.editText);
                    edtxt.setText("");
                }
                crct_button.setText(""+crt_tries);
                incrt_button.setText(""+incrt_tries);


            }
        });
    }


    public void infoDialog(String msg)
    {
        AlertDialog.Builder dialog1=new AlertDialog.Builder(this );
        dialog1.setMessage(msg)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog1.show();
    }



   @Override
   public void onRestoreInstanceState(Bundle savedInstanceState){
       super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null)
        {
            crt_tries=savedInstanceState.getInt("crt_tries");
            //Log.d("msg","In onRestoreInstance crt_tries - "+crt_tries);
            incrt_tries=savedInstanceState.getInt("incrt_tries");
            //Log.d("msg","In onRestoreInstance incrt_tries - "+incrt_tries);

            age=savedInstanceState.getString("age");

            findViewById(R.id.layout).setBackgroundColor(savedInstanceState.getInt("color"));

            Button incrt_button=findViewById(R.id.incrt_score);
            incrt_button.setText(""+incrt_tries);

            Button crt_button=findViewById(R.id.crt_score);
            crt_button.setText(""+crt_tries);

            TextView textView=findViewById(R.id.text_view);
            textView.setText(savedInstanceState.getString("tv"));
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Log.d("msg", "From save instance state 1 - "+age);
        outState.putString("age", age);
        outState.putInt("crt_tries",crt_tries);
        //Log.d("msg","In onsaveInstance crt_tries -"+crt_tries );

        outState.putInt("incrt_tries",incrt_tries);
        //Log.d("msg","In onsaveInstance incrt_tries - "+incrt_tries);

        ConstraintLayout current_layout=findViewById(R.id.layout);
        ColorDrawable viewColor=(ColorDrawable)current_layout.getBackground();
        int color=viewColor.getColor();
        //Log.d("msg", "Printing from onsaveinstance state "+ color);
        outState.putInt("color",color);
        TextView textView=findViewById(R.id.text_view);
        String tv=textView.getText().toString();
        outState.putString("tv",tv);

        //Log.d("msg", "Color value - "+color);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.setage));

// Set up the input
            final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Editable temp = input.getText();
                    int x =Integer.parseInt(temp.toString());
                    if(x<1 || x>100){
                        Toast toast=Toast.makeText(getApplicationContext(),getString(R.string.age_range), Toast.LENGTH_LONG);
                        toast.show();


                    }else {
                        age=input.getText().toString();
                        Log.d("msg", age);
                    }

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
