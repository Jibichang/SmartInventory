package org.lox.smartinventory


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import org.lox.smartinventory.databinding.FragmentProfileBinding

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    val SIGNOUT_KEY = "confirm"
    lateinit var binding :FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.buttonSignout.setOnClickListener {
            initSignout(binding.inputConfirmSignout.text.toString())
        }

        binding.buttonCancelSignout.setOnClickListener {
            v: View? ->  v?.findNavController()!!.navigate(ProfileFragmentDirections.actionProfileFragmentToMainFragment())
            Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_mainFragment)

            v.hideKeyboard()
        }
        return binding.root
    }

    private fun initSignout(text :String){
        if (text.equals(SIGNOUT_KEY)){
            binding.textWrongType.text = ""
            Toast.makeText(context, getString(R.string.signout), Toast.LENGTH_SHORT).show()
        }else {
            binding.textWrongType.text = getString(R.string.text_confirm)
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


}
