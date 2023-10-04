package woowacourse.paint.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import woowacourse.paint.R
import woowacourse.paint.databinding.ActivityMainBinding
import woowacourse.paint.ui.recyclerview.PaintAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRangeSlider()
        setPalette()
    }

    private fun setRangeSlider() {
        binding.rangeSlider.addOnChangeListener { _, value, _ ->
            binding.canvas.setMyStrokeWidth(value)
        }
    }

    private fun setPalette() {
        binding.palette.apply {
            adapter = PaintAdapter(
                listOf(
                    getColor(R.color.red),
                    getColor(R.color.orange),
                    getColor(R.color.yellow),
                    getColor(R.color.green),
                    getColor(R.color.blue),
                ),
                binding.canvas::setMyStrokeColor,
            )
            setHasFixedSize(true)
        }
    }
}
