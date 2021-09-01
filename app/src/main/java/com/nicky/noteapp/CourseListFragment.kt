package com.nicky.noteapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicky.noteapp.databinding.FragmentCourseListBinding


class CourseListFragment : Fragment() {
    private var _binding: FragmentCourseListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCourseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView =binding.courseItems
        //set the layout manager of the recyclerview
        recyclerView.layoutManager= LinearLayoutManager(context)
        //connect the item view to the adapter
        recyclerView.adapter=CourseListRecyclerAdapter(context, DataManager.courses.values.toList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}