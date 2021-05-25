package com.proyectoempresa.spring.boot.backend.apirest.auth;

public class JwtConfig {
	
public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAtX6w0Gvj6ElTiBgs2C0ilcORJYZBOW6eNmCvxxlU6wd8+t8i\r\n"
			+ "2kKP9IzVdRJl6+jUjWfLxcHUEn3kqFiE2efmM7nGlaJiPRgODx4d/N1MzgOfmrzX\r\n"
			+ "0yTfgNLzcakWU3DWD1pKCvrvwxvNZm86rksdENens1jOw2tmw3nKiyl9RE8GZMXQ\r\n"
			+ "gtOdvICV4hcNXNJ6jvcgzg2+1+EdWwDpD83cavU9KqMQGRGCe6nOycfVa/EqlAwx\r\n"
			+ "VEi4IUyUA+VlHPtN6QmONaXepVfrxKBdMLU6oFwGsPfGFlaj+f20ag+vDkzeCd+z\r\n"
			+ "l+Irms671HUF4MYVLK/+svCTEiL9UG0Vq4pJ0QIDAQABAoIBAGtjF8lqXQJfCI65\r\n"
			+ "ByetpQ4KFgKm6kbKHdC86qSaZ3VdC+UATAXqZnTjM5W+mhG4xLMaXCaZphp+5OF6\r\n"
			+ "5rhsDvhCDq8Q0qGlbwQg5MtuQXiQCkqrO+RRp/D4YFS7IFukovOYj8Dpcx31gFYA\r\n"
			+ "sC7agMsrXq2ueUCFdttoX6Bxnw3f1/1WswTCQUAf0kHdhjAHI25mO5vExVC/Ophw\r\n"
			+ "32WDTLNAIdfe/DxHQkS19iEzOCuAtlIHm/l9k6AFidqS/DSg3NsSq5IzqdJMJsw5\r\n"
			+ "hNQM/TYnWvzTFppbCtJ5qwZXMOOVfRvvifYGYUDeCbQp1qOEM8tSI7lXMG7CKXJk\r\n"
			+ "rB1360UCgYEA7Uu0y4A/L4HW/eK5fMAeUJXE9sU0c9FTlqd3Qy0Wm/3TYvjAi9eR\r\n"
			+ "HR2iTsFyLc/7cvPs1qY0YKuaQ75jdt0T1ja+6Q8uQBtTWMSQa4ORDVSzZ5FyR1pL\r\n"
			+ "RYndmXBpZ9CBtadvzRB7pIFyf16Ryxk7yvZuJ8m10QYZmnOp61vQXkcCgYEAw80A\r\n"
			+ "gzij/AcfEIeTipFaYDDdb5yJTEG4vVjWnru2ztTJ/NdjRZbfmQAmQltj4siQDnl7\r\n"
			+ "eEaDOA6xgJpZWAv+TNghQq2KIyhKdEXSa8l6SHzVBlJ0Sa3b/9tAG5vhyt7eop8h\r\n"
			+ "WIND9xdbpsTPJeid1E5XV2gExrHv8PhbeSZaKycCgYEA3phm14LNQt5Uc8LL5vc9\r\n"
			+ "OLDVm/rvsjlJZQhg+tX/4IKhWbUowcWMbbiPubsDRXBVWsbwg4ZTmd8/jY66NRU7\r\n"
			+ "d3XRbkR8SUyYyatSIli/p7atuFiaz84mz+t8wWPOrMDN/D49xSpSIcYARvTKZK+e\r\n"
			+ "BE1YleBEuvgy6kzXt11gQB8CgYAtUEFBHReeWQuQaL/1fqQaxNRKY0DHHCKj925b\r\n"
			+ "9/dbsJU6ZaJ81WjT4Nv52Wqpbl8gam7vq+nsTEI6D/6DSOtGX3J7GuxwLH/mns4O\r\n"
			+ "0ebx5anrN6Pf9VOHx/bzLMU5jRCbNBakhGRzR72XP87s6AO2wZanDNSmI0HzU5bf\r\n"
			+ "18dgWwKBgQCau/NHSxEvM/0Bpu/IfoJTdHyjh8Goib7CqgFnaSr6KVXE08d/D9L/\r\n"
			+ "tFt42JDezm3IqO3dYbf/CXmPiry6iu5qsp+5aO1rgT8UTzp4SkBER8Fiuw3cxe5k\r\n"
			+ "85yYOjGVoSD+XDCsPWaUx/fZkX418Wc8mHPeQf+UDlbstqGgXyTxgw==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtX6w0Gvj6ElTiBgs2C0i\r\n"
			+ "lcORJYZBOW6eNmCvxxlU6wd8+t8i2kKP9IzVdRJl6+jUjWfLxcHUEn3kqFiE2efm\r\n"
			+ "M7nGlaJiPRgODx4d/N1MzgOfmrzX0yTfgNLzcakWU3DWD1pKCvrvwxvNZm86rksd\r\n"
			+ "ENens1jOw2tmw3nKiyl9RE8GZMXQgtOdvICV4hcNXNJ6jvcgzg2+1+EdWwDpD83c\r\n"
			+ "avU9KqMQGRGCe6nOycfVa/EqlAwxVEi4IUyUA+VlHPtN6QmONaXepVfrxKBdMLU6\r\n"
			+ "oFwGsPfGFlaj+f20ag+vDkzeCd+zl+Irms671HUF4MYVLK/+svCTEiL9UG0Vq4pJ\r\n"
			+ "0QIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
