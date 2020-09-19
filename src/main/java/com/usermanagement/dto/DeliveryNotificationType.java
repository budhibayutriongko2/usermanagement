package com.usermanagement.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Delivery notification
 * <p>
 * A notification of a delivery status of a MSS Message
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "externalId",
        "systemCode",
        "messageStatus",
        "timestamp",
        "recipient",
        "description",
        "answer",
        "attributes"
})
public class DeliveryNotificationType {

    /**
     * Unique identification of message - provided by external system
     * (Required)
     *
     */
    @JsonProperty("externalId")
    @JsonPropertyDescription("Unique identification of message - provided by external system")
    private String externalId;
    /**
     * Unique identification of external system
     * (Required)
     *
     */
    @JsonProperty("systemCode")
    @JsonPropertyDescription("Unique identification of external system")
    private String systemCode;
    /**
     * New status of the Message
     * (Required)
     *
     */
    @JsonProperty("messageStatus")
    @JsonPropertyDescription("New status of the Message")
    private DeliveryNotificationType.MessageStatus messageStatus;
    /**
     * Time when the status change occurred (ISO 8601)
     * (Required)
     *
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Time when the status change occurred (ISO 8601)")
    private String timestamp;
    /**
     * Message recipient (phone number or email address)
     * (Required)
     *
     */
    @JsonProperty("recipient")
    @JsonPropertyDescription("Message recipient (phone number or email address)")
    private String recipient;
    /**
     * Optional description providing more information about the status
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Optional description providing more information about the status")
    private String description;
    /**
     * Answer received for this interactive message. Status = ANSWERED.
     *
     */
    @JsonProperty("answer")
    @JsonPropertyDescription("Answer received for this interactive message. Status = ANSWERED.")
    private String answer;
    /**
     * Map of key/value pairs with additional parameters
     *
     */
    @JsonProperty("attributes")
    @JsonPropertyDescription("Map of key/value pairs with additional parameters")
    private List<Attribute> attributes = null;

    /**
     * Unique identification of message - provided by external system
     * (Required)
     *
     */
    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    /**
     * Unique identification of message - provided by external system
     * (Required)
     *
     */
    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Unique identification of external system
     * (Required)
     *
     */
    @JsonProperty("systemCode")
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * Unique identification of external system
     * (Required)
     *
     */
    @JsonProperty("systemCode")
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    /**
     * New status of the Message
     * (Required)
     *
     */
    @JsonProperty("messageStatus")
    public DeliveryNotificationType.MessageStatus getMessageStatus() {
        return messageStatus;
    }

    /**
     * New status of the Message
     * (Required)
     *
     */
    @JsonProperty("messageStatus")
    public void setMessageStatus(DeliveryNotificationType.MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    /**
     * Time when the status change occurred (ISO 8601)
     * (Required)
     *
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Time when the status change occurred (ISO 8601)
     * (Required)
     *
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Message recipient (phone number or email address)
     * (Required)
     *
     */
    @JsonProperty("recipient")
    public String getRecipient() {
        return recipient;
    }

    /**
     * Message recipient (phone number or email address)
     * (Required)
     *
     */
    @JsonProperty("recipient")
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Optional description providing more information about the status
     *
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Optional description providing more information about the status
     *
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Answer received for this interactive message. Status = ANSWERED.
     *
     */
    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    /**
     * Answer received for this interactive message. Status = ANSWERED.
     *
     */
    @JsonProperty("answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Map of key/value pairs with additional parameters
     *
     */
    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Map of key/value pairs with additional parameters
     *
     */
    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public enum MessageStatus {

        CREATED("CREATED"),
        PREPARED("PREPARED"),
        FORWARDED("FORWARDED"),
        IN_GATEWAY("IN_GATEWAY"),
        SENT("SENT"),
        DELIVERED("DELIVERED"),
        EXPIRED("EXPIRED"),
        ERROR("ERROR"),
        REJECTED("REJECTED"),
        ANSWERED("ANSWERED"),
        PARTIALLY_DELIVERED("PARTIALLY_DELIVERED"),
        READ("READ"),
        CANCELED("CANCELED");
        private final String value;
        private final static Map<String, DeliveryNotificationType.MessageStatus> CONSTANTS = new HashMap<String, DeliveryNotificationType.MessageStatus>();

        static {
            for (DeliveryNotificationType.MessageStatus c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private MessageStatus(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static DeliveryNotificationType.MessageStatus fromValue(String value) {
            DeliveryNotificationType.MessageStatus constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}