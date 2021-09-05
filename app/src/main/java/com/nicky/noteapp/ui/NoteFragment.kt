package com.nicky.noteapp

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.nicky.noteapp.data.DataManager
import com.nicky.noteapp.data.POSITION_NOT_SET
import com.nicky.noteapp.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding?=null
    private val binding get() = _binding!!
    private var notePosition= POSITION_NOT_SET

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
        val adapterCourses = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCourses.adapter=adapterCourses

        notePosition = arguments?.let {
            NoteFragmentArgs.fromBundle(it).position}!!
        //SHow the currently selected note
        if (notePosition != POSITION_NOT_SET)
            displayNote()
        //Adding new notes
        else{
            DataManager.notes.add(NoteInfo())
            notePosition= DataManager.notes.lastIndex
        }
    }
    private fun displayNote() {
        val note= DataManager.notes[notePosition]
        binding.textNoteTitle.setText(note.title)
        binding.editTextTextMultiLine.setText(note.text)

        val coursePosition= DataManager.courses.values.indexOf(note.course)
        binding.spinnerCourses.setSelection(coursePosition)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_settings ->true
            R.id.action_next ->{
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun moveNext() {
        ++notePosition
        displayNote()
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note= DataManager.notes[notePosition]
        note.title=binding.textNoteTitle.text.toString()
        note.text=binding.editTextTextMultiLine.text.toString()
        note.course=binding.spinnerCourses.selectedItem as CourseInfo
    }
}