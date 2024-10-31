package org.localbeat.api.gis.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/****************************************************************************
 * <b>Title:</b> GeocoderConfig.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Map that holds the configuration for the geocoder services <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 3, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "conf")
@Configuration
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GeocoderConfig {

	Map<String, GeocoderConfigDTO> geocoder = new HashMap<>();
}

