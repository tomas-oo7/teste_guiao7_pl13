package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Abrir e fechar uma porta com fechadura. */
@StateSet({"trancada", "fechada", "aberta", "partida"})
public class Porta {

    @StateRefinement(to="trancada()")
    public Porta() {}

    /** Fecha a porta. */
    @StateRefinement(from="aberta(this)", to="fechada(this)")
    public void fechar() {}

    /** Arromba a porta (definitivo). */
    @StateRefinement(from="trancada(this) || fechada(this)", to="partida(this)")
    public void arrombar() {}

    /** Abre a porta. */
    @StateRefinement(from="fechada(this)", to="aberta(this)")
    public void abrir() {}

    /** Destranca a porta; fica fechada. */
    @StateRefinement(from="trancada(this)", to="fechada(this)")
    public void destrancar() {}

    /** Tranca a porta. */
    @StateRefinement(from="fechada(this)", to="trancada(this)")
    public void trancar() {}
}
