package com.example.virginmoney.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.databinding.ItemRoomsBinding

class RoomsAdapter(val rooms:ArrayList<RoomsItemModel>):RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    var onItemClick:  ((RoomsItemModel) -> Unit)? = null

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val binding=ItemRoomsBinding.bind(view)

        fun handleData(item:RoomsItemModel?){
            binding.itemNo.text=item?.id
            binding.itemStatus.text=item?.isOccupied.toString()
            binding.itemMaxlimit.text=item?.maxOccupancy.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_rooms, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int =rooms?.size?:0

    override fun onBindViewHolder(holder: RoomsAdapter.ViewHolder, position: Int) {
        holder.handleData(rooms?.get(position))
        holder.itemView.setOnClickListener{
            rooms?.get(position)?.let{
                onItemClick?.invoke(it)
            }
        }


    }
}