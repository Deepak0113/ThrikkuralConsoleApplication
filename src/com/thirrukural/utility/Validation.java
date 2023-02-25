package com.thirrukural.utility;

public class Validation {
    static Boolean validateOption(String option){
        if(option.length()>1)
            return false;
        return true;
    }
}
