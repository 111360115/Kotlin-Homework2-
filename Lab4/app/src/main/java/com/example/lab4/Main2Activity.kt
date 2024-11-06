package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var btn_send: Button? = null

    private var sugar = "無糖"
    private var ice_opt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize EditText and RadioGroup components
        set_drink = findViewById(R.id.ed_drink)
        rg1 = findViewById(R.id.radioGroup)
        rg2 = findViewById(R.id.radioGroup2)
        btn_send = findViewById(R.id.btn_send)

        // Set listener for sugar RadioGroup
        rg1?.setOnCheckedChangeListener { _, i ->
            sugar = when (i) {
                R.id.radioButton1 -> "無糖"
                R.id.radioButton2 -> "少糖"
                R.id.radioButton3 -> "半糖"
                R.id.radioButton4 -> "全糖"
                else -> sugar
            }
        }

        // Set listener for ice RadioGroup
        rg2?.setOnCheckedChangeListener { _, i ->
            ice_opt = when (i) {
                R.id.radioButton5 -> "去冰"
                R.id.radioButton6 -> "微冰"
                R.id.radioButton7 -> "少冰"
                R.id.radioButton8 -> "正常冰"
                else -> ice_opt
            }
        }

        // Set click listener for send button
        btn_send?.setOnClickListener {
            val drink = set_drink?.text.toString() // Get text from EditText
            val intent = Intent()
            val bundle = Bundle()
            bundle.putString("drink", drink)
            bundle.putString("sugar", sugar)
            bundle.putString("ice", ice_opt)
            intent.putExtras(bundle)
            setResult(101, intent)
            finish()
        }
    }
}
