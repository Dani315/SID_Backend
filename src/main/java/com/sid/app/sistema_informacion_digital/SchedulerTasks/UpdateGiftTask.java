package com.sid.app.sistema_informacion_digital.SchedulerTasks;

import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.UseCase.GiftUseCase;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class UpdateGiftTask implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateGiftTask.class);


    private final GiftUseCase giftUseCase;

    public UpdateGiftTask(GiftUseCase giftUseCase) {
        this.giftUseCase = giftUseCase;
    }


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        long giftUpdateSize = giftUseCase.updateGiftJob();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        LOG.info("Cantidad de bonos actualizados: {}, La hora actual es {}",giftUpdateSize, dateFormat.format((new Date())));
    }

}
