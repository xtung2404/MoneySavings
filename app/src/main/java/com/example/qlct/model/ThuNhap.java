package com.example.qlct.model;

import java.util.Date;

public class ThuNhap {
    private  int MaThuNhap;
    private double SoTien;
    private  String MaVi;
    private Date ThoiGianTN;
    private String GhiChu;

    public ThuNhap(int maThuNhap, double soTien, String maVi, Date thoiGianTN, String ghiChu) {
        MaThuNhap = maThuNhap;
        SoTien = soTien;
        MaVi = maVi;
        ThoiGianTN = thoiGianTN;
        GhiChu = ghiChu;
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

    public String getMaVi() {
        return MaVi;
    }

    public void setMaVi(String maVi) {
        MaVi = maVi;
    }

    public Date getThoiGianTN() {
        return ThoiGianTN;
    }

    public void setThoiGianTN(Date thoiGianTN) {
        ThoiGianTN = thoiGianTN;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
