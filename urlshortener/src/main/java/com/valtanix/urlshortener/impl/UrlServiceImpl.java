package com.valtanix.urlshortener.impl;

import com.valtanix.urlshortener.services.UrlService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    private static HashMap<String, String> keyMap = new HashMap<>();

    @Override
    public String shortenUrl(String longUrl) throws URISyntaxException {
        String key = hash(longUrl);
        keyMap.put(key, longUrl);
        return getDomainFromUrl(longUrl) + key;
    }

    @Override
    public String getOriginalUrl(String shortenUrl) throws URISyntaxException {
        String key = shortenUrl.replace(getDomainFromUrl(shortenUrl), "");
        return keyMap.get(key);
    }

    private String getDomainFromUrl(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String host = uri.getHost();
        return "https://"+host+"/";
    }

    private static String hash(String longUrl) {
        int hashCode = longUrl.hashCode();
        String key = Integer.toString(hashCode, 36);
        return key;
    }
}