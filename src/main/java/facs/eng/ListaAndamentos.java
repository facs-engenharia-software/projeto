package facs.eng;

import java.util.List;

public class ListaAndamentos {

    private List<Andamento> andamentos;

    public ListaAndamentos() {}

    public void adicionarAndamento(Andamento andamento){
        andamentos.add(andamento);
    }

    public void removerAndamento(long idAndamento){
        andamentos.removeIf(andamento -> andamento.getIdAndamento() == idAndamento);
    }

    public List<Andamento> getAndamentos() {
        return andamentos;
    }

}
