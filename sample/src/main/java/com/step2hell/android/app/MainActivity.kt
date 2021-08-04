package com.step2hell.android.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.step2hell.android.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_greeting).visibleIf(true).clicks(
            lifecycleScope,
            duration = 1000,
            onIgnore = { view, interval ->
                toast("click onIgnore $view interval=$interval")
                ("click onIgnore $view interval=$interval").logw()
            },
            onClick = {
                toast("click onClick $it")
            }
        ).expandTouchArea(findViewById<ConstraintLayout>(R.id.relative), 50f.dp2px, 50f.dp2px, 100f.dp2px, 0)

        findViewById<TextView>(R.id.text_greeting2).clicks(
            lifecycleScope
        ) {
            toast("click onClick $it")
        }.expandTouchArea(
            findViewById<ConstraintLayout>(R.id.constraint),
            50f.dp2px,
            50f.dp2px,
            100f.dp2px,
            0
        ).visibleIf(true, View.INVISIBLE)

        "screenWidth=$SCREEN_WIDTH screenHeight=$SCREEN_HEIGHT".logd()
    }
}
