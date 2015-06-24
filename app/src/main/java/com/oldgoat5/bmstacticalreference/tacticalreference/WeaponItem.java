package com.oldgoat5.bmstacticalreference.tacticalreference;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Item used in the weapon database listview.
 *
 * @author Michael Evans
 * @since 6/24/2015
 ********************************************************************/
public class WeaponItem
{
    private String name;
    private String[] uses;

    public WeaponItem(String name, String[] uses)
    {
        this.name = name;
        this.uses = uses;
    }

    public String getName()
    {
        return this.name;
    }

    public String[] getUses()
    {
        return this.uses;
    }
}
