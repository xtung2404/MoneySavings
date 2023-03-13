package com.example.qlct.model;

import android.os.Parcelable;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Plan implements Serializable{
    private String MaKeHoach;
    private String TenKeHoach;
    private float HanMuc;
    private String ThoiGianBatDau;
    private String ThoiGianKetThuc;
    private String GhiChu;
    private boolean isDeleted;

    public Plan(String maKeHoach, String tenKeHoach, float hanMuc, String thoiGianBatDau, String thoiGianKetThuc, String ghiChu, boolean isDeleted) {
        MaKeHoach = maKeHoach;
        TenKeHoach = tenKeHoach;
        HanMuc = hanMuc;
        ThoiGianBatDau = thoiGianBatDau;
        ThoiGianKetThuc = thoiGianKetThuc;
        GhiChu = ghiChu;
        this.isDeleted = isDeleted;
    }

    public String getMaKeHoach() {
        return MaKeHoach;
    }

    public void setMaKeHoach(String maKeHoach) {
        MaKeHoach = maKeHoach;
    }

    public String getTenKeHoach() {
        return TenKeHoach;
    }

    public void setTenKeHoach(String tenKeHoach) {
        TenKeHoach = tenKeHoach;
    }

    public float getHanMuc() {
        return HanMuc;
    }

    public void setHanMuc(float hanMuc) {
        HanMuc = hanMuc;
    }

    public String getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        ThoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        ThoiGianKetThuc = thoiGianKetThuc;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
