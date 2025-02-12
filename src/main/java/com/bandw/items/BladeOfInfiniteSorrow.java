package com.bandw.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

/*public static final ToolMaterial GUIDITE_TOOL_MATERIAL = new ToolMaterial(
    BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22,GuiditeArmorMaterial.REPAIRS_GUIDITE_ARMOR
);*/

public class BladeOfInfiniteSorrow extends SwordItem {
    public BladeOfInfiniteSorrow(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
};