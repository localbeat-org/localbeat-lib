package org.localbeat.api.gis.util;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/****************************************************************************
 * <b>Title:</b> GeocoderConfigDTO.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> --- Change Me -- <br>
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
@Configuration
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GeocoderConfigDTO {
	
	private String key;
	private String url;
	private String clazz;
}

