package org.localbeat.api.gis.data;

// JDK 17
import java.sql.Timestamp;
import java.util.UUID;

// Spring 3.2.4
import org.hibernate.annotations.CreationTimestamp;

import com.siliconmtn.io.api.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Lombok 1.18.30
import lombok.Data;

/****************************************************************************
 * <b>Title:</b> ZipCodeEntity.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> Data entity for the zipcode table <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Mar 31, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Data
@Entity
@Table(name="zip_code", schema="gis")
public class ZipCodeEntity implements BaseEntity {
	
	private static final long serialVersionUID = 5625986881428310611L;

	@Id
	@GeneratedValue
	@Column(name = "zip_code_id", columnDefinition = "uuid", nullable = false)
	private UUID zipCodeId;
	
	@Column(name = "zip_cd", columnDefinition = "varchar(16)", nullable = false)
	private String zipCode;
	
	@Column(name = "city_id", columnDefinition = "uuid", nullable = false)
	private UUID cityId;
	
	@Column(name = "city_nm", columnDefinition = "varchar(40)", nullable = false)
	private String city;
	
	@Column(name = "state_id", columnDefinition = "varchar(8)", nullable = false)
	private String stateId;
	
	@Column(name = "state_cd", columnDefinition = "varchar(3)", nullable = false)
	private String stateCode;
	
	@Column(name = "county_nm", columnDefinition = "varchar(32)", nullable = false)
	private String county;
	
	@Column(name = "country_cd", columnDefinition = "varchar(2)", nullable = false)
	private String countryCode;
	
	@Column(name = "latitude_no", columnDefinition = "numeric(12,8)", nullable = false)
	private double latitude;
	
	@Column(name = "longitude_no", columnDefinition = "numeric(12,8)", nullable = false)
	private double longitude;
	
	@Column(name = "create_dt", columnDefinition = "timestamp DEFAULT timezone('utc', now()) NOT NULL")
	@CreationTimestamp
	private Timestamp createDate;
}
