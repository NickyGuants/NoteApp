package com.nicky.noteapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicky.noteapp.databinding.FragmentNoteListBinding


class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.floatingActionButton2.setOnClickListener{
            findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteFragment(
                POSITION_NOT_SET))

    }
        recyclerView =binding.listItems
        //set the layout manager of the recyclerview
        recyclerView.layoutManager=LinearLayoutManager(context)
        //connect the item view to the adapter
        binding.listItems.adapter= NoteListRecyclerAdapter(context, DataManager.notes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}