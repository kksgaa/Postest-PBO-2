/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cosplay.tiket.service;

import cosplay.tiket.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private final List<Ticket> data = new ArrayList<>();
    private int autoId = 1;

    // === Validasi sederhana (nilai tidak boleh kosong) ===
    private String mustNotBlank(String label, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(label + " tidak boleh kosong.");
        }
        return value.trim();
    }

    // === CREATE ===
    public Ticket add(String name, String date, String type, String status) {
        String n = mustNotBlank("Nama", name);
        String d = mustNotBlank("Tanggal", date);
        String t = mustNotBlank("Jenis tiket", type);
        String s = mustNotBlank("Status", status);

        Ticket ticket = new Ticket(autoId++, n, d, t, s);
        data.add(ticket);
        return ticket;
    }

    // === READ (list semua) ===
    public List<Ticket> list() {
        return new ArrayList<>(data); // return copy agar aman
    }

    // === READ (cari by ID) ===
    public Ticket findById(int id) {
        for (Ticket t : data) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    // === UPDATE (hanya update field yang tidak kosong) ===
    public boolean update(int id, String name, String date, String type, String status) {
        Ticket t = findById(id);
        if (t == null) return false;

        if (name != null && !name.isBlank())   t.setName(name.trim());
        if (date != null && !date.isBlank())   t.setDate(date.trim());
        if (type != null && !type.isBlank())   t.setType(type.trim());
        if (status != null && !status.isBlank()) t.setStatus(status.trim());
        return true;
    }

    // === DELETE ===
    public boolean delete(int id) {
        Ticket t = findById(id);
        if (t == null) return false;
        return data.remove(t);
    }

    // === SEARCH (by keyword di nama / jenis / status / tanggal) ===
    public List<Ticket> search(String keyword) {
        List<Ticket> result = new ArrayList<>();
        if (keyword == null) return result;
        String key = keyword.toLowerCase().trim();

        for (Ticket t : data) {
            if (String.valueOf(t.getId()).contains(key)
                    || t.getName().toLowerCase().contains(key)
                    || t.getDate().toLowerCase().contains(key)
                    || t.getType().toLowerCase().contains(key)
                    || t.getStatus().toLowerCase().contains(key)) {
                result.add(t);
            }
        }
        return result;
    }

    // === Util: apakah kosong? ===
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
}
