package br.iff.pooa20141.fitsys.model.test;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDILookupClass {
	private static Context initialContext;

	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.remote.client.InitialContextFactory");
			properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
			properties.put(Context.SECURITY_PRINCIPAL, "user");
			properties.put(Context.SECURITY_CREDENTIALS, "123456");

			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

}