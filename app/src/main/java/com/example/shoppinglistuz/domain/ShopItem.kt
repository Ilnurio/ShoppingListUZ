package com.example.shoppinglistuz.domain

data class ShopItem(

    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {

/* ID = -1 - это жестко закодированное магиечкое число,
плохая практика, так как никто не поймет что это за число.
Это начальное ID для каждого элемента в списке покупок.
Нужно создать константу:
 */

    companion object {
        const val UNDEFINED_ID = -1
    }
}

