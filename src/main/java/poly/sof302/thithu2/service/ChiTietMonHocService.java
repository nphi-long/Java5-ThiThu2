package poly.sof302.thithu2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.sof302.thithu2.entities.Chitietmonhoc;
import poly.sof302.thithu2.repository.IChiTietMonHocRepository;

import java.util.List;

@Service
public class ChiTietMonHocService implements IChiTietMonHocService{
    @Autowired
    private IChiTietMonHocRepository ctmhRepo;


    @Override
    public void saveOrUpdate(Chitietmonhoc chitietmonhoc) {
        ctmhRepo.save(chitietmonhoc);
    }

    @Override
    public List<Chitietmonhoc> findAll() {
        return ctmhRepo.findAll();
    }
}
