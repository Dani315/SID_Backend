package com.sid.app.sistema_informacion_digital.Config;

import com.sid.app.sistema_informacion_digital.SchedulerTasks.UpdateGiftTask;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class QuartzConfig {

    private static final String TIME_ZONE = "GMT-05:00";

    @Value("${cron.job.crearCarga}")
    private String cronGiftUpdate;

    @Bean
    @Qualifier("jobDetailGiftUpdate")
    public JobDetail jobDetailGiftUpdate() {
        return JobBuilder.newJob(UpdateGiftTask.class)
                .withIdentity("UpdateGiftTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerCronUpdateGift(@Qualifier("jobDetailGiftUpdate") JobDetail jobDetailGiftUpdate) {

        return TriggerBuilder.newTrigger()
                .forJob(jobDetailGiftUpdate)
                .withIdentity("triggerCronUpdateGift")
                .startNow()
                .withSchedule(CronScheduleBuilder
                        .cronSchedule(cronGiftUpdate).inTimeZone(TimeZone.getTimeZone(TIME_ZONE)))
                .build();
    }

}
