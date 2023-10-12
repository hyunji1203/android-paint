package woowacourse.paint.ui.brushtype

import android.graphics.Paint
import android.graphics.Path
import com.example.domain.BrushType.RECTANGLE

class Rectangle : BrushType {
    override var type = RECTANGLE

    private var path = Path()
    private var paint = Paint()

    private var startPointX = START_DEFAULT_COORDINATE
    private var startPointY = START_DEFAULT_COORDINATE

    override fun setupPaint(width: Float, color: Int) {
        path = Path()
        paint = Paint()

        paint.color = color
        paint.style = Paint.Style.FILL
        paint.strokeWidth = width
        paint.xfermode = null
    }

    override fun doActionDown(pointX: Float, pointY: Float) {
        startPointX = pointX
        startPointY = pointY
    }

    override fun doActionMove(pointX: Float, pointY: Float) {
        path.reset()
        path.addRect(startPointX, startPointY, pointX, pointY, Path.Direction.CCW)
    }

    override fun getPath(): Path {
        return path
    }

    override fun getPaint(): Paint {
        return paint
    }

    override fun setStrokeWidth(width: Float) {
        paint.strokeWidth = width
    }

    override fun setStrokeColor(color: Int) {
        paint.color = color
    }

    companion object {
        private const val START_DEFAULT_COORDINATE = 0f
    }
}