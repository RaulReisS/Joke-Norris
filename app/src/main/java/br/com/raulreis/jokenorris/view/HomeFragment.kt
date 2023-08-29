package br.com.raulreis.jokenorris.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.raulreis.jokenorris.R
import br.com.raulreis.jokenorris.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMain = view.findViewById<RecyclerView>(R.id.rvMain)
        rvMain.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GroupieAdapter()
        rvMain.adapter = adapter

        adapter.add(CategoryItem(Category("Categoria 1", 0xFF2df55c)))
        adapter.add(CategoryItem(Category("Categoria 2", 0xFF00deb8)))
        adapter.add(CategoryItem(Category("Categoria 3", 0xFF00beff)))
        adapter.add(CategoryItem(Category("Categoria 4", 0xFF0094ff)))
        adapter.add(CategoryItem(Category("Categoria 5", 0xFF2458ed)))

        adapter.notifyDataSetChanged()
    }
}