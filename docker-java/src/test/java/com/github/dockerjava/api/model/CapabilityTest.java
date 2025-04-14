package com.github.dockerjava.api.model;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.dockerjava.test.serdes.JSONTestHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapabilityTest {

    @Test
    public void serializeCapability() throws Exception {
        String json = JSONTestHelper.getMapper().writeValueAsString(Capability.ALL);
        assertEquals("\"CAP_ALL\"", json);
    }

    @Test
    public void deserializeCapability() throws Exception {
        Capability capability = JSONTestHelper.getMapper().readValue("\"CAP_ALL\"", Capability.class);
        assertEquals(Capability.ALL, capability);
    }

    @Test(expected = JsonMappingException.class)
    public void deserializeInvalidCapability() throws Exception {
        JSONTestHelper.getMapper().readValue("\"nonsense\"", Capability.class);
    }
}
