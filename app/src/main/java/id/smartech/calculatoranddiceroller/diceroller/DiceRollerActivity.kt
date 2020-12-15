package id.smartech.calculatoranddiceroller.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import id.smartech.calculatoranddiceroller.BaseActivity
import id.smartech.calculatoranddiceroller.R
import kotlinx.android.synthetic.main.activity_dice_roller.*
import java.util.*

class DiceRollerActivity : BaseActivity() {

    lateinit var dice: Dice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
        dice = Dice(imageView)
    }

    fun onClick (v: View?) {
        when (v?.id) {
            R.id.button -> dice.rollDice()
        }
    }
}	