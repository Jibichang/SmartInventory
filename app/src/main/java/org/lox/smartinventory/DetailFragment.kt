package org.lox.smartinventory

import android.graphics.DashPathEffect
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import org.lox.smartinventory.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    lateinit var binding :FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val args = DetailFragmentArgs.fromBundle(arguments!!)
        binding.textDetail.text = args.id

        initGraph()

        return binding.root
    }

    private fun initGraph(){
        val graph = binding.graph
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(
            arrayOf(
                DataPoint(2015.0, (100..1000).random().toDouble()),
                DataPoint(2016.0, (100..1000).random().toDouble()),
                DataPoint(2017.0, (100..1000).random().toDouble()),
                DataPoint(2018.0, (100..1000).random().toDouble()),
                DataPoint(2019.0, (100..1000).random().toDouble())
            )
        )
        series.isDrawDataPoints = true
        series.thickness = 10
        series.backgroundColor = R.color.primaryBackground

        val paint = Paint()
        paint.color = resources.getColor(R.color.primaryLightColor)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10.toFloat()
        paint.pathEffect = DashPathEffect(floatArrayOf(8f, 5f), 0.toFloat())
        series.setCustomPaint(paint)
        graph.addSeries(series)
    }

}
