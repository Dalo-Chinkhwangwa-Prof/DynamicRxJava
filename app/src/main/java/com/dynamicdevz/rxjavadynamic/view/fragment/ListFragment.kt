package com.dynamicdevz.rxjavadynamic.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynamicdevz.rxjavadynamic.databinding.ListFragmentLayoutBinding
import com.dynamicdevz.rxjavadynamic.databinding.ListItemLayoutBinding
import com.dynamicdevz.rxjavadynamic.util.ViewType
import com.dynamicdevz.rxjavadynamic.view.adapter.RickAdapter
import com.dynamicdevz.rxjavadynamic.viewmodel.RickyViewModel

class ListFragment : Fragment() {

    //implementation 'androidx.fragment:fragment-ktx:1.2.5'
    private lateinit var binding: ListFragmentLayoutBinding
    private val viewModel by activityViewModels<RickyViewModel>()
    private val adapter = RickAdapter(ViewType.LIST)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listRv.adapter = adapter

        viewModel.rickData.observe(viewLifecycleOwner, {
            adapter.listResults = it
        })

    }
}