package com.example.lab6;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText originalPriceInput;
    private EditText paymentInput;
    private EditText discountInput;
    private TextView resultText;
    private TextView changeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originalPriceInput = findViewById(R.id.original_price_input);
        paymentInput = findViewById(R.id.payment_input);
        discountInput = findViewById(R.id.discount_input);
        Button calculateButton = findViewById(R.id.calculate_button);
        resultText = findViewById(R.id.result);
        changeText = findViewById(R.id.change_result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFinalPrice();
            }
        });
    }

    private void calculateFinalPrice() {
        String originalPriceStr = originalPriceInput.getText().toString();
        String paymentStr = paymentInput.getText().toString();
        String discountStr = discountInput.getText().toString();

        if (!originalPriceStr.isEmpty() && !paymentStr.isEmpty() && !discountStr.isEmpty()) {
            double originalPrice = Double.parseDouble(originalPriceStr);
            double payment = Double.parseDouble(paymentStr);
            double discount = Double.parseDouble(discountStr);

            double discountAmount = (originalPrice * (discount / 100));
            double finalPrice = originalPrice - discountAmount;

            double change = payment - finalPrice; // Change received

            // Determine if the customer needs to pay more or receive change
            if (change < 0) {
                resultText.setText(String.format("Final Price: Taka %.2f", finalPrice));
                changeText.setText(String.format("Need to pay more: Taka %.2f", Math.abs(change)));
            } else {
                resultText.setText(String.format("Final Price: Taka %.2f", finalPrice));
                changeText.setText(String.format("Receivable Change: Taka %.2f", change));
            }
        } else {
            resultText.setText("Please enter valid inputs");
            changeText.setText("");
        }
    }
}