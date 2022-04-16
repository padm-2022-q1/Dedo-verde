package com.example.dedoverde.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dedoverde.databinding.MyPlantationListItemBinding
import com.example.dedoverde.model.Plantation

class MyPlantationAdapter(private val plantations: List<Plantation>, private val onClickListener: OnClickListener):
    RecyclerView.Adapter<MyPlantationAdapter.MyPlantationHolder>() {

    class MyPlantationHolder(itemBinding: MyPlantationListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val name = itemBinding.plantationName
        val date = itemBinding.plantationDate
        val size = itemBinding.plantationSize
    }

    class OnClickListener(
        val clickListener: (plantation: Plantation) -> Unit
    ) {
        fun onClick(plantation: Plantation) = clickListener(plantation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPlantationHolder =
        MyPlantationHolder(MyPlantationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyPlantationHolder, position: Int) {
        val plantation = plantations[position]

        holder.name.text = plantation.name
        holder.date.text = plantation.formattedDateCreated()
        holder.size.text = plantation.size

        holder.itemView.setOnClickListener {
            onClickListener.onClick(plantation)
        }
    }

    override fun getItemCount(): Int = plantations.size

}