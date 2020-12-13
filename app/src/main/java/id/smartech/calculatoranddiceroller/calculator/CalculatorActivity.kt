package id.smartech.calculatoranddiceroller.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.smartech.calculatoranddiceroller.BaseActivity
import id.smartech.calculatoranddiceroller.R
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

    }

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
        } catch (e:Exception) {
            Log.d("Exception", "message : " + e.message )
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
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

//    Set On Click Listener
    fun onClickNumber (v: View?) {
        when (v?.id) {
            R.id.tvOne -> appendOnExpression("1",true)
            R.id.tvTwo -> appendOnExpression("2",true)
            R.id.tvThree -> appendOnExpression("3",true)
            R.id.tvFour -> appendOnExpression("4",true)
            R.id.tvFive -> appendOnExpression("5",true)
            R.id.tvSix -> appendOnExpression("6",true)
            R.id.tvSeven -> appendOnExpression("7",true)
            R.id.tvEight -> appendOnExpression("8",true)
            R.id.tvNine -> appendOnExpression("9",true)
            R.id.tvZero -> appendOnExpression("0",true)
        }
    }

    fun onClickOperation (v: View?) {
        when (v?.id) {
            R.id.tvPlus -> appendOnExpression("+",false)
            R.id.tvMinus -> appendOnExpression("-",false)
            R.id.tvMul -> appendOnExpression("*",false)
            R.id.tvDivide -> appendOnExpression("/",false)
        }
    }

    fun onClickFunctional (v: View?) {
        when (v?.id) {
            R.id.tvDot -> appendOnExpression(".",true)
            R.id.tvOpen -> appendOnExpression("(",false)
            R.id.tvClose -> appendOnExpression(")",false)
            R.id.tvBack -> clearNum()
            R.id.tvClear -> clearAllNum()
            R.id.tvEquals -> calculate()
        }
    }
}


