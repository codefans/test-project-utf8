package com.codefans.reusablecode.encode;

import com.codefans.reusablecode.util.Assert;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author: codefans
 * @date: 2019-07-18 20:05
 */
public class RSAUtils {

    private static final String ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
    private static final String DEFAULT_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static final int KEYSIZE = 1024;
    private static final int MAX_ENCRYPT_DATA_SIZE = 117;
    private static final int MAX_DECRYPT_DATA_SIZE = 128;

    public static KeyPair generateKeyPair() {
        return generateKeyPair(1024);
    }

    private static KeyPair generateKeyPair(int keySize) {
        Assert.isTrue(keySize >= 512 && keySize <= 16384, "密钥长度必须大于等512且小于等于16384。");

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keySize);
            java.security.KeyPair kPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = kPair.getPublic();
            PrivateKey privateKey = kPair.getPrivate();
            return new KeyPair(Base64.base64Encode(publicKey.getEncoded()), Base64.base64Encode(privateKey.getEncoded()));

        } catch (NoSuchAlgorithmException var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public static String encryptByPublicKey(String input, Charset charset, String publicKey) {
        Assert.isNotBlank(input, "待加密数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(publicKey, "公钥数据不能为空！");
        byte[] data = input.getBytes(charset);
        byte[] pubKey = Base64.base64Decode(publicKey);
        byte[] encryptedData = encryptByPublicKey(data, pubKey);
        return Base64.base64Encode(encryptedData);
    }

    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) {
        Assert.notEmpty(data, "要进行加密的数据不能为空!");
        Assert.notEmpty(publicKey, "公钥数据不能为空!");
        int dataSize = data.length;
        int blockCount = dataSize % 117 == 0 ? dataSize / 117 : dataSize / 117 + 1;
        ByteArrayOutputStream out = new ByteArrayOutputStream(blockCount * 128);

        byte[] var9;
        try {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key publicK = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicK);
            encryptByBlock(out, cipher, data);
            var9 = out.toByteArray();
        } catch (NoSuchAlgorithmException var20) {
            throw new IllegalArgumentException(var20);
        } catch (InvalidKeyException var21) {
            throw new IllegalArgumentException(var21);
        } catch (Exception var22) {
            throw new IllegalStateException(var22);
        } finally {
            try {
                out.close();
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return var9;
    }

    public static String decryptByPrivateKey(String input, Charset charset, String privateKey) {
        Assert.isNotBlank(input, "待解密数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(privateKey, "私钥数据不能为空！");
        byte[] encryptedData = Base64.base64Decode(input);
        byte[] prvKey = Base64.base64Decode(privateKey);
        byte[] data = decryptByPrivateKey(encryptedData, prvKey);
        return new String(data, charset);
    }

    public static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) {
        Assert.notEmpty(data, "要进行解密的数据不能为空!");
        Assert.notEmpty(privateKey, "私钥数据不能为空!");
        int dataSize = data.length;
        int blockCount = dataSize / 128;
        ByteArrayOutputStream out = new ByteArrayOutputStream(blockCount * 117);

        byte[] var9;
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey prvKey = keyFactory.generatePrivate(keySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, prvKey);
            decryptByBlock(out, cipher, data);
            var9 = out.toByteArray();
        } catch (NoSuchAlgorithmException var20) {
            throw new IllegalArgumentException(var20);
        } catch (InvalidKeyException var21) {
            throw new IllegalArgumentException(var21);
        } catch (Exception var22) {
            throw new IllegalStateException(var22);
        } finally {
            try {
                out.close();
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return var9;
    }

    public static String encryptByPrivateKey(String input, Charset charset, String privateKey) {
        Assert.isNotBlank(input, "待加密数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(privateKey, "私钥数据不能为空！");
        byte[] data = input.getBytes(charset);
        byte[] prvKey = Base64.base64Decode(privateKey);
        byte[] encryptedData = encryptByPrivateKey(data, prvKey);
        return Base64.base64Encode(encryptedData);
    }

    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) {
        Assert.notEmpty(data, "要进行加密的数据不能为空!");
        Assert.notEmpty(privateKey, "私钥数据不能为空!");
        int dataSize = data.length;
        int blockCount = dataSize % 117 == 0 ? dataSize / 117 : dataSize / 117 + 1;
        ByteArrayOutputStream out = new ByteArrayOutputStream(blockCount * 128);

        byte[] var9;
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey prvKey = keyFactory.generatePrivate(keySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, prvKey);
            encryptByBlock(out, cipher, data);
            var9 = out.toByteArray();
        } catch (NoSuchAlgorithmException var20) {
            throw new IllegalArgumentException(var20);
        } catch (InvalidKeyException var21) {
            throw new IllegalArgumentException(var21);
        } catch (Exception var22) {
            throw new IllegalStateException(var22);
        } finally {
            try {
                out.close();
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return var9;
    }

    public static String decryptByPublicKey(String input, Charset charset, String publicKey) {
        Assert.isNotBlank(input, "待解密数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(publicKey, "公钥数据不能为空！");
        byte[] encryptedData = Base64.base64Decode(input);
        byte[] prvKey = Base64.base64Decode(publicKey);
        byte[] data = decryptByPublicKey(encryptedData, prvKey);
        return new String(data, charset);
    }

    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) {
        Assert.notEmpty(data, "要进行解密的数据不能为空!");
        Assert.notEmpty(publicKey, "公钥数据不能为空!");
        int dataSize = data.length;
        int blockCount = dataSize / 128;
        ByteArrayOutputStream out = new ByteArrayOutputStream(blockCount * 117);

        byte[] var9;
        try {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key publicK = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicK);
            decryptByBlock(out, cipher, data);
            var9 = out.toByteArray();
        } catch (NoSuchAlgorithmException var20) {
            throw new IllegalArgumentException(var20);
        } catch (InvalidKeyException var21) {
            throw new IllegalArgumentException(var21);
        } catch (Exception var22) {
            throw new IllegalStateException(var22);
        } finally {
            try {
                out.close();
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return var9;
    }

    public static String sign(String input, Charset charset, String privateKey) {
        Assert.isNotBlank(input, "待签名数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(privateKey, "私钥数据不能为空！");
        byte[] data = input.getBytes(charset);
        byte[] prvKey = Base64.base64Decode(privateKey);
        byte[] sign = sign(data, prvKey);
        return Base64.base64Encode(sign);
    }

    public static byte[] sign(byte[] data, byte[] privateKey) {
        Assert.notEmpty(data, "要签名的数据不能为空!");
        Assert.notEmpty(privateKey, "私钥不能为空!");

        try {
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey key = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(key);
            signature.update(data);
            return signature.sign();
        } catch (NoSuchAlgorithmException var6) {
            throw new IllegalArgumentException(var6);
        } catch (InvalidKeyException var7) {
            throw new IllegalArgumentException(var7);
        } catch (InvalidKeySpecException var8) {
            throw new IllegalArgumentException(var8);
        } catch (SignatureException var9) {
            throw new IllegalStateException(var9);
        }
    }

    public static boolean verify(String input, Charset charset, String publicKey, String sign) {
        Assert.isNotBlank(input, "待验证数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(publicKey, "公钥数据不能为空！");
        Assert.isNotBlank(sign, "数据签名不能为空！");
        byte[] data = input.getBytes(charset);
        byte[] pubKey = Base64.base64Decode(publicKey);
        byte[] signBytes = Base64.base64Decode(sign);
        return verify(data, pubKey, signBytes);
    }

    public static boolean verify(byte[] data, byte[] publicKey, byte[] sign) {
        Assert.notEmpty(data, "要验证的数据不能为空!");
        Assert.notEmpty(publicKey, "公钥不能为空!");
        Assert.notEmpty(sign, "数字签名不能为空!");

        try {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(x509KeySpec);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(key);
            signature.update(data);
            return signature.verify(sign);
        } catch (NoSuchAlgorithmException var7) {
            throw new IllegalArgumentException(var7);
        } catch (InvalidKeyException var8) {
            throw new IllegalArgumentException(var8);
        } catch (InvalidKeySpecException var9) {
            throw new IllegalArgumentException(var9);
        } catch (SignatureException var10) {
            throw new IllegalStateException(var10);
        }
    }

    public static boolean verifySign(String input, Charset charset, String publicKey, String uploadEncryptData) {
        Assert.isNotBlank(input, "待验证数据不能为空！");
        Assert.notNull(charset, "数据编码不能为空！");
        Assert.isNotBlank(publicKey, "公钥数据不能为空！");
        Assert.isNotBlank(uploadEncryptData, "数据签名不能为空！");

        String encryptData = encryptByPublicKey(input, charset, publicKey);
        if(encryptData.equals(uploadEncryptData)) {
            return true;
        } else {
            return false;
        }
    }

    private static void encryptByBlock(ByteArrayOutputStream out, Cipher cipher, byte[] data) throws Exception {
        int startIndex = 0;

        for(int dataSize = data.length; startIndex < dataSize; startIndex += 117) {
            int leftSize = dataSize - startIndex;
            if (leftSize >= 117) {
                out.write(cipher.doFinal(data, startIndex, 117));
            } else {
                out.write(cipher.doFinal(data, startIndex, leftSize));
            }
        }

    }

    private static void decryptByBlock(ByteArrayOutputStream out, Cipher cipher, byte[] data) throws Exception {
        int startIndex = 0;

        for(int dataSize = data.length; startIndex < dataSize; startIndex += 128) {
            int leftSize = dataSize - startIndex;
            if (leftSize >= 128) {
                out.write(cipher.doFinal(data, startIndex, 128));
            }
        }

    }

    private RSAUtils() {
    }

}
