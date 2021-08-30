package com.nicky.noteapp

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.nicky.noteapp.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList())
        }
        adapterCourses?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCourses.adapter=adapterCourses
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

}