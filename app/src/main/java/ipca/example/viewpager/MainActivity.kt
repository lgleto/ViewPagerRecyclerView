package ipca.example.viewpager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var titles : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titles = arrayListOf<String>("English", "Portuguese" )

        sectionsPagerAdapter = SectionsPagerAdapter( supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        viewPager.adapter = sectionsPagerAdapter

        tabs.setupWithViewPager(viewPager)

        fragments.add(RvFragment.newInstance("Hello", "World!"))
        fragments.add(RvFragment.newInstance("Olá", "Mundo!"))

        sectionsPagerAdapter.notifyDataSetChanged()
    }


    private var fragments: MutableList<Fragment> = ArrayList()
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter


    inner class SectionsPagerAdapter( fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        override fun getCount(): Int {
            return fragments.count()
        }
    }
}