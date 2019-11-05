package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan() {
        //TODO: get all inputs and calculate outputs
        if (editTextCarPrice.text.isEmpty()) { //check if the editText is empty
            editTextCarPrice.setError(getString(R.string.input_error))
            return; //end the program execution
        } else if (editTextDownPayment.text.isEmpty()) {
            editTextDownPayment.setError(getString(R.string.input_error))
            return;
        } else if (editTextLoanPeriod.text.isEmpty()) {
            editTextLoanPeriod.setError(getString(R.string.input_error))
            return;
        } else if (editTextInterestRate.text.isEmpty()) {
            editTextInterestRate.setError(getString(R.string.input_error))
            return;
        } else {

            val carPrice: Int = editTextCarPrice.text.toString().toInt()
            val downPayment: Int = editTextDownPayment.text.toString().toInt()
            val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
            val interestRate: Float = editTextInterestRate.text.toString().toFloat()

            val carLoan: Int = carPrice - downPayment
            val interest: Float = carLoan * interestRate / 100 * loanPeriod
            val monthly_Repayment: Float = (carLoan + interest) / loanPeriod / 12

            textViewLoan.text = String.format("%s %d", getString(R.string.loan), carLoan)
            textViewInterest.text = String.format("%d", getString(R.string.interest), interest)
            textViewMontlyRepayment.text = String.format("%d", getString(R.string.monthly_repayment), monthly_Repayment)
        }


    }

    fun reset(view: View) {
        editTextCarPrice.text.clear();
        editTextDownPayment.text.clear();
        editTextInterestRate.text.clear();
        editTextLoanPeriod.text.clear();

    }
}