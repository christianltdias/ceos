package com.hefesto.ceos.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LicitacaoTask {

    Logger logger = LoggerFactory.getLogger(LicitacaoTask.class);

	@Scheduled(cron = "${app.tasks.cron.updateLicitacoes}")
	public void scheduleUpdateValuesAndWarranties() throws Exception {
		logger.error("Inicio da tarefa de atualização de valores e garantias");
	}
    
}
