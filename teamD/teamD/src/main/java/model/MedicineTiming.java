package model;

public class MedicineTiming {
    private int id;
    private int medicineId;
    private String timing;

    // コンストラクタ
    public MedicineTiming(int id, int medicineId, String timing) {
        this.id = id;
        this.medicineId = medicineId;
        this.timing = timing;
    }
    

    // IDのgetterメソッド
    public int getId() {
        return id;
    }

    // IDのsetterメソッド
    public void setId(int id) {
        this.id = id;
    }

    // お薬IDのgetterメソッド
    public int getMedicineId() {
        return medicineId;
    }

    // お薬IDのsetterメソッド
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    // タイミングのgetterメソッド
    public String getTiming() {
        return timing;
    }

    // タイミングのsetterメソッド
    public void setTiming(String timing) {
        this.timing = timing;
    }
}
