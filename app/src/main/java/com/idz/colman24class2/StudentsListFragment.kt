package com.idz.colman24class2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idz.colman24class2.adapter.StudentsRecyclerAdapter
import com.idz.colman24class2.databinding.FragmentStudentsListBinding
import com.idz.colman24class2.model.Model
import com.idz.colman24class2.model.Student

class StudentsListFragment : Fragment() {

    private var adapter: StudentsRecyclerAdapter? = null
    private var binding: FragmentStudentsListBinding? = null
    private var viewModel: StudentsListViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[StudentsListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStudentsListBinding.inflate(inflater, container, false)

        // TODO: Set DB ✅
        // TODO: Refactor Model to support local db ✅
        // TODO: Refactor Fragments to work with live data ✅
        // TODO: Add progress indicator for better UX
        // TODO: Migrate to ViewBinding


        binding?.recyclerView?.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.layoutManager = layoutManager

        adapter = StudentsRecyclerAdapter(viewModel?.students)

        adapter?.listener = object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d("TAG", "On click Activity listener on position $position")
            }

            override fun onItemClick(student: Student?) {
                Log.d("TAG", "On student clicked name: ${student?.name}")

//                Navigation.findNavController(view).navigate(R.id.action_studentsListFragment_to_blueFragment)

                student?.let {
                    val action = StudentsListFragmentDirections.actionStudentsListFragmentToBlueFragment(it.name)
                    binding?.root?.let {
                        Navigation.findNavController(it).navigate(action)
                    }
                }
            }
        }

        binding?.recyclerView?.adapter = adapter

        val action = StudentsListFragmentDirections.actionGlobalAddStudentFragment()
        binding?.addStudentButton?.setOnClickListener(Navigation.createNavigateOnClickListener(action))

        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        getAllStudents()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun getAllStudents() {

        binding?.progressBar?.visibility = View.VISIBLE

        Model.shared.getAllStudents {
            viewModel?.set(students = it)
            adapter?.set(it)
            adapter?.notifyDataSetChanged()

            binding?.progressBar?.visibility = View.GONE
        }
    }
}