/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cosplay.tiket.main;

import cosplay.tiket.model.Ticket;
import cosplay.tiket.service.TicketService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TicketService service = new TicketService();

        while (true) {
            menu();
            int pilih = readInt(in, "Pilih menu [1-6]: ");
            switch (pilih) {
                case 1 -> doAdd(in, service);
                case 2 -> doList(service);
                case 3 -> doUpdate(in, service);
                case 4 -> doDelete(in, service);
                case 5 -> doSearch(in, service);
                case 6 -> {
                    System.out.println("Selesai. Terima kasih!");
                    return;
                }
                default -> System.out.println("Menu tidak dikenal.");
            }
            System.out.println();
        }
    }

    private static void menu() {
        System.out.println("=== Manajemen Tiket Event Cosplay ===");
        System.out.println("1. Tambah Tiket");
        System.out.println("2. Tampilkan Semua Tiket");
        System.out.println("3. Ubah Data Tiket");
        System.out.println("4. Hapus Tiket");
        System.out.println("5. Cari (Search)");
        System.out.println("6. Keluar");
    }

    // ================== View/Controller helpers ==================

    private static void doAdd(Scanner in, TicketService service) {
        System.out.println("== Tambah Tiket ==");
        System.out.print("Nama pembeli: ");
        String name = in.nextLine();
        System.out.print("Tanggal beli: ");
        String date = in.nextLine();
        System.out.print("Jenis tiket: ");
        String type = in.nextLine();
        System.out.print("Status tiket: ");
        String status = in.nextLine();

        try {
            Ticket t = service.add(name, date, type, status);
            System.out.println("Tiket berhasil ditambahkan. " + t);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambah tiket: " + e.getMessage());
        }
    }

    private static void doList(TicketService service) {
        System.out.println("== Daftar Tiket ==");
        List<Ticket> all = service.list();
        if (all.isEmpty()) {
            System.out.println("(Data tiket kosong)");
            return;
        }
        for (Ticket t : all) {
            System.out.println(t);
        }
    }

    private static void doUpdate(Scanner in, TicketService service) {
        System.out.println("== Ubah Tiket ==");
        if (service.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }
        doList(service);
        int id = readInt(in, "Masukkan ID tiket yang diubah: ");

        Ticket existing = service.findById(id);
        if (existing == null) {
            System.out.println("ID tidak ditemukan.");
            return;
        }

        System.out.println("Kosongkan input untuk mempertahankan nilai lama.");
        System.out.print("Nama baru [" + existing.getName() + "]: ");
        String name = in.nextLine();
        System.out.print("Tanggal baru [" + existing.getDate() + "]: ");
        String date = in.nextLine();
        System.out.print("Jenis tiket baru [" + existing.getType() + "]: ");
        String type = in.nextLine();
        System.out.print("Status baru [" + existing.getStatus() + "]: ");
        String status = in.nextLine();

        boolean ok = service.update(id, name, date, type, status);
        System.out.println(ok ? "Data tiket berhasil diperbarui." : "Gagal memperbarui data.");
    }

    private static void doDelete(Scanner in, TicketService service) {
        System.out.println("== Hapus Tiket ==");
        if (service.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }
        doList(service);
        int id = readInt(in, "Masukkan ID tiket yang dihapus: ");
        boolean ok = service.delete(id);
        System.out.println(ok ? "Tiket berhasil dihapus." : "ID tidak ditemukan.");
    }

    private static void doSearch(Scanner in, TicketService service) {
        System.out.println("== Pencarian Tiket ==");
        System.out.print("Masukkan kata kunci (id/nama/tanggal/jenis/status): ");
        String key = in.nextLine();
        List<Ticket> result = service.search(key);
        if (result.isEmpty()) {
            System.out.println("Tidak ada data yang cocok.");
            return;
        }
        for (Ticket t : result) {
            System.out.println(t);
        }
    }

    // ================== Input utils ==================
    private static int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka. Coba lagi.");
            }
        }
    }
}
