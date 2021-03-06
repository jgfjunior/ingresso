package br.com.caelum.ingresso.model.descontos;

import br.com.caelum.ingresso.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by matheusbrandino on 5/3/17.
 */
public class DescontoTest {

    @Test
    public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos() {

        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Lugar lugar = new Lugar("A",1);

        Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.BANCO, lugar);


        BigDecimal precoEsperado = new BigDecimal("22.75");

        assertEquals(precoEsperado.doubleValue(), ingresso.getPreco().doubleValue(), 0.001);

    }


    @Test
    public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante() {


        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Lugar lugar = new Lugar("A",1);

        Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugar);

        BigDecimal precoEsperado = new BigDecimal("16.25");


        assertEquals(precoEsperado, ingresso.getPreco());

    }

    @Test
    public void naoDeveConcederDescontoParaIngressoNormal() {

        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Lugar lugar = new Lugar("A",1);

        Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, lugar);


        BigDecimal precoEsperado = new BigDecimal("32.5");


        assertEquals(precoEsperado, ingresso.getPreco());


    }

}
