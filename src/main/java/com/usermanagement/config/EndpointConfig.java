package com.usermanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="api")
@PropertySource("file:/file/tippers/api.properties")
public class EndpointConfig {
	private String urlEnvironment;
	private String utilContextRoot;
	private String notificationContextRoot;
	private String incentiveContextRoot;
	private String coreContextRoot;

	private String parameterSettingCategory;
	private String parameterSettingForDocument;
	private String getAllDistrict;
	private String trustList;
	private String faq;
	private String ocrObject;
	private String getCode;
	private String tippersAllDailyIncentive;
	private String listDeviceIdIncentive;
	private String listDeviceIdEmailOrPhoneNumber;
}
