package thread.racecondition;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EnergySystemTest {

	//将要构建的能量世界中能量盒子数量
	public static final int BOX_AMOUNT = 100;
	//每个盒子初始能量
    public static final double INITIAL_ENERGY = 1000;

    public static void main(String[] args){
    	EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < BOX_AMOUNT; i++){
			EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
			es.execute(task);
			es.shutdown();
//    		Thread t = new Thread(task,"TransferThread_"+i);
//    		t.start();
    	}
    }

}
