package ipca.example.viewpager

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var adapter = MyFriendRecyclerViewAdapter()

    var listStrings = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_rv, container, false)
        val recyclerViewFriends = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerViewFriends.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewFriends.adapter = adapter
        recyclerViewFriends.itemAnimator = DefaultItemAnimator()
        return view
    }

    companion object {
        const val ARG_PARAM1 = "ARG_PARAM1"
        const val ARG_PARAM2 = "ARG_PARAM2"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RvFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        param1?.let { listStrings.add(it) }
        param2?.let { listStrings.add(it) }
    }

    inner class MyFriendRecyclerViewAdapter :
        RecyclerView.Adapter<MyFriendRecyclerViewAdapter.ViewHolder>() {

        inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return listStrings.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.v.apply {
                findViewById<TextView>(R.id.textViewTitle).text = listStrings[position]
            }
        }

    }



}