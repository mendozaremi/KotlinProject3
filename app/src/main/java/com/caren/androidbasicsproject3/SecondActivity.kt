package com.caren.androidbasicsproject3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_task)

        findViewById<View>(R.id.btnSaveReturn).setOnClickListener {
            finish()
        }
    }
}