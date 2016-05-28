package com.oldgoat5.bmstacticalreference.tools.intdefs;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 3/11/2016
 *********************************************************************/
public class IntDefs
{
    @IntDef({SAVED_OK, INVALID_INPUT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataCardIntDefs {}

    public static final int SAVED_OK = 0;
    public static final int INVALID_INPUT = 1;

}
