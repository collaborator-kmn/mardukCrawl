package kmn.marduk.core;

import kmn.marduk.common.MardukFactory;
import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.core.impl.ContextImpl;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;

import java.util.Properties;

public abstract class AbstractTransporter implements InterfaceTransporter {
   private Context context;
   protected AbstractTransporter(Context context){
      this.context = context;
   }


   protected Context getContext() {
      return context;
   }
}
