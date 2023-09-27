package woowacourse.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val path = Path()
    private val paint = Paint()

    init {
        setupPaint()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val pointX = event.x
        val pointY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(pointX, pointY)
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(pointX, pointY)
            }
            MotionEvent.ACTION_UP -> { }
            else -> super.onTouchEvent(event)
        }
        invalidate()
        return true
    }

    private fun setupPaint() {
        paint.color = Color.MAGENTA
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 10f
    }
}
