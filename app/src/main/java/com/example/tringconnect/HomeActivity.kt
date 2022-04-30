package com.example.tringconnect

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import com.example.tringconnect.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.bottomBar.itemIconTintList = null

        binding.toolbar.menu.forEachIndexed { _, item ->
            item.iconTintList = ColorStateList.valueOf(getColor(R.color.black))
        }


        binding.toolbar.setNavigationOnClickListener {
            val color =
                if (binding.toolbar.navigationIconTint == getColor(R.color.black)) getColor(R.color.lightGreen) else getColor(
                    R.color.black
                )
            binding.toolbar.setNavigationIconTint(color)
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                val menuColor =
                    if (it.iconTintList == ColorStateList.valueOf(getColor(R.color.black)))
                        ColorStateList.valueOf(getColor(R.color.lightGreen))
                    else
                        ColorStateList.valueOf(getColor(R.color.black))

                it.iconTintList = menuColor
                }
            }

            return@setOnMenuItemClickListener true
        }
    }

    fun onClick(view: View) {
        view.findViewById<ImageView>(R.id.badge).visibility = View.GONE
        view.findViewById<ImageView>(R.id.notify).apply {
            val menuColor =
                if (imageTintList == ColorStateList.valueOf(getColor(R.color.black)))
                    ColorStateList.valueOf(getColor(R.color.lightGreen))
                else
                    ColorStateList.valueOf(getColor(R.color.black))

            imageTintList = menuColor
        }
    }
}