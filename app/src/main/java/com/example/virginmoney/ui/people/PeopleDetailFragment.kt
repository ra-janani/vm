package com.example.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailFragment : Fragment() {
    private var _binding: FragmentPeopleDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PeopleDetailViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeopleDetailBinding.inflate(inflater, container, false)

        val people = arguments?.getSerializable("PeopleItem") as PeopleItemModel
//Lval card=findR.id.pdCard
            val view =binding.root
        Glide.with(view)
            .load(people.avatar)
            .into(binding.peopleImage)
        binding.peopleFirstname.text = people.firstName
        binding.peopleId.text = people.id
        binding.peopleEmail.text = people.email
        binding.peopleJobtitle.text = people.jobtitle
        binding.peopleFavcolor.text = people.favouriteColor

        when(people.favouriteColor) {

            "pink" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.pink
                    )
                )
            }
            "olive" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.olive
                    )
                )
            }
            "orchid" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.orchid
                    )
                )
            }

            "sky blue" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.skyblue
                    )
                )
            }
            "cyan" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.cyan
                    )
                )
            }
            "lavender" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.lavender
                    )
                )
            }
            "indigo" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.indigo
                    )
                )
            }
            "blue" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.blue
                    )
                )
            }
            "plum" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.plum
                    )
                )
            }
            "violet" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.violet
                    )
                )
            }
            "azure" -> {

                binding.llPeople.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context, R.color.azure
                    )
                )
            }
            //val mCardView=(CardView)itemView.fin
            // mCardView.setCardBackgroundColor(people.favouriteColor?.uppercase())
            //View cardLayout=pdCard

//binding.llPeople.setBackgroundColor(people.favouriteColor?.uppercase()!!.toInt())

            // var myColor= setOf<String>(people.favouriteColor).toString()

            /*if(people.favouriteColor=="pink"){
     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.pink)
     )

 } else if(people.favouriteColor=="olive"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.olive)
     )
 }
 else if(people.favouriteColor=="sky blue"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.skyblue)
     )
 }
 else if(people.favouriteColor=="cyan"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.cyan)
     )
 }
 else if(people.favouriteColor=="lavender"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.lavender)
     )
 }
 else if(people.favouriteColor=="indigo"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.indigo)
     )
 }
 else if(people.favouriteColor=="blue"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.blue)
     )
 }
 else if(people.favouriteColor=="plum"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.plum)
     )
 }
 else if(people.favouriteColor=="violet"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.violet)
     )
 }

 else if(people.favouriteColor=="azure"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view.context,R.color.azure)
     )
 }*/
        }
            return binding.root

    }
    /*private fun colorList(people: ArrayList<PeopleItemModel>?): MutableList<String> {
        //val colorList = ArrayList<String>()
        val colorList= setOf<PeopleItemModel>():
        people?.forEach {
            colorList.add(it.favouriteColor.toString())

        }
        return colorList*/
    }

