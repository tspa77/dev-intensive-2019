package ru.skillbranch.devintensive.ui.custom


import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import ru.skillbranch.devintensive.R
import kotlin.math.max


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
    private var borderWidth = (DEFAULT_BORDER_WIDTH * resources.displayMetrics.density).toInt()


    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)

            val dp = resources.displayMetrics.density
            Log.d("M_CircleImageView","$dp dp")
            borderWidth = a.getDimensionPixelSize(R.styleable.CircleImageView_cv_borderWidth, (DEFAULT_BORDER_WIDTH * dp).toInt())
            borderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)

            a.recycle()

        }
    }


    override fun onDraw(canvas: Canvas) {

        //создаем круг
        Log.d("M_CircleImageView","$width width")
        val halfWidth = width / 2f
        val halfHeight = height / 2f
        val radius = max(halfWidth, halfHeight)
        Log.d("M_CircleImageView","$radius radius")
        val path = Path()
        path.addCircle(halfWidth, halfHeight, radius, Path.Direction.CCW)

        //обрезаем
        canvas.clipPath(path)

        super.onDraw(canvas)


        // делаем бордюр
        val borderPaint = Paint()
        borderPaint.isAntiAlias = true
        borderPaint.style = Paint.Style.STROKE
        borderPaint.color = DEFAULT_BORDER_COLOR
        borderPaint.strokeWidth = DEFAULT_BORDER_WIDTH.toFloat()
        Log.d("M_CircleImageView","${borderPaint.strokeWidth} borderPaint.strokeWidth")


        //рисуем
        canvas.drawCircle(halfWidth, halfHeight, radius, borderPaint)


    }


}