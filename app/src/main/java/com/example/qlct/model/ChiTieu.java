package com.example.qlct.model;

import java.util.Date;

public class ChiTieu {
    private int maChiTieu;
    private double soTien;
    private int maVi;
    private int maLoaiCT;
    private Date tgCT;
    private String ghiChu;

    public ChiTieu(int maChiTieu, double soTien, int maVi, int maLoaiCT, Date tgCT, String ghiChu) {
        this.maChiTieu = maChiTieu;
        this.soTien = soTien;
        this.maVi = maVi;
        this.maLoaiCT = maLoaiCT;
        this.tgCT = tgCT;
        this.ghiChu = ghiChu;
    }

    public int getMaChiTieu() {
        return maChiTieu;
    }

    public void setMaChiTieu(int maChiTieu) {
        this.maChiTieu = maChiTieu;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getMaVi() {
        return maVi;
    }

    public void setMaVi(int maVi) {
        this.maVi = maVi;
    }

    public int getMaLoaiCT() {
        return maLoaiCT;
    }

    public void setMaLoaiCT(int maLoaiCT) {
        this.maLoaiCT = maLoaiCT;
    }

    public Date getTgCT() {
        return tgCT;
    }

    public void setTgCT(Date tgCT) {
        this.tgCT = tgCT;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
