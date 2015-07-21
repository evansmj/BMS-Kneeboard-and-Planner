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
    private int maxEngAlt;
    private int range_km;
    private String guidance;
    private String fireControl;
    private String threatType;

    public ThreatObject(String name, int maxTOF, int weight, int range_km, int minEngRange, int minEngAlt,
            int maxEngAlt, String guidance, String fireControl, String threatType)
    {
        this.name = name;
        this.weight = weight;
        this.maxTOF = maxTOF;
        this.minEngRange = minEngRange;
        this.minEngAlt = minEngAlt;
        this.guidance = guidance;
        this.fireControl = fireControl;
        this.range_km = range_km;
        this.maxEngAlt = maxEngAlt;
        this.threatType = threatType;
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

    public int getMaxEngAlt()
    {
        return maxEngAlt;
    }

    public int getRange_km()
    {
        return range_km;
    }

    public String getThreatType()
    {
        return threatType;
    }
}
