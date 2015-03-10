package com.oldgoat5.bmstacticalreference;

public class RowItem
{
    private String id;
    private String weaponName;
    private String weight;
    
    public RowItem(String id, String weaponName, String weight)
    {
        this.id = id;
        this.weaponName = weaponName;
        this.weight = weight;
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public String getWeaponName()
    {
        return this.weaponName;
    }
    
    public String getWeight()
    {
        return this.weight;
    }
    
}
