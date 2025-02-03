package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Contest;

import java.util.List;

public interface IContestService {
    /**
     * Crea un nuovo contest
     * @param contest il nuovo contest da creare
     * @return il nuovo contest salvato nel repository
     */
    Contest creaContest(Contest contest, List<Integer> contenuti);

    Contest getContest(Integer id);

    List<Contest> getAllContest();

    void modificaContest(Contest contest, List<Integer> contenuti);

    void iscrizioneContenuto(Integer contentID, Integer contestID);

    void chiusuraContest(Integer contestID, Integer contenutoVincitoreID);
}