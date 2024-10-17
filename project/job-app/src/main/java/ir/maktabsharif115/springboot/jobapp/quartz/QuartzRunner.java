package ir.maktabsharif115.springboot.jobapp.quartz;

import lombok.SneakyThrows;
import org.quartz.*;
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
//        scheduleTimeJob(scheduler);
//        scheduleTimeJobTwo(scheduler);
        scheduleTimeJobThree(scheduler);
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

    @SneakyThrows
    private void scheduleTimeJobThree(Scheduler scheduler) {

        JobDetail jobDetail = JobBuilder.newJob(TimerJob.class)
                .withIdentity(TimerJob.class.getSimpleName()).build();

        DailyTimeIntervalScheduleBuilder builder = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                .startingDailyAt(TimeOfDay.hourMinuteAndSecondOfDay(15, 52, 0))
                .endingDailyAt(TimeOfDay.hourMinuteAndSecondOfDay(15, 53, 30))
                .withIntervalInSeconds(4)
                .onEveryDay()
                .withMisfireHandlingInstructionIgnoreMisfires();

        DailyTimeIntervalTrigger trigger = TriggerBuilder.newTrigger().withIdentity(
                TimerJob.class.getSimpleName() + getTriggerName()
        ).withSchedule(builder).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
