package com.example.ktgk_2415053122343_luungoctran
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvTenKhoanChi_343: TextView
    private lateinit var tvSoTien_343: TextView
    private lateinit var tvGhiChu_343: TextView
    private lateinit var tvTrangThai_343: TextView

    private var ten_343 = ""
    private var tien_343 = 0.0
    private var ghiChu_343 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        tvTenKhoanChi_343 = findViewById(R.id.tvTenKhoanChi)
        tvSoTien_343 = findViewById(R.id.tvSoTien)
        tvGhiChu_343 = findViewById(R.id.tvGhiChu)
        tvTrangThai_343 = findViewById(R.id.tvTrangThai)

        ten_343 = intent.getStringExtra("TEN_KHOAN_CHI") ?: ""
        tien_343 = intent.getDoubleExtra("SO_TIEN", -1.0)
        ghiChu_343 = intent.getStringExtra("GHI_CHU") ?: ""

        if (ten_343.isBlank() ||
            !tien_343.isFinite() ||
            tien_343 <= 0
        ) {
            Toast.makeText(
                this,
                "Du lieu khoan chi khong hop le",
                Toast.LENGTH_LONG
            ).show()
            finish()
            return
        }

        hienThiKhoanChi_343()

        findViewById<Button>(R.id.btnQuayLai).setOnClickListener {
            finish()
        }
    }

    private fun hienThiKhoanChi_343() {
        tvTenKhoanChi_343.text = "Ten khoan chi: $ten_343"
        tvSoTien_343.text = "So tien: ${tien_343} VNĐ"
        tvGhiChu_343.text =
            "Ghi chu: ${ghiChu_343.ifBlank { "Khong co" }}"
        tvTrangThai_343.text = "Trang thai: Chua thanh toan"
    }
}