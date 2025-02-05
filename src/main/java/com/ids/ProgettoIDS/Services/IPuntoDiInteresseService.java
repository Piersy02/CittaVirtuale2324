package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import java.util.List;

public interface IPuntoDiInteresseService {
    PuntoDiInteresse creaPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse);
    PuntoDiInteresse getPuntoDiInteresseById(Integer id);
    List<PuntoDiInteresse> getAllPuntiDiInteresse();
    PuntoDiInteresse modificaPuntoDiInteresse(Integer id, PuntoDiInteresse puntoDiInteresse);
    void eliminaPuntoDiInteresse(Integer id);
}
