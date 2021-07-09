package com.dynamicdevz.rxjavadynamic.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevz.rxjavadynamic.databinding.RickyDetailsFragmentLayoutBinding
import com.dynamicdevz.rxjavadynamic.model.data.Result

class RickyDetailsFragment: Fragment() {

    companion object{
        lateinit var rickyDetailsFragment: RickyDetailsFragment
        const val RESULT_KEY = "RESULT"

        fun getInstance(result: Result): RickyDetailsFragment{
            if(!this::rickyDetailsFragment.isInitialized)// checking if lateinit property has been initialized
                rickyDetailsFragment = RickyDetailsFragment()

            return rickyDetailsFragment.also {
                it.arguments = Bundle().also { bnd ->
                    bnd.putParcelable(RESULT_KEY, result)
                }
            }
        }

    }

    private lateinit var binding: RickyDetailsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RickyDetailsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Result>(RESULT_KEY)?.let {

            Glide.with(view)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(it.image)
                .into(binding.detailsImageview)

        }

    }
}






