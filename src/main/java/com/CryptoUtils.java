package com;

import java.util.EnumMap;
import java.util.HashMap;

public class CryptoUtils {

    public static final HashMap<String, Double> cryptoPriceMap = new HashMap<>();

    public static void initializeCryptoPrices(){
        cryptoPriceMap.put("BITCOIN", 8745575.35);
        cryptoPriceMap.put("ETHEREUM", 673587.31);
        cryptoPriceMap.put("SOLANA", 29897.33);
        cryptoPriceMap.put("TETHER", 202.92);
        cryptoPriceMap.put("CARDANO", 277.27);

    }

    public static Double getPrice(String type){
       return cryptoPriceMap.get(type);
    }

    public static boolean isEmpty(String s){
        return s == null || s.length() == 0;
    }
}

