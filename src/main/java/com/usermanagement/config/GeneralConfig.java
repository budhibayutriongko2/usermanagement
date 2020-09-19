package com.usermanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by andry.sunandar01 on 09/02/2018.
 */
@Data
@Component
@ConfigurationProperties(prefix="generalConfig")
@PropertySource("file:/file/tippers/notification.properties")
public class GeneralConfig {
    private int restConnectTimeout;
    private int restReadTimeout;
    private String wsUsername;
    private String wsPassword;
    private String wsTrustListURL;
    private String firebaseServerKey;
    private String firebaseApiUrl;
    private String emailFrom;
    private String emailHost;
    private Integer emailPort;
    private String emailUsername;
    private String emailPass;
    private String wsMSSMessageURL;
    private String mssSystemCode;
    private String mssMessageCode;
    private String proxyUser;
    private String proxyPas;
}
