package classify.encryption;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


public class DES {
    public static void encryptDecrypt(String key, int cipherMode, File in, File out) throws InvalidKeyException,
            NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException {
        FileInputStream  fileinput = new FileInputStream(in);
        FileOutputStream fileOutput = new FileOutputStream(out);

        //key needs to have 8 bytes min, and we are converting the key to bytes
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());

        //Creating a secret key factory using the DES Algorithm
        SecretKeyFactory secretKF = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKF.generateSecret(desKeySpec);

        //Using Electronic Code Book
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        if (cipherMode == Cipher.ENCRYPT_MODE){
            //initialise cipher
            //Using SHA1 Hash Algorithm, and Pseudo Random Number Generator
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherInputStream cipherInput= new CipherInputStream(fileinput, cipher);
            write (cipherInput,fileOutput);
        } else if (cipherMode == Cipher.DECRYPT_MODE){
            cipher.init(Cipher.DECRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherOutputStream cipherOutput = new CipherOutputStream(fileOutput, cipher);
            write(fileinput,cipherOutput);
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException{
        byte[] buffer = new byte[64];
        int numOfBytesRead;
        while((numOfBytesRead = in.read(buffer)) != -1){
            out.write(buffer,0,numOfBytesRead);
        }
        out.close();
        in.close();
    }

    public static void main(String[] args){
        File plaintext = new File("./data/testFolder/hello.txt");
        File encrypted = new File("./data/testFolder/encrypted.txt");
        File decrypted = new File("./data/testFolder/decrypted.txt");

        try {
            encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, plaintext, encrypted);
            System.out.println("Encryption Complete!");
            encryptDecrypt("12345678", Cipher.DECRYPT_MODE, encrypted, decrypted);
            System.out.println("Decryption Complete!");
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException |
                 NoSuchPaddingException | IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public static void encrypt(String key, File in, File out){
        try{
            encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, in, out);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException |
                 NoSuchPaddingException | IOException e) {
            System.out.println("Something went wrong with Encryption!");
        }
    }

    public static void decrypt(String key, File in , File out){
        try{
            encryptDecrypt("12345678", Cipher.DECRYPT_MODE, in, out);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException |
                 NoSuchPaddingException | IOException e) {
            System.out.println("Something went wrong with Encryption!");
        }
    }
}
