package facs.eng;

import java.util.List;

public class ListaPrazos {

    private List<Prazo> listaPrazos;

    public ListaPrazos() {}

    public void adicionarPrazo(Prazo novoPrazo){
        listaPrazos.add(novoPrazo);
    }

    public void removerPrazo(long idPrazo){
        listaPrazos.removeIf(prazo -> prazo.getIdPrazo() == idPrazo);
    }

    public List<Prazo> getListaPrazos() {
        return listaPrazos;
    }
}
