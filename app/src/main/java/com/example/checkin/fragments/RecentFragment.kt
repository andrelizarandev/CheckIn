package com.example.checkin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkin.R
import com.example.checkin.activities.IdDetails
import com.example.checkin.activities.PhotoResult
import com.example.checkin.adapters.IdsListAdapter
import com.example.checkin.data.IdentificationData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecentFragment : Fragment() {

	// Components
	private lateinit var fabCamera: FloatingActionButton
	private lateinit var rvIds: RecyclerView

	private var idsList: MutableList<IdentificationData> = mutableListOf(
		IdentificationData("25/08/2022", "05:12:20", true,  "WAIASDOPE", "Usuario Test 1"),
		IdentificationData("25/08/2022", "12:21:50", false, "IODAIWODJ", "Usuario Test 2"),
		IdentificationData("25/08/2022", "13:32:23", true,  "CSNDCSOIN", "Usuario Test 3"),
		IdentificationData("25/08/2022", "23:05:43", false, "FPOEFWMEP", "Usuario Test 4")
	)

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.fragment_recent, container, false)
		fabCamera = view.findViewById(R.id.fab_camera)
		rvIds = view.findViewById(R.id.rv_ids)
		addListeners()
		initRecyclerView()
		return view
	}

	private fun addListeners () {
		fabCamera.setOnClickListener { startTakingPhotos() }
	}

	private fun startTakingPhotos () {
		val intent = Intent(activity, PhotoResult::class.java)
		startActivity(intent)
	}

	private fun initRecyclerView () {
		rvIds.layoutManager = LinearLayoutManager(activity)
		val adapter = IdsListAdapter(idsList)
		rvIds.adapter = adapter
		adapter.setOnItemClickListener(object :IdsListAdapter.onItemClickListener {
			override fun onItemClick(position: Int) {
				val intent = Intent(activity, IdDetails::class.java)
				startActivity(intent)
			}
		})
	}

}

