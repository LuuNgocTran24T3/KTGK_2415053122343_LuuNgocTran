package com.example.ktgk_2415053122343_luungoctran
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tenKhoanChi_343: EditText
    private lateinit var soTien_343: EditText
    private lateinit var ghiChu_343: EditText
    private lateinit var btnThemKhoanChi_343: Button
    private lateinit var btnXemChiTiet_343: Button

    private var tenDaNhap_343 = ""
    private var tienDaNhap_343 = ""
    private var ghiChuDaNhap_343 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Luu Ngoc Tran - 2415053122343 - Quan ly chi tieu ca nhan"

        tenKhoanChi_343 = findViewById(R.id.editTenKhoanChi)
        soTien_343 = findViewById(R.id.editSoTien)
        ghiChu_343 = findViewById(R.id.editGhiChu)
        btnThemKhoanChi_343 = findViewById(R.id.btnThemKhoanChi)
        btnXemChiTiet_343 = findViewById(R.id.btnXemChiTiet)

        btnThemKhoanChi_343.setOnClickListener {
            themKhoanChi_343()
        }

        btnXemChiTiet_343.setOnClickListener {
            Toast.makeText(
                this,
                "Chuc nang chi tiet se duoc hoan thien o Cau 2",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun themKhoanChi_343() {
        val ten_343 = tenKhoanChi_343.text.toString().trim()
        val tienChuoi_343 = soTien_343.text.toString().trim()
        val ghiChuMoi_343 = ghiChu_343.text.toString().trim()

        if (ten_343.isEmpty()) {
            tenKhoanChi_343.error = "Vui long nhap ten khoan chi"
            tenKhoanChi_343.requestFocus()
            return
        }

        val tien_343 = tienChuoi_343.toDoubleOrNull()

        if (tien_343 == null || !tien_343.isFinite() || tien_343 <= 0) {
            soTien_343.error = "So tien phai lon hon 0"
            soTien_343.requestFocus()
            return
        }

        tenDaNhap_343 = ten_343
        tienDaNhap_343 = tienChuoi_343
        ghiChuDaNhap_343 = ghiChuMoi_343

        Toast.makeText(
            this,
            "Them khoan chi thanh cong",
            Toast.LENGTH_SHORT
        ).show()
    }
}