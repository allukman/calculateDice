package id.smartech.calculatoranddiceroller

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.smartech.calculatoranddiceroller.calculator.CalculatorActivity
import id.smartech.calculatoranddiceroller.diceroller.DiceRollerActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        when (v?.id) {
            R.id.imageDice -> {
                baseStartActivity<DiceRollerActivity>(this)
            }

            R.id.imageCalculator -> {
                baseStartActivity<CalculatorActivity>(this)
            }
        }
    }

}

