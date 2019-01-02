package com.example.hakim.homelless;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Second extends AppCompatActivity {

    private Homeless player;
    private TextView txtAge, txtHealth, txtCapital, txtQuest;
    private Scene[] arrScene= new Scene[5];
    private Situation[] arrSit = new Situation[15];
    private ListView list;
    private String[] names = new String[3];
    private int index = 0;
    private AlertDialog.Builder a_builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        player = (Homeless) arguments.getSerializable(Homeless.class.getSimpleName());
        txtHealth = (TextView)findViewById(R.id.textHealth);
        txtAge = (TextView)findViewById(R.id.textAge);
        txtCapital = (TextView)findViewById(R.id.textCapital);
        txtQuest = (TextView)findViewById(R.id.textQuestions);
        list = (ListView)findViewById(R.id.Answer);
        a_builder = new AlertDialog.Builder(Second.this);

        filling1();
        filling2();
        status(index);
        list();
    }

    private void status(int i){
        txtAge.setText("Возраст: " + Integer.toString(player.getAge()) + AgeStr(player.getAge()));
        txtHealth.setText("Здоровье: " + Integer.toString(player.getHealth()) + "%");
        txtCapital.setText("Капитал: " + Integer.toString(player.getCapital()) + "$");
        txtQuest.setText(arrScene[i].getQues());
        names[0] = arrScene[i].getSit(0).getStr();names[1] = arrScene[i].getSit(1).getStr();names[2] = arrScene[i].getSit(2).getStr();
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.names, names);
        list.setAdapter(adapter);
    }

    public void list(){

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        player.setAge(arrScene[index].getSit((int)id).getChangeAge());
                        player.setCapital(arrScene[index].getSit((int)id).getChangeCapital());
                        player.setHealth(arrScene[index].getSit((int)id).getChangeHealth());
                        if (player.getHealth() > 100){
                            player.setHealth(100 - player.getHealth());
                        }
                        else if (player.getHealth() <= 0){
                            a_builder.setMessage("Хотите начать заново?")
                                    .setCancelable(false)
                                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            onBackPressed();
                                        }
                                    })
                                    .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            moveTaskToBack(true);
                                            onBackPressed();
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.setTitle(player.getName() + ", YOU DIED!");
                            alert.show();
                        }
                        if (player.getCapital() >= 100){
                            a_builder.setMessage("Хотите начать заново?")
                                    .setCancelable(false)
                                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            onBackPressed();
                                        }
                                    })
                                    .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            moveTaskToBack(true);
                                            onBackPressed();
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.setTitle(player.getName() + ", вы потеряли стату БОМЖа!");
                            alert.show();
                        }
                        else if (player.getCapital() < 0){
                            player.setCapital(Math.abs(player.getCapital()));
                        }

                        Toast.makeText(Second.this, "Ты " + (arrScene[index].getSit((int)id).getChangeCapital() >= 0 ? "приобрёл ": "потерял ") + Math.abs(arrScene[index].getSit((int)id).getChangeCapital()) + "$" + "\n" +
                                (arrScene[index].getSit((int)id).getChangeHealth() >= 0 ? "приобрёл ": "потерял ") + Math.abs(arrScene[index].getSit((int)id).getChangeHealth()) + "% здоровья" + "\n" +
                                "постарел на " + arrScene[index].getSit((int)id).getChangeAge() + AgeStr(arrScene[index].getSit((int)id).getChangeAge()), Toast.LENGTH_LONG).show();

                        index++;
                        if (index == arrScene.length){
                            if (player.getCapital() >= 100){
                                a_builder.setMessage("Хотите начать заново?")
                                        .setCancelable(false)
                                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                onBackPressed();
                                            }
                                        })
                                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                moveTaskToBack(true);
                                                onBackPressed();
                                            }
                                        });
                                AlertDialog alert = a_builder.create();
                                alert.setTitle(player.getName() + ", вы потеряли стату БОМЖа!");
                                alert.show();
                            }
                            else if (player.getHealth() <= 0){
                                a_builder.setMessage("Хотите начать заново?")
                                        .setCancelable(false)
                                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                onBackPressed();
                                            }
                                        })
                                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                moveTaskToBack(true);
                                                onBackPressed();
                                            }
                                        });
                                AlertDialog alert = a_builder.create();
                                alert.setTitle(player.getName() + ", YOU DIED!");
                                alert.show();
                            }
                            else{
                                a_builder.setMessage("Хотите начать заново?")
                                        .setCancelable(false)
                                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                onBackPressed();
                                            }
                                        })
                                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                moveTaskToBack(true);
                                                onBackPressed();
                                            }
                                        });
                                AlertDialog alert = a_builder.create();
                                alert.setTitle("КОНЕЦ(пока что)");
                                alert.show();
                            }

                        }
                        else{
                            status(index);
                        }

                    }
                }
        );
    }

    private void filling1(){
        arrSit[0] = new Situation("Вокзал", 10, 10, 1);
        arrSit[1] = new Situation("Парк", -20, 20, 1);
        arrSit[2] = new Situation("Гаражи", -30, 10, 0);
        arrSit[3] = new Situation("Покажу им, кто здесь батя!", -30, 30, 1);
        arrSit[4] = new Situation("Найду общий язык", -20, -20, 1);
        arrSit[5] = new Situation("Тихо уйду, чтобы никому не мешать", 20, 0, 2);
        arrSit[6] = new Situation("Сказать всё как есть", 50, -20, 3);
        arrSit[7] = new Situation("Сказать, что забыл их дома(прикинуться дурачком)", 0, 0, 0);
        arrSit[8] = new Situation("Врубить нитро и дать дёру", -20, 0, 1);
        arrSit[9] = new Situation("Догнать и отдать", 10, 100, 0);
        arrSit[10] = new Situation("Взять из кошелька немного денег и отдать", 0, 20, 0);
        arrSit[11] = new Situation("Присвоить себе кошелек", 0, 50, 0);
        arrSit[12] = new Situation("Конечно", -20, -20, 3);
        arrSit[13] = new Situation("Ни в коем случае", 0, 0, 1);
        arrSit[14] = new Situation("Нет, ещё и его остановлю", -10, 0, 5);

    }

    private void filling2(){
        arrScene[0] = new Scene(arrSit[0], arrSit[1], arrSit[2], "Ты только что стал бомжом! Тебе нужно выбрать место для ночлега.");
        arrScene[1] = new Scene(arrSit[3], arrSit[4], arrSit[5], "Местные \"авторитеты\" не довольны тобой. Что ты будешь делать?");
        arrScene[2] = new Scene(arrSit[6], arrSit[7], arrSit[8], "Полицейский попросил тебя предъявить документы, что ты намерен делать?");
        arrScene[3] = new Scene(arrSit[9], arrSit[10], arrSit[11], "На твоих глазах женщина с ребенком оставила на скамейке кошелек. Твои действия:");
        arrScene[4] = new Scene(arrSit[12], arrSit[13], arrSit[14], "Твой сосед готовиться к крупному делу(ограбить местную лавку). Ты с ним?");
    }

    private String AgeStr(int i){
        if (i == 1){
            return " год";
        }
        else if(i <= 4){
            return " года";
        }
        else if (i <= 20){
            return " лет";
        }
        else if (i % 10 == 0){
            return " лет";
        }
        else if (i % 10 <= 4){
            return "года";
        }
        else{
            return " лет";
        }
    }
}
