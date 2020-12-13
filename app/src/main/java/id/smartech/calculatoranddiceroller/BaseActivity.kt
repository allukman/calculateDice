package id.smartech.calculatoranddiceroller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }

    protected inline fun <reified ClassActivity> baseStartActivity(context: Context) {
        context.startActivity(Intent(context, ClassActivity::class.java))
    }
}