package com.oldgoat5.bmstacticalreference.navigation;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 12/25/2015
 *********************************************************************/
public class NavigationChartsTuple<Title, Drawable>
{
    private final Title title;
    private final Drawable drawable;

    public NavigationChartsTuple(Title title, Drawable drawable)
    {
        this.title = title;
        this.drawable = drawable;
    }

    public Title getTitle()
    {
        return this.title;
    }

    public Drawable getDrawable()
    {
        return this.drawable;
    }

    @Override
    public int hashCode()
    {
        return this.title.hashCode() ^ this.drawable.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof NavigationChartsTuple))
        {
            return false;
        }

        NavigationChartsTuple t = (NavigationChartsTuple) o;

        return this.title.equals(t.getTitle()) && this.drawable.equals(t.getDrawable());
    }
}
