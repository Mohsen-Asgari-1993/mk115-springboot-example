package ir.maktabsharif115.springboot.jobapp.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
@Slf4j
public class TimerJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("timerJob: " + jobExecutionContext.getJobDetail().getKey().getName());
    }
}
