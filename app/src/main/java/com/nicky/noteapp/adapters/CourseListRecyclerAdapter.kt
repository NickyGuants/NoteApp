package com.nicky.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicky.noteapp.data.CourseInfo

class CourseListRecyclerAdapter(context: Context?, private val courses: List<CourseInfo>):
    RecyclerView.Adapter<CourseListRecyclerAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseTitle =itemView?.findViewById<TextView>(R.id.courseTitle)
        var coursePosition =0

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_course_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course =courses[position]
        holder.courseTitle?.text=course.title
        holder.coursePosition =position
    }

    override fun getItemCount(): Int {
        return courses.size
    }

}
