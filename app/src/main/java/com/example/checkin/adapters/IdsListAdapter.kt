package com.example.checkin.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkin.R
import com.example.checkin.data.IdentificationData

class IdsListAdapter (val idsListElements: List<IdentificationData>):RecyclerView.Adapter<IdsListAdapter.IdsListHolder>() {

	private lateinit var clickListener:onItemClickListener

	interface onItemClickListener {
		fun onItemClick (position: Int)
	}

	fun setOnItemClickListener (listener: onItemClickListener) {
		clickListener = listener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdsListHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		return IdsListHolder(layoutInflater.inflate(R.layout.rve_id, parent, false), clickListener)
	}

	override fun onBindViewHolder(holder: IdsListHolder, position: Int) {
		holder.render(idsListElements[position])
	}

	override fun getItemCount(): Int {
		return idsListElements.size
	}

	class IdsListHolder (val view: View, listener: onItemClickListener):RecyclerView.ViewHolder(view) {
		init {
			view.findViewById<LinearLayout>(R.id.ll_id_container).setOnClickListener {
				listener.onItemClick(adapterPosition)
			}
		}
		fun render (idListElement: IdentificationData) {
			view.findViewById<TextView>(R.id.tv_id_name).text = "Nombre: ${idListElement.fullName}"
			view.findViewById<TextView>(R.id.tv_id_curp).text = "CURP: ${idListElement.curp}"
			view.findViewById<TextView>(R.id.tv_id_hour).text = "Ingreso: ${idListElement.hour}"
			view.findViewById<TextView>(R.id.tv_id_is_new).text = if (idListElement.isNew) "Perfil: Usuario Nuevo" else "Perfil: Usuario Registrado"
		}
	}
}