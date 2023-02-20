package com.valtanix.urlshortener.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlServiceRequest {
    private String longUrl;
    private String shortenedUrl;
}