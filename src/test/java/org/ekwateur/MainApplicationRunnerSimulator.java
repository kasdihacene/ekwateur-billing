package org.ekwateur;

import org.junit.jupiter.api.Test;

class MainApplicationRunnerSimulator {

    @Test
    void shouldExecuteApplicationWhenHavingIndividualInputs() {
        MainApplication.main(new String[]{"IND;EKW12345678;Mr;Jon;Doe;10;10"});
    }

    @Test
    void shouldExecuteApplicationWhenHavingIndividualInputsWithoutConsumption() {
        MainApplication.main(new String[]{"IND;EKW12345678;Mr;Jon;Doe;   ;"});
    }

    @Test
    void shouldExecuteApplicationWhenHavingProfessionalInputs() {
        MainApplication.main(new String[]{"PRO;EKW12345678;SIRET001;SOCIAL0001;10000000;10;10"});
    }

    @Test
    void shouldExecuteApplicationWhenHavingProfessionalInputsWithMinimumCA() {
        MainApplication.main(new String[]{"PRO;EKW12345678;SIRET001;SOCIAL0001;1000;10;10"});
    }

    @Test
    void shouldExecuteApplicationWhenHavingProfessionalInputsWithoutCA() {
        MainApplication.main(new String[]{"PRO;EKW12345678;SIRET001;SOCIAL0001; ;10;10"});
    }

    @Test
    void shouldExecuteApplicationWhenHavingProfessionalInputsWithoutCAAndConsumptions() {
        MainApplication.main(new String[]{"PRO;EKW12345678;SIRET001;SOCIAL0001;;0;"});
    }

    @Test
    void shouldReturnExceptionWhenNoArgIsSent() {
        MainApplication.main(new String[]{});
    }

    @Test
    void shouldThrowAnExceptionWhenHavingIncorrectReference() {
        MainApplication.main(new String[]{"PRO;EKO12345678;SIRET001;SOCIAL0001;;0;"});
    }

    @Test
    void shouldThrowAnExceptionWhenHavingIncorrectClientType() {
        MainApplication.main(new String[]{"EKW;EKW12345678;SIRET001;SOCIAL0001;;0;"});
    }

}