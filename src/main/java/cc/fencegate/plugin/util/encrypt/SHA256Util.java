package cc.fencegate.plugin.util.encrypt;

import java.io.File;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

public class SHA256Util {

    public static byte[] getSha256(File input) {
        int buff = 16384;
        try {
            RandomAccessFile file = new RandomAccessFile(input, "r");
            long startTime = System.nanoTime();
            MessageDigest hashSum = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[buff];
            byte[] partialHash = null;
            long read = 0;
            long offset = file.length();
            int unitsize;
            while (read < offset) {
                unitsize = (int) (((offset - read) >= buff) ? buff : (offset - read));
                file.read(buffer, 0, unitsize);
                hashSum.update(buffer, 0, unitsize);
                read += unitsize;
            }
            file.close();
            partialHash = hashSum.digest();
            return partialHash;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
