package com.oldgoat5.bmstacticalreference.tacticalreference;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 7/15/2015
 *********************************************************************/
public class ThreatObject
{
    private String name;
    private int weight;
    private int maxTOF;
    private int minEngRange;
    private int minEngAlt;
    private String guidance;
    private String fireControl;

    public ThreatObject(String name, int weight, int maxTOF, int minEngRange, int minEngAlt,
            String guidance, String fireControl)
    {
        this.name = name;
        this.weight = weight;
        this.maxTOF = maxTOF;
        this.minEngRange = minEngRange;
        this.minEngAlt = minEngAlt;
        this.guidance = guidance;
        this.fireControl = fireControl;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    public String getFireControl()
    {
        return fireControl;
    }

    public String getGuidance()
    {
        return guidance;
    }

    public int getMinEngAlt()
    {
        return minEngAlt;
    }

    public int getMinEngRange()
    {
        return minEngRange;
    }

    public int getMaxTOF()
    {
        return maxTOF;
    }
}
