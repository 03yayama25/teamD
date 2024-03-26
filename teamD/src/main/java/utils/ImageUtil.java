package utils;

import java.util.ArrayList;
import java.util.List;

/* ImageUtilクラスは、他のクラスからアクセス可能 */
public class ImageUtil {
    /* 画像のパスを格納するリスト */
    private static final List<String> imagePaths = new ArrayList<>();

    static {
        // 画像の枚数
        int numImages = 10;

        // 画像ファイル名の形式
        String imagePathFormat = "/img/%d.jpg";

        // 画像のパスを追加
        for (int i = 1; i <= numImages; i++) {
            String imagePath = String.format(imagePathFormat, i);
            imagePaths.add(imagePath);
        }
    }

    /* getRandomImagePathメソッドは、リストからランダムな画像パスを選択して返す */
    public static String getRandomImagePath() {
        // ランダムに画像のパスを選択
        int index = (int) (Math.random() * imagePaths.size());
        return imagePaths.get(index);
    }
}
