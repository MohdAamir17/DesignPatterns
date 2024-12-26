package com.design.patterns.CreationalDesignPatterns.SingletonDesignPatterns.service;


import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class CacheManager {

    // Singleton instance
    private static CacheManager instance;

    // Cache storage (key-value pairs)
    private Map<String, Object> cache;

    // Private constructor for Singleton
    private CacheManager() {
        cache = new ConcurrentHashMap<>();
    }

    // Thread-safe Singleton instance retrieval
    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    // Add to cache
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    // Retrieve from cache
    public Object get(String key) {
        return cache.get(key);
    }

    // Remove from cache
    public void remove(String key) {
        cache.remove(key);
    }

    // Clear all cache
    public void clearCache() {
        cache.clear();
    }
}

