package com.codefans.opensource.util;


import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class JsonUtils {
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
    public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
    static ObjectMapper objectMapper = new ObjectMapper();

    public JsonUtils() {
    }

    public static Map<String, Object> readValue(String jsonStr) throws RuntimeException {
        try {
            return (Map)objectMapper.readValue(jsonStr, HashMap.class);
        } catch (JsonParseException var2) {
            LOG.error(var2.getMessage(), var2);
            throw new RuntimeException(var2);
        } catch (JsonMappingException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (IOException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        }
    }

    public static <T> T readValue(String jsonStr, Class<T> cls) throws RuntimeException {
        try {
            return objectMapper.readValue(jsonStr, cls);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static <T> T readValue(String jsonStr, TypeReference<T> t) throws RuntimeException {
        try {
            return objectMapper.readValue(jsonStr, t);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static <T> T readValue(String jsonStr, JavaType t) throws RuntimeException {
        try {
            return objectMapper.readValue(jsonStr, t);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static <T> T readValue(InputStream jsonStr, Class<T> cls) throws RuntimeException {
        try {
            return objectMapper.readValue(jsonStr, cls);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static <T> T readValue(InputStream josnStr, TypeReference<T> t) throws RuntimeException {
        try {
            return objectMapper.readValue(josnStr, t);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static <T> T readValue(InputStream jsonStr, JavaType t) throws RuntimeException {
        try {
            return objectMapper.readValue(jsonStr, t);
        } catch (JsonParseException var3) {
            LOG.error(var3.getMessage(), var3);
            throw new RuntimeException(var3);
        } catch (JsonMappingException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (IOException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        }
    }

    public static String writeValue(Object entity) throws RuntimeException {
        return writeValue(entity, false);
    }

    public static String writeValue(Object entity, boolean prettyPrint) throws RuntimeException {
        try {
            StringWriter e = new StringWriter();
            JsonGenerator jg = objectMapper.getJsonFactory().createJsonGenerator(e);
            if(prettyPrint) {
                jg.useDefaultPrettyPrinter();
            }

            objectMapper.writeValue(jg, entity);
            return e.toString();
        } catch (JsonGenerationException var4) {
            LOG.error(var4.getMessage(), var4);
            throw new RuntimeException(var4);
        } catch (JsonMappingException var5) {
            LOG.error(var5.getMessage(), var5);
            throw new RuntimeException(var5);
        } catch (IOException var6) {
            LOG.error(var6.getMessage(), var6);
            throw new RuntimeException(var6);
        }
    }

    public static String getJsonStr(int count) {
        return "{\"result\":" + count + " }";
    }

    public static JsonFactory getJsonFactory() {
        return objectMapper.getJsonFactory();
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static void main(String[] args) {
    }

    static {
        objectMapper.disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        objectMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
        objectMapper.enable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
        objectMapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
        objectMapper.setDateFormat(new SimpleDateFormat(DATEFORMAT));
    }
}
