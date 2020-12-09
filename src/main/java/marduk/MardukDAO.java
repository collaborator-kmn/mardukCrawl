package marduk;

import java.util.Date;
import java.util.List;
import marduk.entity.Marduk;

public interface MardukDAO {
    List<Marduk> get(Date start, Date end);
}
