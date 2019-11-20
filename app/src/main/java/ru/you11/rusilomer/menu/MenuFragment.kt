package ru.you11.rusilomer.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import ru.you11.rusilomer.R
import ru.you11.rusilomer.base.BaseFragment
import ru.you11.rusilomer.databinding.FragmentMainBinding

class MenuFragment : BaseFragment<MenuViewModel>() {

    lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main, container, false)
        binding.apply {
            toTasksFragmentBtn.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMainFragmentToTasksFragment())
            }
        }
        return binding.root
    }

    override fun createViewModel(): MenuViewModel {
        return ViewModelProviders.of(this).get(MenuViewModel::class.java)
    }
}