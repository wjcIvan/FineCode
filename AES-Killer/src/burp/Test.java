package burp;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Test {
    public static String key= "e79465cfbb39cjdusimcuekd3b066a6e";
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static void main(String[] args) {
        String a = Test.b("e79465cfbb39cjdusimcuekd3b066a6e","{\"mod\":\"system\",\"bundle_id\":\"com.didi.android\",\"oauth_id\":\"5b0b684a74b0c278679fc324ed6649ef\",\"oauth_type\":\"android\",\"version\":\"5.0.1\",\"timestamp\":\"1608083320135\",\"app_type\":\"local\",\"code\":\"index\"}");
        System.out.println(a);
    }

    public static byte[][] b1() {
        try {
            String str = "e79465cfbb39cjdusimcuekd3b066a6e";
            Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
            byte[][] a2 = a(32, 16, (byte[]) null, str.getBytes("UTF-8"), 0);
            return a2;
//            System.out.println(a2[1]);
//            instance.init(1, new SecretKeySpec(a2[0], "AES"), new IvParameterSpec(a2[1]));
//            return b(a(instance.getIV(), instance.doFinal(str2.getBytes("UTF-8"))));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }


    //main str：key
    public static String b(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
            byte[][] a2 = a(32, 16, (byte[]) null, key.getBytes("UTF-8"), 0);
//            System.out.println(bytesToString(a2[0]));
//            System.out.println(bytesToString(a2[1]));
            instance.init(1, new SecretKeySpec(a2[0], "AES"), new IvParameterSpec(a2[1]));
            return b(a(instance.getIV(), instance.doFinal(str2.getBytes("UTF-8"))));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
    public static String bytesToString(byte[] bs) {
        try {
            // 通过指定的字符集解码指定的byte数组并构造一个新的字符串
            return new String(bs, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String a(String str, String str2) {
        try {
            byte[] b2 = b(str2);
            byte[] copyOfRange = Arrays.copyOfRange(b2, 0, 16);
            byte[] copyOfRange2 = Arrays.copyOfRange(b2, 16, b2.length);
            byte[][] a2 = a(32, 16, (byte[]) null, key.getBytes("UTF-8"), 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(copyOfRange);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2[0], "AES");
            Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(copyOfRange2), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            return null;
        }
        int i = length / 2;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    private static String b(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str.toUpperCase();
    }

    public static byte[] a(String str, byte[] bArr) {
        try {
            byte[] b2 = b(new String(bArr));
            byte[] copyOfRange = Arrays.copyOfRange(b2, 0, 16);
            byte[] copyOfRange2 = Arrays.copyOfRange(b2, 16, b2.length);
            byte[][] a2 = a(32, 16, (byte[]) null, str.getBytes("UTF-8"), 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(copyOfRange);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2[0], "AES");
            Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(copyOfRange2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    //获取IV
    public static byte[][] a(int i, int i2, byte[] bArr, byte[] bArr2, int i3) throws Exception {
        byte[] digest;
        int i4;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        MessageDigest instance = MessageDigest.getInstance("md5");
        int i5 = i;
        byte[] bArr5 = new byte[i5];
        int i6 = i2;
        byte[] bArr6 = new byte[i6];
        byte[][] bArr7 = {bArr5, bArr6};
        if (bArr4 == null) {
            return bArr7;
        }
        byte[] bArr8 = null;
        int i7 = i6;
        int i8 = 0;
        int i9 = 0;
        int i10 = i5;
        int i11 = 0;
        while (true) {
            instance.reset();
            int i12 = i11 + 1;
            if (i11 > 0) {
                instance.update(bArr8);
            }
            instance.update(bArr4);
            if (bArr3 != null) {
                instance.update(bArr3, 0, 8);
            }
            digest = instance.digest();
            int i13 = i3;
            for (int i14 = 1; i14 < i13; i14++) {
                instance.reset();
                instance.update(digest);
                digest = instance.digest();
            }
            if (i10 > 0) {
                i4 = 0;
                while (i10 != 0 && i4 != digest.length) {
                    bArr5[i8] = digest[i4];
                    i10--;
                    i4++;
                    i8++;
                }
            } else {
                i4 = 0;
            }
            if (i7 > 0 && i4 != digest.length) {
                while (i7 != 0 && i4 != digest.length) {
                    bArr6[i9] = digest[i4];
                    i7--;
                    i4++;
                    i9++;
                }
            }
            if (i10 == 0 && i7 == 0) {
                break;
            }
            i11 = i12;
            bArr8 = digest;
        }
        for (int i15 = 0; i15 < digest.length; i15++) {
            digest[i15] = 0;
        }
        return bArr7;
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("UTF-8"));
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}