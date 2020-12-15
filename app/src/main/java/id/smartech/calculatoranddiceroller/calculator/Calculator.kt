package id.smartech.calculatoranddiceroller.calculator

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calculator (var tvExpression: TextView, var tvResult: TextView) {

    fun clearAllNum() {
        tvExpression.text = ""
        tvResult.text = ""
    }

    fun clearNum() {
        val string = tvExpression.text.toString()
        if(string.isNotEmpty()){
            tvExpression.text = string.substring(0,string.length - 1)
        }
        tvResult.text = ""
    }

    fun calculate() {
        try {
            val expression = ExpressionBuilder(tvExpression.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        } catch (e: Exception) {
            Log.d("Exception", "message : " + e.message )
//            Toast.makeText(CalculatorActivity, "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean) {
        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text =""
        }
    }
}