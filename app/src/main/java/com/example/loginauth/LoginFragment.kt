package com.example.loginauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.loginauth.databinding.FragmentLoginBinding
import com.example.loginauth.model.datamodel
import com.example.loginauth.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding:FragmentLoginBinding?=null
    private val binding get() =_binding!!
    private lateinit var viewModel:LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).mainViewModel

        binding.loginpageloginbtn.setOnClickListener {
            var loginuname=binding.loginuname.text.toString().trim()
            var loginpwd=binding.loginupwd.text.toString().trim()
            if (loginpwd.isNotEmpty() && loginuname.isNotEmpty()){

                lifecycleScope.launch {
                    try {
                        val searchList: List<datamodel> = viewModel.authenticate(loginuname, loginpwd)

                        if (searchList.isNotEmpty()) {
                            // Authentication successful
                            Toast.makeText(requireContext(), "Successfully Login", Toast.LENGTH_LONG).show()
                            it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        } else {
                            // Authentication failed
                            Toast.makeText(requireContext(), "Failure Login", Toast.LENGTH_LONG).show()
                        }
                    } catch (e: Exception) {
                        // Handle exceptions if any
                        Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }




}