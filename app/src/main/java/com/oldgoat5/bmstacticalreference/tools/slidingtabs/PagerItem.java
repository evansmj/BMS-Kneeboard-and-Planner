package com.oldgoat5.bmstacticalreference.tools.slidingtabs;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * A tab object for sliding tab layout.
 *
 * @author Michael Evans
 * @since 5/27/2015
 *********************************************************************/
public class PagerItem
{
    private String title;
    private int indicatorColor;
    private int dividerColor;

    public PagerItem(String title, int indicatorColor, int dividerColor)
    {
        this.title = title;
        this.indicatorColor = indicatorColor;
        this.dividerColor = dividerColor;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getIndicatorColor()
    {
        return this.indicatorColor;
    }

    public int getDividerColor()
    {
        return this.dividerColor;
    }
}
