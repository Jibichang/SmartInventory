package org.lox.smartinventory

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.lox.smartinventory.databinding.FragmentDetailBinding
import org.lox.smartinventory.databinding.FragmentMainBinding


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false)

        val args = DetailFragmentArgs.fromBundle(arguments!!)
//        Toast.makeText(context, "NumCorrect: ${args.id}", Toast.LENGTH_LONG).show()
        binding.textDetail.text = "${args.id} try"
        return binding.root
    }

}
