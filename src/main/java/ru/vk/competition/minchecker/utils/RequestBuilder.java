package ru.vk.competition.minchecker.utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestBuilder {

    public static final String  API_ROOT =  new SystemVariables().apiRoot();
    
    public static Request postRequestBuilder(String url, Object obj, String place) {
        //System.out.println(place + ": url=" + url);
        return new Request.Builder()
                .url(url)
                .post(createRequestBody(obj))
                .build();
    }

    public static Request putRequestBuilder(String url, Object obj, String place) {
        //System.out.println(place + ": url=" + url);
        return new Request.Builder()
                .url(url)
                .put(createRequestBody(obj))
                .build();
    }

    public static Request deleteRequestBuilder(String url, Object obj, String place) {
        //System.out.println(place + ": url=" + url);
        return new Request.Builder()
                .url(url)
                .delete(createRequestBody(obj))
                .build();
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.registerModule(module);
        return mapper;
    }

    private static RequestBody createRequestBody(Object obj) {
        ObjectMapper mapper = getObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(obj);
            //System.out.println("postRequestBuilder: str=" + str);
        }
        catch (Exception e) {
            System.out.println("postRequestBuilder: ERROR");
        }
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(JSON, str);
    }
}
