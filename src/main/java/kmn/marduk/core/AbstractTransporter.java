package kmn.marduk.core;


public abstract class AbstractTransporter implements InterfaceTransporter {

   private Context context;

   protected AbstractTransporter(Context context){
      this.context = context;
   }

   protected Context getContext() {
      return context;
   }
}
