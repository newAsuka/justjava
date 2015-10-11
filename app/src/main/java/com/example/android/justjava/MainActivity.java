package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;
    //boolean isChecked = false;

    /**
    public boolean setCheckBox (boolean isChecked){
        isChecked = !isChecked;
        if (isChecked) return true;
        else return false;
    }
     */

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);

        CheckBox addCreamCheckBox = (CheckBox) findViewById(R.id.creamCbox_id);
        boolean hasCream = addCreamCheckBox.isChecked();

        CheckBox addMMCheckBox = (CheckBox) findViewById(R.id.mmCBox_id);
        creatOrderSummary(price, hasCream);


    }

    private void creatOrderSummary (int price, boolean hasCream){
        String summaryMessage = "name:balonfan" + "\n" + "quantity" + "=" + quantity +
               "\nHas cream: " + hasCream + "\ntotal:" + "$" + price + "\nthank you.";
        displayMessage(summaryMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    public void increment(View view){

        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){

        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);


    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
