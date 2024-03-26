package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメーターの取得
        String usernameInput = request.getParameter("name");
        String passwordInput = request.getParameter("pass");

        try (Connection conn = DBUtil.getConnection()) {
            // LoginDAOインスタンス作成
            LoginDAO loginDAO = new LoginDAO();

            // ログインをチェック
            boolean success = loginDAO.checkLogin(usernameInput, passwordInput);

            if (success) {
                // ログイン成功時の処理
                // ユーザー名をセッションに保存
                request.getSession().setAttribute("name", usernameInput);
                // メインページにリダイレクト
                response.sendRedirect("main.jsp");// ログイン成功時に main.jsp にリダイレクト(実装前はこっち)
                // MedicineTimingServletにリダイレクトする(いろいろ実装したらここ変更！！)
                //response.sendRedirect(request.getContextPath() + "/MedicineTiming");
            } else {
                // ログイン失敗時の処理
                request.setAttribute("errorMessage", "名前またはパスワードが正しくありません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // エラーが発生した場合の処理
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // エラーページにリダイレクト
        }
    }
}

/* 
@WebServlet("/Login")
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
                boolean success;
                try (ResultSet resultSet = statement.executeQuery()) {
                		success = resultSet.next(); //結果が存在するかどうかを取得
                }
                
                    if (success) {
                        // ログイン成功時の処理
                    	// ユーザー名をセッションに保存
                        request.getSession().setAttribute("name", usernameInput);
                     // MedicineTimingServletにリダイレクトする(いろいろ実装したらここ変更！！)
                        //response.sendRedirect(request.getContextPath() + "/MedicineTiming");
                        
                        response.sendRedirect("main.jsp"); // ログイン成功時に main.jsp にリダイレクト(実装前はこっち)
                    } else {
                        // ログイン失敗時の処理
                        request.setAttribute("errorMessage", "名前またはパスワードが正しくありません。");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
                        // ログイン失敗時に index.jsp にフォワードし、エラーメッセージをリクエストスコープにセット
                    }
                }
        	} catch (SQLException e) {
            // エラーが発生した場合の処理
        		e.printStackTrace();
        		response.sendRedirect("error.jsp"); // エラーページにリダイレクト
        	}
    	}
	}
	*/
