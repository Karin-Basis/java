/*
* Copyright 2014 Basis Technology Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.basistech.rosette.apimodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.basistech.rosette.apimodel.jackson.ApiModelMixinModule;

public class PolymorphicRequestTest extends Assert {
    private ObjectMapper mapper;

    @Before
    public void init() {
        mapper = ApiModelMixinModule.setupObjectMapper(new ObjectMapper());
    }

    @Test
    public void testRequestTypes() throws Exception {
        String json = "{\"content\": \"what is my type\", \"type\": \"DocumentRequest\"}";
        Request request = mapper.readValue(json, Request.class);
        assertTrue(request instanceof DocumentRequest);

        String serialized = mapper.writeValueAsString(request);
        assertTrue(serialized.contains("\"DocumentRequest\""));

        json = "{\"name1\": {\"text\": \"Joe\"}, \"name2\": {\"text\": \"Geo\"}, \"type\": \"NameSimilarityRequest\"}";
        request = mapper.readValue(json, Request.class);
        assertTrue(request instanceof NameSimilarityRequest);

        json = "{\"name\": \"Joe\", \"targetLanguage\": \"ara\", \"type\": \"NameTranslationRequest\"}";
        request = mapper.readValue(json, Request.class);
        assertTrue(request instanceof NameTranslationRequest);

    }
}