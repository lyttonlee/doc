package cool.lytton.doc.util;

import com.qiniu.util.Auth;

public class QiniuUtil {
    private static String AK = "YOXpF0XvM_3yVDsz5C-hWwrFE5rtDAUQC3XjBQEG";
    private static String SK = "CmrhUV2xHf1d8nPCsws9wwm7jKypCPA0lRVm-7lS";
    private static String bucket = "test-editor";

    public static String createToken() {
        try {
            Auth auth = Auth.create(AK, SK);
            String upToken = auth.uploadToken(bucket);
            return upToken;
        } catch (Exception err) {
            return null;
        }

    }
}
