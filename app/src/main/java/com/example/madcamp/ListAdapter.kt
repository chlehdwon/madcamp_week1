package com.example.madcamp

import android.app.Activity
import android.app.Dialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class ListAdapter(private var list: MutableList<TestData>): RecyclerView.Adapter<ListAdapter.ListItemViewHolder> (){

    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var data1Text: TextView = itemView!!.findViewById(R.id.data1Text)
//        var data2Text: TextView = itemView!!.findViewById(R.id.data2Text)
//        var data3Text: TextView = itemView!!.findViewById(R.id.data3Text)

        // onBindViewHolder의 역할을 대신한다.
        fun bind(data: TestData, position: Int) {
            data1Text.text = data.getData1()
//            data2Text.text = data.getData2()
//            data3Text.text = data.getData3()
        }
    }

    // ViewHolder에게 item을 보여줄 View로 쓰일 item_data_list.xml를 넘기면서 ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        val vHolder  = ListItemViewHolder(view)

        val dialog: Dialog = Dialog(parent.context)
        dialog.setContentView(R.layout.contact_popup)

        vHolder.itemView.setOnClickListener {
            var dialog_name: TextView = dialog!!.findViewById(R.id.dialog_name)
            var dialog_number: TextView = dialog!!.findViewById(R.id.dialog_number)
            var dialog_profile: TextView = dialog!!.findViewById(R.id.dialog_profile)
            var dialog_callbtn: Button = dialog!!.findViewById(R.id.dialog_call)
            var dialog_dmbtn: Button = dialog!!.findViewById(R.id.dialog_dm)

            dialog_name.setText(list.get(vHolder.adapterPosition).getData1())
            dialog_number.setText(list.get(vHolder.adapterPosition).getData2())
            dialog_profile.setText(list.get(vHolder.adapterPosition).getData3())




            dialog.show()

            dialog_dmbtn.setOnClickListener{
                dialog.hide()
                (parent.context as MainActivity).changer(2)
            }

            dialog_callbtn.setOnClickListener{
                val intent = Intent(parent.context, CallActivity::class.java)

                intent.putExtra("name", list.get(vHolder.adapterPosition).getData1())
                parent.context.startActivity(intent)
            }

        }


        return vHolder
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    // ViewHolder의 bind 메소드를 호출한다.
    override fun onBindViewHolder(holder: ListAdapter.ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }


}