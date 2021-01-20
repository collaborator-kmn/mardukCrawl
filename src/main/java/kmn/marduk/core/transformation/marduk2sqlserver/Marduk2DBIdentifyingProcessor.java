package kmn.marduk.core.transformation.marduk2sqlserver;

import kmn.marduk.core.transformation.marduk2sqlserver.processor.Processor;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

import java.util.Arrays;

/** Класс, преобрузующий сущности типа Мардук в сущность БД
 */

public class Marduk2DBIdentifyingProcessor implements Processor<Marduk, DataBaseIdentifying> {
    @Override
    public DataBaseIdentifying process(Marduk marduk)  {
        DataBaseIdentifying dataBaseIdentifying = new DataBaseIdentifying();
        dataBaseIdentifying.setDate(marduk.getDATE_BEG());
        dataBaseIdentifying.setFreq(substringFromEnd(marduk.getFREQ_HZ()));
        dataBaseIdentifying.setNum(marduk.getSIG_TYPE());
        dataBaseIdentifying.setOper(marduk.getSEANCE());
        dataBaseIdentifying.setCoun(isStringEmpty(marduk.getWHO_IS_COUNTRY()) ? marduk.getPLACE_COUNTRY() : marduk.getWHO_IS_COUNTRY());
        dataBaseIdentifying.setTown(isStringEmpty(marduk.getWHO_IS_BRANCH()) ? createPlace(marduk) : normalizeString(marduk.getWHO_IS_BRANCH()));
        dataBaseIdentifying.setComm(createComment(marduk));
        
        dataBaseIdentifying.setAnal("");
        return dataBaseIdentifying;
    }

    private String substringFromEnd(String str) {
        char[] chars = str.toCharArray();
        char[] res = Arrays.copyOf(chars, chars.length-3);
        return new String(res);
    }

    private boolean isStringEmpty(String str){
        return !(str != null && str.length() > 0);
    }

    private String createComment(Marduk marduk){
        return (isStringEmpty(marduk.getSENDER()) && isStringEmpty(marduk.getRECEIVER()))
                ? !isStringEmpty(marduk.getWHO_IS()) ? normalizeString(marduk.getWHO_IS()) : normalizeString(marduk.getREM())
                : normalizeString(marduk.getSENDER()) + " -> " + normalizeString(marduk.getRECEIVER())+";" + normalizeString(marduk.getREM());
    }

    private String createPlace(Marduk marduk) {
        String res = "";
        if (!isStringEmpty(marduk.getPLACE_NAME()))
            res += normalizeString(marduk.getPLACE_NAME());
        if (!isStringEmpty(marduk.getPLACE_REGION()))
            res += "/"+normalizeString(marduk.getPLACE_REGION());
        return res;
    }

    private String normalizeString(String str) {
        return str == null ? "" : str;
    }

}
