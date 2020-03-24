
package com.amith.cms.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "feed_details")
@SequenceGenerator(name="feedSeq", initialValue=100, allocationSize=1)
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="feedSeq")
    @JsonProperty("id")
    private Integer id;
	
    @JsonProperty("created_at")
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    
    @JsonProperty("channel_id")
    @Column(name = "channel_id", nullable = false)
    private int channelId;
    
    @JsonProperty("field1")
    private String field1;
    @JsonProperty("field2")
    private String field2;
    @JsonProperty("field3")
    private String field3;
    @JsonProperty("field4")
    private String field4;
    @JsonProperty("field5")
    private String field5;
    @JsonProperty("field6")
    private String field6;
    @JsonProperty("field7")
    private String field7;
    @JsonProperty("field8")
    private String field8;
    
	@JsonProperty("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    
    @JsonProperty("channel_id")
    public int getChannelId() {
		return channelId;
	}
    
    @JsonProperty("channel_id")
	public void setChannelId(int channelId) {
		this.channelId = channelId;
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
    public String getField4() {
        return field4;
    }

    @JsonProperty("field4")
    public void setField4(String field4) {
        this.field4 = field4;
    }

    @JsonProperty("field5")
    public String getField5() {
        return field5;
    }

    @JsonProperty("field5")
    public void setField5(String field5) {
        this.field5 = field5;
    }

    @JsonProperty("field6")
    public String getField6() {
        return field6;
    }

    @JsonProperty("field6")
    public void setField6(String field6) {
        this.field6 = field6;
    }

    @JsonProperty("field7")
    public String getField7() {
        return field7;
    }

    @JsonProperty("field7")
    public void setField7(String field7) {
        this.field7 = field7;
    }

    @JsonProperty("field8")
    public String getField8() {
        return field8;
    }

    @JsonProperty("field8")
    public void setField8(String field8) {
        this.field8 = field8;
    }

}
