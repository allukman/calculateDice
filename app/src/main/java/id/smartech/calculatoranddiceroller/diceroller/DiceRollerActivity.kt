package id.smartech.calculatoranddiceroller.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import id.smartech.calculatoranddiceroller.BaseActivity
import id.smartech.calculatoranddiceroller.R
import java.util.*

class DiceRollerActivity : BaseActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.text = getString(R.string.let_roll)
        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.imageView)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6)+1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        diceImage.setImageResource(drawableResource)

    }

}	