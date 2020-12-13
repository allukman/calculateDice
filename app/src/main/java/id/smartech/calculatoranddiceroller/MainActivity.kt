package id.smartech.calculatoranddiceroller

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.smartech.calculatoranddiceroller.calculator.CalculatorActivity
import id.smartech.calculatoranddiceroller.diceroller.DiceRollerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        when (v?.id) {
            R.id.imageDice -> {
                val intent = Intent(this, DiceRollerActivity::class.java)
                startActivity(intent)
            }

            R.id.imageCalculator -> {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

