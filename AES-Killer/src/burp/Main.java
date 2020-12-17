package burp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static String b(String... args) {
        String requestParam = args[0];
        String[] param = requestParam.split("&");
        String timestamp = param[0].split("=")[1];
        String data = param[1].split("=")[1];
        String  a= "timestamp=1608167523&data=0EB44C7F3C20A63808D6C2237D6F1A5FC64F2074D08F8339D631D05B0A5227D7B647788E781B8FD2246629E988C213222F1EF6BDED6E1F710181ED432D6DF12924396D4078C20AC1D8C74A24409FEB633268C0D5568E2557373FAB21B1A1BAB2DEDB14F8211B73F536D72DDE63138996BAFBCFB1E81B6EDE9F59C9D9C45565D3D1594C71156CF38F755B37A175091E3B45D670299DAA454DB1CB293C2AE9136C7F909B58C301EC0FF8629A31AC756E447D7A0AEA3224E8458EC5933CDDD299B482A27E4C3A75A4C52C0EA530D800A41E23F0177593F62497E747F232ED15621E8D33&sign=95361a5da5f3525fda24de164e7e4c32";
        //请求数据：{"timestamp":"1608168158","data":"0EB44C7F3C20A63808D6C2237D6F1A5FC64F2074D08F8339CC26C74A171D29D99EDCE37EA377AEF95DAAE144EEC5D2907CE60C6724D4CE7751CD5AC3E0A1DD2E660569119668F5FD99EFAD456420514C1EF468C140863C3E534A7B2A20E3D3C27368D51DEE062D5E516172138FCD6F1C1CFF93303CC44F8152F16D5BA8E0371AA1E99ED0DC0422AFFCBD8C3ACFE9DEC16600ED07DAB335633573043BCDF8646CE5B8A957F0118442263F78D9712267BD52CE5B168FEE0A299DC43B2BB97CA1C0AC9E6F264ADE613C49745FD93B66DB7042AE637B","sign":"b06de0c84338c7fa9fa741e1d74c9644"}
        String salt = "132f1537f85sjdpcm59f7e318b9epa51";
//        String timestamp = "1608168158";
//        String data = "0EB44C7F3C20A63808D6C2237D6F1A5FC64F2074D08F8339CC26C74A171D29D99EDCE37EA377AEF95DAAE144EEC5D2907CE60C6724D4CE7751CD5AC3E0A1DD2E660569119668F5FD99EFAD456420514C1EF468C140863C3E534A7B2A20E3D3C27368D51DEE062D5E516172138FCD6F1C1CFF93303CC44F8152F16D5BA8E0371AA1E99ED0DC0422AFFCBD8C3ACFE9DEC16600ED07DAB335633573043BCDF8646CE5B8A957F0118442263F78D9712267BD52CE5B168FEE0A299DC43B2BB97CA1C0AC9E6F264ADE613C49745FD93B66DB7042AE637B";

        String originalStr = "data=" + data + "&timestamp=" + timestamp + salt;
        String sign = md5(sha256(originalStr));
        System.out.println("sign: " + sign);
        return param[0]+"&"+param[1]+"&sign="+sign;
    }

    public static String sha256(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("UTF-8"));
            return byte2Str(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return "";
        }
    }


    public static String md5(String str) {
        try {
            return byte2Str(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }


    private static String byte2Str(byte[] bArr) {
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
