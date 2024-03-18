package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメーターの取得
        String usernameInput = request.getParameter("name");
        String passwordInput = request.getParameter("pass");

        // LoginDAOインスタンス作成し、データベース接続
        LoginDAO loginDAO = new LoginDAO();
        try (Connection conn = loginDAO.getConnection()) {
            // SQLクエリを準備
            String sql = "SELECT * FROM accounts WHERE name = ? AND pass = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, usernameInput);
                statement.setString(2, passwordInput);

                // クエリを実行して結果を取得
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // ログイン成功時の処理
                        response.sendRedirect("main.jsp"); // ログイン成功時に main.jsp にリダイレクト
                        return; // リダイレクト後に処理を終了
                    } else {
                        // ログイン失敗時の処理
                        request.setAttribute("errorMessage", "名前またはパスワードが正しくありません。");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
                        // ログイン失敗時に index.jsp にフォワードし、エラーメッセージをリクエストスコープにセット
                        return; // フォワード後に処理を終了
                    }
                }
            }
        } catch (SQLException e) {
            // エラーが発生した場合の処理
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // エラーページにリダイレクト
        }
    }
}
