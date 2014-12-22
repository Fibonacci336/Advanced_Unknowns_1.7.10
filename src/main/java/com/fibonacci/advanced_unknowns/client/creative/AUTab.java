package com.fibonacci.advanced_unknowns.client.creative;

import com.fibonacci.advanced_unknowns.reference.AU_Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Fibonacci on 12/20/14.
 */
public class AUTab extends CreativeTabs{
    public AUTab(String lable) {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return AU_Items.warphome;
    }

    public boolean hasSearchBar()
    {
        return true;
    }

    public int getSearchbarWidth()
    {
        return 62;
    }
}
