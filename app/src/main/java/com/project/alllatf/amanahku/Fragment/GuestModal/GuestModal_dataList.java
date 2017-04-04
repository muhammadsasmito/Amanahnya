package com.project.alllatf.amanahku.Fragment.GuestModal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fachrul on 3/21/17.
 */

public class GuestModal_dataList {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail =
                new HashMap<>();

        List<String> persyaratan = new ArrayList<>();
        persyaratan.add("1.\tWarga negara republik indonesia yang berumur 18 tahun keatas.");
        persyaratan.add("2.\tBerdomisili di yogyakarta");
        persyaratan.add("3.\tSangup mentaati semua peraturan yang ditetapkan");
        persyaratan.add("4.\tSanggup berkomitmen untuk melakukn pembayaran sampai lunas");
        persyaratan.add("5.\tMampu menjaga kepercayaan antar pihak");

        List<String> fitur = new ArrayList<>();
        fitur.add("1.\tPemesanan barang");
        fitur.add("2.\tDetail barang dan status pemesanan");
        fitur.add("3.\tTimeline dan pengingat jadwal");
        fitur.add("4.\tEdukasi hukum transaksi syariah");


        List<String> keuntungan = new ArrayList<>();
        keuntungan.add("1.\tAlur kerja sesuai dengan kaidah syariah dan peraturan yang berlaku");
        keuntungan.add("2.\tCicilan menjadi ringan karena ditentukan oleh pengguna sendiri.");
        keuntungan.add("3.\tAkad yang aman, jelas dan halal.");
        keuntungan.add("4.\tProses transaksi tercatat dengan baik");
        keuntungan.add("5.\tProses transaksi akan tepat pada aktunya");


        List<String> hukum = new ArrayList<>();
        hukum.add("1)\tLarangan Riba \n “...Allah telah menghalalkan pada jual beli dan mengharamkan pada riba....” (Surat Al-Baqarah : 275)\n");
        hukum.add("2)\tKebencian riba\n" +
                " “Allah memusnahkan riba dan menyuburkan sedekah. Dan Allah SWT tidak menyukai setiap orang yang tetap dalam kekafiran dan selalu berbuat dosa. ” (Surat Albaqoroh : 276).\n");
        hukum.add("3)\tAkibat riba\n" +
                "-\tSiksaan yang pedih\n" +
                "1)\t “Dan disebabkan karena mereka memakan riba, padahal seseungguhnya mereka telah dilarang daripadanya, da karena mereka memakan hrta orang dengan cara jalan yang batil. Kami telah menyediakan untuk orang-orang kafir diantara merekan itu dengan siksa yang pedih.” (Q.S. An\u00ADNisa: 161)\n" +
                "2)\t“Orang-orang yang makan(mengambil) riba, tidak dapat berdiri melainkan seperti berdirinya orang yang kemasukan setan lantaran(tekanan) penyakit gila....” (Surat Albaqoroh : 275 \n" +
                "-\tMendapat laknat dari Alloh SWT\n" +
                "“Alloh melaknat pemakan riba, orang yang memberi makan dengan riba, dua orang saksinya dan penulisnya juga . (HR penulis sunan, At Tirmidzi)\n");



        expandableListDetail.put("Fitur", fitur);
        expandableListDetail.put("Keuntungan", keuntungan);
        expandableListDetail.put("Persyaratan", persyaratan);
        expandableListDetail.put("Penjelasan Hukum", hukum);

        return expandableListDetail;
    }
}
