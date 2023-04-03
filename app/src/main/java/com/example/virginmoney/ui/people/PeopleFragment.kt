package com.example.virginmoney.ui.people

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment(){

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PeopleViewModel>()
    lateinit var searchView: SearchView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        /*searchView = requireView().findViewById(R.id.searchview)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener,
                android.widget.SearchView.onQueryTextListener
        {
            override fun onQueryTextSubmit(query:String?):Boolean{
                if(viewModel.people.contains(query)){
                    peopleAdapter.filter.filter(query)
                }
                else{
                    Toast.makeText(this,"No persons found",Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?):Boolean{
                peopleAdapter.filter.filter(newText)

                return false

            }

        }*/

        viewModel.people.observe(viewLifecycleOwner){
            it?.let{
                setupUI(it)
            }

        }
        viewModel.getPeopleData()
        return binding.root
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_search,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        Toast.makeText(requireContext(),"Fragment search clicked",Toast.LENGTH_SHORT).show()
        return true
    }*/

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }*/

    private fun setupUI(people:ArrayList<PeopleItemModel>){

        val peopleAdapter=PeopleAdapter(people)
        binding.rvPeople.apply{
            layoutManager=LinearLayoutManager(context)
            adapter=peopleAdapter
        }

        peopleAdapter.onItemClick= {
            val bundle = Bundle().apply {
                putSerializable("PeopleItem", it)
            }

            findNavController().navigate(R.id.action_nav_people_to_peopleDetailFragment, bundle)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}