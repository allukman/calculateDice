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
    private lateinit var calculate: Calculator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculate = Calculator(tvExpression, tvResult)
    }


//    OnClick for number
    fun onClickNumber (v: View?) {
        when (v?.id) {
            R.id.tvOne -> calculate.appendOnExpression("1",true)
            R.id.tvTwo -> calculate.appendOnExpression("2",true)
            R.id.tvThree -> calculate.appendOnExpression("3",true)
            R.id.tvFour -> calculate.appendOnExpression("4",true)
            R.id.tvFive -> calculate.appendOnExpression("5",true)
            R.id.tvSix -> calculate.appendOnExpression("6",true)
            R.id.tvSeven -> calculate.appendOnExpression("7",true)
            R.id.tvEight -> calculate.appendOnExpression("8",true)
            R.id.tvNine -> calculate.appendOnExpression("9",true)
            R.id.tvZero -> calculate.appendOnExpression("0",true)
        }
    }

//    OnClick for Operation
    fun onClickOperation (v: View?) {
        when (v?.id) {
            R.id.tvPlus -> calculate.appendOnExpression("+",false)
            R.id.tvMinus -> calculate.appendOnExpression("-",false)
            R.id.tvMul -> calculate.appendOnExpression("*",false)
            R.id.tvDivide -> calculate.appendOnExpression("/",false)
        }
    }

//    OnClick for Functional
    fun onClickFunctional (v: View?) {
        when (v?.id) {
            R.id.tvDot -> calculate.appendOnExpression(".",true)
            R.id.tvOpen -> calculate.appendOnExpression("(",false)
            R.id.tvClose -> calculate.appendOnExpression(")",false)
            R.id.tvBack -> calculate.clearNum()
            R.id.tvClear -> calculate.clearAllNum()
            R.id.tvEquals -> calculate.calculate()
        }
    }
}


