package com.usermanagement.utility;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class ConnectorUtil {

	private ConnectorUtil() {
		throw new IllegalStateException("Utility class");
	}

	private static final Logger log = LogManager.getLogger(ConnectorUtil.class.getName());

	@SuppressWarnings("unchecked")
    public static Map<String, Object> postA (String url, Map<String, Object> request) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(url);
        Map<String, Object> response = new HashMap<>();
        try {
            ResponseEntity responseEntity =  restTemplate.postForEntity(uri, request, Map.class);
            response = (Map<String, Object>) responseEntity.getBody();
        } catch (Exception e) {
            log.error(e);
        }
        return response;
    }

	public void postB (String url, Map<String, Object> param){
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			log.error(e);
		}
		restTemplate.postForEntity(uri, param, String.class);
	}

	@SuppressWarnings({ "rawtypes" })
	public static Map getC (String url, Map<String, Object> param){
		RestTemplate restTemplate = new RestTemplate();
	    Map response = null;
		try {
			response = new HashMap<String, Object>();
			response = restTemplate.getForObject(url,Map.class);
		} catch (Exception e) {
			log.error(e);
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static Map postC (String url, Map<String, Object> param) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
	    Map response = new HashMap<>();
		try {
			response = restTemplate.postForObject(url, param, Map.class);
		} catch (Exception e) {
			log.error(e);
		}
		return response;
	}
}
