/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cosplay.tiket.model;

/**
 *
 * @author ASUS
 */
public class Ticket {
    // === Properties (>=3) ===
    private int id;           // ID tiket (auto increment)
    private String name;      // Nama pembeli
    private String date;      // Tanggal pembelian (string sederhana)
    private String type;      // Jenis tiket (contoh: Reguler/VIP)
    private String status;    // Status (contoh: Sudah Masuk/Belum Masuk)

    // === Constructor ===
    public Ticket(int id, String name, String date, String type, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    // === Getters & Setters (Access Modifiers: public) ===
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // === Representasi teks saat ditampilkan ===
    @Override
    public String toString() {
        return String.format("ID:%d | Nama:%s | Tanggal:%s | Jenis:%s | Status:%s",
                id, name, date, type, status);
    }
}
