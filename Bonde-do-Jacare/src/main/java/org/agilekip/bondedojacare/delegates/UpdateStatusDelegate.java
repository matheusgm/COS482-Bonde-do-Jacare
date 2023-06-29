package org.agilekip.bondedojacare.delegates;

import java.math.BigDecimal;
import org.agilekip.bondedojacare.domain.Vaccination;
import org.agilekip.bondedojacare.service.dto.VaccinationProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // Object o = delegateExecution.getVariable("pi");
        // System.out.println(o);
        // VaccinationProcessDTO pi = (VaccinationProcessDTO)
        // String type = pi.getVaccination().getVaccineType();
        // if (type == "" || type == null || type == 'null') {
        //     pi.getVaccination().setEndStatus("Não Vacinado");
        // } else {
        //     pi.getVaccination().setEndStatus("Vacinado");
        // }
        // System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // System.out.println(pi.getVaccination().getEndStatus());

        System.out.println("=================================================");
        System.out.println("=============== HI WORLD!!!======================");
        System.out.println("===============  VACINADO  ======================");
        System.out.println("=================================================");
    }
}
