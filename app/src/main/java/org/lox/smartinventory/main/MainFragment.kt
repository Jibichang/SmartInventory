package org.lox.smartinventory.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.lox.smartinventory.Inventory
import org.lox.smartinventory.R
import org.lox.smartinventory.databinding.FragmentMainBinding
import org.lox.smartinventory.service.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private var mAPIService = APIUtils.apiService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding :FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container, false)

        val inv : Inventory =
            Inventory("dsf", "Sdffs", "10", "20")
        inv.initList()
        binding.inventory  = inv

        binding.textUsername.setOnClickListener {
            v: View? -> v?.findNavController()!!.navigate(MainFragmentDirections.actionMainFragmentToProfileFragment())
            Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_profileFragment)
        }

        val adapterReceive = ArrayAdapter.createFromResource(context,
            R.array.org_list, android.R.layout.simple_spinner_item)
        adapterReceive.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOrg.adapter = adapterReceive

        val adapterInventory = AdapterInventory(
            context!!.applicationContext,
            inv.listItem
        )
        binding.recycleInv.layoutManager = LinearLayoutManager(context!!)
        binding.recycleInv.adapter = adapterInventory

        return binding.root
    }

    @SuppressLint("ShowToast")
    fun service() {
        mAPIService.texttest.enqueue(object : Callback<String> {

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                if (response!!.isSuccessful){
                    Toast.makeText(context, response.body().toString(), Toast.LENGTH_SHORT)
                    Log.d("servicemAPIService", "ok")
                } else {
                    Log.d("servicemAPIService", "ok ${response.code()}")
                }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Toast.makeText(context, t!!.message, Toast.LENGTH_SHORT)
//                Log.d("servicemAPIService", t!!.message)
            }

        })
    }

}
