/****************************************************************************
 * <b>Title:</b> GeocodeParseException.java <br>
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
package org.localbeat.api.gis.util;

/****************************************************************************
 * <b>Title:</b> GeocodeParseException.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Standard exception for the geocoding service <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 3, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class GeocodeParseException extends Exception {

	private static final long serialVersionUID = -8891062102748547532L;

	/**
	 * 
	 */
	public GeocodeParseException() {
		super();
	}

	/**
	 * @param message
	 */
	public GeocodeParseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GeocodeParseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GeocodeParseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public GeocodeParseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

