package mx.org.banxico.jakarta.timer;

import java.util.Collection;

import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerService;

@Singleton
public class CustomerScheduler {

	@Resource
	private TimerService timerService;
	
	@Schedule(hour = "*", minute = "*", persistent = true)
	public void scheduleCustomerMessage() {

		Collection<Timer> timers = timerService.getAllTimers();
		
		System.out.println("Numero de timers diponibles: " + timers.size());
		for(Timer timer : timers) {
			System.out.println("info: " + timer.getInfo());
			System.out.println("schedule: " + timer.getSchedule());
		}
		
		CustomerEndPoint.sendMessage("hola desde el servidor");
	}
}
