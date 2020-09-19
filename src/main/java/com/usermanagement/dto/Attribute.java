package com.usermanagement.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "value"
})
public class Attribute {

    /**
     * Attribute key.
     *
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Attribute key.")
    private String type;
    /**
     * Attribute value.
     *
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Attribute value.")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Attribute key.
     *
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Attribute key.
     *
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Attribute value.
     *
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Attribute value.
     *
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}