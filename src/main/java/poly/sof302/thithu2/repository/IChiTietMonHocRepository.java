package poly.sof302.thithu2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.sof302.thithu2.entities.Chitietmonhoc;

@Repository
public interface IChiTietMonHocRepository extends JpaRepository<Chitietmonhoc, Integer> {
}
