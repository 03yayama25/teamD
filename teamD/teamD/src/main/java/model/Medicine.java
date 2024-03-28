package model;

import java.util.List;

public class Medicine {
    private int id;
    private int userId;
    private String name;
    private String type;
    private List<MedicineTiming> timings; // タイミング情報を保持するリスト

    // デフォルトコンストラクタ
    public Medicine() {
    }

    // コンストラクタ
    public Medicine(int id, int userId, String name, String type) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
    }

    // IDのgetterメソッド
    public int getId() {
        return id;
    }

    // IDのsetterメソッド
    public void setId(int id) {
        this.id = id;
    }

    // ユーザーIDのgetterメソッド
    public int getUserId() {
        return userId;
    }

    // ユーザーIDのsetterメソッド
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // お薬の名前のgetterメソッド
    public String getName() {
        return name;
    }

    // お薬の名前のsetterメソッド
    public void setName(String name) {
        this.name = name;
    }

    // お薬の種類のgetterメソッド
    public String getType() {
        return type;
    }

    // お薬の種類のsetterメソッド
    public void setType(String type) {
        this.type = type;
    }

    // タイミング情報のgetterメソッド
    public List<MedicineTiming> getTimings() {
        return timings;
    }

    // タイミング情報のsetterメソッド
    public void setTimings(List<MedicineTiming> timings) {
        this.timings = timings;
    }
}