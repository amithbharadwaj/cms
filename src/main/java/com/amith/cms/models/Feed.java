
package com.amith.cms.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_at",
    "entry_id",
    "field1",
    "field2",
    "field3",
    "field4",
    "field5",
    "field6",
    "field7",
    "field8"
})
public class Feed {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("entry_id")
    private Integer entryId;
    @JsonProperty("field1")
    private String field1;
    @JsonProperty("field2")
    private String field2;
    @JsonProperty("field3")
    private String field3;
    @JsonProperty("field4")
    private Object field4;
    @JsonProperty("field5")
    private Object field5;
    @JsonProperty("field6")
    private Object field6;
    @JsonProperty("field7")
    private Object field7;
    @JsonProperty("field8")
    private Object field8;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("entry_id")
    public Integer getEntryId() {
        return entryId;
    }

    @JsonProperty("entry_id")
    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    @JsonProperty("field1")
    public String getField1() {
        return field1;
    }

    @JsonProperty("field1")
    public void setField1(String field1) {
        this.field1 = field1;
    }

    @JsonProperty("field2")
    public String getField2() {
        return field2;
    }

    @JsonProperty("field2")
    public void setField2(String field2) {
        this.field2 = field2;
    }

    @JsonProperty("field3")
    public String getField3() {
        return field3;
    }

    @JsonProperty("field3")
    public void setField3(String field3) {
        this.field3 = field3;
    }

    @JsonProperty("field4")
    public Object getField4() {
        return field4;
    }

    @JsonProperty("field4")
    public void setField4(Object field4) {
        this.field4 = field4;
    }

    @JsonProperty("field5")
    public Object getField5() {
        return field5;
    }

    @JsonProperty("field5")
    public void setField5(Object field5) {
        this.field5 = field5;
    }

    @JsonProperty("field6")
    public Object getField6() {
        return field6;
    }

    @JsonProperty("field6")
    public void setField6(Object field6) {
        this.field6 = field6;
    }

    @JsonProperty("field7")
    public Object getField7() {
        return field7;
    }

    @JsonProperty("field7")
    public void setField7(Object field7) {
        this.field7 = field7;
    }

    @JsonProperty("field8")
    public Object getField8() {
        return field8;
    }

    @JsonProperty("field8")
    public void setField8(Object field8) {
        this.field8 = field8;
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
