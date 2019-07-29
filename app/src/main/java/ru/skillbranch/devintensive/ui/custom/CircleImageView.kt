package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R

import android.graphics.Paint
import androidx.annotation.ColorRes
import androidx.annotation.Dimension


class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 2
    }

    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH

    private var circlePaint = Paint()


    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)

            borderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            borderWidth = a.getDimensionPixelSize(R.styleable.CircleImageView_cv_borderWidth, DEFAULT_BORDER_WIDTH)

            a.recycle()
        }
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) return

        //paint object for drawing in onDraw
        circlePaint = Paint()
        circlePaint.isAntiAlias = true

        //get half of the width and height as we are working with a circle
        val viewWidthHalf = this.getMeasuredWidth() / 2
        val viewHeightHalf = this.getMeasuredHeight() / 2

        //get the radius as half of the width or height, whichever is smaller
        //subtract ten so that it has some space around it
        var radius = if (viewWidthHalf > viewHeightHalf) viewHeightHalf else viewWidthHalf

        canvas.drawCircle(viewWidthHalf.toFloat(), viewHeightHalf.toFloat(), radius.toFloat(), circlePaint)


    }


//    //@Dimension
//    fun getBorderWidth() = borderWidth
//
//    //@Dimension
//    fun setBorderWidth(dp: Int) {
//        if (dp != borderWidth){
//            borderWidth = dp
//            setup()
//        }
//    }
//
//    fun getBorderColor() = borderColor
//
//
//    fun setBorderColor(@ColorRes colorId: Int) {
//        setIntBorderColor(resources.getColor(colorId, context.theme))
//    }
//
//    fun setBorderColor(hex:String){
//        setIntBorderColor(Integer.parseInt(hex,16))
//    }
//
//
//    fun setIntBorderColor(color: Int) {
//        if (color != borderColor) {
//            borderColor = color
//            borderPaint.color = borderColor
//            invalidate()
//        }
//    }


}