package servlet;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AccountRegister") // 新規アカウント登録
public class AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
			// フォームから送信されたデータを取得
			String usernameInput = request.getParameter("name");
			String passwordInput = request.getParameter("pass");
			
		    // ログ出力
		    System.out.println("Received name: " + usernameInput);
		    System.out.println("Received pass: " + passwordInput);
		
		    
		    //名前の重複チェック
			AccountDAO accountDAO = new AccountDAO();
			if (accountDAO.isUsernameExists(usernameInput)) {
	            // 名前が重複している場合はエラーメッセージを表示して登録を中止
	            request.setAttribute("errorMessage", "既に存在する名前です。別の名前を使用してください。");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
	            dispatcher.forward(request, response);
	            return;
	        }
			
			// AccountDAOを使用してデータベースに新しいアカウントを登録
			boolean success = accountDAO.registerAccount(usernameInput, passwordInput);

		    // ログ出力
		    System.out.println("Registration success: " + success);
			
			// 登録の結果に応じて適切なページにリダイレクト	
			if (success) {
	            // リクエストの属性を保持したまま、register-success.jsp にフォワード
	            RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	            dispatcher.forward(request, response);
				} else {
				response.sendRedirect("register.jsp");
				}
		}
	}

