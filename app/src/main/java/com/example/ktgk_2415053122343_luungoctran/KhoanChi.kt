package com.example.ktgk_2415053122343_luungoctran


data class KhoanChi(
    val maKhoanChi: String,
    var tenKhoanChi: String,
    var soTien: Double,
    var ghiChu: String,
    var daThanhToan: Boolean = false
) {

    fun layThongTin_343(): String {
        val trangThai_343 =
            if (daThanhToan) "Da thanh toan"
            else "Chua thanh toan"

        return """
            Ma khoan chi: $maKhoanChi
            Ten khoan chi: $tenKhoanChi
            So tien: $soTien VNĐ
            Ghi chu: ${ghiChu.ifBlank { "Khong co" }}
            Trang thai: $trangThai_343
        """.trimIndent()
    }

    fun laSoTienHopLe_343(): Boolean {
        return soTien.isFinite() && soTien > 0
    }
}