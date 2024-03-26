package utils;

import java.util.ArrayList;
import java.util.List;

/* クラスImageUtil 他のクラスからアクセス可能 */
public class ImageUtil {  
	/* 配列imagePaths(String型) 配列にimgフォルダの画像ファイルのパスを保持 */ 
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
    
    /* 旧コード ここから
    private static final String[] imagePaths = {
        "/img/1.jpg",
        "/img/2.jpg",
        "/img/3.jpg",
        "/img/4.jpg",
        // 画像の追加
    };
    ここまで */
    
    

    /* メソッドgetRandomImagePath 配列imagePathsからランダムな画像パスを選択して返す */
    public static String getRandomImagePath() {
        // ランダムに画像のパスを選択
        int index = (int) (Math.random() * imagePaths.size());
        return imagePaths.get(index);
    }
}

	/* 旧コード ここから
    public static String getRandomImagePath() {
        Random random = new Random();
        int index = random.nextInt(imagePaths.length);
        return imagePaths[index];
    }
}
ここまで */
