package com.bandw.util;

import com.bandw.Main;
import java.util.Map;
import java.util.HashMap;

public class CharterContractManager {
    public CharterContractManager(boolean isCharterLoaded){
        isCharterLoaded ? Main.LOGGER.info("Charter is loaded, setting up Contract hooks...") : Main.LOGGER.info("Charter is not loaded, Contract severing functionality not available.");
    };
};