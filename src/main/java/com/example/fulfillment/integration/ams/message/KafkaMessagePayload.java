package com.example.fulfillment.integration.ams.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class KafkaMessagePayload {

    @NotNull
    @JsonProperty("revision")
    private Integer revision;

    @JsonCreator
    public KafkaMessagePayload(final Integer revision) {
        this.revision = revision;
    }

    protected KafkaMessagePayload() {
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    //Finish the payload here
}
