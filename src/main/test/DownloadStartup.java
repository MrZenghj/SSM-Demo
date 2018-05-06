import java.net.MalformedURLException;

public class DownloadStartup {
    private static final String encoding = "utf-8";
    public static void main(String[] args) throws MalformedURLException {

        DownloadTask downloadManager = new DownloadTask();
        String urlStr = "http://dldir1.qq.com/weixin/Windows/WeChatSetup.exe";

        downloadManager.setSleepSeconds(5);
        String downladFileName = downloadManager.download(urlStr, encoding);
        System.out.println("Download file is " + downladFileName + ".");
    }
}
