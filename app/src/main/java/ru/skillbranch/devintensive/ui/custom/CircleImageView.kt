package ru.skillbranch.devintensive.ui.custom


import android.content.Context
import android.graphics.*
import android.graphics.Bitmap.Config
import android.graphics.PorterDuff.Mode
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R
import kotlin.math.min


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



    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)

            borderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            borderWidth = a.getDimensionPixelSize(R.styleable.CircleImageView_cv_borderWidth, DEFAULT_BORDER_WIDTH)

            a.recycle()
        }
    }



    /*
    Следующие 2 методы взяты чуть более чем полностью отсюда:
    https://gist.github.com/melanke/7158342
     */
    override fun onDraw(canvas: Canvas) {

        val drawable: Drawable? = drawable

        if ((drawable == null) && (width == 0 || height == 0)) {
            return
        }

        val b = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Config.ARGB_8888, true)

        val w = width
//        val h = height

        val roundBitmap = getCroppedBitmap(bitmap, w)
        canvas.drawBitmap(roundBitmap, 0f, 0f, null)

    }

    fun getCroppedBitmap(bmp: Bitmap, radius: Int): Bitmap {
        val sbmp: Bitmap

        sbmp = if (bmp.width != radius || bmp.height != radius) {
            val smallest = min(bmp.width, bmp.height).toFloat()
            val factor = smallest / radius
            Bitmap.createScaledBitmap(bmp, (bmp.width / factor).toInt(), (bmp.height / factor).toInt(), false)
        } else {
            bmp
        }

        val output = Bitmap.createBitmap(radius, radius, Config.ARGB_8888)
        val canvas = Canvas(output)

        val paint = Paint()
        val rect = Rect(0, 0, radius, radius)

        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = Color.parseColor("#BAB399")
        canvas.drawCircle(
            radius / 2 + 0.7f,
            radius / 2 + 0.7f,
            radius / 2 + 0.1f,
            paint
        )
        paint.xfermode = PorterDuffXfermode(Mode.SRC_IN)
        canvas.drawBitmap(sbmp, rect, rect, paint)

        return output
    }

}