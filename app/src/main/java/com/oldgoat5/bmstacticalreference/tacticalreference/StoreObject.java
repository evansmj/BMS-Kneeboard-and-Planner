package com.oldgoat5.bmstacticalreference.tacticalreference;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 7/15/2015
 *********************************************************************/
public class StoreObject
{
    private String name;
    private int weight;
    private int drag;
    private String description;

    public StoreObject(String name, int weight, int drag)
    {
        this.name = name;
        this.weight = weight;
        this.drag = drag;
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
}
