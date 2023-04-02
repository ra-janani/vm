package com.example.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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


        binding.peopleFirstname.text = people.firstName
        binding.peopleId.text = people.id
        binding.peopleEmail.text = people.email
        binding.peopleJobtitle.text = people.jobtitle
        binding.peopleFavcolor.text = people.favouriteColor

 /*if(people.favouriteColor=="pink"){

     binding.llPeople.setBackgroundColor(
         ContextCompat.getColor(
             view?.context ?:#FFD3457D)
              )
 }
*/

        return binding.root
    }
}
