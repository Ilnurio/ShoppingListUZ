package com.example.shoppinglistuz.data

import com.example.shoppinglistuz.domain.ShopItem
import com.example.shoppinglistuz.domain.ShopListRepository
/*Data слой отвечает за работу с данными
Он предоствляет конкретную реализацию репозитория.
Data слой зависит от domain слоя. При это Domain слой ничего не знает о data слое.
*/
object ShopListRepositoryImpl: ShopListRepository {
    // создаем изменяемый лист для списка покупок
    private val shopList = mutableListOf<ShopItem>()
    //создаем переменную ID для хранения ID элементов покупок
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun getShopList(): List<ShopItem> {
        //возвращаем копию этого листа, а не сам лист, так надо с точки зрения архитектуры
        return shopList.toList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        //находим элемент списка по ID и возвращаем его
        //через Элвиса кидаем Exception, если будет null
        return shopList.find { it.id == shopItemId } ?:
            throw RuntimeException("Элемент $shopItemId не найден")
    }

    override fun editShopItem(shopItem: ShopItem) {
        //нужно удалить старый объект и положить новый отредактированный
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }
}