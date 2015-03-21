package com.oldgoat5.bmstacticalreference;

/*****************************************************************
 * Contains a class for containing ordinance objects from the 
 * BMSLoadDb ordinance table.
 * 
 * @author Michael Evans
 * 
 *****************************************************************/
public class OrdinanceObject
{
    private int id;
    private String name;
    private int weight;
    private int drag;
    private String damage;
    private String guidance;
    private int range;
    private int blast;
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
    public OrdinanceObject(int id, String name, int weight, int drag, 
            String damage, String guidance, int range, int blast, String info)
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
    
    public int getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    
    public int getDrag()
    {
        return this.drag;
    }
    
    public String getDamage()
    {
        return this.damage;
    }
    
    public String getGuidance()
    {
        return this.damage;
    }
    
    public int getRange()
    {
        return this.range;
    }
    
    public int getBlast()
    {
        return this.blast;
    }
    
    public String getInfo()
    {
        return this.info;
    }
}
