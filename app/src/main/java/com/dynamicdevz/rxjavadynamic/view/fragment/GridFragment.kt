package com.dynamicdevz.rxjavadynamic.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynamicdevz.rxjavadynamic.databinding.GridFragmentLayoutBinding
import com.dynamicdevz.rxjavadynamic.model.data.Result
import com.dynamicdevz.rxjavadynamic.util.ViewType
import com.dynamicdevz.rxjavadynamic.view.adapter.RickAdapter
import com.dynamicdevz.rxjavadynamic.viewmodel.RickyViewModel

class GridFragment: Fragment(), RickAdapter.RickDelegate {

    //implementation 'androidx.fragment:fragment-ktx:1.2.5'
    private lateinit var binding: GridFragmentLayoutBinding
    private val viewModel by activityViewModels<RickyViewModel>()
    private val adapter = RickAdapter(ViewType.GRID)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GridFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gridRv.adapter = adapter

        viewModel.rickData.observe(viewLifecycleOwner, {
            adapter.listResults = it
        })

    }

    override fun selectCharacter(result: Result) {

    }

}