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
    private int weaponDrag;
    private int weaponWeight;
    private String weaponName;

    public WeaponUseList()
    {
        this.useList = new ArrayList<String>();
        this.weaponName = "";
        this.weaponDrag = 0;
        this.weaponWeight = 0;
    }

    public void addUse(String use)
    {
        useList.add(use);
    }

    public String getWeaponName()
    {
        return this.weaponName;
    }

    public int getWeaponDrag()
    {
        return this.weaponDrag;
    }

    public int getWeaponWeight()
    {
        return this.weaponWeight;
    }

    public String[] getUses()
    {
        return this.useList.toArray(new String[useList.size()]);
    }

    public void setWeaponName(String name)
    {
        this.weaponName = name;
    }

    public void setWeaponDrag(int weaponDrag)
    {
        this.weaponDrag = weaponDrag;
    }

    public void setWeaponWeight(int weaponWeight)
    {
        this.weaponWeight = weaponWeight;
    }

    public int size()
    {
        return useList.size();
    }

}
