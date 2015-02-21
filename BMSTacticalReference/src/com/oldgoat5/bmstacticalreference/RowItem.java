package com.oldgoat5.bmstacticalreference;

public class RowItem
{
    private int id;
    private String weaponName;
    
    public RowItem(int id, String weaponName)
    {
        this.id = id;
        this.weaponName = weaponName;
    }
    
    public String getWeaponName()
    {
        return this.weaponName;
    }
}
