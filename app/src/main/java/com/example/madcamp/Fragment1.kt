package com.example.madcamp

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentOnAttachListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.core.view.Change
import org.json.JSONObject
import java.util.Calendar.getInstance


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TestData(
    private var data1: String? = null,
    private var data2: String? = null,
    private var data3: String? = null,
    private var data4: String? = null
){
    fun getData1(): String? {
        return data1
    }
    fun getData2(): String? {
        return data2
    }
    fun getData3(): String? {
        return data3
    }
    fun getData4(): String? {
        return data4
    }
}

class Fragment1 : Fragment(){
    // RecyclerView.adapter에 지정할 Adapter
    private lateinit var listAdapter: ListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_1, container, false)

        val myCard: Button = view!!.findViewById(R.id.my_card)
        val dialog: MyDF = MyDF().getInstance()
        myCard.setOnClickListener {
            activity?.supportFragmentManager?.let { fragmentManager ->
                dialog.show(fragmentManager, "TAG_DIALOG_EVENT")
            }
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var dataList = arrayListOf<TestData>()
//        var list: ArrayList<TestData> = requireActivity().intent!!.extras!!.get("DataList") as ArrayList<TestData>
//        Log.e("FirstFragment", "Data List: ${list}")
        val assetManager: AssetManager = requireContext().resources.assets
        val inputStream = assetManager.open("Data.json")
        val jsonString = inputStream.bufferedReader().use{it.readText()}
        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("phonebook")

        for(i in 0 until jArray.length()){
            val obj = jArray.getJSONObject(i)
            val name = obj.getString("Name")
            val number = obj.getString("Phone")
            val profile = obj.getString("Profile")
            val url = obj.getString("url")
            dataList.add(TestData(name, number,profile,url))
        }
        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
        listAdapter = ListAdapter(dataList)
        val listView: RecyclerView = requireView().findViewById<View>(R.id.listView) as RecyclerView
        listView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // RecyclerView.adapter에 지정
        listView.isNestedScrollingEnabled = false
        listView.setHasFixedSize(false)
        listView.adapter = listAdapter

    }
}
