package servlet;

import java.io.IOException;

import dao.MedicineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MedicineRegister") // 新規アカウント登録
public class MedicineRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// フォームから送信されたデータを取得
			String medicinenameInput = request.getParameter("name");
			String typeInput = request.getParameter("type");
			
		    // ログ出力
		    System.out.println("Received name: " + medicinenameInput);
		    System.out.println("Received type: " + typeInput);
		    
		 // MedicinestypeDAOを使用してデータベースに新しいアカウントを登録
			MedicineDAO medicineDAO = new MedicineDAO();
			boolean success = medicineDAO.registerMedicine(medicinenameInput, typeInput);

		    // ログ出力
		    System.out.println("Registration success: " + success);
		    
			// 登録の結果に応じて適切なページにリダイレクト	
			if (success) {
	            // リクエストの属性を保持したまま、main.jsp にフォワード
	            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
	            dispatcher.forward(request, response);
				} else {
				response.sendRedirect("medicine-register.jsp.jsp");
				}
		}
	}
