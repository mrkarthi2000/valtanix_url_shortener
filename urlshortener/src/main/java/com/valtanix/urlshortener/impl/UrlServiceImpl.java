package com.valtanix.urlshortener.impl;

import com.valtanix.urlshortener.services.UrlService;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    private static HashMap<String, String> keyMap = new HashMap<>();
    public static final String BASE_URL="http://val.us/";

    @Override
    public String shortenUrl(String longUrl) {
        String key = hash(longUrl);
        keyMap.put(key, longUrl);
        return BASE_URL + key;
    }

    @Override
    public String getOriginalUrl(String shortenUrl){
        String key = shortenUrl.replace(BASE_URL, "");
        return keyMap.get(key);
    }

    private static String hash(String longUrl) {
        String num=longUrl.toUpperCase();
        int hashCode =num.hashCode();
        String key = Integer.toString(hashCode, 36);
        return key;
    }
}
