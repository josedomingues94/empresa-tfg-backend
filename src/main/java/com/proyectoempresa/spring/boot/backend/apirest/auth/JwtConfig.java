package com.proyectoempresa.spring.boot.backend.apirest.auth;


public class JwtConfig {

	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAs29M919jlaeHqYcQZKb0ch3A/q4Eaf34EnLjmrXFO8AHeZgH\r\n"
			+ "Msf7MBPmOID/hZlPR20PYGpNaJZ25vt8aZgNPK62wKSK6wka0R2ijJevL3LmYbOG\r\n"
			+ "f7pd8LJTHrdrrmvYAXZoYprpbLAtkPhtyd+w3kwZdgO5TXgiU06Hkqn0yFkYtoDz\r\n"
			+ "ItcDLHscwjAqCut4R1kFKsA9YQojHQ4fkvx2Ic0mRIXSAPQ+TyM6AOjWuU8WZE1K\r\n"
			+ "EysVegPrm94AlnouhHylabg6GIP22uGyLRkgEH+n/Jx060HfHBIT8MgDVcc4Xy3S\r\n"
			+ "9bUAe+jX2BXRc4hRIyXppQz9LEcU4lDFH/KEXQIDAQABAoIBAG6iOXpsviIP4X2N\r\n"
			+ "YXYt2pph7hUZhm8zwDjfzaYeXTWx+Onn6shMtXu3SUOdhe8Bz/fiLpDr+j56R2Wz\r\n"
			+ "ucoBjmfT8aplyaGRQ4+cDhVRkRpYZePnpQ4sAq/dw5I01Zf9tnlwYHwrt7DkD7RK\r\n"
			+ "+KZ33b2yfiBdu2sgn0luKfksAVllTH3br4DGB7ZvwbZZ9ZBSaO4KWPUyRS3O/Jq3\r\n"
			+ "mbXPPYkL+YSn+Xt/O41QGIjsQiQxt+61DpgwojnhY9veAVRQc5vW64Khn3kL3BVc\r\n"
			+ "dNaD4OXiJ4v248W/1KoGI+TkGRNWDYijaMswVCEUJYIPj7RhxndAKOTNBr/bEbIS\r\n"
			+ "WdBYIqECgYEA60B38P9n7Jjwq28D/0odFIxbOCBkmzFe70dmnlg/p5+LWP/d920N\r\n"
			+ "y1uqD1c0O/cnDxUi1xQIqzLJCEcOl8A+JyvuPZPAxtAVVYNbnWUlKOdgnFIfxa8v\r\n"
			+ "t4VVlUHTUvsBLcGHyK2Ybu8xpP9NMTpUyVjopZ2P5IUgLjM5WU/w9r8CgYEAw0KX\r\n"
			+ "Pd2OwxK1N9zA8pT3LnWv21YB29ztewiQan06RtQZvvi5GQxEks1JLvbqgwkwhGRr\r\n"
			+ "y/Z492ogsv8+1B4+aUn+hUXXm6kQRtBzNpFc4hC5MF9VghjsvDr7dNTq3ofJIKvV\r\n"
			+ "eGy/kctOsvwg2pXXKvudAUyIOVz9vJWfewAXh+MCgYAFpX17flXbOuyD4N1Csl+y\r\n"
			+ "T5Ac78Iaa3vw2FDhOhMFDfJFR5bnSmnLWL7jMV+ilNMOLJ6ydNukaEqk9TencsjL\r\n"
			+ "HeXQ+ovk+beZXtbDF1tl+O+7sMjscMD/cabVN0hANKAZngyJR4liGEGjyTDsHo9M\r\n"
			+ "aeLjnr2GaZ+VHEujFiUddwKBgAz1FU5ArqGZUzdCyfcPFZwaqTHX8kWh0oyQk+zN\r\n"
			+ "JJngp1i57qaP3tkTEGEyd3t8l6ChfVnKoFpiy4q1T3kKDMA17dLwQI+O14qreInN\r\n"
			+ "ealyzKc+HFGGz+bpzxgArRlZT2qAnKjiJpBJOo68Fn4K5X1vtwqIBp4v4pKqJywl\r\n"
			+ "ZGpbAoGBAIhto8EYOhE//b2Y4iDKL4ZPG7p8oElXZmZZ6zBEuirdwlNt0f1BFt0u\r\n"
			+ "zap2hjObmN6PXn2zYhql+GZNbpTg5/i/Tjqi/oMVbR2yY6PWMlA0VegSeY2AE9AL\r\n"
			+ "75dUVSDB2BGRhxgSiQFK/yCV7q8ZJkl5hluP1zq0IRDNOazrUQ72\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs29M919jlaeHqYcQZKb0\r\n"
			+ "ch3A/q4Eaf34EnLjmrXFO8AHeZgHMsf7MBPmOID/hZlPR20PYGpNaJZ25vt8aZgN\r\n"
			+ "PK62wKSK6wka0R2ijJevL3LmYbOGf7pd8LJTHrdrrmvYAXZoYprpbLAtkPhtyd+w\r\n"
			+ "3kwZdgO5TXgiU06Hkqn0yFkYtoDzItcDLHscwjAqCut4R1kFKsA9YQojHQ4fkvx2\r\n"
			+ "Ic0mRIXSAPQ+TyM6AOjWuU8WZE1KEysVegPrm94AlnouhHylabg6GIP22uGyLRkg\r\n"
			+ "EH+n/Jx060HfHBIT8MgDVcc4Xy3S9bUAe+jX2BXRc4hRIyXppQz9LEcU4lDFH/KE\r\n"
			+ "XQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}