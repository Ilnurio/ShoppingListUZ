package com.example.shoppinglistuz.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem>{
       return shopListRepository.getShopList()
    }
}