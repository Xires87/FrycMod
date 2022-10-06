# FrycMod
This mod adds everything from my other mods + 3 new armors, new ore, scrolls and new curse enchantment 
-----------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------
How to block recipes when Frycmod (or Hammers and Smithing) is installed:

All you have to do is adding 1 - 4 json files to your mod (2 - 8 files if you want to block recipes for both Frycmod and Hammers and Smithing)
-------------
File name: 

Files must be named: "needs_N_table" ("needs_N_smithing_table" for Hammers and Smithing), where N is: "copper" or "iron" or "golden" or "diamond".

For example if file is named "needs_copper_table" ("needs_copper_smithing_table" for Hammers and Smithing), all items recipes inside this file will be blocked if you don't stand near Copper Smithing Table (or better smithing table)

-------------
File content: 
```json
{
  "replace": false,
  "values": [
    "your_mod_id:item_you_want_to_block",
    "your_mod_id:another_item_you_want_to_block"
  ]
}
```
 You can also block vanilla recipes if you want (needs_diamond_table.json from Frycmod):
 ```json
 {
  "replace": false,
  "values": [
    "frycmod:diamond_hammer",
    "minecraft:diamond_pickaxe",
    "minecraft:diamond_axe",
    "minecraft:diamond_shovel",
    "minecraft:diamond_hoe",
    "minecraft:diamond_sword",
    "minecraft:diamond_helmet",
    "minecraft:diamond_chestplate",
    "minecraft:diamond_leggings",
    "minecraft:diamond_boots",
    "minecraft:enchanting_table"
  ]
}
```

Where to put these files: 

Path: resources/data/minecraft/tags/items/

 

Note:

Hammers and Smithing mod uses the same recipe blocking mechanic ,but uses different files.

Frycmod uses "needs_N_table.json" , Hammers and Smithing uses "needs_N_smithing_table.json"

You can add files for both Frycmod and Hammers and Smithing if you want.

These files won't do anything unless Frycmod (or Hammers and Smithing) is installed.

You can even block recipes from other mods, but things may break if these "other mods" aren't installed.
