package com.bandw.util;

import com.bandw.Main;
import java.util.Map;
import java.util.HashMap;

public class CharterContractManager {
    public CharterContractManager(boolean isCharterLoaded){
        Main.LOGGER.info(isCharterLoaded ? "Charter is loaded, setting up Contract hooks..." : "Charter is not loaded, Contract severing functionality not available.");
    };
};