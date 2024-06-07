package facs.eng;

import java.util.List;

public class ListaContratos {

    private List<Contrato> listaContratos;

    public ListaContratos() {
    }

    public void adicionarContrato(Contrato contrato) {
        listaContratos.add(contrato);
    }

    public void removerContrato(long idContrato) {
        listaContratos.removeIf(contrato -> contrato.getIdContrato() == idContrato);
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }
}
