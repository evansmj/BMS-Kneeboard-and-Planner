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
public class WeaponUseList
{
    private ArrayList<String> useList;
    private String weaponName;

    public WeaponUseList()
    {
        this.useList = new ArrayList<String>();
        this.weaponName = "";
    }

    public void addUse(String use)
    {
        useList.add(use);
    }

    public String getWeaponName()
    {
        return this.weaponName;
    }

    public String[] getUses()
    {
        return this.useList.toArray(new String[useList.size()]);
    }

    public void setWeaponName(String name)
    {
        this.weaponName = name;
    }

    public int size()
    {
        return useList.size();
    }

}
