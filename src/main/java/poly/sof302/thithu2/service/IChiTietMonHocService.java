package poly.sof302.thithu2.service;

import poly.sof302.thithu2.entities.Chitietmonhoc;

import java.util.List;

public interface IChiTietMonHocService {
    public void saveOrUpdate(Chitietmonhoc chitietmonhoc);
    public List<Chitietmonhoc> findAll();
}
