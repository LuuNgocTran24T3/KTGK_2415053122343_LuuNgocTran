
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415053122343_luungoctran.R

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvTenKhoanChi_456: TextView
    private lateinit var tvSoTien_456: TextView
    private lateinit var tvGhiChu_456: TextView
    private lateinit var tvTrangThai_456: TextView

    private var ten_456 = ""
    private var tien_456 = 0.0
    private var ghiChu_456 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        tvTenKhoanChi_456 = findViewById(R.id.tvTenKhoanChi)
        tvSoTien_456 = findViewById(R.id.tvSoTien)
        tvGhiChu_456 = findViewById(R.id.tvGhiChu)
        tvTrangThai_456 = findViewById(R.id.tvTrangThai)

        ten_456 = intent.getStringExtra("TEN_KHOAN_CHI") ?: ""
        tien_456 = intent.getDoubleExtra("SO_TIEN", -1.0)
        ghiChu_456 = intent.getStringExtra("GHI_CHU") ?: ""

        if (ten_456.isBlank() ||
            !tien_456.isFinite() ||
            tien_456 <= 0
        ) {
            Toast.makeText(
                this,
                "Du lieu khoan chi khong hop le",
                Toast.LENGTH_LONG
            ).show()
            finish()
            return
        }

        hienThiKhoanChi_456()

        findViewById<Button>(R.id.btnQuayLai).setOnClickListener {
            finish()
        }
    }

    private fun hienThiKhoanChi_456() {
        tvTenKhoanChi_456.text = "Ten khoan chi: $ten_456"
        tvSoTien_456.text = "So tien: ${tien_456} VNĐ"
        tvGhiChu_456.text =
            "Ghi chu: ${ghiChu_456.ifBlank { "Khong co" }}"
        tvTrangThai_456.text = "Trang thai: Chua thanh toan"
    }
}