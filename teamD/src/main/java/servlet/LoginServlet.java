package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// リクエストパラメーターの取得
		String usernameInput = request.getParameter("name");
		String passwordInput = request.getParameter("pass");
		
		//LoginDAOインスタンス作成し、データベース接続
		LoginDAO loginDAO = new LoginDAO();
		try(Connection conn = loginDAO.getConnection()){
			//SQLクエリを準備
			String sql = "SELECT * FROM accounts WHERE name = ? AND pass = ?";
			try (PreparedStatement statement = conn.prepareStatement(sql)) {
	                statement.setString(1, usernameInput);
	                statement.setString(2, passwordInput);
	                
	             // クエリを実行して結果を取得
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                        // ログイン成功時の処理
	                        response.sendRedirect("main.jsp"); // ログイン成功時に welcome.jsp にリダイレクト
	                    } else {
	                        // ログイン失敗時の処理
	                        response.sendRedirect("index.jsp?errorMessage=名前またはパスワードが正しくありません。"); 
	                        // ログイン失敗時に index.jsp にリダイレクトし、エラーメッセージを付加
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            // データベースエラー時の処理
	            e.printStackTrace();
	            response.sendRedirect("index.jsp?errorMessage=データベースエラーが発生しました。");
	        }
	    }			
	}

