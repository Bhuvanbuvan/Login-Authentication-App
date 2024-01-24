package com.example.loginauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.loginauth.databinding.FragmentNewRegBinding
import com.example.loginauth.model.datamodel
import com.example.loginauth.viewmodel.LoginViewModel

class NewRegFragment : Fragment(R.layout.fragment_new_reg) {

    private  var _binding:FragmentNewRegBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel:LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentNewRegBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as MainActivity).mainViewModel

        binding.registerbtn.setOnClickListener {
            var loginuname=binding.registernuname.text.toString().trim()
            var loginpwd=binding.registernupwd.text.toString().trim()

            if (loginpwd.isNotEmpty() && loginuname.isNotEmpty()){
                var data= datamodel(0,loginuname,loginpwd)
                viewModel.insert(data)
                Toast.makeText(requireContext(),"Successfully Registered", Toast.LENGTH_LONG).show()

                it.findNavController().navigate(R.id.action_newRegFragment_to_homeFragment2)

            }
        }
    }

}