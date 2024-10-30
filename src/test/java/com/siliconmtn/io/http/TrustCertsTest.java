package com.siliconmtn.io.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> TrustCertsTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Oct 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

class TrustCertsTest {
	
	// Members
	TrustCerts certs;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		certs = new TrustCerts();
		
	}

	/**
	 * Test method for {@link com.siliconmtn.io.http.TrustCerts#getTrustCerts()}.
	 */
	@Test
	void testGetTrustCerts() {
		SSLContext ctx = certs.getTrustCerts();
		assertNotNull(ctx);
	}

	/**
	 * Test method for {@link com.siliconmtn.io.http.TrustCerts#getTrustManagers()}.
	 */
	@Test
	void testGetTrustManagers() {
		TrustManager[] tm = certs.getTrustManagers();
		assertEquals(1, tm.length);
	}
	
	/**
	 * Test method for {@link com.siliconmtn.io.http.TrustCerts#getTrustManagers()}.
	 * @throws Exception 
	 */
	@Test
	void testGetTrustManagersDetail() throws Exception {
		TrustManager[] tms = certs.getTrustManagers();
		X509TrustManager mgr = (X509TrustManager)tms[0];
		X509Certificate[] x509certs = mgr.getAcceptedIssuers();
		assertNotNull(x509certs);
		System.out.println(x509certs.length);
		
	    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	    keyPairGenerator.initialize(4096);
	    KeyPair keyPair = keyPairGenerator.generateKeyPair();
	    final X509Certificate cert509 = X509Sample.generate(keyPair, "SHA256withRSA", "localhost", 730);
	    X509Certificate[] cert = { cert509 };
		
	    assertDoesNotThrow(() -> {
	    	mgr.checkClientTrusted(cert, "TEST");
	    });
	    
	    assertDoesNotThrow(() -> {
	    	mgr.checkServerTrusted(cert, "TEST");
	    });
	}

	
}
