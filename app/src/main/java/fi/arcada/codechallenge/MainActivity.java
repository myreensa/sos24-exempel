package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    // 1. Deklarera objektet.
    EditText inputText;

    double[] values = { 3.5, 4.4, 9.0, 1.2, 6.5, 12.0 }; // code challenge

    outputText.SetText(String.format((
            "medelvärde: %.2f"
            Statistics.calcMean(values)));
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText); // 2. initialisera ett värde
        inputText = findViewById(R.id.inputText);


      ; // 3. köra metoder på objektet
    }
    public void buttonHandler(View view) {
        outputText.setText(inputText.getText().toString()); // setters and getters
    }
    public void calculate(View view) {
        double sum = 0.0;
        for(int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        double mean = sum / values.length; // code challenge
        outputText.setText(String.format("Medelvärde: %.2f", mean));


    }
}