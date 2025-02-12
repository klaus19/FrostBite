package com.tejas.frosty

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class FrostyButton @JvmOverloads constructor(
       context: Context,
    attrs:AttributeSet?=null,
    defStyleAttr:Int=0
):AppCompatButton(context,attrs,defStyleAttr){

    private var cornerRadius:Float = 0f
    private var buttonColor: Int = Color.parseColor("#1976D2")

    init {
        // Get custom attributes
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomButton,
            0,0
        ).apply {
            try {
                cornerRadius = getDimension(R.styleable.CustomButton_cornerRadius,0f)
                buttonColor = getColor(R.styleable.CustomButton_buttonColor,Color.parseColor("#1976D2"))

            }finally {
                recycle()
            }
        }
        setUpButton()
    }

    private fun setUpButton() {
        background = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = this@FrostyButton.cornerRadius
            setColor(buttonColor)
        }
        // Add elevation
        elevation = 4f
    }
    // Public methods to change properties programmatically
    fun setCustomCornerRadius(radius: Float) {
        cornerRadius = radius
        setUpButton()
    }

    fun setCustomButtonColor(color: Int) {
        buttonColor = color
        setUpButton()
    }
}