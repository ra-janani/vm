package com.example.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.databinding.ItemPeopleBinding

class PeopleAdapter(var people:ArrayList<PeopleItemModel>):RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    var onItemClick:  ((PeopleItemModel) -> Unit)? = null


    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){

        val binding=ItemPeopleBinding.bind(view)

        fun handleData(item:PeopleItemModel?){
           binding.itemFirstName.text=item?.firstName
            binding.itemJobtitle.text=item?.jobtitle

            if (adapterPosition % 2 == 0) {
                binding.ccPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.green
                    )
                )

            } else {
                binding.ccPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.green_100
                    )
                )


            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return ViewHolder(view)
    }
    fun filterList(filterlist:ArrayList<PeopleItemModel>){
        people=filterlist
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int =people?.size?:0

    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.handleData(people?.get(position))
        holder.itemView.setOnClickListener{
            people?.get(position)?.let{
                onItemClick?.invoke(it)

            }
        }


    }
}