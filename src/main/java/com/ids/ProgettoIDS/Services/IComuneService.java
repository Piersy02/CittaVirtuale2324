package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Comune;

public interface IComuneService {
    /**
     * Crea un nuovo comune
     * @param comune il comune da creare
     * @return il nuoco comune aggiunto al repository
     */
    Comune creaComune(Comune comune);
}