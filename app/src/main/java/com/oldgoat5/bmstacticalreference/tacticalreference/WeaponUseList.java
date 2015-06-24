package com.oldgoat5.bmstacticalreference.tacticalreference;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * This list has a name property with a list of attributes.
 *
 * @author Michael Evans
 * @since 6/24/2015
 *********************************************************************/
public class WeaponUseList extends ArrayList
{
    private ArrayList<String> useList;
    private String weaponName;

    public void addUse(String use)
    {
        useList.add(use);
    }

    public String getName()
    {
        return weaponName;
    }

    public ArrayList<String> getUses()
    {
        return useList;
    }

    public void setWeaponName(String name)
    {
        weaponName = name;
    }

}
