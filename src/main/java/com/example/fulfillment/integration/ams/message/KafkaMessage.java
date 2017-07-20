package com.example.fulfillment.integration.ams.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KafkaMessage<P extends KafkaMessagePayload> {

    @NotNull
    @JsonProperty("id")
    private String id;

    @NotEmpty
    @JsonProperty("key")
    private String key;

    @NotNull
    @JsonProperty("time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private ZonedDateTime time;

    @NotEmpty
    @JsonProperty("type")
    private String type;

    @NotEmpty
    @JsonProperty("queue")
    private String queue;

    @JsonProperty("channel")
    private String channel;

    @NotEmpty
    @JsonProperty("tenant")
    private String tenant;

    @NotNull
    @JsonProperty("payloadId")
    private String payloadId;

    @NotEmpty
    @JsonProperty("payload")
    @Valid
    private P payload;

    KafkaMessage() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public P getPayload() {
        return payload;
    }

    public void setPayload(P payload) {
        this.payload = payload;
    }

    public static final class KafkaMessageBuilder<P> {

        private String id;
        private String key;
        private ZonedDateTime time;
        private String type;
        private String queue;
        private String channel;
        private String tenant;
        private String payloadId;
        private P payload;

        private KafkaMessageBuilder() {
        }

        public static KafkaMessageBuilder aKafkaMessage() {
            return new KafkaMessageBuilder();
        }

        public KafkaMessageBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public KafkaMessageBuilder withKey(String key) {
            this.key = key;
            return this;
        }

        public KafkaMessageBuilder withTime(ZonedDateTime time) {
            this.time = time;
            return this;
        }

        public KafkaMessageBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public KafkaMessageBuilder withQueue(String queue) {
            this.queue = queue;
            return this;
        }

        public KafkaMessageBuilder withChannel(String channel) {
            this.channel = channel;
            return this;
        }

        public KafkaMessageBuilder withTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public KafkaMessageBuilder withPayloadId(String payloadId) {
            this.payloadId = payloadId;
            return this;
        }

        public KafkaMessageBuilder withPayload(P payload) {
            this.payload = payload;
            return this;
        }

        public KafkaMessage build() {
            KafkaMessage kafkaMessage = new KafkaMessage();
            kafkaMessage.setId(id);
            kafkaMessage.setKey(key);
            kafkaMessage.setTime(time);
            kafkaMessage.setType(type);
            kafkaMessage.setChannel(channel);
            kafkaMessage.setTenant(tenant);
            kafkaMessage.setPayloadId(payloadId);
            kafkaMessage.setPayload((KafkaMessagePayload) payload);
            kafkaMessage.queue = this.queue;
            return kafkaMessage;
        }
    }
}
