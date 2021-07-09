package com.dynamicdevz.rxjavadynamic.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.dynamicdevz.rxjavadynamic.R
import com.dynamicdevz.rxjavadynamic.databinding.ActivityMainBinding
import com.dynamicdevz.rxjavadynamic.model.data.Result
import com.dynamicdevz.rxjavadynamic.view.adapter.HomeFragmentAdapter
import com.dynamicdevz.rxjavadynamic.view.fragment.RickyDetailsFragment
import com.dynamicdevz.rxjavadynamic.view.fragment.RickySelector
import com.dynamicdevz.rxjavadynamic.viewmodel.RickyViewModel

class MainActivity : AppCompatActivity(), RickySelector {

    private val viewModel by viewModels<RickyViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var hFA: HomeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hFA = HomeFragmentAdapter(supportFragmentManager)
        binding.mainVp.adapter = hFA

        binding.mainVp.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                binding.mainMenu.selectedItemId = if(position == 0) R.id.list_menu_item else R.id.grid_menu_item
            }

            override fun onPageScrollStateChanged(state: Int) {
//                TODO("Not yet implemented")
            }

        })

        binding.mainMenu.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.list_menu_item -> {
                    binding.mainVp.currentItem = 0
                } else-> {
                    binding.mainVp.currentItem = 1
                }
            }
            true
        }
    }

    override fun openDetailsFragment(result: Result) {
        val fragment = RickyDetailsFragment.getInstance(result)

        Log.d("TAG_X", "odf")
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            .add(R.id.details_frame, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }


}