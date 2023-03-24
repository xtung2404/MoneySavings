package com.example.qlct.model;

public class LoaiChiTieu {
    private int MaLoaiChiTieu;
    private String TenLoaiChiTieu;
    private int isDeleted;

    public LoaiChiTieu(int maLoaiChiTieu, String tenLoaiChiTieu) {
        MaLoaiChiTieu = maLoaiChiTieu;
        TenLoaiChiTieu = tenLoaiChiTieu;
        isDeleted = 1;
    }

    public int getMaLoaiChiTieu() {
        return MaLoaiChiTieu;
    }

    public void setMaLoaiChiTieu(int maLoaiChiTieu) {
        MaLoaiChiTieu = maLoaiChiTieu;
    }

    public String getTenLoaiChiTieu() {
        return TenLoaiChiTieu;
    }

    public void setTenLoaiChiTieu(String tenLoaiChiTieu) {
        TenLoaiChiTieu = tenLoaiChiTieu;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
