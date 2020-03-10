package pl.wlodarczyk.layoutexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView warningOk = findViewById(R.id.warningOk);
        TextView warningFalse = findViewById(R.id.warningInfected);
        boolean isInfected = getIntent().getBooleanExtra("isInfected", false);

        if (isInfected){
            warningFalse.setVisibility(View.VISIBLE);
        }
        else
            warningOk.setVisibility(View.VISIBLE);

    }
}
