package com.example.qlct.model;

public class ChiTieu {
    private int MaChiTieu;
    private double SoTien;
    private int MaVi;
    private int MaLoaiChiTieu;
    private String ThoiGianCT;
    private String GhiChu;
    private int isDeleted;

    public ChiTieu(int maChiTieu, double soTien, int maVi, int maLoaiChiTieu, String thoiGianCT, String ghiChu) {
        MaChiTieu = maChiTieu;
        SoTien = soTien;
        MaVi = maVi;
        MaLoaiChiTieu = maLoaiChiTieu;
        ThoiGianCT = thoiGianCT;
        GhiChu = ghiChu;
        isDeleted = 1;
    }

    public int getMaChiTieu() {
        return MaChiTieu;
    }

    public void setMaChiTieu(int maChiTieu) {
        MaChiTieu = maChiTieu;
    }

    public double getSoTien() {
        return SoTien;
    }

    public void setSoTien(double soTien) {
        SoTien = soTien;
    }

    public int getMaVi() {
        return MaVi;
    }

    public void setMaVi(int maVi) {
        MaVi = maVi;
    }

    public int getMaLoaiChiTieu() {
        return MaLoaiChiTieu;
    }

    public void setMaLoaiChiTieu(int maLoaiChiTieu) {
        MaLoaiChiTieu = maLoaiChiTieu;
    }

    public String getThoiGianCT() {
        return ThoiGianCT;
    }

    public void setThoiGianCT(String thoiGianCT) {
        ThoiGianCT = thoiGianCT;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
