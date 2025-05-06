package com.normalorg.bandw.util;

import com.normalorg.bandw.Defiance;
import java.util.Map;
import java.util.HashMap;

public class CharterContractManager {
    public boolean isInitialized=false;
    private Map<Integer,String> contracts=new HashMap<>();
    public CharterContractManager(boolean isCharterLoaded){
        Defiance.LOGGER.info(isCharterLoaded && this.initialize() ? "Charter is loaded, setting up Contract hooks..." : "Charter is not loaded, Contract severing functionality not available.");
    };
    public boolean initialize(){
        if (!isInitialized){
            isInitialized=true;
            Defiance.LOGGER.info("ChartMan: initialize()");
        };
        return true;
    };
};