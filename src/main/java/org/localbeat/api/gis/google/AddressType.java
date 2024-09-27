package org.localbeat.api.gis.google;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> AddressType.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 2, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Data
@NoArgsConstructor
class AddressType {
	@JsonProperty(value = "long_name")
	private String longName;
	
	@JsonProperty(value = "short_name")
	private String shortName;
	
	
	private List<TypePart> types;
}

