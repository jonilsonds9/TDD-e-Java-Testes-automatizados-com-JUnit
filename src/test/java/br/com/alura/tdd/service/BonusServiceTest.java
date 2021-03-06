package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    void inicializar() {
        service = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Jonilson", LocalDate.now(), new BigDecimal("25000"))));

//        try {
//            service.calcularBonus(new Funcionario("Jonilson", LocalDate.now(), new BigDecimal("25000")));
//            fail("Nao deu a exception!");
//        } catch (Exception e) {
//            assertEquals("Funcionario com salario maior do que R$ 10000 não pode receber bonus!", e.getMessage());
//        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Jonilson", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Jonilson", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}