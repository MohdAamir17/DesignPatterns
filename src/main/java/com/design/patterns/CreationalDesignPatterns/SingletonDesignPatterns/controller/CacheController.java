package com.design.patterns.CreationalDesignPatterns.SingletonDesignPatterns.controller;


import com.design.patterns.CreationalDesignPatterns.SingletonDesignPatterns.service.CacheManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheManager cacheManager = CacheManager.getInstance();

    @PostMapping("/add")
    public String addToCache(@RequestParam String key, @RequestParam String value) {
        cacheManager.put(key, value);
        return "Data added to cache!";
    }

    @GetMapping("/get")
    public Object getFromCache(@RequestParam String key) {
        Object value = cacheManager.get(key);
        return value != null ? value : "Key not found in cache!";
    }

    @DeleteMapping("/remove")
    public String removeFromCache(@RequestParam String key) {
        cacheManager.remove(key);
        return "Key removed from cache!";
    }

    @DeleteMapping("/clear")
    public String clearCache() {
        cacheManager.clearCache();
        return "Cache cleared!";
    }
}

