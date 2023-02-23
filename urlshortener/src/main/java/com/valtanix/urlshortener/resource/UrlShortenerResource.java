package com.valtanix.urlshortener.resource;

import com.valtanix.urlshortener.requests.UrlServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.valtanix.urlshortener.services.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class UrlShortenerResource {

    @Autowired
    private UrlService urlService;

    @PostMapping("/example")
    public ResponseEntity longUrl(@RequestBody UrlServiceRequest urlServicesRequest) {
        String longURl=urlServicesRequest.getLongUrl();
        String value=urlService.shortenUrl(longURl);
        return ResponseEntity.ok(value);
    }

    @PostMapping("/example1")
        public ResponseEntity getOriginal(@RequestBody UrlServiceRequest urlServicesRequest) {
        String original=urlService.getOriginalUrl(urlServicesRequest.getShortenedUrl());
        return ResponseEntity.ok(original);
    }
}
