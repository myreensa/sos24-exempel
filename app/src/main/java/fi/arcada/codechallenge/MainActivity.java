package fi.arcada.codechallenge;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView value;
    TextView value1;
    TextView value2;
    TextView value3;
    TextView combinedPercentage; // procent för barn

    TextView combinedPercentage1; // procent vuxna

    TextView chiSquareResultTextView; // chi resultatet





    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.value);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);
        combinedPercentage = findViewById(R.id.combined_percentage);
        combinedPercentage1 = findViewById(R.id.combined_percentage1);

        chiSquareResultTextView = findViewById(R.id.chiSquareResult);




    }









    public void increment(View v) {
        count++;
        value.setText(String.valueOf(count));
        calculateAndDisplayPercentage();
        calculateAndDisplayPercentageForA();
        calculateAndDisplayChiSquareResult();

    }

    public void increment1(View v) {
        count1++;
        value1.setText(String.valueOf(count1));
        calculateAndDisplayPercentage();
        calculateAndDisplayPercentageForA();
        calculateAndDisplayChiSquareResult();


    }

    public void increment2(View v) {
        count2++;
        value2.setText(String.valueOf(count2));
        calculateAndDisplayPercentage();
        calculateAndDisplayChiSquareResult();


    }

    public void increment3(View v) {
        count3++;
        value3.setText(String.valueOf(count3));
        calculateAndDisplayPercentageForA();
        calculateAndDisplayChiSquareResult();


    }

    public void resetValues(View v) {
        count = 0;
        count1 = 0;
        count2 = 0;
        count3 = 0;

        value.setText(String.valueOf(count));
        value1.setText(String.valueOf(count1));
        value2.setText(String.valueOf(count2));
        value3.setText(String.valueOf(count3));
        calculateAndDisplayPercentage();
        calculateAndDisplayPercentageForA();
        calculateAndDisplayChiSquareResult();
        // reset knapp funktion


    }

    private void calculateAndDisplayPercentage() {
        int totalCount = count1 + count2;
        if (totalCount == 0) {
            combinedPercentage.setText("% av barn");
        } else {
            double percentage = ((double) count1 / totalCount) * 100.0;
            combinedPercentage.setText(String.format("%.2f%%", percentage));
        }

    }

    // Bara percentage är för barn

    private void calculateAndDisplayPercentageForA() {
        int totalCount = count + count3;
        if (totalCount == 0) {
            combinedPercentage1.setText("% av vuxna");
        } else {
            double percentage = ((double) count / totalCount) * 100.0;
            combinedPercentage1.setText(String.format("%.2f%%", percentage));
        }
    }

    // ForA ar variabel namn for adults representerar alltså för vuxna

    private void calculateAndDisplayChiSquareResult() {
        double count4 = 0;
        double count5 = 0;
        double count6 = 0;
        double count7 = 0;
        double count8 = 0;
        double count9 = 0;
        double count10 = 0;
        double count11 = 0;

        if (count1 + count + count2 + count3 != 0) {
            count4 = ((count1 + count) * (count1 + count2)) / (double) (count1 + count + count2 + count3);
            count5 = ((count1 + count) * (count + count3)) / (double) (count1 + count + count2 + count3);
            count6 = ((count2 + count3) * (count1 + count2)) / (double) (count1 + count + count2 + count3);
            count7 = ((count2 + count3) * (count + count3)) / (double) (count1 + count + count2 + count3);

            count8 = Math.pow(count1 - count4, 2) / count4;
            count9 = Math.pow(count - count5, 2) / count5;
            count10 = Math.pow(count2 - count6, 2) / count6;
            count11 = Math.pow(count3 - count7, 2) / count7;
        }

        double chiSquareResult = count8 + count9 + count10 + count11;

        chiSquareResultTextView.setText("Chi2 resultatet: " + String.valueOf(chiSquareResult));
    }

}



