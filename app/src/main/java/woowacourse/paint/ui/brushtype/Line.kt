package woowacourse.paint.ui.brushtype

import android.graphics.Paint
import android.graphics.Path
import com.example.domain.BrushType.LINE

class Line : BrushType {
    override var type = LINE

    private var path = Path()
    private var paint = Paint()

    override fun setupPaint(width: Float, color: Int) {
        path = Path()
        paint = Paint()

        paint.isAntiAlias = true
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = width
        paint.xfermode = null
    }

    override fun startDrawing(pointX: Float, pointY: Float) {
        path.moveTo(pointX, pointY)
    }

    override fun moveDrawing(pointX: Float, pointY: Float) {
        path.lineTo(pointX, pointY)
    }

    fun doActionUp(pointX: Float, pointY: Float) {
        path.lineTo(pointX, pointY)
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
}
