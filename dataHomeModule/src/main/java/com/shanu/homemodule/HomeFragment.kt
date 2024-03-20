package com.shanu.homemodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.shanu.homemodule.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeModuleDataCallback: () -> Unit

    fun registerHomeModuleDataCallback(dataCallback: () -> Unit) {
        homeModuleDataCallback = dataCallback
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                /*val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
                activity?.finish()
                Intent(
                    requireActivity(),
                    Class.forName("com.shanu.nmsuperapp.presentation.activity.LoginActivity")
                ).apply {
                    startActivity(this)
                }.also {
                    activity?.finish()
                }*/
                homeModuleDataCallback.invoke()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout and bind to the _binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }
}