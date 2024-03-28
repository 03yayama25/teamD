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
import jakarta.servlet.http.HttpSession;
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
                HttpSession session = request.getSession();
                int userId = loginDAO.getUserId(usernameInput, passwordInput);
                session.setAttribute("userId", userId);
                session.setAttribute("name", usernameInput);
                //セッション保存されているかコンソールで確認
                System.out.println("ユーザーID: " + userId); // コンソールにユーザーIDを出力
                System.out.println("名前: " + usernameInput); // コンソールに名前を出力

                // メインページにリダイレクト
                response.sendRedirect("main.jsp");
            } else {
                // ログイン失敗時の処理
                request.setAttribute("errorMessage", "名前またはパスワードが正しくありません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // エラーが発生した場合の処理
            e.printStackTrace();
            response.sendRedirect("error.jsp");
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
*/