package kmn.marduk.dao;

import kmn.marduk.entity.Marduk;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MardukDAO {
    List<Marduk> get(Date start, Date end);
}