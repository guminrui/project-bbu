package com.bbu.util;

import java.util.Collection;

public class Utils {
    public Utils(){}
    public static boolean isListNull(Collection collection){
        return collection==null|| collection.size()==0;

    }
}
