package org.lox.smartinventory

import kotlin.random.Random

class Inventory (var itemID :String, var itemName :String, var itemStock :String, var predict :String)  {
    lateinit var listItem :MutableList<Inventory>
    var title :String = "Smart Inventory"

    fun initList(){
        listItem = mutableListOf()
        for (x in 0..9){
            val rnd = (0..100).random()
            val rnd2 = (0..100).random()
            val item = Inventory("2202_300166-CS${x+1}", "DetailFragment${x+1}", rnd.toString(), rnd2.toString())
            listItem.add(item)
        }
    }
}