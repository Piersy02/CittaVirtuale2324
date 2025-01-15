package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Contest;

public interface IContestService {
    /**
     * Crea un nuovo contest
     * @param contest il nuovo contest da creare
     * @return il nuovo contest salvato nel repository
     */
    Contest creaContest(Contest contest);
}