package org.lox.smartinventory


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.lox.smartinventory.databinding.FragmentReceiveBinding

class ReceiveFragment : Fragment() {
    private lateinit var binding :FragmentReceiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_receive, container, false)

        initSpinnerType()

        return binding.root
    }

    private fun initSpinnerType(){
        val adapterReceive = ArrayAdapter.createFromResource(context,
            R.array.receive_list, android.R.layout.simple_spinner_item)
        adapterReceive.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerType.adapter = adapterReceive

        binding.spinnerType.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) { }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getValues(view)
            }
        }
    }

    fun getValues(view: View?) {
        Toast.makeText(context, "Spinner ${binding.spinnerType.selectedItem}", Toast.LENGTH_LONG).show()

    }


}
