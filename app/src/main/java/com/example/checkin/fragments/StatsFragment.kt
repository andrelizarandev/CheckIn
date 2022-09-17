package com.example.checkin.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.checkin.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class StatsFragment : Fragment() {

	private lateinit var barList:ArrayList<BarEntry>
	private lateinit var barData:BarData
	private lateinit var barDataSet:BarDataSet

	// Components
	private lateinit var bcDaysStats:BarChart

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.fragment_stats, container, false)
		bcDaysStats = view.findViewById(R.id.bc_days_stats)
		barList = ArrayList()
		barList.add(BarEntry(1f, 500f))
		barList.add(BarEntry(2f, 400f))
		barList.add(BarEntry(3f, 350f))
		barList.add(BarEntry(4f, 300f))
		barList.add(BarEntry(5f, 250f))
		barList.add(BarEntry(6f, 200f))
		barList.add(BarEntry(7f, 150f))
		barDataSet = BarDataSet(barList, "Concurrencia durante la semana")
		barData = BarData(barDataSet)
		bcDaysStats.data = barData
		barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 250)
		barDataSet.valueTextColor = Color.BLACK
		barDataSet.valueTextSize = 10f
		bcDaysStats.description.isEnabled = false
		return view
	}

}