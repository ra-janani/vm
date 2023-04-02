package com.example.virginmoney.ui.rooms

import android.os.Bundle
import android.view.*
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
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.databinding.FragmentRoomsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment(){

    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RoomsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)

        viewModel.rooms.observe(viewLifecycleOwner){
            it?.let{
                setupUI(it)
            }

        }
        viewModel.getRoomsData()
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

    private fun setupUI(rooms:ArrayList<RoomsItemModel>){

        val roomsAdapter=RoomsAdapter(rooms)
        binding.rvRooms.apply{
            layoutManager=LinearLayoutManager(context)
            adapter=roomsAdapter
        }

        roomsAdapter.onItemClick= {
            val bundle = Bundle().apply {
                putSerializable("RoomsItem", it)
            }



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}