package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ImageUtil;

@WebServlet("/getRandomImagePath")  // エンドポイントのマッピング
public class RandomImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Content-Typeを設定
        response.setContentType("text/plain");
        
        // ランダムな画像パスを取得
        String imagePath = ImageUtil.getRandomImagePath();
        
        // レスポンスに画像パスを書き込み
        PrintWriter out = response.getWriter();
        out.print(imagePath);
    }
}
