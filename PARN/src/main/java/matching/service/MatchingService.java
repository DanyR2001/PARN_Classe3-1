package matching.service;

import Storage.Entity.Annuncio;
import Storage.Entity.Curriculum;
import Storage.Entity.Istruzione;
import annuncio.service.AnnuncioService;
import annuncio.service.AnnuncioServiceInterface;
import storage.entity.Annuncio;
import storage.entity.Curriculum;
import storage.entity.Istruzione;


import java.util.ArrayList;
import java.util.List;

public class MatchingService implements MatchingServiceInterface{


    @Override
    public List<Annuncio> personalizzaAnnunci(Curriculum curriculum) {
        List<Annuncio> returnment=new ArrayList<>();
        AnnuncioServiceInterface serviceAnnucio=new AnnuncioService();
        List<Annuncio> all=serviceAnnucio.getAnnunciByStato("In corso");
        List<String> Qualifiche=new ArrayList<>();
        for (Istruzione i:curriculum.getIstruzioni())
            Qualifiche.add(i.getQualifica());
        for (Annuncio a: all) {
            if (Qualifiche.containsAll(a.getRequisiti()))
                returnment.add(a);
        }
        return returnment;

    }

    @Override
    public List<Annuncio> personalizzaAnnunciKeyword(List<Annuncio> annunci, String keyword) {
        List<Annuncio> returnment=new ArrayList<>();
        for (Annuncio a: annunci)
            if (a.getKeyword().contains(keyword))
                returnment.add(a);
        return returnment;
    }

    @Override
    public List<Curriculum> selezioneFigureSpecializzate(Annuncio annuncio) {
        List<Curriculum> returnment=new ArrayList<>();
        CurriculumServiceInterface serviceCurriculum;
        List<Curriculum> all=serviceCurriculum.getAllCurriculum();
        for (Curriculum c: all){
            List<String> Qualifiche=new ArrayList<>();
            for (Istruzione i:curriculum.getIstruzioni())
                Qualifiche.add(i.getQualifica());
            if (Qualifiche.containsAll(annuncio.getRequisiti()))
                    returnment.add(c);
            }
        return returnment;
    }
}
