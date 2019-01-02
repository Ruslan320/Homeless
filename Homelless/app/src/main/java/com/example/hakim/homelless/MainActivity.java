package com.example.hakim.homelless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar seek;
    private TextView txt;
    private EditText edit;
    private Button btn;
    private Homeless player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek = (SeekBar)findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(this);
        txt = (TextView)findViewById(R.id.textView2);
        login();
    }

    public void login() {
        btn = (Button)findViewById(R.id.button);
        edit = (EditText)findViewById(R.id.editText);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        player = new Homeless(String.valueOf(edit.getText()), seek.getProgress());
                        Toast.makeText(MainActivity.this, player.getName() + ", ты БОМЖ!\nТвоя цель: накопить 100$", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(".Second");
                        intent.putExtra(Homeless.class.getSimpleName(), player);
                        startActivity(intent);

                    }
                }
        );
    }


    public Homeless getPlayer(){
        return player;
    }

    @Override
    public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seek) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seek) {
        txt.setText(String.valueOf(seek.getProgress()));
    }
}
