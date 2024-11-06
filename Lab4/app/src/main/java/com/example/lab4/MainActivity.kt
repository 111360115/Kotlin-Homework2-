package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tv_meal: TextView
    private lateinit var btn_select: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_meal = findViewById(R.id.tv_meal)
        btn_select = findViewById(R.id.btn_choice)

        btn_select.setOnClickListener {
            startActivityForResult(Intent(this, Main2Activity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) return

        if (requestCode == 1 && resultCode == 101) {
            val b = data.extras
            val str1 = b?.getString("drink")
            val str2 = b?.getString("sugar")
            val str3 = b?.getString("ice")
            tv_meal.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s", str1, str2, str3)
        }
    }
}
