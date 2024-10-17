package ir.maktabsharif115.springboot.jobapp.quartz;

import lombok.SneakyThrows;
import org.quartz.Scheduler;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzRunner extends BaseQuartzRunner {
    protected QuartzRunner(SchedulerFactoryBean schedulerFactoryBean) {
        super(schedulerFactoryBean);
    }

    @Override
    protected void scheduleJobs() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleTimeJob(scheduler);
        scheduleTimeJobTwo(scheduler);
    }

    @SneakyThrows
    private void scheduleTimeJob(Scheduler scheduler) {
        registerNewJob(
                scheduler,
                TimerJob.class,
                "TimerJob",
                "* * * ? * * *",
                "TimerJob"
        );
    }

    @SneakyThrows
    private void scheduleTimeJobTwo(Scheduler scheduler) {
        registerNewJob(
                scheduler,
                TimerJob.class,
                "TimerJobTwo",
                "0/10 * * ? * * *",
                "TimerJobTwo"
        );
    }
}
