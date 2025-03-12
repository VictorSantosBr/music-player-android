package com.example.player

import android.animation.Animator
import android.app.ActivityOptions
import android.app.Fragment
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.MotionEvent
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.player.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var intent: Intent

    private var playIcon: Drawable? = null
    private var pauseIcon: Drawable? = null
    private var clicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        playIcon = AppCompatResources.getDrawable(this, R.drawable.play_icon)
        pauseIcon = AppCompatResources.getDrawable(this, R.drawable.pause)
        intent = Intent(this, SecondActivity::class.java)

        click()
        changeActivity()

    }
    private fun click() {
        binding.play.setOnClickListener {
            if (!clicked) {
                binding.play.icon = pauseIcon
                binding.play.iconGravity = MaterialButton.ICON_GRAVITY_START
                clicked = true
                println("foram ${clicked} ativou pauseIcon")
            } else {
                binding.play.icon = playIcon
                binding.play.iconGravity = MaterialButton.ICON_GRAVITY_END
                clicked = false
                println("foram ${clicked} ativou playIcon")
            }
        }
    }
    private fun changeActivity () {
        binding.secondarrow.setOnClickListener {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        binding.changeActivity.setOnClickListener {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }
}
