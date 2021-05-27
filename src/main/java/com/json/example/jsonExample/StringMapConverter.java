package com.json.example.jsonExample;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter
@Slf4j
public class StringMapConverter implements AttributeConverter<Map<String, Object>, String> {

        private static ObjectMapper objectMapper;

        static {
                // To avoid instantiating ObjectMapper again and again.
                objectMapper = new ObjectMapper();
        }

        @Override
        public String convertToDatabaseColumn(Map<String, Object> customerInfo) {

                String customerInfoJson = null;
                try {
                        customerInfoJson = objectMapper.writeValueAsString(customerInfo);
                } catch (final JsonProcessingException e) {
                        log.error("JSON writing error", e);
                }

                return customerInfoJson;
        }

        @Override
        public Map<String, Object> convertToEntityAttribute(String customerInfoJSON) {

                Map<String, Object> customerInfo = null;
                try {
                        customerInfo = objectMapper.readValue(customerInfoJSON, Map.class);
                } catch (final IOException e) {
                        log.error("JSON reading error", e);
                }

                return customerInfo;
        }
        }
