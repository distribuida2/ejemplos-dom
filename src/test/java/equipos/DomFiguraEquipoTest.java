package equipos;

import org.junit.Assert;
import org.junit.Test;

public class DomFiguraEquipoTest {

    @Test
    public void testDameFigura__caminoFeliz() throws Exception {

        DomFiguraEquipo domFiguraEquipo = new DomFiguraEquipo();
        String figura = domFiguraEquipo.dameFiguraDelPartido("quilmes_2012.xml");

        Assert.assertEquals("El método damefiguradelpartido no está devolviendo lo esperado",
                "Martín Cauteruccio", figura);
    }

    @Test(expected = SinFiguraException.class)
    public void testDameFigura__noHayFigura() throws Exception {
        DomFiguraEquipo domFiguraEquipo = new DomFiguraEquipo();
        domFiguraEquipo.dameFiguraDelPartido("quilmes_2012_sin_figura.xml");
    }

    @Test
    public void testDameFigura__hayDosFiguras() throws Exception {

    }
}