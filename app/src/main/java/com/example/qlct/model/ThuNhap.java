package com.example.qlct.model;

public class ThuNhap {
    private int MaThuNhap;
    private double SoTien;
    private int MaVi;
    private String ThoiGianTN;
    private String GhiChu;
    private int isDeleted;

    public ThuNhap(int maThuNhap, double soTien, int maVi, String thoiGianTN, String ghiChu) {
        MaThuNhap = maThuNhap;
        SoTien = soTien;
        MaVi = maVi;
        ThoiGianTN = thoiGianTN;
        GhiChu = ghiChu;
        isDeleted = 1;
    }

    public int getMaThuNhap() {
        return MaThuNhap;
    }

    public void setMaThuNhap(int maThuNhap) {
        MaThuNhap = maThuNhap;
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

    public String getThoiGianTN() {
        return ThoiGianTN;
    }

    public void setThoiGianTN(String thoiGianTN) {
        ThoiGianTN = thoiGianTN;
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
