package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.MedicineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicine;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションからユーザーIDを取得
        int userId = (int) request.getSession().getAttribute("userId");

        // ユーザーIDを使用して薬の情報を取得
        MedicineDAO medicineDAO = new MedicineDAO();
        try {
            List<Medicine> medicines = medicineDAO.getUserMedicines(userId);
            // リクエストスコープに薬の情報をセット
            request.setAttribute("medicines", medicines);

            // main.jspにフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーが発生した場合の処理
            response.sendRedirect("error.jsp");
        }
    }
}
