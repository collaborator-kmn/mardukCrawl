package kmn.marduk.core.transportation;


import kmn.marduk.core.context.Context;

public abstract class AbstractTransporter implements Transporter {

   private Context context;

   protected AbstractTransporter(Context context){
      this.context = context;
   }

   protected Context getContext() {
      return context;
   }
}
