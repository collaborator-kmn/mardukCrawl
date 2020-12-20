package kmn.marduk.core;

import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.entity.DataBaseIdentifying;

import java.util.List;

public interface InterfaceTransporter {
    List<DataBaseIdentifying> run() throws ProcessException;
}