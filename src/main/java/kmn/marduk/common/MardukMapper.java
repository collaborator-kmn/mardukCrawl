package kmn.marduk.common;

import kmn.marduk.entity.Marduk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MardukMapper implements Mapper<Marduk, SQLException> {

    public Marduk process(ResultSet resultSet) throws SQLException {
        Marduk marduk = new Marduk();
        marduk.setMarduk_id(resultSet.getLong("id"));
        marduk.setMarduk_date(resultSet.getDate("date"));
        marduk.setMarduk_frequency(resultSet.getDouble("frequency"));
        marduk.setMarduk_placeWork(resultSet.getString("place"));
        marduk.setMarduk_country(resultSet.getString("country"));
        String modulation = (resultSet.getString("modulation")); // сверить строку в бд!
        marduk.setMarduk_speed(resultSet.getInt("speed"));
        Double period = resultSet.getDouble("period");
        String kds = resultSet.getString("kds");
        marduk.setMarduk_typeSignal(resultSet.getInt("erbd"));
        marduk.setMarduk_note(resultSet.getString("name"));
        marduk.setMarduk_RadioNetwork(resultSet.getString("radioNetwork"));
        String comment = resultSet.getString("comment");
        marduk.setMarduk_session(resultSet.getInt("operator"));
        String accounting = resultSet.getString("accounting");
        int score = resultSet.getInt("score");
        String analysis = resultSet.getString("analysis");
        marduk.setMarduk_latitude(resultSet.getDouble("nl"));
        marduk.setMarduk_longitude(resultSet.getDouble("el"));
        return marduk;
    }
}