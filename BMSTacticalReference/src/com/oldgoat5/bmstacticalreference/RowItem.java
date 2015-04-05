package com.oldgoat5.bmstacticalreference;

public class RowItem
{
    private String id;
    private String weaponName;
    private String weight;
    private String drag;
    private String damage;
    private String guidance;
    private String range;
    private String blast;
    private String info;
    
    public RowItem(String id, String weaponName, String weight, String drag,
            String damage, String guidance, String range, String blast, 
            String info)
    {
        this.id = id;
        this.weaponName = weaponName;
        this.weight = weight;
        this.drag = drag;
        this.damage = damage;
        this.guidance = guidance;
        this.range = range;
        this.blast = blast;
        this.info = info;
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
    
    public String getDrag()
    {
        return this.drag;
    }
    
    public String getDamage()
    {
        return this.damage;
    }
    
    public String getGuidace()
    {
        return this.guidance;
    }
    
    public String getRange()
    {
        return this.range;
    }
    
    public String getBlast()
    {
        return this.blast;
    }
    
    public String getInfo()
    {
        return this.info;
    }
}
