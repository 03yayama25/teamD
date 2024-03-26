package servlet;

import java.io.IOException;
import java.util.List;

import dao.MedicineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicine;

@WebServlet("/MedicineTiming")
public class MedicineTimingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ログインユーザーのIDを取得（セッションやリクエストパラメーターから）
        int userId = 1; // 仮のユーザーID（実際のシステムでは適切な方法で取得する）

        // 朝の服薬情報を取得
        List<Medicine> morningMedicines = MedicineDAO.getMorningMedicines(userId);

        // 昼の服薬情報を取得
        List<Medicine> noonMedicines = MedicineDAO.getNoonMedicines(userId);

        // 晩の服薬情報を取得
        List<Medicine> eveningMedicines = MedicineDAO.getEveningMedicines(userId);

        // リクエストスコープに服薬情報をセット
        request.setAttribute("morningMedicines", morningMedicines);
        request.setAttribute("noonMedicines", noonMedicines);
        request.setAttribute("eveningMedicines", eveningMedicines);

        // main.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
