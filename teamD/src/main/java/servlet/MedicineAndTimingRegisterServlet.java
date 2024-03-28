package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MedicineDAO;
import dao.MedicineTimingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicine;
import model.MedicineTiming;

@WebServlet("/MedicineAndTimingRegister")
public class MedicineAndTimingRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ユーザーIDと薬の情報を取得
        int userId = (int) request.getSession().getAttribute("userId");
        String medicineName = request.getParameter("name");
        String type = request.getParameter("type");
        String[] timings = request.getParameterValues("timing");

        // 薬の情報をデータベースに登録
        MedicineDAO medicineDAO = new MedicineDAO();
        int medicineId;
        try {
            Medicine medicine = new Medicine(0, userId, medicineName, type);
            medicineId = medicineDAO.addMedicine(medicine);
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーが発生した場合の処理
            response.sendRedirect("error.jsp");
            return;
        }


        // ここでMedicineTimingDAOのインスタンスを作成して、薬のタイミングをデータベースに登録
        MedicineTimingDAO timingDAO = new MedicineTimingDAO();
        List<MedicineTiming> medicineTimings = new ArrayList<>();
        for (String timing : timings) {
            MedicineTiming medicineTiming = new MedicineTiming(0, medicineId, timing);
            medicineTimings.add(medicineTiming);
        }
        try {
            timingDAO.addMedicineTimings(medicineTimings);
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーが発生した場合の処理
            response.sendRedirect("error.jsp");
            return;
        }

        // 登録完了後、メインページにリダイレクト
        response.sendRedirect("main.jsp");
    }
}
