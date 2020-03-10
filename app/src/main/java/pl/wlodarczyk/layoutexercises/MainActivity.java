package pl.wlodarczyk.layoutexercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton yes;
    private RadioButton no;
    private CheckBox checkYes;
    private CheckBox checkNo;
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.radioInfectedYes);
        no = findViewById(R.id.radioInfectedNo);
        checkYes = findViewById(R.id.infectedYes);
        checkNo = findViewById(R.id.infectedNo);
        Switch switcher = findViewById(R.id.coronaSwitch);
        Button button = findViewById(R.id.goFurther);
        counter = findViewById(R.id.countCorona);

        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    counter.setVisibility(View.VISIBLE);
                }
                else {
                    counter.setVisibility(View.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yes.isChecked() && no.isChecked()){
                    yes.setChecked(false);
                    no.setChecked(false);
                    Toast.makeText(MainActivity.this, "Wybierz tylko jedną opcję!", Toast.LENGTH_LONG).show();
                }

                else if (checkYes.isChecked() && checkNo.isChecked()){
                    checkYes.setChecked(false);
                    checkNo.setChecked(false);
                    Toast.makeText(MainActivity.this, "Wybierz tylko jedną opcję!", Toast.LENGTH_LONG).show();
                }
                else
                openActivityTwo();
            }
        });

    }


    public void openActivityTwo() {
        Intent intent = new Intent(this, SecondActivity.class);
        if (yes.isChecked() || checkYes.isChecked()) {
            intent.putExtra("isInfected", true);
            startActivity(intent);
        }
        if (no.isChecked() && checkNo.isChecked()) {
            intent.putExtra("isInfected", false);
            startActivity(intent);
        }
    }
}
