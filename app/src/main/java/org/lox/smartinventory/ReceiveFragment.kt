package org.lox.smartinventory


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.floatingActionButton.setOnClickListener {
            binding.layoutInputItem.visibility = View.GONE
            binding.listResultReceive.visibility = View.VISIBLE
            binding.textStatusSearch.visibility = View.VISIBLE
            binding.floatingActionButton.hideKeyboard()

            val input = "${binding.inputTextItemText!!.editText!!.text} \n ${binding.inputTextItemDes!!.editText!!.text}"
            binding.textStatusSearch.text = input

            val inv = Inventory("dsf", "Sdffs", "10", "20")
            inv.initList()
            val adapterInventory = AdapterReceive(context!!.applicationContext, inv.listItem)
            binding.listResultReceive.layoutManager = LinearLayoutManager(context!!)
            binding.listResultReceive.adapter = adapterInventory
        }

        binding.textStatusSearch.setOnClickListener {
            binding.layoutInputItem.visibility = View.VISIBLE
            binding.listResultReceive.visibility = View.GONE
            binding.textStatusSearch.visibility = View.GONE
        }
        return binding.root
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
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
