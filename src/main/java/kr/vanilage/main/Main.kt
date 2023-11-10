package kr.vanilage.main

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hello, World!")
        loadConfig()
    }

    private fun loadConfig() {
        this.saveDefaultConfig()
        this.reloadConfig()

        addShapedRecipe()
        addShapelessRecipe()
    }

    private fun addShapedRecipe() {
        if (config.getConfigurationSection("shaped") == null) return
        val shaped = config.getConfigurationSection("shaped")!!

        for (i in shaped.getKeys(false)) {
            val resultType = Material.getMaterial(config.getString("shaped.$i.result.type")!!)!!
            val resultAmount = config.getInt("shaped.$i.result.amount")
            val result = generateItemStack(resultType, resultAmount)
            val shape = config.getList("shaped.$i.shape")!!
            val recipe = ShapedRecipe(NamespacedKey(this, i), result)

            if (shape.size == 1) recipe.shape(shape[0].toString())
            else if (shape.size == 2) recipe.shape(shape[0].toString(), shape[1].toString())
            else if (shape.size == 3) recipe.shape(shape[0].toString(), shape[1].toString(), shape[2].toString())

            for (j in config.getConfigurationSection("shaped.$i.ingredient")!!.getKeys(false)) {
                recipe.setIngredient(j.first(), Material.getMaterial(config.getString("shaped.$i.ingredient.$j")!!)!!)
            }

            Bukkit.addRecipe(recipe)
        }
    }

    private fun addShapelessRecipe() {
        if (config.getConfigurationSection("shapeless") == null) return
        val shapeless = config.getConfigurationSection("shapeless")!!

        for (i in shapeless.getKeys(false)) {
            val resultType = Material.getMaterial(config.getString("shapeless.$i.result.type")!!)!!
            val resultAmount = config.getInt("shapeless.$i.result.amount")
            val result = generateItemStack(resultType, resultAmount)
            val recipe = ShapelessRecipe(NamespacedKey(this, i), result)

            for (j in config.getList("shapeless.$i.ingredient")!!) {
                recipe.addIngredient(Material.getMaterial(j.toString())!!)
            }

            Bukkit.addRecipe(recipe)
        }
    }
}