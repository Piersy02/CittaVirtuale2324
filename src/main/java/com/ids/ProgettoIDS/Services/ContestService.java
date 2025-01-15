package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Contest;
import com.ids.ProgettoIDS.Repositories.ContestRepository;
import org.springframework.stereotype.Service;
@Service
public class ContestService implements IContestService{

    private final ContestRepository contestRepository;

    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Override
    public Contest creaContest(Contest contest) {
        return contestRepository.save(contest);
    }
}
