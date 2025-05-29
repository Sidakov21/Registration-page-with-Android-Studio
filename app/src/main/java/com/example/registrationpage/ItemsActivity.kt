package com.example.registrationpage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "img_1", "Смартфон", "Флагман с OLED-экраном", "В наличии", 79900))
        items.add(Item(2, "img", "Ноутбук", "Игровой ноутбук 16 ГБ ОЗУ", "Последний экземпляр", 64900))
        items.add(Item(3, "img_2", "Наушники", "Беспроводные с шумоподавлением", "Акция -20%", 12900))
        items.add(Item(4, "img_3", "Умные часы", "С отслеживанием пульса и сна", "Доставка завтра", 19900))
        items.add(Item(5, "img_4", "Телевизор", "4K UHD с HDR", "Рассрочка 0%", 89900))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}