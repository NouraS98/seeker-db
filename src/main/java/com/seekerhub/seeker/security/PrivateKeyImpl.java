package com.seekerhub.seeker.security;

import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.security.KeyFactory;
import javax.crypto.Cipher;

public interface PrivateKeyImpl {

    String privateKeyString ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCcAeTP0q2htFh/Ue4zDYaNmbjq" +
            "uuLFyoLnfs9uZ2BLR9ED1OwZYpJkyv7/7TIcid76MdrQO3Npg5ClsHyfMLZDieb9dLi3UTQ7n+Sn" +
            "gwwbRMKO/jgtl79v8CX9HAB6UIpDeWmC67jRNqq5FMdUG1svzApggN7QGVbW6oCBO7Mj+B0HkLbq" +
            "YOcPw+apnTh0IdsoFcuL67ndjFUaRFEtbCtp+WbbQG7TDa2UycLHtFfQ9HwP5e6FlURm3h5lYPqn" +
            "Cz0NYBorLtsjgBjsOGnHJApXJgg4LxwZLqt/xo2W03PV2nlmql5fSLLStO64KZDHnHPQQqBVxOom" +
            "aaOsKlYdgweHAgMBAAECggEAQ20aHKxcuQf+O8EIZ25QGkE3R9RQENZu72jCdGAfoUm/z50mEe6l" +
            "gQSvY6N7xhPcmFwVy2v2fMMNMF9v7UmbbONcP21ELI7fOWno5HFiOSLlx/GeDC6K4fF0KcoBdtv6" +
            "diEydhA1R88NyIJviC1uouDYF097fYuGGcsukSxhR4jXGJl3SnJG/7SEBREQoam0vJR9hf0/Rpln" +
            "P4IipnDDA8mbjTt1FGzLPlH3Wr5D5N8TPljW+3T0xrtHhnWebYcKeU2gkAy4vr1Eb+KGNjoseo6H" +
            "VbF3yZCHHeoa+LjboxBQyYfeH3GI/Aqi5puegPzpZlIGmGDnxnHM4sB1+vRY4QKBgQDKN7OwHN5t" +
            "odYFfEBJ8aFtfmEykhJxv1BfkLG82tpvEHTPssQVmt6SVwzOwOPxO2F+lcuG9j30MC1Xf90QwBBG" +
            "9V9pK3GBq59A4JOyavS4RYvhJ+dAHZ7at+tQqVA41EPTUYpsihX00lVfBQ24iTC2h7LCOcx1Wu7u" +
            "06UTYxezFwKBgQDFf+ZITTX2y4WHpqkdhMRj4ZpnlpiV7V5wt2jb1/va8n0ando9sODCZ/Yl+RRu" +
            "wyvB8v55ao6h7be07COIsqDVt3n5D75IQX8v8C1sZs0LZ0gpSPEAD9cQihkak3pjXIK9T7rgWcB9" +
            "VGcN50Vow6VDMAnFtACgCczCTq36o0LVEQKBgE1yf/NXWykJ7nozWDv5uyXAXWGM6FuANjwjoq79" +
            "8uLOnq5dfRP5OH07scANyD8/yts8a7LI5Hl9aiA07GnZ5WIH3/7bkKFlJZ0nZenTZN6eZDBbpAm+" +
            "TnTeM9W0wvDA+ykX9bgUOsyFMgUuXk7q3ClMV35jvJbFuPTnQjXmodEJAoGBAI9mc20x6qncUoMR" +
            "Jp/RQ8uGBleKiBXsOPM8qL1fkHYENYP683hxknB1jcs6lHRr77yuU8kS7qdydD3Aa3iYwqEKzFxj" +
            "6vSJ4fCLwl+AMQdDoaigVqSF29EdhGbAiE/W3vLYDkdRw6r8eqskrkgILlmfaqkLLp0FIJBBEp/2" +
            "pNMRAoGAGGFSrjYrSzhlvY67LZOJ+Wk49me5XiT2llAs9Wm3ViZok9zkaz+WWIuMjT917vJAwK+e" +
            "WIWjBgQu1YtUQ8cy4igCqSj1YfCNbw9GVUFbhWNNb2WJH/UbBwCXcMejTi1E/IpiEI4QHG/+OM7K" +
            "AeuLgKPi0kqARkym6lTZov8WCQ0=";

    // Decrypt using RSA public key
     static String decryptMessage(String encryptedText) throws Exception {
         PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
         KeyFactory kf = KeyFactory.getInstance("RSA");
         PrivateKey privateKey = kf.generatePrivate(priKeySpec);


        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
}
