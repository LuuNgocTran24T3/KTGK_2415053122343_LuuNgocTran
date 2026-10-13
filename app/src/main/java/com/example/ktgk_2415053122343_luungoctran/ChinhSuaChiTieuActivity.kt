package com.example.ktgk_2415053122343_luungoctran
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var ten_343: EditText
    private lateinit var tien_343: EditText
    private lateinit var ghiChu_343: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        ten_343 = findViewById(R.id.editSuaTenKhoanChi)
        tien_343 = findViewById(R.id.editSuaSoTien)
        ghiChu_343 = findViewById(R.id.editSuaGhiChu)

        ten_343.setText(intent.getStringExtra("TEN_KHOAN_CHI") ?: "")
        tien_343.setText(
            intent.getDoubleExtra("SO_TIEN", 0.0).toString()
        )
        ghiChu_343.setText(intent.getStringExtra("GHI_CHU") ?: "")

        findViewById<Button>(R.id.btnLuuChinhSua).setOnClickListener {
            val tenMoi_343 = ten_343.text.toString().trim()
            val tienChuoi_343 = tien_343.text.toString().trim()
            val tienMoi_343 = tienChuoi_343.toDoubleOrNull()

            if (tenMoi_343.isBlank()) {
                ten_343.error = "Ten khong duoc de trong"
                return@setOnClickListener
            }

            if (tienMoi_343 == null ||
                !tienMoi_343.isFinite() ||
                tienMoi_343 <= 0
            ) {
                tien_343.error = "So tien khong hop le"
                return@setOnClickListener
            }

            val ketQua_343 = intent.apply {
                putExtra("TEN_KHOAN_CHI", tenMoi_343)
                putExtra("SO_TIEN", tienMoi_343)
                putExtra(
                    "GHI_CHU",
                    ghiChu_343.text.toString().trim()
                )
            }

            setResult(RESULT_OK, ketQua_343)
            finish()
        }

        findViewById<Button>(R.id.btnHuyChinhSua).setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}