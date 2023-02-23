package com.valtanix.urlshortener.services;


public interface UrlService {

    String shortenUrl(String url);
    String getOriginalUrl(String url);
}
