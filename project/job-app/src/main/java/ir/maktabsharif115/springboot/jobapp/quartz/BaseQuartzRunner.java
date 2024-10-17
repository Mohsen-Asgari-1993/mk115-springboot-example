package ir.maktabsharif115.springboot.jobapp.quartz;

import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@SuppressWarnings("unused")
public abstract class BaseQuartzRunner implements CommandLineRunner {

    protected final SchedulerFactoryBean schedulerFactoryBean;

    protected BaseQuartzRunner(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }

    @Override
    public void run(String... args) {
        scheduleJobs();
        System.out.println(getStartTaskMessage());
    }

    protected String getStartTaskMessage() {
        return ">>>>>>>>>>>>>>> Quartz Start Execution <<<<<<<<<<<<<";
    }

    protected String getTriggerName() {
        return "Trigger";
    }

    protected void registerNewJob(Scheduler scheduler, Class<? extends Job> jobClass, String jobName,
                                  String cron, String triggerName) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName)
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    protected abstract void scheduleJobs();
}
