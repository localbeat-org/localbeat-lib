/****************************************************************************
 * <b>Title:</b> GeocoderFactory.java <br>
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

import java.lang.reflect.Constructor;

import org.localbeat.api.gis.data.AbstractGeocoder;

/****************************************************************************
 * <b>Title:</b> GeocoderFactory.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Determines which geocoder to implement based upon the data provided <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 3, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class GeocoderFactory {
	
	/**
	 * Provate constructor for a static class
	 */
	private GeocoderFactory() {
		// Nothing to do
	}

	/**
	 * 
	 * @param config
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static AbstractGeocoder getInstance(GeocoderConfigDTO config) throws ClassNotFoundException {
		
		try {
			Thread t = Thread.currentThread();
			ClassLoader cl = t.getContextClassLoader();
			cl.clearAssertionStatus();
			Class<?> load = cl.loadClass(config.getClazz());
			Constructor<?> c = load.getConstructor(GeocoderConfigDTO.class);
			return (AbstractGeocoder) c.newInstance(config);
		} catch (Exception e) {
			throw new ClassNotFoundException("Unable to instantiate: " + config, e);
		}
	}
}

