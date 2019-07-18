package com.codefans.reusablecode.encode;

/**
 * @author: codefans
 * @date: 2019-07-18 20:20
 */
public class KeyPair {

    private String publicKey;
    private String privateKey;

    public KeyPair(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

}
