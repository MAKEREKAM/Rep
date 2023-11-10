package kr.vanilage.main

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun generateItemStack(type : Material, amount : Int) : ItemStack {
    return ItemStack(type, amount)
}

fun generateItemStack(type : Material, amount: Int, name : String) : ItemStack {
    val itemStack = ItemStack(type, amount)
    val meta = itemStack.itemMeta
    val component = Component.text(name)
    component.decorations().clear()
    meta.displayName(component)
    itemStack.itemMeta = meta
    return itemStack
}