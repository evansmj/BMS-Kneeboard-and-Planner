package com.oldgoat5.bmstacticalreference.loadout;

/*****************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Contains a class for containing ordinance objects from the 
 * BMSLoadDb ordinance table.
 * 
 * @author Michael Evans
 *****************************************************************/
public class OrdnanceObject
{
    private String id;
    private String name;
    private String weight;
    private String drag;
    private String damage;
    private String guidance;
    private String range;
    private String blast;
    private String info;
    
    /*****************************************************************
     * This class contains an ordinance object.
     * 
     * @param id
     * @param name
     * @param weight
     * @param drag
     * @param damage
     * @param guidance
     * @param range
     * @param blast
     * @param info
     *****************************************************************/
    public OrdnanceObject(String id, String name, String weight, String drag,
            String damage, String guidance, String range, String blast, String info)
    {
        this.id = id;
        this.name = name;
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
    
    public String getName()
    {
        return this.name;
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
    
    public String getGuidance()
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
