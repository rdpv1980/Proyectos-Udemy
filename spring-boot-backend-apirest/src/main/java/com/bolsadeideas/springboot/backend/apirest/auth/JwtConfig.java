package com.bolsadeideas.springboot.backend.apirest.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA="alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpQIBAAKCAQEAwQPe9q1bLGl7gg1doLfFQlrvS8e4B6BSPbYwnw2F6Ua7OcSl\r\n"
			+ "yUH6sFdfH5rvcZiqUh3T+70O43PQrWvRf3G+P9q9FoSEWTpzrtpete9J33VfF0Vj\r\n"
			+ "jXfVEGUMh8Ai3vOzY3Vp95qzRPcitkrHF+9PwjGgyOtrRJQIBHas5KPt6nAcaziP\r\n"
			+ "nV9YE9B0dVxB5KLYRci0qmkoovwa3z5OUjplo/ePeucxD7KWhWpUzxNHhYZFtdke\r\n"
			+ "ErWqAZlyiMhw/EctQhh9IgCsegfrtDi8IteHm6Y1ih3eQ9gVyYfAXhk8FAcBvTNB\r\n"
			+ "5HJXOkiVlWBSxThNvVp0G0KCUuld45B+pAPwcQIDAQABAoIBAQC88GYcwJvkQKln\r\n"
			+ "KGBDiEDvcIaYfruVs4lt4V99AsbYEKYLqYTEGvMkFZMHJCpJ37CyS4KMBYiCfIeE\r\n"
			+ "i2t7PsOGTEAWv8eydLZzLk3R+Jguxv07kXAfNnN55gC7DgjUiGhM7s25VFUyKF1x\r\n"
			+ "Zoe31UoVBXGn3FOXwPSMMgOSmSm29y5x/rvoqn/1xZfC7rW4E+J2246zDu4xbqTW\r\n"
			+ "3eeER9tvvKGJNLUQa8WXLoRSh2a9FzTY7mBgti+MkGDQcQM0BrwarTts7xe9myVU\r\n"
			+ "WgsOzt28juCKlcvBLeZBR3pg8q9N1SnuObnk0blIq7vZjxcXta5QjCAEog6il9Ot\r\n"
			+ "aNkcfARBAoGBAOQ9mlM3f8n1IViGA0Y6f0mtwUrLc6wZ/whH7a3qoF16UKfMdNjO\r\n"
			+ "z00xealxGVBhj0fFSJV5wktO7zsX6Y/djn1j/OekWrxnWfD/giZZDHMIWTP0Piqg\r\n"
			+ "BUzCO18420MI04r21rIuFSq/mvtC9pJPJFW5fOkTKTu600RFU11LHwC5AoGBANh9\r\n"
			+ "gJ5+a8LvvvslsRkKCw+33Fu23UBbhqF0m2DbGqQ9PKRWzZ8Xc5jvC33DkREtIIt8\r\n"
			+ "GiOurzhETAtPpZDZBjiaY2diZjYgb2e5KkNPXcN2rsm8sx1tWNTBeW7iB88uh9vx\r\n"
			+ "hQ9hhz6ofhcfVd9qga6zklQhwMtRdRNwoC/3iuF5AoGALSNlvult82HwS1KNmTj+\r\n"
			+ "bXLYlFMyOCoX/upCvi91sab8BoNv5GTaKJkNR45fhD8XGAmTNkSTQVOGCnjLLzGQ\r\n"
			+ "+YlpveIKM9J4vim58p2P0bwn8Bdwp/tnsOuE1GspKdO4CnaQtUJZ209zdhejLgJK\r\n"
			+ "3E1Hv8yTTgW/vHO9bejqY7kCgYEAiAO5xlpZK/1iuPnCXZ/wuSxj9v9Z3LBkUpYn\r\n"
			+ "dN/TyjJrIjkjMPwT9ZbiWl5/ixIWK2yKI7cBgVFvkX+13t5rSS6+m1q4KvOP6tPs\r\n"
			+ "GKQJnd+4CylSQ3/K2si/mYnLLEDovKfuWG6HATftGGvokNiip3dMzSzzqwn/i3os\r\n"
			+ "OlbFW8kCgYEAxxH+TKg4j8Tcf90KJLvLlNn5+HY9dm7ocC/P4LvOtpf18R8NV0P4\r\n"
			+ "M1kLultc0ysdojUtFov9iF7s7r7b7s7gbIhe7ogTbBTrptalUWMBjro5I6MZ7uMi\r\n"
			+ "1x9aLOJpwKXVDvRxyK3PKBaF+TXVlgrwDFH8P5NWiLuutiTZ/bSiLQs=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQPe9q1bLGl7gg1doLfF\r\n"
			+ "QlrvS8e4B6BSPbYwnw2F6Ua7OcSlyUH6sFdfH5rvcZiqUh3T+70O43PQrWvRf3G+\r\n"
			+ "P9q9FoSEWTpzrtpete9J33VfF0VjjXfVEGUMh8Ai3vOzY3Vp95qzRPcitkrHF+9P\r\n"
			+ "wjGgyOtrRJQIBHas5KPt6nAcaziPnV9YE9B0dVxB5KLYRci0qmkoovwa3z5OUjpl\r\n"
			+ "o/ePeucxD7KWhWpUzxNHhYZFtdkeErWqAZlyiMhw/EctQhh9IgCsegfrtDi8IteH\r\n"
			+ "m6Y1ih3eQ9gVyYfAXhk8FAcBvTNB5HJXOkiVlWBSxThNvVp0G0KCUuld45B+pAPw\r\n"
			+ "cQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
